package Java.SomeCode;

public class ImplClass extends AbstractSampleClasses {

    public ImplClass(String name) {
        super(name);
    }


    @Override
    public void toBeImplementedShow() {
        System.out.println("This is a to be implemented show from Impl class");
    }

    public void implSpecificMethod() {
        System.out.println("This is a impl specific method..");
    }

    public void showNewName() {
        System.out.println("The new name : "+newName);
    }

    public void setNewName(String newName) {
        super.newName = newName;
    }
    
    public static void main(String[] args) {
        ImplClass imp = new ImplClass("Peter");
        imp.showAbstractName();
        imp.toBeImplementedShow();
        imp.showNewName();
        imp.setNewName("Lucas");
        imp.showNewName();
        // imp.implSpecificMethod();

        // AbstractSampleClasses absClass = new AbstractSampleClasses("Luis");
    }
    
}
