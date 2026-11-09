package GeometryUtils;

import Figures.Rectangle;

public class RectangleUtils {
    public static Rectangle rectangle(double length, double width) {
        return new Rectangle(length, width);
    }

    public static int compareRectanglesArea(Rectangle r1, Rectangle r2) {
        return Double.compare(r1.area(), r2.area());
    }

}
