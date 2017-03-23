package impact;

import java.util.Random;
import java.util.Scanner;


public class test3 {

	public static void main(String[] args) {


			 
			String motMagique = "SeSaMe" ;
	        Random rnd = new Random() ; 
	        Scanner clavier = new Scanner (System.in); 
	        String motclee[] = {"SeSaMe" , "MeSaMe", "easy" , " kita", "amy"};

			char tab [] ={ 'S' , 'M' , 'S' , 'a' , 'e' ,'a'} ;
			char tab2 [] ={'q' , 's' , 'x' , 'w', 'k' , 'i'};
			// Il s'agit ici de faire un random sur un nombre compris entre 0 et la taille du tableau
		     //int position = rmd.nextInt(valeurMax - valeurMin + 1) + valeurMin;
		     int position = rnd.nextInt(tab.length-1 - 0 + 1) + 0;
		     System.out.println("position : " + position);
		     int bonjour = rnd.nextInt(tab2.length-1 - 0 + 1) + 0;
		     System.out.println("bonjour : " + bonjour);

			String motSaisie = "" ;
		
			/*for(int i= 0 ; i<=motclee.length-1 ; i++){
				String mad ;
				mad = motclee[i] ;
				System.out.println(mad);
			}*/

			String motAtrouvee = motclee[0];
			// On veut découper les lettres du mot : SeSame
			
			//Ici on crée un tableau de caratères qui aura la taille du mot à trouver ... ici SeSame
			char tebLettre [] = new char[motAtrouvee.length()-1] ;

			for(int j=0; j<=motAtrouvee.length()-1; j++){
				// cette fonction permet de découper le mot par caractères
				char lettres1 = motAtrouvee.charAt(j);
				System.out.println(lettres1);			
			}
			
			  /*System.out.println("Quel est le mot magique parmi ces lettres :");
			   motSaisie = clavier.next();
	 
			   if(motSaisie.equals(motMagique)){
				  System.out.println("vous avez trouvez le bon mot Magique:");
				  motSaisie = clavier.next();
			   }
				
			   else {
			   System.out.println("vous n'avez pas trouvez le bon mot Magique");
	
			}*/
			
	}
}	

		
		

	


