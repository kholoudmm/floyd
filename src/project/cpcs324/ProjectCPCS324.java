/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.cpcs324; 

import java.util.*;
import java.lang.*;
import java.io.*;
 
public class ProjectCPCS324 {
  
 final static int INFINITY = 999999, vertices = 10;
 
    static void FloydWarshall(int graph[][])
    {
        int[][] D = new int[vertices][vertices];
        int i, j, k;
  
        // loop puts values of matrix in the main in the previous matrix
        for (i = 0; i < vertices; i++)
            for (j = 0; j < vertices; j++)
                D[i][j] = graph[i][j]; //copy the vertex
 
        // the algorithm "Floyd-Warshall"
        for (k = 0; k < vertices; k++)
        {
            for (i = 0; i < vertices; i++)
            {
                for (j = 0; j < vertices; j++)
                {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }

            // Print the matrix
            System.out.println("\niteration " + (k + 1) + ": ");
            display(D);
        }

    }

   static void display(int[][] DMatric)
    {
      // display the matrix after each iteration
        for (int i=0; i<vertices; ++i) {
            for (int j=0; j<vertices; ++j) {
                if (DMatric[i][j]==INFINITY)
                    System.out.printf("%1s \t", "∞");
                else
                    System.out.printf("%1d \t", DMatric[i][j]);
            }
            System.out.println("");
        }
    }
 
       
        
    public static void main(String[] args)
    {
        
        int[][] arrayMatrix = {
        {0, 10, INFINITY, INFINITY, INFINITY, 5, INFINITY, INFINITY, INFINITY, INFINITY},
        {INFINITY, 0, 3, INFINITY, 3, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
        {INFINITY, INFINITY, 0, 4, INFINITY, INFINITY, INFINITY, 5, INFINITY, INFINITY},
        {INFINITY, INFINITY, INFINITY, 0, INFINITY, INFINITY, INFINITY, INFINITY, 4, INFINITY},
        {INFINITY, INFINITY, INFINITY, 7, 0, INFINITY, 2, INFINITY, INFINITY, INFINITY},
        {INFINITY, 3, INFINITY, INFINITY, INFINITY, 0, INFINITY, INFINITY, INFINITY, 2},
        {INFINITY, INFINITY, INFINITY, 7, INFINITY, INFINITY, 0, INFINITY, INFINITY, INFINITY},
        {INFINITY, INFINITY, INFINITY, 4, INFINITY, INFINITY, INFINITY, 0, 3, INFINITY},
        {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 0, INFINITY},
        {INFINITY, 6, INFINITY, INFINITY, INFINITY, INFINITY, 8, INFINITY, INFINITY, 0},};

        System.out.println("The Original Adjacency Matrix : ");
        display(arrayMatrix);
        FloydWarshall(arrayMatrix);
    }
}
