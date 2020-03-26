//HACKEREARTH

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SocialNetworkingGraph {
    static ArrayList<Integer> d;
    static int[] v ;
    static ArrayList<Integer>[] gp;
    static Queue<Integer> q ;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            v = new int[n+1];
            gp = new ArrayList[n+1];
            q = new LinkedList<>();
            for(int i=0; i<=n; i++){gp[i] = new ArrayList<>();v[i] = 0;}

            while(e--  > 0){
                s = br.readLine().split(" ");
                int v1 = Integer.parseInt(s[0]);
                int v2 = Integer.parseInt(s[1]);

                gp[v1+1].add(v2+1);
                gp[v2+1].add(v1+1);
            }

            ArrayList<Integer>[] ans = new ArrayList[n+1];
            for(int i=0;i<=n;i++)ans[i] = new ArrayList<>();

            for(int i=1;i<=n;i++){
                d = new ArrayList<>();
                for(int j=0; j<=n; j++){d.add(0);v[j] = 0;}
                ans[i].addAll(bfs_sssp(i));
                //System.out.println(ans[i]);
            }


        int m = Integer.parseInt(br.readLine());
        while (m-- > 0){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);

            System.out.println(Collections.frequency(ans[v1+1],t));
        }

    }

    private static ArrayList<Integer> bfs_sssp(int node){
        if(v[node] == 0){v[node] = 1;q.add(node);}
        while(!q.isEmpty()){
            int top = q.poll();
            for(int i:gp[top]){
                if(v[i] == 0){
                    q.add(i);
                    v[i] = 1;
                    //d[i] = d[top]+1;
                    d.set(i,d.get(top)+1);
                }
            }
        }
        return d;
    }
}

