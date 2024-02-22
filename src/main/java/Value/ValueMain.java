package Value;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10 , b= a;
        a = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Integer c = new Integer(10);
        Integer d = c;

        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
