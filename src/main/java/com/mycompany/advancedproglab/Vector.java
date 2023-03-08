/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advancedproglab;

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
    
    Vector add(Vector v) {
        return new Vector(x + v.x,y + v.y);
    }
    
    Vector sub(Vector v) {
        return new Vector(x - v.x, y - v.y);
    }
}
