package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        String server;
        if (args.length == 0) {
            server = "127.0.0.1";
        } else {
            server = args[0];
        }

        try {
            // Connect to the server
            Socket socket = new Socket(server, portNumber);
            // Get the input and output stream
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Write data from standard input to the server
            // Print all the input we receive from the server
            int system;
            while((system = System.in.read()) != -1) {
              out.write(system);
              int response = in.read();
              System.out.write(response);
      }

            // Close the socket when we're done reading from it
            socket.shutdownOutput();
            System.out.flush();

            // Provide some minimal error handling.
        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}
