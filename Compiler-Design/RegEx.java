import java.io.File;
import java.util.Scanner;

public class RegEx {
 public void run(){
    try{
        File file=new File("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            String s = sc.next();
            if(s.contains("@gmail") | s.contains("@email") | s.contains("@hotmail") | s.contains("@yahoo")){
                System.out.println(EmailChecker(s)+","+i);
            }

            if(s.startsWith("www.")){
                System.out.println(WebChecker(s)+","+i);
            }
        }

        sc.close();
    }catch(Exception e){
        System.out.println();
    }
 }

 public String EmailChecker(String a){
     String result = "Email";
     if(Character.isDigit(a.charAt(0))){
         result="invalid Email";
     }
     if(!a.endsWith(".com")){
         result="invalid Email";
     }

     String[] A = a.split("@",2);
    if(A[1].contains("@")){
        result="in valid email";
    }

     return result;
 }

    public String WebChecker(String b){
        String result = "web";
        if(!b.endsWith(".com")){
            result="invalid web";
        }
        String[] B = b.split(".",2);
        String a[]= {"!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",";","'",",","?"};
        for(int i=0;i<a.length;i++) {
            if (B[1].contains(a[i])) {
                result = "invalid web";
            }
        }

        return result;
    }
}
