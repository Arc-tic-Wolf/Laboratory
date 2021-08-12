import java.io.*;
import java.net.*;
public class client {
    public static void main (String [] args){
        try{
            Socket s=new Socket("localhost",5000);
            InputStreamReader in=new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader read=new BufferedReader(in);
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            PrintWriter write=new PrintWriter(out,true);
            Scanner sc=new Scanner(System.in);

            for (;;){
                System.out.println("Server is listening");
                String i=sc.nextLine();
                write.println(i);
                String res=read.readLine();
                System.out.println("From server  "+res);
                if (res.equalsIgnoreCase("goodbye")){
                    break;
                }
            }
            
            s.close();
        
        
        } catch(Exception e){
            System.out.println(e);
        }
    }
}