package GeometryUtils;

import Figures.Triangle;

public class TriangleUtils {
    public static Triangle getTriangle(double a, double b) {
        return new Triangle(a, b, Math.sqrt(a*a + b*b));
    }

    public static int compareTrianglesAreas(Triangle a, Triangle b) {
        return Double.compare(a.area(), b.area());
    }
}
