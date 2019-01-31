/*  Darian Sampare
 *  T00578132
 *  COMP 3411
 *  Assignment 1
 */

import java.util.*;

public class MatrixMultiply {

    //initial size of the matrices
    public static int m1_rows = 3;
    public static int m1_cols = 3;
    public static int m2_rows = 3;
    public static int m2_cols = 3;
    
    public static int [][] matrix_1 = new int [m1_rows][m1_cols]; 
    public static int [][] matrix_2 = new int [m2_rows][m2_cols];

    //initialize the resulting matrix based on size of operand matrices
    public static int [][] product = new int [m1_rows][m2_cols];

    //initialize threads needed for calculations
    public static Worker[][] WorkerThreads = new Worker [m1_rows][m2_cols];

     

    public static void main(String[] args) {
        
        //initialize the contents of matrix 1
        for (int i=0; i < m1_rows; i++) {
            for (int j=0; j < m1_cols; j++) {
                matrix_1 [i][j] = (int)(Math.random()*10);
            } 
        }

        //initialize the contents of matrix 2
        for (int i=0; i < m2_rows; i++) {
            for (int j=0; j < m2_cols; j++) {
                matrix_2 [i][j] = (int)(Math.random()*10);
            } 
        }

        //calculate each matrix value with a new thread
        for (int i=0; i < m1_rows; i++) {
            for (int j=0; j < m2_cols; j++) {
                WorkerThreads[i][j] = new Worker(i,j,m1_rows,m2_cols,m1_cols,matrix_1,matrix_2,product);
                WorkerThreads[i][j].start();
            } 
        }

        //contents of matrix 1
        System.out.println("Matrix 1:");
        for (int i=0; i < m1_rows; i++) {
            for (int j=0; j < m1_cols; j++) {
                System.out.print("["+ matrix_1[i][j] +"]");
            }
            System.out.println();
        }
        System.out.println();

        //contents of matrix 2
        System.out.println("Matrix 2:");
        for (int i=0; i < m2_rows; i++) {
            for (int j=0; j < m2_cols; j++) {
                System.out.print("["+ matrix_2[i][j] +"]");
            }
            System.out.println();
        }
        System.out.println();
        
        //contents of resulting matrix
        System.out.println("Product Matrix:");
        for (int i=0; i < m1_rows; i++) {
            for (int j=0; j < m2_cols; j++) {

                //wait for threads to terminate before printing results
                try { WorkerThreads[i][j].join(); }
                
                catch(InterruptedException ie) {}
                
                //print resulting cell of product matrix
                System.out.print("["+ product[i][j] +"]");
            }
            System.out.println();
        }
    }

}
