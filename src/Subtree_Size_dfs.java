import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Subtree_Size_dfs {
    static int[] v;
    static int[] s;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        v = new int[n+1];
        s = new int[n+1];
        gp = new ArrayList[n+1];

        for(int i=0;i<=n;i++){v[i] = 0;s[i] = 0;gp[i] = new ArrayList<>();}
        while(e-- > 0){
            st = br.readLine().split(" ");
            int v1 = Integer.parseInt(st[0]);
            int v2 = Integer.parseInt(st[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        int size = dfs_size(1);
        System.out.println(size);
        for(int i:s) System.out.print(i+" ");
        System.out.println();

        int inp = Integer.parseInt(br.readLine());
        System.out.println("for node: "+inp+" subtree_size: "+s[inp] );
    }

    private static int dfs_size(int node){
        if(v[node] == 0){v[node] = 1;s[node] = 1;}

        for(int i:gp[node]){
            if(v[i] == 0){
                int ints = dfs_size(i);
                s[node]+=ints;
            }
        }

       return s[node];
    }


}
