import java.io.*;
import java.util.*;

public class Banker {
  public static int safe[];
  public static void main(String[] args) throws Exception {
    File file = new File("in.txt");
    Scanner sc = new Scanner(file);
    int a = sc.nextInt();
    int b = sc.nextInt();
    safe=new int[a+10];
    int max[][] = new int[a][b];
    int alloc[][] = new int[a][b];
    int avail[] = new int[b];
    int need[][] = new int[a][b];
    int[][] changed = new int[a][b];
    for (int i = 0; i < a; i++){
      for (int j = 0; j < b; j++) {
        max[i][j] = sc.nextInt();
      } 
    }
    System.out.println("need matrix");
    for (int i = 0; i < a; i++){
      for (int j = 0; j < b; j++){ 
        alloc[i][j] = sc.nextInt();
        need[i][j] = max[i][j] - alloc[i][j];
        System.out.print(need[i][j]+" ");
      }
      System.out.println();
    } 
    for (int i = 0; i < b; i++) {
      avail[i] = sc.nextInt();
    }

    if (safetycheck(a, b, avail, alloc, need, changed)) {
      System.out.println("safe sequence");
      for (int i = 0; i < a; i++) {
        System.out.print((char)(65+safe[i])+" ");
      }
      System.out.println();
      System.out.println("change in available resource matrix");
      for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
          System.out.print(changed[i][j]+" ");
        }
        System.out.println();
      } 
    }
    else
      System.out.println("System is in unsafe state");

  }

  public static boolean safetycheck(int a, int b, int avail[], int alloc[][], int need[][], int changed[][]) {
    boolean boolSafe[] = new boolean[a];
    int check0 = 0;
    int check1 = 0;
    while (check0 <=a && check1 <=a) {
      for (int i = 0; i < a; i++) {
        boolean flag = true;
        if (!boolSafe[i]) {
          for (int j = 0; j < b; j++) {
            if (avail[j] < need[i][j])
              flag = false;
          }
          if (flag) {
            for (int j = 0; j < b; j++) {
              avail[j] = avail[j] + alloc[i][j];
              changed[check0][j] = avail[j];
            }
            safe[check0] = i;
            check0++;
            boolSafe[i] = true;
          }
        }
      }
      check1++;
    } 
    if (check0 > a)
      return false;
    else
      return true;
  }
}