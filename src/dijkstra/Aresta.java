/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author Renan
 */

public class Aresta {
      private final String vertice1;
      private final String vertice2;
      private final int distancia;
      
      public Aresta(String v1, String v2, int dist) {
         this.vertice1 = v1;
         this.vertice2 = v2;
         this.distancia = dist;
      }

    /**
     * @return the vertice1
     */
    public String getVertice1() {
        return vertice1;
    }

    /**
     * @return the vertice2
     */
    public String getVertice2() {
        return vertice2;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }
      
      
   }
