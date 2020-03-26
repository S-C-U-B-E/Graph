//SPOJ


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BUGLIFE {

    static int[] v;
    static int[] cl;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int si=1; si<=t; si++){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            v = new int[n+1];
            cl = new int[n+1];
            gp = new ArrayList[n+1];
            for(int i=0;i<=n;i++){gp[i] = new ArrayList<>();v[i] = 0;cl[i] = 0;}

            while(e-- > 0){
                s = br.readLine().split(" ");
                int v1 = Integer.parseInt(s[0]);
                int v2 = Integer.parseInt(s[1]);

                gp[v1].add(v2);
                gp[v2].add(v1);
            }

            int nope = 0;
            System.out.println("Scenario #"+si+":");
            for(int i=1;i<=n;i++){
                if(v[i] == 0){
                    if(!dfs_bug(i,1)){
                        nope = 1;
                        break;
                    }
                }
            }
            if(nope == 1){
                System.out.println("Suspicious bugs found!");
            }else{
                System.out.println("No suspicious bugs found!");
            }
        }
    }

    private static boolean dfs_bug(int node, int clr){

        if(v[node] == 0){v[node] = 1;cl[node] = clr;}

        for(int i:gp[node]){
            if(v[i] == 0){
                if(dfs_bug(i,clr^1) == false)
                    return false;
            }else{
                if(cl[i] == cl[node])
                    return false;
            }
        }
        return true;
    }
}
