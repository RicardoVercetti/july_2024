package Java.EfficientThreads;

import java.io.IOException;

import Java.EfficientThreads.resources.Messages.SampleIsoBytes1;
import Java.EfficientThreads.utils.ByteTranslator;

public class BunchOfClients {
    Client[] cliList;

    public BunchOfClients(int noOFClients, String serverAddress, int portNo) {
        // the client array
        cliList = new  Client[noOFClients];

        // create the number of client objects and add it into array

        for (int i=0; i<noOFClients; i++) {
            Client newCli = new Client(serverAddress, portNo);
            cliList[i] = newCli;
        }
    }

    public void sendData() {
        for(Client cli: cliList) {
            cli.start();
        }
    }

    public void sendSpecificData(String data) {
        for(Client cli: cliList) {
            try {
                cli.sendSpecificData(data);
            } catch (IOException e) {
                System.out.println("Failed to send data:" + System.lineSeparator() + data);
            }
        }
    }

    public void sendSpecificData(byte[] data) {
        for(Client cli: cliList) {
            try {
                cli.sendSpecificData(data);
            } catch (IOException e) {
                System.out.println("Failed to send data:" + System.lineSeparator() + ByteTranslator.formatData(data));
            }
        }
    }

    public void closeAllConnections() {
        for(Client cli: cliList) {
            cli.closeConnection();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        BunchOfClients boc = new BunchOfClients(4, "localhost", 1680);
        boc.sendData();
        // Thread.sleep(5000);
        // boc.sendSpecificData("SpEcIfIc dAtA".getBytes());
        boc.sendSpecificData(SampleIsoBytes1.set1);
        boc.closeAllConnections();
    }
}
