/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.ArrayList;

/**
 *
 * @author Renan
 */
 
public class Dijkstra {
   private static final String INICIO = "A";
   private static final String FIM = "F";
 
   public static void main(String[] args) {
      ArrayList<Vertice> vertices = new ArrayList<>();
      ArrayList<Aresta> edges = new ArrayList<>();
      ArrayList<String> caminho = new ArrayList<>();
      Leitor l = new Leitor("teste.txt", vertices, edges, caminho);
      String inicio = caminho.get(0);
      String fim = caminho.get(1);
      Grafo g = new Grafo(edges);
      System.out.println("Algoritmo de Dijkstra");
      g.printVertices(vertices);
      g.printArestas(edges);
      g.dijkstra(inicio);
      g.printCaminhoFinal(fim);
      g.printCaminho();
   }
}