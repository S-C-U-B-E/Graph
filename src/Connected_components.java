//HACKEREARTH

import java.io.*;
import java.util.ArrayList;

public class Connected_components {
    static int[] v ;
    static ArrayList<Integer>[] gph ;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        v = new int[n+1];
        gph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){gph[i]=new ArrayList<Integer>();v[i] = 0;}

        while(e-- > 0){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gph[v1].add(v2);
            gph[v2].add(v1);
        }

        int count = 0;

        for(int i=1;i<=n;i++){
            if(v[i] == 0 ){count++;dfs(i);}
        }

        for(Object o:gph){
            System.out.println(o);
        }

        System.out.println(count);

    }

    private static void dfs(int node){

        if(v[node] == 0){v[node] = 1;}

        for(int i: gph[node]){
            if(v[i] == 0 )
                dfs(i);
        }
    }
}
