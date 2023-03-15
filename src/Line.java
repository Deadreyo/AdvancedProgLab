public class Line {

    private Vector vc;
    private Point pt;
    

    public static void main(String[] args) {
        System.out.println("LINE");
    }

    Line(Point point, Vector vec) {
        this.pt = point;
        this.vc = vec;
    }

    Line(double pX, double pY, double vX, double vY) {
        pt = new Point(pX, pY);
        vc = new Vector(vX, vY);
    }

    void print() {
        System.out.println("Point: " + pt.x + ", " + pt.y);
        System.out.println("Vector: " + vc.getX() + ", " + vc.getY());
    }
    

}

// couldn't understand how to install javaFX
class Point {
    public double x;
    public double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}