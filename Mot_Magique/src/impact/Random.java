package impact;


import java.util.Random;
import java.util.Scanner;


public class test3 {

	public static void main(String[] args) {


			 
			//String motMagique = "SeSaMe" ;
	        Random rnd = new Random() ; 
	        Scanner clavier = new Scanner (System.in); 
	        String motclee[] = {"SeSaMe" , "MeSaMe", "easy" , " kita", "amy"};
            
			char tab [] ={ 'S' , 'M' , 'S' , 'a' , 'e' ,'a'} ;
			char tab2 [] ={'q' , 's' , 'x' , 'w', 'k' , 'i'};
			// Il s'agit ici de faire un random sur un nombre compris entre 0 et la taille du tableau
		     //int position = rmd.nextInt(valeurMax - valeurMin + 1) + valeurMin;
		     int position = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position]);
		     
		     int position2 = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position2]);
		     
		     
		     int position3 = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position3]);
		     
		     int position4 = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position4]);
		     
		     int position5 = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position5]);
		     
		     
		     int position6 = (int) (Math.random() * tab.length );
		     System.out.println("à l'emplacement nous avons " + tab[position6]);
		     
		     
		     int position7 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position7]);
		     
		     int position8 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position8]);
		     
		     int position9 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position9]);
		     
		     int position10 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position10]);
		     
		     
		     int position11 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position11]);
		     
		     
		     int position12 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position12]);
		     
		     
		     int position13 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position13]);
		     
		     int position14 = (int) (Math.random() * tab2.length );
		     System.out.println("à l'emplacement nous avons " + tab2[position14]);
		     /*int bonjour = rnd.nextInt(tab2.length-1 - 0 + 1) + 0;
		     System.out.println("bonjour : " + bonjour);
		     int bonsoir = rnd.nextInt(tab.length-1 - 0 + 1) + 0 ;
		     System.out.println("bonsoir:" + bonsoir);
		     int noir = rnd.nextInt(tab2.length-1 - 0 + 1) + 0 ;
		     System.out.println("noir:" + noir) ;
		     int effective = rnd.nextInt(tab.length-1 - 0 + 1) + 0 ;
		     System.out.println("voila:" + effective) ;
		     int king = rnd.nextInt(tab2.length-1 - 0 + 1) + 0 ;
		     System.out.println("voila:" + king) ;
		     int kong = rnd.nextInt(tab2.length-1 - 0 + 1) + 0 ;
		     System.out.println("voila:" + kong) ;
		     
		     int voici = rnd.nextInt(tab2.length-1 - 0 + 1) + 0 ;
		     System.out.println("voila:" + voici);*/
		     

			String motSaisie = "" ;
		
		
			/*for(int i= 0 ; i<=motclee.length-1 ; i++){
				String mad ;
				mad = motclee[i] ;
				System.out.println(mad);
			}*/

			/*	String motAtrouvee = motclee[0];
			// On veut découper les lettres du mot : SeSame
			
			//Ici on crée un tableau de caratères qui aura la taille du mot à trouver ... ici SeSame
			char tebLettre [] = new char[motAtrouvee.length()-1] ;

			for(int j=0; j<=motAtrouvee.length()-1; j++){
				// cette fonction permet de découper le mot par caractères
				char lettres1 = motAtrouvee.charAt(j);
				System.out.println(lettres1);			
			}*/
			
			 System.out.println("Quel est le mot magique parmi ces lettres :");
			   motSaisie = clavier.next();
               boolean found = false ;
			   for(String element : motclee )
			   
			   if(element.equals(motSaisie)){
				   found = true ;
				  System.out.println("vous avez trouvez le bon mot Magique:");
				  motSaisie = clavier.next();
				  
				  return  ;
			   }
			   
			   if (found) {
				    System.out.println( "The array contains the string: " + motSaisie );
				} else {
				    System.out.println( "The array does not contains the string: " + motSaisie );
				}
				
			   /*else {
			   System.out.println("vous n'avez pas trouvez le bon mot Magique");
			   
	
			}*/
			   }
			
	}



		
		

	


