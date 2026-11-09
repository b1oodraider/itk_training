package app;

import Figures.Circle;
import Figures.Rectangle;
import Figures.Triangle;
import GeometryUtils.TriangleUtils;

public class GeometryPlayground {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        Rectangle rectangle = new Rectangle(3,4);
        Circle circle = new Circle(5);

        System.out.printf("Triangle: \tarea — %.2f \tperimeter — %.2f\n" +
                          "Rectangle:\tarea — %.2f \tperimeter — %.2f\n" +
                          "Circle:   \tarea — %.2f \tperimeter — %.2f\n",
                triangle.area(), triangle.perimeter(),
                rectangle.area(), rectangle.perimeter(),
                circle.area(), circle.perimeter());

        System.out.println(TriangleUtils.getTriangle(5,12).area());
    }
}
