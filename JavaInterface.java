interface A{
    // Methods are public by default
    void show();
    void config();
}
class B implements A{
    public void show()
    {
        System.out.println("In Show");

    }
    public void config()
    {
        System.out.println("In Config");
    }
}
public class JavaInterface{
    public static void main(String[] args)
    {
        A obj;
        obj=new B();
        obj.show();
        obj.config();
    }
}