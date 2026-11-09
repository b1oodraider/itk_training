package TDS;
public class Cube {
    private final double dimension;

    public  Cube(double dimension) {
        this.dimension = dimension;
    }

    public double getArea() {
        return dimension * dimension + dimension * dimension + dimension * dimension
                + dimension * dimension + dimension * dimension + dimension * dimension;
    }

    public double getVolume() {
        return dimension * dimension * dimension;
    }

    public double perimeter() {
        return dimension * 12;
    }
}
