//PRACTICE

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SSSP_DFS {

    static int[] d;
    static int[] v ;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        v = new int[n+1];
        d = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0; i<=n; i++){gp[i] = new ArrayList<>();v[i] = 0;d[i] = 0;}

        while(e--  > 0){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        int node = Integer.parseInt(br.readLine());
        dfs_sssp(node,d);

        for(int i:d) System.out.print(i+" ");
    }

    private static void dfs_sssp(int node,int[] d){
        if(v[node] == 0){v[node] = 1;}

        for(int i:gp[node]){
            if(v[i] == 0){
                d[i] = d[node]+1;
                dfs_sssp(i,d);
            }
        }
    }
}
