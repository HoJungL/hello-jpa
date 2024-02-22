package Value;

import hellojpa.Address;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10 , b= a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Integer c = new Integer(10);
        Integer d = c;

        System.out.println("c = " + c);
        System.out.println("d = " + d);

        System.out.println("a == b : " + (a == b));
        System.out.println("c == d : " + (c == d));

        Address add1 = new Address("city", "street", "10000");
        Address add2 = new Address("city", "street", "10000");
        System.out.println("add1 == add2 : " + (add1 == add2));


    }
}
