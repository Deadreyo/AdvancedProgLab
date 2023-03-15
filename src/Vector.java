import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
public class Vector {
    private double x;
    private double y;
   
    public static void main(String[] args) {
        System.out.println("VECTOOOOR");
    }
    
    Vector() {
        x = 0;
        y = 0;
    }
    
    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
   
    double magnitude() {
        return Math.sqrt(x*x + y*y);
    }
    
    double angle() {
        return Math.atan(y/x);
    }
    
    void print() {
        System.out.println(x+"i + "+y+"j");
        System.out.println(magnitude() + "[" + angle() + "]");
    }
    
    // included in lab 3
    void read() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x: ");
        x = input.nextDouble();
        System.out.println("Enter y: ");
        y = input.nextDouble();
        input.close();
    }
    
    // included in lab 3
    static Vector add(Vector a, Vector b) {
        return new Vector(a.x + b.x, a.y + b.y);
    }
    
    // included in lab 3
    static Vector sub(Vector a, Vector b) {
        return new Vector(a.x - b.x, a.y - b.y);
    }
}
