import java.net.*;
import java.io.*;
public class HttpServerDemo
{
    public static void main(String[] args) throws IOException
    {
        int port=8081;
        ServerSocket serverSocket=new ServerSocket(port);
        System.err.println("Server is runnning on port: "+port);
        while(true)
        {
            Socket clientSocket=serverSocket.accept();
            System.err.println("Client connected");
            BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String s;
            while((s=in.readLine())!=null)
            {
                System.out.println(s);
                if(s.isEmpty())
                {
                    break;
                }
            }
            OutputStream clientOutput=clientSocket.getOutputStream();
            clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
            clientOutput.write("\r\n".getBytes());
            clientOutput.write("<b><h1>WelCome To Priti's Code!</h1></b>".getBytes());
            clientOutput.write("\r\n\r\n".getBytes());
            clientOutput.flush();
            System.err.println("Client connection closed!");
            in.close();
            clientOutput.close();
        }
    }
}