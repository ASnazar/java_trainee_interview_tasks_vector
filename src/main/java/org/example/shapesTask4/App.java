package org.example.shapesTask4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(new Rectangle(2,3));
        shapes.add(new Triangle(2,4));
        shapes.add(new Square(4));
        Collections.sort(shapes);
        shapes.stream().forEach(x -> System.out.println(x.getArea()));
    }
}
