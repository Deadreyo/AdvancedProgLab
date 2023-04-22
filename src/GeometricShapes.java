import java.util.ArrayList;

import javafx.geometry.Point2D;

public class GeometricShapes {
    
        public static void main(String[] args) {
            // test for Canvas class
            Canvas canvas = new Canvas();
            canvas.addShape(new Rectangle(new Point2D(0, 0), 5, 7));
            canvas.addShape(new Ellipse(new Point2D(5, 5), 3, 2));
            canvas.addShape(new Rectangle(new Point2D(1, 1), 6, 8));
            canvas.addShape(new Ellipse(new Point2D(6, 6), 4, 3));
            canvas.drawAll();
            canvas.getShape(new Point2D(3, 3)).draw();
        }
    
}

abstract class Shape {
    private Point2D start;
    final public Point2D getStart() {
        return start;
    }

    final public void setStart(Point2D start) {
        this.start = start;
    }

    private double length;
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private double width;
    
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    Shape(Point2D start, double length, double width) {
        this.start = start;
        this.length = length;
        this.width = width;
    }

    Shape(double x, double y, double length, double width) {
        start = new Point2D(x, y);
        this.length = length;
        this.width = width;
    }

    public abstract void draw();
}

class Line {

    private Point2D start;
    private Point2D end;

    public static void main(String[] args) {
        System.out.println("LINE");
    }

    Line(Point2D start, Point2D end) {
        this.end = start;
        this.start = end;
    }

    Line(double pX, double pY, double vX, double vY) {
        end = new Point2D(pX, pY);
        start = new Point2D(vX, vY);
    }

    void print() {
        System.out.println("Point2D: " + end.getX() + ", " + end.getY());
        System.out.println("Point2D: " + start.getX() + ", " + start.getY());
    }

    public void draw() {
        System.out.println("--- LINE ---");
        System.out.println("start: " + end.getX() + ", " + end.getY());
        System.out.println("end: " + start.getX() + ", " + start.getY());
    }
    
}

class Rectangle extends Shape {

    public Rectangle(Point2D start, double length, double width) {
        super(start, length, width);
    }

    @Override
    public void draw() {
        System.out.println("--- RECTANGLE ---");
        System.out.println("start: " + getStart().getX() + ", " + getStart().getY());
        System.out.println("length: " + getLength());
        System.out.println("width: " + getWidth());
    }
    
}

class Ellipse extends Shape {

    public Ellipse(Point2D start, double length, double width) {
        super(start, length, width);
    }

    @Override
    public void draw() {
        System.out.println("--- ELLIPSE ---");
        System.out.println("start: " + getStart().getX() + ", " + getStart().getY());
        System.out.println("length: " + getLength());
        System.out.println("width: " + getWidth());
    }
    
}

class Canvas {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getShape(Point2D position) {
        Shape nearest = shapes.get(0);
        double smallestDist = position.distance(nearest.getStart());
        for(Shape shape: shapes) {
            double distance = position.distance(shape.getStart());
            if(distance < smallestDist) {
                smallestDist = distance;
                nearest = shape;
            }
        }
        return nearest;
    }

    public void drawAll() {
        for(Shape shape: shapes) {
            shape.draw();
        }
    }

}