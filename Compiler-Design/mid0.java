import java.util.*;
import java.io.*;
public class mid0{
  public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(new File("m0.txt"));
    String a="";
    while(sc.hasNext()){
        a=sc.next();

    }
    String s[]=a.split("");
    String sum="";

    for(int i=0;i<4;i++){
        sum+=s[i];
    }
    System.out.println(sum+"-The year");
    sum="";
    switch(s[4]){
        case "1":
            sum="Spring";
            break;
        case "2":
            sum="Summer";
            break;
        case "3":
            sum="Fall";
            break;

    }
    System.out.println(s[4]+"-"+sum+" Semester");
    sum="";
    int num=Integer.parseInt(s[5]+""+s[6]);
    switch(num){
        case 60:
            sum="CSE";
            break;
        case 50:
            sum="EEE";
            break;
        case 55:
            sum="CIVIL";
            break;
        case 68:
            sum="Pharm";
            break;
    }
    System.out.println(num+"-"+sum);
    num=Integer.parseInt(s[7]+s[8]+s[9]);
    System.out.println(num+"-Unique ID");
        


  }
}
    