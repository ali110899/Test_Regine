package it.polito.tdp.Anagrammi_esempi;

public class Anagramma {
	
	/*
	 * AVVIO RICORSIONE
	 * 
	 * Riceve una stringa e stampa tutti i suoi anagrammi 
	*/
	
	public void anagramma(String s) {
		
		anagramma_ricorsiva("", 0, s); //"s" rappresenta la stringa
	}
	
	/*
	 * PROCEDURA RICORSIVA
	 * 
	 * Data una soluzione parziale, stampa TUTTI gli anagrammi che iniziano in quel modo.
	 * 
	 * parziale --> Soluzione parziale, iniziale del mio anagramma. Avrà "livello" carattere
	 * livello --> Livello della ricorsione
	 * l_rimanenti --> Caratteri ancora da sistemare
	 */
	
	private void anagramma_ricorsiva(String parziale, int livello, String l_rimanenti) { 
	
		if(l_rimanenti.length()==0) { //caso terminale --> non rimane nulla
			
			System.out.println(parziale);
			
		} else {
			
			// es.Intermedio--> parziale= "AC", livello=2, l_rimanenti="BD"
			//devo  aggiungere il terzo carattere tra B e D ed aggiungerlo alla stringa AC --> due sottocasi
			//devo decompore questto problema in sottoproblemi quanti sono le lettere rimanenti
			
			for(int pos=0; pos<l_rimanenti.length(); pos++) {
				anagramma_ricorsiva(parziale+l_rimanenti.charAt(pos), 
									livello+1, 
									l_rimanenti.substring(0, pos)+l_rimanenti.substring(pos+1));
			}
			
		}
		
	}
	
	public static void main(String[] args) {
	
		Anagramma main = new Anagramma();
		main.anagramma("ABCD");
		
	}

}
