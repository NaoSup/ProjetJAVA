package com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Choix du jeu (mot magique ou nombre magique)
		Scanner saisie = new Scanner(System.in);
		System.out.println("Nombre magique : 1 / Mot magique : 2");
		int jeu = saisie.nextInt();
		
		if (jeu != 1 && jeu != 2) {
			Scanner sca = new Scanner(System.in);
			System.out.println("!!!! nombre magique : 1 / mot magique : 2");
			jeu = sca.nextInt();
		}
		
		if (jeu == 2) {
			System.out.println("EN TRAVAUX");;
		}
			
		else if (jeu == 1){
			//Random du nombre magique
			int limiteRand = 301; //limite le random entre 0 et 30 (inclus)
			int limiteJeu = limiteRand - 1;
			int nombreMagique = (int) (Math.random()*limiteRand);
			//System.out.println(nombreMagique);
				
			//règle du jeu
			System.out.println("\n" + "Vous devez trouvez un nombre compris entre 0 et " + limiteJeu + ". \n");
			
			//choix du mode de jeu
			Scanner scmode = new Scanner(System.in);
			System.out.println("Voulez-vous jouer en mode illimité (tapez 1) ou limité (tapez 2) ?");
			int mode = scmode.nextInt();
			
			//mode choisi incorrect
			if (mode != 1 && mode != 2) {
				Scanner saisie6 = new Scanner(System.in);
				System.out.println("Veuillez choisir le mode numéro 1 (illimité) ou le mode numéro 2 : ");
				mode = saisie6.nextInt();
			}
			
			//mode illimité
			if (mode == 1) {
				//permet au joueur de saisir des nombres
				Scanner saisie3 = new Scanner(System.in);
				System.out.println("\n" + "Veuillez saisir un nombre :");
				int nombreSaisi = saisie3.nextInt();
					
				//Comptage du nombre de tentatives
				int tentative = 1;
					
				while (nombreSaisi != nombreMagique) {
							
					//Vérification nombre saisi compris dans les limites du random
					if (nombreSaisi > limiteJeu) {
						Scanner saisie4 = new Scanner(System.in);
						System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
						nombreSaisi = saisie4.nextInt();
					}
						
					else if (nombreSaisi < 0) {
						Scanner saisie5 = new Scanner(System.in);
						System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
						nombreSaisi = saisie5.nextInt();
					}
						
					else {
						//si nombre saisi plus grand que nombre magique
						if (nombreSaisi > nombreMagique) {
							
							//affichage "plus petit"
							System.out.println("\n" + "Plus petit");
							
							//saisie d'un nouveau nombre 							
							Scanner sc = new Scanner(System.in);
							System.out.println("\n" + "Veuillez saisir un nouveau nombre :");
							nombreSaisi = sc.nextInt();
							
							tentative = tentative+1;
						}
							
						//si nombre saisi plus petit que nombre magique
						else if (nombreSaisi < nombreMagique) {
								
							//affichage "plus grand"
							System.out.println("\n" + "Plus grand");
							
							//saisie d'un nouveau nombre
							Scanner sc = new Scanner(System.in);
							System.out.println("\n" + "Veuillez saisir un nouveau nombre :");
							nombreSaisi = sc.nextInt();
								
							tentative = tentative+1;
						}
					}//fin else
				} //fin while

					
				System.out.println("\n" + "Vous avez trouvez le nombre magique !!! :)");
				System.out.println("Le nombre magique est " + nombreMagique); //affichage nombre magique
				System.out.println("Nombre de tentatives : " + tentative); //affichage nombre tentative
				
			} //fin if mode illimité
				
			//mode limité
			else if (mode == 2) {
				int tentativesMax = 10;
				int tentativesRestantes ;
				
				System.out.println("\n" + "Vous avez droit à " + tentativesMax + " tentatives.");
				
				//permet au joueur de saisir des nombres
				Scanner saisie3 = new Scanner(System.in);
				System.out.println("\n" + "Veuillez saisir un nombre :");
				int nombreSaisi = saisie3.nextInt();
					
				//Comptage du nombre de tentatives
				int tentative = 1;
					
					
				while (nombreSaisi != nombreMagique && tentative != tentativesMax) {
							
					//Vérification nombre saisi compris dans les limites du random
					if (nombreSaisi > limiteJeu) {
						Scanner saisie4 = new Scanner(System.in);
						System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
						nombreSaisi = saisie4.nextInt();
					}
						
					else if (nombreSaisi < 0) {
						Scanner saisie5 = new Scanner(System.in);
						System.out.println("\n Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
						nombreSaisi = saisie5.nextInt();
					}
					
					else {
						//si nombre saisi plus grand que nombre magique
						if (nombreSaisi > nombreMagique) {
							
							//affichage "plus petit"
							System.out.println("\n" + "Plus petit");
							
							//nombre de tentatives restantes 
							tentativesRestantes = tentativesMax - tentative;
							System.out.println("\n" + "Il vous reste " + tentativesRestantes + " tentatives.");
							
							//saisie d'un nouveau nombre 							
							Scanner sc = new Scanner(System.in);
							System.out.println("Veuillez saisir un nouveau nombre :");
							nombreSaisi = sc.nextInt();
							
							tentative = tentative+1;
						}
							
						//si nombre saisi plus petit que nombre magique
						else if (nombreSaisi < nombreMagique) {
								
							//affichage "plus grand"
							System.out.println("\n" + "Plus grand");
							
							//nombre de tentatives restantes 
							tentativesRestantes = tentativesMax - tentative;
							System.out.println("\n" + "Il vous reste " + tentativesRestantes + " tentatives.");
							
							//saisie d'un nouveau nombre
							Scanner sc = new Scanner(System.in);
							System.out.println("Veuillez saisir un nouveau nombre :");
							nombreSaisi = sc.nextInt();
								
							tentative = tentative+1;
						}
					}//fin else
				}//fin while
				
				if (nombreSaisi == nombreMagique || (nombreSaisi == nombreMagique && tentative == tentativesMax)) {
					//affichage du résultat 
					System.out.println("\n" + "GAGNE :)");
					System.out.println("Le nombre magique est " + nombreMagique); //affichage nombre magique
					System.out.println("Nombre de tentatives : " + tentative); //affichage nombre tentative
				}
				else if (tentative == tentativesMax){
					System.out.println("\n" + "PERDU :(");
					System.out.println("Le nombre magique était " + nombreMagique); //affichage nombre magique
					System.out.println("Nombre de tentatives : " + tentative); //affichage nombre tentative
				}	
			}//fin if mode limité
		}		
	} //fin fonction MAIN	
} //fin class MAIN
