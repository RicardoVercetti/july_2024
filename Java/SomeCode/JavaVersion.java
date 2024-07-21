package Java.SomeCode;

public class JavaVersion {
    public static void main(String[] args) {
        // Print the Java version
        System.out.println("Java Version: " + System.getProperty("java.version"));
        
        // Print the Java Runtime Environment version
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        
        // Print the Java vendor
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        
        // Print the Java vendor URL
        System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
        
        // Print the Java home directory
        System.out.println("Java Home Directory: " + System.getProperty("java.home"));
    }
}
