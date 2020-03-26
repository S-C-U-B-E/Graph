import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FIRESC {
    static long con = (long)Math.pow(10,9)+7;
    static int[] v;
    static long ele = 0;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);

            int cc = 0;

            v = new int[n+1];
            gp = new ArrayList[n+1];

            for(int i=0;i<=n;i++){v[i] = 0;gp[i] = new ArrayList<>();}
            while(e-- > 0){
                st = br.readLine().split(" ");
                int v1 = Integer.parseInt(st[0]);
                int v2 = Integer.parseInt(st[1]);

                gp[v1].add(v2);
                gp[v2].add(v1);
            }

            long ans = 1;
            for(int i=1;i<=n;i++) {
                if (v[i] == 0) {
                    cc++;
                    ele = 0;
                    dfs(i);
                    ans = (ans*ele)%con;
                }
            }

            System.out.println(cc+ " "+ans);

        }

    }

    private static void dfs(int node){
        if(v[node] == 0){v[node] = 1;ele++;}

        for(int i:gp[node]){
            if(v[i] == 0){
                dfs(i);
            }
        }
    }
}
