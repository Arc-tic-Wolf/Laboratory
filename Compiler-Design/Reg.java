import java.util.regex.*;
import java.util.*;
import java.io.*;
public class Reg {
  public static void main(String [] args) throws Exception{
    Scanner sc=new Scanner(new FileReader("a.txt"));
    int t=Integer.parseInt(sc.next());
    
    
    for(int i=0;i<t;i++){
        int n=Integer.parseInt(sc.next());
        
        String a[]=new String[n];
        for(int j=0;j<a.length;j++){
            a[j]=sc.next();
        }
        
        int m=Integer.parseInt(sc.next());
        
        for(int j=0;j<m;j++){
            String s=sc.next();
            
            int sum=-1;
            for(int k=0;k<a.length;k++){
                if(Pattern.matches(a[k],s)){
                    sum=k+1;
                    
                    break;
                }
            }
            if(sum ==-1){
                System.out.println("NO, 0");
            }else {
                System.out.println("YES, "+sum);
            }
            sum=-1;
        }
        
    }
                   
  }
}
    
    