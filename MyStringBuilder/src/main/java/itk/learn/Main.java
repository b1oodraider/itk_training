package itk.learn;

import MSB.MyStringBuilder;

public class Main {
    public static void main() {
        MyStringBuilder msb = new MyStringBuilder("abc");
        System.out.println(msb.toString());
        msb.append("abc");
        System.out.println(msb.toString());
        msb.undo();
        System.out.println(msb.toString());


    }
}
