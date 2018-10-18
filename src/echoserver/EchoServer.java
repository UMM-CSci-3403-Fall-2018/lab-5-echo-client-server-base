package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            // Start listening on the specified port
            ServerSocket sock = new ServerSocket(portNumber);

            // Run forever, which is common for server style services
            while (true) {
                // Wait until someone connects
                Socket client = sock.accept();
                System.out.println("Got a request!");

                InputStream clientRequest = client.getInputStream();
                OutputStream serverResponse = client.getOutputStream();

                int tempByte;

                // Read data sent from client and send it back to the client
                while((tempByte = clientRequest.read()) != -1) {
                  serverResponse.write(tempByte);
                }
                // Close the client
                client.shutdownOutput();
              }
            }
     // Exception catching
     catch(IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}
