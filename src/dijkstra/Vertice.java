/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Renan
 */

public class Vertice implements Comparable<Vertice>{
	private final String nome;
	public int distancia = Integer.MAX_VALUE;
	public Vertice pai = null;
	public final Map<Vertice, Integer> vizinhos = new HashMap<>();
 
	public Vertice(String name)
	{
		this.nome = name;
	}

        
        
	public void printCaminho()
	{
		if (this == this.pai)
		{
			System.out.printf("%s", this.getNome());
		}
		else if (this.pai == null)
		{
			System.out.printf("%s(unreached)", this.getNome());
		}
		else
		{
			this.pai.printCaminho();
			System.out.printf(" -> %s(%d)", this.getNome(), this.distancia);
		}
	}
 
	public int compareTo(Vertice outroVertice)
	{
		if (distancia == outroVertice.distancia)
			return getNome().compareTo(outroVertice.getNome());
 
		return Integer.compare(distancia, outroVertice.distancia);
	}
 
	@Override public String toString()
	{
		return "(" + getNome() + ", " + distancia + ")";
	}

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    }
