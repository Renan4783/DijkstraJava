package dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Leitor {
    
    public Leitor(String s, ArrayList<Vertice> vertices, ArrayList<Aresta> arestas, ArrayList<String> caminho) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(s));
            boolean edge = false;
            boolean path = false;
            while (in.ready()) {
                String str = in.readLine();
                if (str.equals("#")) 
                {
                    edge = true;
                }
                else if (str.equals("$"))
                {
                    edge = false;
                    path = true;
                }
                else 
                {
                    if (edge == false && path == false) 
                    {
                        Vertice v = new Vertice(str);
                        vertices.add(v);
                    } 
                    else if (edge == true && path == false) 
                    {
                        String[] b = str.split(" ");
                        String v = b[0];
                        String v2 = b[1];
                        int peso = Integer.parseInt(b[2]);
                        Aresta newedge = new Aresta(v, v2, peso);
                        arestas.add(newedge);
                    }
                    else
                    {
                        String[] b = str.split(" ");
                        String inicio = b[0];
                        String fim = b[1];
                        caminho.add(inicio);
                        caminho.add(fim);
                    }
                }
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}