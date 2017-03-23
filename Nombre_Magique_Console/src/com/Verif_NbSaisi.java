package com;

import java.util.Scanner;

public class Verif_NbSaisi {
	int nombreSaisi;
	int nombreMagique;
	int tentative = 0;
	int limiteJeu;
	int limiteRand;
	int jeu;
	int mode;
	
	public void choixNombreMagique(int limiteRand) {
		this.limiteRand = limiteRand;
		this.limiteJeu = this.limiteRand - 1;
		this.nombreMagique = (int) (Math.random()*limiteRand);
	}
	
	//inclus choixModeNombre
	public void choixJeu() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Nombre magique : 1 / Mot magique : 2");
		this.jeu = saisie.nextInt();
		
		if(this.jeu == 1) {
			choixModeNombre();
		}
		else if(this.jeu == 2) {
			System.out.println("JEU EN CONSTRUCTION");
		}
	}
	
	//inclus nombreModeIllimite & nombreModeLimite
	public void choixModeNombre() {
		
		System.out.println("Vous devez trouver le nombre magique compris entre 0 et " + this.limiteJeu + ".");
		
		Scanner saisie = new Scanner(System.in);
		System.out.println("Mode illimité : 1 / Mode limité : 2");
		this.mode = saisie.nextInt();
		if(this.mode == 1) {
			nombreModeIllimite();
		}
		else if(this.mode == 2) {
			nombreModeLimite(10);
		}
	}
	
	public void saisieNombre() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("\n" + "Veuillez saisir un nombre :");
		this.nombreSaisi = saisie.nextInt();
	}
	
	//inclus verifNombreSaisi
	public void verifLimiteJeu() {
		//Vérification nombre saisi compris dans les limites du random
		if (this.nombreSaisi > limiteJeu) {
			Scanner saisie2 = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
			this.nombreSaisi = saisie2.nextInt();
		}
			
		else if (this.nombreSaisi < 0) {
			Scanner saisie3 = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nombre COMPRIS entre 0 et " + limiteJeu + " :");
			this.nombreSaisi = saisie3.nextInt();
		}
		else {
			verifNombreSaisi();
		}
	}
	
	public void verifNombreSaisi() {
		//si nombre saisi plus grand que nombre magique
		if (this.nombreSaisi > this.nombreMagique) {
			
			//affichage "plus petit"
			System.out.println("\n" + "Plus petit");
			
			//saisie d'un nouveau nombre 							
			Scanner sc = new Scanner(System.in);
			System.out.println("\n" + "Veuillez saisir un nouveau nombre :");
			this.nombreSaisi = sc.nextInt();
			
			this.tentative = this.tentative+1;
		}
			
		//si nombre saisi plus petit que nombre magique
		else if (this.nombreSaisi < this.nombreMagique) {
				
			//affichage "plus grand"
			System.out.println("\n" + "Plus grand");
			
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
	public void nombreModeLimite(int tentativesMax) {
		int tentativesRestantes;
		
		System.out.println("\n" + "Vous avez droit à " + tentativesMax + " tentatives.");

		saisieNombre();
		this.tentative = 1;
		
		while (this.nombreSaisi != this.nombreMagique && this.tentative != tentativesMax) {
			verifLimiteJeu();
		}
		
		if (this.nombreSaisi == this.nombreMagique || (this.nombreSaisi == this.nombreMagique && this.tentative == tentativesMax)) {
			//affichage du résultat 
			System.out.println("\n" + "GAGNE :)");
			System.out.println("Le nombre magique est " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}
		else if (this.tentative == tentativesMax){
			System.out.println("\n" + "PERDU :(");
			System.out.println("Le nombre magique était " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}	
	}
}


