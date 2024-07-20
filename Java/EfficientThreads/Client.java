package Java.EfficientThreads;

import java.io.BufferedOutputStream;
// import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
import java.net.Socket;
// import java.net.SocketException;

import Java.EfficientThreads.utils.ByteTranslator;

public class Client extends Thread {

    BufferedOutputStream out;
    InputStream in;
    Socket socket;
    boolean isOpen = false;

    String serverAddress;
    int serverPort;

    public Client(String serverAddress, int severPort) {
        this.serverAddress = serverAddress;
        this.serverPort = severPort;
        try {
            socket = new Socket(serverAddress, severPort);
            isOpen = true;
            System.out.println("Connected to the server");

            // Obtain input and output streams
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            System.out.println("Closing client connection...");
            this.in.close();
            // this.out.close();
            this.socket.close();
            isOpen = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            out = new BufferedOutputStream(socket.getOutputStream());
            in = socket.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            // Communicate with the server
            // out.println("Rainy seasons are nice...");
            // String response = in.readLine();
            // System.out.println("Server response: " + response);

            while (isOpen) {
                // System.out.println("Receiving point open...");
                int bytesRead;
                byte[] data = new byte[1024]; // Buffer size of 1024 bytes

                bytesRead = in.read(data, 0, data.length);
                // Read the bytes from the input stream in chunks of 1024 bytes
                if (bytesRead == 0)
                    continue;
                if (bytesRead == -1)
                    break;
                buffer.write(data, 0, bytesRead);

                // Convert the buffer to a byte array
                byte[] allBytes = buffer.toByteArray();

                System.out.println("Bytes received : "+ System.lineSeparator() + ByteTranslator.formatData(allBytes));
                // System.out.println("Bytes received : "+new String(allBytes));
            }
            // System.out.println("Exited out of the reading loop...");

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("The connection is already closed, read operation not possible...");
        // } catch (SocketException e) {
        //     System.out.println("The connection is already closed...");

        } finally {
            // closeConnection();
        }

    }

    public void sendSpecificData(String data) throws IOException {
        System.out.println("Sending data from " + serverAddress);
        System.out.println("Data sent : "+ System.lineSeparator() + data);
        out.write(data.getBytes());
        out.flush();
    }

    public void sendSpecificData(byte[] data) throws IOException {
        System.out.println("Sending data from " + serverAddress);
        System.out.println("Data sent :" + System.lineSeparator() + ByteTranslator.formatData(data));
        out.write(data);
        out.flush();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Client cl = new Client("localhost", 1680);
        cl.start();
        cl.sendSpecificData("Some data".getBytes());

        Thread.sleep(8000);
        cl.closeConnection();
    }

}
