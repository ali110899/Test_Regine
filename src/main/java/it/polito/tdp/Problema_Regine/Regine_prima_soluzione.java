package it.polito.tdp.Problema_Regine;

import java.util.ArrayList;
import java.util.List;

public class Regine_prima_soluzione {
	
	List<Integer> soluzione;

	public List<Integer> cercaRegine (int N) {
		
		this.soluzione = null;
		
		//AVVIO ricorsione al livello 0
		List<Integer> parziale = new ArrayList<Integer>();  //creo lista vuota
		regine_ricorsiva(parziale, 0, N);
		return this.soluzione;
	}
	
	private boolean regine_ricorsiva(List<Integer> parziale, int livello, int N) {
		
		if(livello==N) {  //caso terminale --> soluzione completa(sono già andata oltre quando arrivo a N, parto da 0 e arrivo a N-1)
			
			//System.out.println(parziale);
			this.soluzione = new ArrayList<Integer>(parziale);  //Attenzione devo fare la new della mia lista parziale(che cambia ogni vota)
			return false;  //non continuare!!
			
		} else {
			
			//Ho già parziale[0] fino a parziale[livello-1] già decise
			//devo decidere parziale[livello] tra tutti i valori possibili
			//da 0 a N-1 (colonne), purchè compatibili.
			
			for(int col=0; col<N; col++) {
				if(compatibile(livello, col, parziale)) {
					parziale.add(col);  //aggiungo e provo un tentativo
					
					boolean continua = regine_ricorsiva(parziale, livello+1, N);  //delego a quasto metodo di verificare se è possibile dato il livello successivo
					
					if(!continua) {
						return false;
					}
					
					//BACKTRACKING
					parziale.remove(parziale.size()-1);  //tolgo la regina che ho appena messo e la metto in altre posizioni possibili
					
				}
			}
			return true;
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
