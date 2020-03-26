//HACKEREARTH

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BishuandhisGirlfriend {

    static ArrayList<Integer> d;
    static int[] v ;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = n-1;

        v = new int[n+1];
        d = new ArrayList<>();
        for(int i=0;i<=n;i++){d.add(0);}
        //d = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0; i<=n; i++){gp[i] = new ArrayList<>();v[i] = 0;}

        while(e--  > 0){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        int node = 1;
        dfs_sssp(node,d);

        //for(int i:d) System.out.print(i+" ");
        int q = Integer.parseInt(br.readLine());
        int mini = Integer.MAX_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=q;i++){
            int pos = Integer.parseInt(br.readLine());
            int val =  d.get(pos);
            if( val < mini ) {mini = val; ans.add(pos);}
        }

        System.out.println(Collections.min(ans));
    }

    private static void dfs_sssp(int node,ArrayList<Integer> d){
        if(v[node] == 0){v[node] = 1;}

        for(int i:gp[node]){
            if(v[i] == 0){
                //d[i] = d[node]+1;
                d.set(i,d.get(node)+1);
                dfs_sssp(i,d);
            }
        }
    }
}
