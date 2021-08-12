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
                
                
                DataOutputStream out=new DataOutputStream(s.getOutputStream());
                PrintWriter write=new PrintWriter(out,true);
                InputStreamReader in=new InputStreamReader(new DataInputStream(s.getInputStream()));
                BufferedReader read=new BufferedReader(in);
                
                for(;;){
                    String cli=read.readLine();
                    if(cli.equalsIgnoreCase("end game")){
                        write.println("goodbye");
                        break;
                    }else{
                        write.println(cli);
                    }
                }
                
                ss.close();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}