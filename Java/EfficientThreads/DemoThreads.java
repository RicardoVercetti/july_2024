package Java.EfficientThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DemoThreads extends Thread {

    public DemoThreads() {
        start();
        String address = "https://api.carbonintensity.org.uk/intensity";
        int requestsNo = 80;

        long startTime = System.currentTimeMillis();
        // makeHttpRequest(address);
        makeASetOfHttpRequests(requestsNo,address);

        long endTime = System.currentTimeMillis();


        System.out.println("Total time ellapsed in seconds : "+ ((endTime - startTime)/1000.0));
        System.out.println("Number of requests : " + requestsNo);

    }

    public void run() {
        System.out.println("Thread started...");
        int numberOfRequests = 100;
        String endPoint = "https://api.carbonintensity.org.uk/intensity";

        long threadedStartTime = System.currentTimeMillis();
        makeASetOfHttpRequests(numberOfRequests, endPoint);
        long threadedEndTime = System.currentTimeMillis();
        System.out.println("Threadded fetching elapsed time : "+ ((threadedEndTime-threadedStartTime)/1000.0));
    } 

    public void makeHttpRequest(String endPoint) {
        try {
            URI uri = URI.create(endPoint);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set request headers if needed
            connection.setRequestProperty("Content-Type", "application/json");

            // The request is sent here
            int responseCode = connection.getResponseCode();
            // System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            // Print the response
            // System.out.println("Response: " + response.toString());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error caught manually...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Caught by outer catch...");
        }
    }

    void makeASetOfHttpRequests(int noOfReq, String address) {
        for (int i=0; i<noOfReq; i++) {
            makeHttpRequest(address);
        }
    }

    public static void main(String[] args) {
        System.out.println("Started...");

        long totalTimeStart = System.currentTimeMillis();
        DemoThreads dt = new DemoThreads();
        long totalTimeEnd = System.currentTimeMillis();

        System.out.println("Total time elappsed : "+ ((totalTimeEnd - totalTimeStart)/1000.0));

    }
}
