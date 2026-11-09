package GeometryUtils;

import Figures.Triangle;

public class TriangleUtils {
    public static Triangle getTriangle(double a, double b, double c) {
        return new Triangle(a, b, c);
    }

    public static int compareTrianglesAreas(Triangle a, Triangle b) {
        return Double.compare(a.area(), b.area());
    }
}
