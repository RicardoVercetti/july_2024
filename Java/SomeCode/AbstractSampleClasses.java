package Java.SomeCode;

public abstract class AbstractSampleClasses {
    String name;
    String newName;

    public AbstractSampleClasses(String name) {
        this.name = name;
        this.newName = "Simon " + name;
    }

    public void showAbstractName(){
        System.out.println("From show abstract name : " + this.name);
    }

    public abstract void toBeImplementedShow();


    // public static void main(String [] args) {
    //     System.out.println("Runs...");
    // }
}