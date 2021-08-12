import java.io.*;
import java.net.*;
public class client {
    public static void main (String [] args){
        try{
            Socket s=new Socket("localhost",5000);
            InputStreamReader in=new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader read=new BufferedReader(in);
            read.readLine();
            s.close();
        
        
        } catch(Exception e){
            System.out.println(e);
        }
    }
}