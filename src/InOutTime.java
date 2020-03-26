//TO TELL IF A NODE LIES IN THE SUB-TREE OF ANOTHER NODE OR NOT

//FOR A CHILD NODE: IN_TIME BORO (PORE CHILD ASE XD)  ;  OUT_TIME CHOTO (PARENT ER AAGE BEROBE)
//FOR A PARENT NODE: IN_TIME CHOTO (AAGE PARENT ASE)  ;  OUT_TIME BORO (CHILD ER PORE BEROBE)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InOutTime{
    static int[] v;
    static int[] IN;
    static int[] OUT;
    static int timer = 1;
    static ArrayList<Integer>[] gp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int edge = e;

        v = new int[n+1];
        IN = new int[n+1];
        OUT = new int[n+1];
        gp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){gp[i] = new ArrayList<>();v[i] = 0;IN[i] = 0;OUT[i] = 0;}

        while(edge-- > 0){
            s =  br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);

            gp[v1].add(v2);
            gp[v2].add(v1);
        }

        dfs_in_out(1);

        for(int i:IN) System.out.print(i+" ");
        System.out.println();
        for(int i:OUT) System.out.print(i+" ");

    }

    private static void dfs_in_out(int node) {
        if(v[node] == 0){v[node] = 1;IN[node] = timer++;}

        for(int i:gp[node]){
            if(v[i] == 0){
                dfs_in_out(i);
            }
        }

        OUT[node] = timer++;
    }
}
