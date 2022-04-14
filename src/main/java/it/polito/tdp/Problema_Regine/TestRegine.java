package it.polito.tdp.Problema_Regine;

import java.util.List;

public class TestRegine {

	public static void main(String[] args) {
		
		//Regine r = new Regine();
		//r.cercaRegine(8);
		
		//Regine_migliorata r = new Regine_migliorata();
		//List<List<Integer>> soluzioni = r.cercaRegine(8);
		//System.out.println(soluzioni.size());
	 
		Regine_prima_soluzione r = new Regine_prima_soluzione();
		List<Integer> soluzione = r.cercaRegine(15);
		System.out.println(soluzione);
		
	}

}
