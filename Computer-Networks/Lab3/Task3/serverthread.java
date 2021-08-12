public class serverthread extends Thread{
    public void run(){
        try{
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
        } catch(Exception e){
            System.out.println(e);
        }
    }
    private Socket socket;
    serverthread(Socket s){
        socket=s;
    }
}