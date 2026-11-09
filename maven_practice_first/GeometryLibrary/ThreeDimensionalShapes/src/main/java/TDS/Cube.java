package TDS;
public class Cube {
    private final double dimension;

    public  Cube(double dimension) {
        this.dimension = dimension;
    }

    @Deprecated
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

    public double fullArea() {
        return dimension * dimension * 6;
    }
}
