import javafx.geometry.Point2D;

public class GeometricShapes {
    
        public static void main(String[] args) {
            Point2D p1 = new Point2D(1, 2);
            Point2D p2 = new Point2D(3, 4);
            Line line = new Line(p1, p2);
            line.print();
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

    Shape(Point2D start) {
        this.start = start;
    }

    Shape(double x, double y) {
        start = new Point2D(x, y);
    }

    public abstract void draw();
}

class Line extends Shape {

    private Point2D start;
    private Point2D end;
    

    public static void main(String[] args) {
        System.out.println("LINE");
    }

    Line(Point2D start, Point2D end) {
        super(start);
        this.end = start;
        this.start = end;
    }

    Line(double pX, double pY, double vX, double vY) {
        super(pX, pY);
        end = new Point2D(pX, pY);
        start = new Point2D(vX, vY);
    }

    void print() {
        System.out.println("Point2D: " + end.getX() + ", " + end.getY());
        System.out.println("Point2D: " + start.getX() + ", " + start.getY());
    }

    @Override
    public void draw() {
        System.out.println("--- LINE ---");
        System.out.println("start: " + end.getX() + ", " + end.getY());
        System.out.println("end: " + start.getX() + ", " + start.getY());
    }
    
}

class Rectangle extends Shape {

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

    public Rectangle(Point2D start, double length, double width) {
        super(start);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("--- RECTANGLE ---");
        System.out.println("start: " + getStart().getX() + ", " + getStart().getY());
        System.out.println("length: " + length);
        System.out.println("width: " + width);
    }
    
}

class Ellipse extends Shape {
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

    public Ellipse(Point2D start, double length, double width) {
        super(start);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("--- ELLIPSE ---");
        System.out.println("start: " + getStart().getX() + ", " + getStart().getY());
        System.out.println("length: " + length);
        System.out.println("width: " + width);
    }
    
}