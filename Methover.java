class Calculator{
public int add(int n1,int n2)
{
return n1+n2;
}
public int add(int n1,int n2,int n3)
{
return n1+n2+n3;
}
public float add(float n1,float n2)
{
return n1+n2;
}
}
public class Methover{
public static void main(String[] args)
{
Calculator obj=new Calculator();
System.out.println(obj.add(1,5,3));
System.out.println(obj.add(1.6f,9.0f));
System.out.println(obj.add(1,3));
}
}


