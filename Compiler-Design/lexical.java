import java.util.*;
import java.io.*;
public class lexical{
  public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(new File("lex.txt"));
    System.out.println("Methods:");
    for(;sc.hasNextLine();){
        String st=sc.nextLine();
        String num="",sum="";
        if(!st.contains("static void main") && st.startsWith("public") && !st.contains("class") ){
            String arr[]=st.split(" ");
            int k=-1;
            if(st.contains("static")){
                k=2;
            }else {
                k=1;
            }
            num=arr[k];
            k++;
            for(;k<arr.length;k++){
                sum+=arr[k]+" ";
            }
            System.out.println(sum+", return type: "+num);
        }

    }
  }
}