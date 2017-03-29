package com;

import java.util.Scanner;

public class Fonctions {
	int nombreSaisi;
	int nombreMagique;
	int tentative = 0;
	int tentativesRestantes;
	int tentativesMax = 10;
	int limiteJeu;
	int limiteRand=501;
	int jeu;
	int mode;
	
	public void choixNombreMagique() {
		this.limiteJeu = this.limiteRand - 1; //limite du jeu affich�e au joueur
		this.nombreMagique = (int) (Math.random()*limiteRand); //calcul du nombre magique
	}
	
	//inclus choixNombreMagique & choixModeNombre
	public void choixJeu() {
		//choix du jeu
		Scanner saisie = new Scanner(System.in);
		System.out.println("Nombre magique : 1 / Mot magique : 2");
		this.jeu = saisie.nextInt();
		
		//nombre magique
		if(this.jeu == 1) {
			choixNombreMagique();
			choixModeNombre();

		}
		
		//mot magique
		else if(this.jeu == 2) {
			System.out.println("JEU EN CONSTRUCTION");
		}
	}
	
	//inclus nombreModeIllimite & nombreModeLimite
	public void choixModeNombre() {
		//�nonc� de la r�gle du jeu
		System.out.println("Vous devez trouver le nombre magique compris entre 0 et " + this.limiteJeu + ".");
		
		//choix du mode de jeu
		Scanner saisie = new Scanner(System.in);
		System.out.println("Mode illimit� : 1 / Mode limit� : 2");
		this.mode = saisie.nextInt();
		if(this.mode == 1) {
			nombreModeIllimite();
		}
		else if(this.mode == 2) {
			nombreModeLimite();
		}
	}
	
	public void saisieNombre() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("\n" + "Veuillez saisir un nombre :");
		this.nombreSaisi = saisie.nextInt();
	}
	
	//inclus verifNombreSaisi
	public void verifLimiteJeu() {
		//Verification nombre saisi compris dans les limites du jeu
		if (this.nombreSaisi > limiteJeu || this.nombreSaisi < 0) {
			Scanner saisie2 = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
			this.nombreSaisi = saisie2.nextInt();
		}
		else {
			verifNombreSaisi();
		}
	}
	
	public void verifNombreSaisi() {
		//si le nombre saisi est plus grand que le nombre magique
		if (this.nombreSaisi > this.nombreMagique) {
			
			//affichage "plus petit"
			System.out.println("\n" + "Plus petit.");
			
			//si dans le mode limit� on affiche les tentatives restantes
			if(this.mode == 2) {
				this.tentativesRestantes = tentativesMax - this.tentative;
				System.out.println("Il vous reste " + this.tentativesRestantes + " tentative(s).");
			}
			
			//saisie d'un nouveau nombre 							
			Scanner sc = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nouveau nombre :");
			this.nombreSaisi = sc.nextInt();
			
			this.tentative = this.tentative+1;	
		}
			
		//si le nombre saisi est plus petit que le nombre magique
		else if (this.nombreSaisi < this.nombreMagique) {
				
			//affichage "plus grand"
			System.out.println("\n" + "Plus grand.");
			
			//si dans le mode limit� on affiche les tentatives restantes
			if(this.mode == 2) {
				this.tentativesRestantes = tentativesMax - this.tentative;
				System.out.println("Il vous reste " + this.tentativesRestantes + " tentative(s).");
			}
			
			//saisie d'un nouveau nombre
			Scanner sc = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nouveau nombre :");
			this.nombreSaisi = sc.nextInt();
				
			this.tentative = this.tentative+1;
		}
	}
	
	//inclus saisieNombre & verifLimiteJeu
	public void nombreModeIllimite(){
		saisieNombre();
		this.tentative = 1;
		
		while (this.nombreSaisi != this.nombreMagique) {
			verifLimiteJeu();
		}
		
		System.out.println("\n" + "Vous avez trouvez le nombre magique !!! :)");
		System.out.println("Le nombre magique est " + this.nombreMagique); //affichage nombre magique
		System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
	}
	
	//inclus saisieNombre & verifLimiteJeu
	public void nombreModeLimite() {
		//�nonc� de la r�gle du mode limit�
		System.out.println("\n" + "Vous avez droit � " + this.tentativesMax + " tentatives.");

		saisieNombre();
		this.tentative = 1;
		
		//on v�rifie le nombre saisi et le nombre de tentatives du joueur
		while (this.nombreSaisi != this.nombreMagique && this.tentative != this.tentativesMax) {
			verifLimiteJeu();
		}
		
		//si le nombre magique est trouv�
		if (this.nombreSaisi == this.nombreMagique || (this.nombreSaisi == this.nombreMagique && this.tentative == this.tentativesMax)) {
			//affichage du r�sultat 
			System.out.println("\n" + "GAGNE :)");
			System.out.println("Le nombre magique est " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}
		
		//si le nombre magique n'est pas trouv�
		else if (this.tentative == tentativesMax){
			System.out.println("\n" + "PERDU :(");
			System.out.println("Le nombre magique �tait " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}	
	}
	
	public void niveaux() {
		
	}
}


