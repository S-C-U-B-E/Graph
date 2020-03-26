import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SSSP_BFS {
    static int[] d;
    static int[] v ;
    static ArrayList<Integer>[] gp;
    static Queue<Integer> q ;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        v = new int[n+1];
        d = new int[n+1];
        gp = new ArrayList[n+1];
        q = new LinkedList<>();
        for(int i=0; i<=n; i++){gp[i] = new ArrayList<>();v[i] = 0;d[i] = 0;}

        while(e--  > 0){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        //q.add(1);
        bfs_sssp(1);
        //for(int i :d) System.out.print(i+" ");
        System.out.println(d[n]);
    }
}

    private static void bfs_sssp(int node){
        if(v[node] == 0){v[node] = 1;q.add(node);}
        while(!q.isEmpty()){
            int top = q.poll();
            for(int i:gp[top]){
                if(v[i] == 0){
                    q.add(i);
                    v[i] = 1;
                    d[i] = d[top]+1;
                }
            }
        }
    }
}

