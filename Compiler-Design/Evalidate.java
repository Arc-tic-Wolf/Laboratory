import java.util.*;
public class Evalidate{
    public static void main(String[] args0){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.print(s);
        if(IsValid(s)){
            System.out.println(" Is Valid");
        }else {
            System.out.println(" Is Invalid");
        }
        
    }
    public static boolean IsValid(String s){
        
        String [] a=s.split("@");
        
        if(a.length!=2){
            
            System.out.print(1);
            
            return false;
            

            
        }
        
        if(a[0].length()==0 || a[1].length()<3){
            
            System.out.print(2);
            
            return false;
            
        }
        
        if(!a[1].contains(".")){
            
            System.out.print(3);
            
            return false;
        }
        int c=(int)a[0].charAt(0);
        if(!( (c>64 && c<91 )|| (c>96 && c<123))){
            System.out.print(4);
            return false;
        }
        int k=s.indexOf("@");
        int l=s.indexOf(".");
        int sum=0;
        for(int i=0;i<s.length();i++){
            c=(int)s.charAt(i);
            if(i>k && i<l){
                
                if((c>64 && c<91 )|| (c>96 && c<123)){
                    sum++;
                }
            }
            
            if(!((c>47 && c<58)|| (c>64 && c<91)|| (c>96 && c<123) && c!=(int)'_') && c!=(int)'.' && c!=(int)'@'){
                System.out.print(c+""+5);
                return false;
            }
        }
        
        if(sum==0){
            return false;
        }
        if(s.contains("..") || s.contains(".@") || s.contains("@.") || s.contains("._.")){
            System.out.print(6);
            return false;
        }
        if(s.endsWith(".")){
            System.out.print(7);
            return false;
        }
        
        return true;
    }
}