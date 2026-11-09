package Figures;

import java.util.Arrays;

public class Rectangle implements Figure{
    private final double length;
    private final double width;

    public Rectangle(double ... measures) {
       if(Arrays.stream(measures).distinct().count() != 2){
           throw new IllegalArgumentException();
       } else {
           this.length = Arrays.stream(measures).distinct().max().getAsDouble();
           this.width = Arrays.stream(measures).distinct().min().getAsDouble();
       }
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public double perimeter() {
        return (width + length) * 2;
    }
}
