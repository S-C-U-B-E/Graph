//SPOJ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PPATH{
    static int[] v;
    static int[] d;
    static ArrayList<Integer>[] gp;
    static ArrayList<Integer> primes;
    static Queue<Integer> q;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gp = new ArrayList[100001];
        for(int i=0;i<100001;i++)gp[i] = new ArrayList<>();
        primes = new ArrayList<>();
        q = new LinkedList<>();

        get_primes(1000,9999);

        build_gp(primes);

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            v = new int[100001];
            d = new int[100001];
            for(int i=1000;i<=9999;i++){v[i] = 0; d[i] = -1;}
            String[] s = br.readLine().split(" ");

            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);

            int ans = bfs(n1,n2) + 1;
            if(ans == -1)
                System.out.println("Impossible");
            else{
                System.out.println(ans);
            }

        }
    }

    private static int bfs(int node1, int node2){
        if(v[node1] == 0){v[node1] = 1; q.add(node1);}

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

        int ans = d[node2];
        return ans;
    }

    private static boolean isValid(int v1, int v2){
        int c = 0;

        while(v1 > 0){
            if(v1%10 != v2%10) c++;

            v1 /= 10; v2 /= 10;
        }

        if(c == 1){return true;}
        else{ return false;}
    }

    private static void build_gp(ArrayList<Integer> primes){

        for(int i=0; i<primes.size();i++){
            for(int j=i+1; j<primes.size(); j++){

                int v1 = primes.get(i);
                int v2 = primes.get(j);

                if(isValid(v1,v2)){
                    gp[v1].add(v2);
                    gp[v2].add(v1);
                }
            }
        }
    }

    private static void get_primes(int n,int m){

        for(int i=n;i<=m;i++){
           if(isprime(i))primes.add(i);
        }
    }

    private static boolean isprime(int n){

        for(int i=2; i*i<=n; i++){
            if(n%i == 0)return false;
        }

        return true;
    }
}