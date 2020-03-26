//SPOJ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Isitatree {

    static int[] v;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int edges = e;

        v = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0; i<=n; i++ ){gp[i] = new ArrayList<>(); v[i] = 0;}

        while(e-- > 0){
            s = br.readLine().split(" ");

            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        int ccomponent = 0;
        for(int i=1; i<=n; i++){
            if(v[i] == 0){ccomponent++;
            dfs(i);}
        }


        if(edges == n-1 && ccomponent==1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static void dfs(int i) {
        if(v[i] == 0){v[i] = 1;}
        for(int node:gp[i]){
            if(v[node] == 0)
                dfs(node);
        }
    }
}
