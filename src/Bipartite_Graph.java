//BIPARTITE

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bipartite_Graph {
    static int[] v;
    static int[] cl;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int edge = e;

        v = new int[n+1];
        cl = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){gp[i] = new ArrayList<>();v[i] = 0;cl[i] = 0;}

        while(edge-- > 0){
            s =  br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        dfs_cl(1,1);
        for(int i:v) System.out.print(v[i]+" ");
        System.out.println();
        for(int i:cl) System.out.print(cl[i]+" ");

    }

    private static boolean dfs_cl(int node, int clr) {
        if(v[node] == 0){v[node] = 1;cl[node] = clr; }

        for(int i:gp[node]){
            if(v[i] == 0){
                if(dfs_cl(i,clr^1) == false)
                    return false;
            }else{
                if(cl[i] == cl[node])
                    return false;
            }
        }

        return true;
    }
}
