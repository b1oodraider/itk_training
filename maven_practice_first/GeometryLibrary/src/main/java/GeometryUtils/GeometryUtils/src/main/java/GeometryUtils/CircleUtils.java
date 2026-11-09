package GeometryUtils;

import Figures.Circle;

public class CircleUtils {
    public static Circle  circle(double radius) {
        return new Circle(radius);
    }

    public static int compareCirclesArea(Circle c1, Circle c2) {
        return Double.compare(c1.area(), c2.area());
    }
}
