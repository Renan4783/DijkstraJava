/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author Renan
 */
public class Grafo {
   private final Map<String, Vertice> grafo;

   public Grafo(ArrayList<Aresta> edges) {
      grafo = new HashMap<>(edges.size());
 
      for (Aresta e : edges) {
         if (!grafo.containsKey(e.getVertice1())) grafo.put(e.getVertice1(), new Vertice(e.getVertice1()));
         if (!grafo.containsKey(e.getVertice2())) grafo.put(e.getVertice2(), new Vertice(e.getVertice2()));
      }
 
      for (Aresta e : edges) {
         grafo.get(e.getVertice1()).vizinhos.put(grafo.get(e.getVertice2()), e.getDistancia());
         //graph.get(e.vertice2).vizinhos.put(grafo.get(e.vertice1), e.distancia);
      }
   }
   
   public void dijkstra(String inicio) {
      if (!grafo.containsKey(inicio)) {
         System.err.printf("Grafo não contém vertice inicial \"%s\"\n", inicio);
         return;
      }
      final Vertice source = grafo.get(inicio);
      NavigableSet<Vertice> q = new TreeSet<>();
 
      for (Vertice v : grafo.values()) {
         v.pai = v == source ? source : null;
         v.distancia = v == source ? 0 : Integer.MAX_VALUE;
         q.add(v);
      }
 
      dijkstra(q);
   }
 
   private void dijkstra(final NavigableSet<Vertice> q) {      
        Vertice u;
        Vertice v;
      while (!q.isEmpty()) {
 
         u = q.pollFirst();
         if (u.distancia == Integer.MAX_VALUE) break;

         for (Map.Entry<Vertice, Integer> a : u.vizinhos.entrySet()) {
            v = a.getKey();
 
            final int alternateDist = u.distancia + a.getValue();
            if (alternateDist < v.distancia) {
               q.remove(v);
               v.distancia = alternateDist;
               v.pai = u;
               q.add(v);
            } 
         }
      }
   }
 
   public void printCaminhoFinal(String fim) {
      if (!grafo.containsKey(fim)) {
         System.err.printf("Grafo não tem vertice final \"%s\"\n", fim);
         return;
      }
      System.out.println("Caminho:");
      grafo.get(fim).printCaminho();
      System.out.println();
   }

   public void printCaminho() {
      for (Vertice v : grafo.values()) {
         v.printCaminho();
         System.out.println();
      }
   }
    
   public void printVertices(ArrayList<Vertice> vertices){
        System.out.println("Vertices:");
        for (Vertice u : vertices) {
            System.out.println(u.getNome());
        }
        System.out.println("");
    }
    
    public void printArestas(ArrayList<Aresta> arestas){
        System.out.println("Arestas:");
        for (Aresta v : arestas) {
            System.out.println(v.getVertice1() + " -> " + v.getVertice2() + " | " + v.getDistancia());
        }
        System.out.println("");
    }
}
