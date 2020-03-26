//CYCLE DETECTION

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CycleDetection {
    static int[] v;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int edge = e;

        v = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){gp[i] = new ArrayList<>();v[i] = 0;}

        while(edge-- > 0){
            s =  br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        if(dfs_cd(1,-1)){
            System.out.println("CYCLE FOUND");
        }else{
            System.out.println("NO CYCLE");
        }

    }

    private static boolean dfs_cd(int node, int parent) {
        if(v[node] == 0){v[node] = 1;}

        for(int i:gp[node]){
            if(v[i] == 0){
                if(dfs_cd(i,node) == true)
                    return true;
            }else{
                if(i != parent)
                    return true;
            }
        }

        return false;
    }
}
