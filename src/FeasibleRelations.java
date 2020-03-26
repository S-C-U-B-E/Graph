//HACKEREARTH

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FeasibleRelations {

    static int[] ve;
    static int[] vn;
    static ArrayList<Integer>[] gpe;
    static ArrayList<Integer>[] gpn;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            vn = new int[n+1];
            gpe = new ArrayList[n+1];
            gpn = new ArrayList[n+1];
            for(int i=0;i<=n;i++){gpe[i] = new ArrayList<>();gpn[i] = new ArrayList<>();}

            while(k-- > 0){
                s = br.readLine().split(" ");
                int v1 = Integer.parseInt(s[0]);
                String r = s[1];
                int v2 = Integer.parseInt(s[2]);

                if(r.equals("=")){
                    gpe[v1].add(v2);
                    gpe[v2].add(v1);
                }else{

                    gpn[v1].add(v2);
                    gpn[v2].add(v1);
                }
            }

            int ans = 0;
            for(int i=1; i<=n; i++){
                for(int j:gpn[i]){
                    ve = new int[n+1];
                    if(dfs(i,j)){ans = 1; break;}
                }
                if(ans == 1)break;
            }

            if(ans == 1) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    private static boolean dfs(int node1, int node2){
        if(ve[node1] == 0){ve[node1] = 1;}

        for(int i:gpe[node1]){
            if(i == node2)return true;
            if(ve[i] == 0){
                if(dfs(i,node2))return true;

            }
        }
        return false;
    }
}
