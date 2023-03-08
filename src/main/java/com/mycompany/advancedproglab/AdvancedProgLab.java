/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.advancedproglab;

/**
 *
 * @author pc
 */
public class AdvancedProgLab {

    public static void main(String[] args) {
        Vector[] vecs = new Vector[10];
        for(int i = 0; i < 10; i++) {
            vecs[i] = new Vector(i, 0);
        }
        double avg = calcAvgMagnitude(vecs);
        System.out.println("Avg Mag: "+avg);
    }
    
    public static double calcAvgMagnitude(Vector[] vecs) {
        double res = 0;
        for(Vector v: vecs) {
            res += v.magnitude();
        }
        return res / vecs.length;
    }
}
