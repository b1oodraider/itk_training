package Figures;

public class Parallelogram implements Figure {
    private final double a;
    private final double b;
    private double h = 0;

    public  Parallelogram(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }


    @Override
    public double area() {
        return a*h;
    }

    @Override
    public double perimeter() {
        return (a+b)*2;
    }
}
