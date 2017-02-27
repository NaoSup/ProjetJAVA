package com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Saisie du nombre magique à trouver
		Scanner saisie1 = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre magique compris entre 1 et 20: ");
		int nombreMagique = saisie1.nextInt();
		
		if (nombreMagique > 20 || nombreMagique < 1) {
			System.out.println("Le nombre saisi n'est pas compris entre 1 et 20");
		}
		else {
			//choix du mode
			Scanner scmode = new Scanner(System.in);
			System.out.println("Voulez-vous jouer en mode illimité ou limité ?");
			String mode = scmode.nextLine();
			
			//mode de jeu illimité
			if (mode == "illimité") {
				//permet au joueur de saisir des nombres
				Scanner saisie2 = new Scanner(System.in);
				System.out.println("Veuillez saisir un nombre :");
				int nombreSaisi = saisie2.nextInt();
				
				//Comptage du nombre de tentatives
				int tentative = 1;
				
				
				while (nombreSaisi != nombreMagique) {
					
					//si nombre saisi plus grand que nombre magique
					if (nombreSaisi > nombreMagique) {
						
						//affichage "plus petit"
						System.out.println("Plus petit");
						
						//saisie d'un nouveau nombre 
						Scanner sc = new Scanner(System.in);
						System.out.println("Veuillez saisir un nouveau nombre :");
						nombreSaisi = sc.nextInt();
						
						tentative = tentative+1;
					}
					
					//si nombre saisi plus petit que nombre magique
					else if (nombreSaisi < nombreMagique) {
						
						//affichage "plus grand"
						System.out.println("Plus grand");
						
						//saisie d'un nouveau nombre
						Scanner sc = new Scanner(System.in);
						System.out.println("Veuillez saisir un nouveau nombre :");
						nombreSaisi = sc.nextInt();
						
						tentative = tentative+1;
					}

				} //fin while
				
				System.out.println("Vous avez trouvez le nombre magique !!! :)");
				System.out.println("Le nombre magique est " + nombreMagique); //affichage nombre magique
				System.out.println("Nombre de tentatives : " + tentative); //affichage nombre tentative
				
			} //fin if mode illimité
		} //fin else	
	} //fin fonction MAIN	
} //fin class MAIN
