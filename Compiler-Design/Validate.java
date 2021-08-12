import java.util.Scanner;
public class Validate {  
  public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j=1;j<=n;j++){
            String a = sc.next();
            if(a.contains("@gmail") | a.contains("@email") | a.contains("@hotmail") | a.contains("@yahoo")){
            	Boolean result=true;
                if(Character.isDigit(a.charAt(0))){
         			result=false;
     			}
     			if(!a.endsWith(".com")){
         			result=false;
     			}

     			String[] A = a.split("@",2);
    			if(A[1].contains("@")){
        			result=false;
    			}
    			if (result){
    				System.out.println("Email , "+j);
    			} else {
    				System.out.println("Invalid email , "+j);
    			}
            

            } else if(a.startsWith("www.")){
                Boolean result = true;
        		if(!a.endsWith(".com")){
            		result=false;
		        }
		        String[] z = a.split(".",2);
		        String b[]= {"!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",";","'",",","?"};
		        for(int i=0;i<b.length;i++) {
		            if (z[1].contains(b[i])) {
		                result = false;
		            }
		        }
		        if (result){
		        	System.out.println("Web , "+j);
		        }else {
		        	System.out.println("Invalid web, "+j);
		        }
            }else {
              System.out.println("Invalid , "+j);
            } 
          }
    
  } 
  
}
