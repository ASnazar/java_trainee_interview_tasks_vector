package org.example.shapesTask4;

abstract class Shape implements Comparable<Shape> {
     abstract double getArea();

     @Override
     public int compareTo(Shape other) {
          return Double.compare(this.getArea(), other.getArea());
     }
}
