import java.io.*;
import java.net.*;
import java.util.Date;
public class server {
    public static void main (String [] args){
        try{
            for(;;){
                ServerSocket ss=new ServerSocket(5000);
                System.out.println("Server running at port:5000");
                Socket s=ss.accept();
                System.out.println("Connected");
                String d=new Date().toString();
                
                DataOutputStream out=new DataOutputStream(s.getOutputStream());
                PrintWriter write=new PrintWriter(out,true);
                write.println(d);
                ss.close();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}