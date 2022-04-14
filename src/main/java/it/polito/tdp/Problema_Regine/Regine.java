package it.polito.tdp.Problema_Regine;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	public void cercaRegine (int N) {
		
		//AVVIO ricorsione al livello 0
		List<Integer> parziale = new ArrayList<Integer>();  //creo lista vuota
		regine_ricorsiva(parziale, 0, N);
	}
	
	private void regine_ricorsiva(List<Integer> parziale, int livello, int N) {
		
		if(livello==N) {  //caso terminale --> soluzione completa(sono già andata oltre quando arrivo a N, parto da 0 e arrivo a N-1)
			
			System.out.println(parziale);
			
		} else {
			
			//Ho già parziale[0] fino a parziale[livello-1] già decise
			//devo decidere parziale[livello] tra tutti i valori possibili
			//da 0 a N-1 (colonne), purchè compatibili.
			
			
			for(int col=0; col<N; col++) {
				if(compatibile(livello, col, parziale)) {
					parziale.add(col);  //aggiungo e provo un tentativo
					regine_ricorsiva(parziale, livello+1, N);  //delego a quasto metodo di verificare se è possibile dato il livello successivo
					//BACKTRACKING
					parziale.remove(parziale.size()-1);  //tolgo la regina che ho appena messo e la metto in altre posizioni possibili
					
				}
			}
			
		}
		
	}
	
	private boolean compatibile(int livello, Integer col, List<Integer> parziale) {
		
		//Verifica COLONNE
		if(parziale.indexOf(col) != -1) {
			return  false;
		}
		
		//Verifica DIAGONALI
		//basta fare se la differenza tra coordinate della prima riga-colonna è uguale a quella della seconda --> stanno sulla stessa riga
		for(int riga=0; riga<parziale.size(); riga++) {
			//regina alle coordinate (R,c)=(riga, parziale.get(riga))
			//confrontare con (R,C)=(livello, col)
			if(riga+parziale.get(riga) == livello+col) {
				return false;
			}
			if(riga-parziale.get(riga) == livello-col) {
				return false;
			}
		}
		return true;
	}
	
}
