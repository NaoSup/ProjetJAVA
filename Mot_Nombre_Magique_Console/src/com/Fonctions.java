package com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fonctions {
	int nombreSaisi;
	int nombreMagique;
	int tentative = 0;
	int tentativesRestantes;
	int tentativesMax = 10;
	int limiteJeu;
	int limiteRand=1001;
	int jeu;
	int mode;
	int niveau;
	
	public void choixNombreMagique() {
		this.limiteJeu = this.limiteRand - 1; //limite du jeu affichée au joueur
		this.nombreMagique = (int) (Math.random()*limiteRand); //calcul du nombre magique
	}
	
	//inclus nombreMagique & motMagique
	public void choixJeu() {
		//choix du jeu
		Scanner saisie = new Scanner(System.in);
		System.out.println("Nombre magique : 1 / Mot magique : 2");
		this.jeu = saisie.nextInt();
		
		//nombre magique
		if(this.jeu == 1) {
			nombreMagique();
		}
		
		//mot magique
		else if(this.jeu == 2) {
			motMagique();  
		}
	}
	
	public void motMagique() {
		String []tabMot = {"ALLO", "BONJOUR","MANGER","BOIRE"};
        	Random rand = new Random();
        	int nombreAleatoire;
        	String motMagique;
        
        
       		nombreAleatoire = rand.nextInt(tabMot.length);
        	motMagique = tabMot[nombreAleatoire];

       		String motSaisi; // = mot de base
        	String lettre = "AZERTYUIOPQSDFGHJKLMWXCVBN";
        
        	int max;
        	int stop = 0;
        	int min = 0;
        	int ajoutdelettre = 3;
        	String lettresMysteres = motMagique;
        
        
        	System.out.println("Voici une liste de lettres" );
        
        	for (int i=0; i < ajoutdelettre; i++){
            		nombreAleatoire = rand.nextInt(26);
            		lettresMysteres += lettre.charAt(nombreAleatoire);
        	}
       		ArrayList<Integer> lettreprise = new ArrayList<>();
        	boolean co = true;
        	while (co){
            		nombreAleatoire = rand.nextInt(lettresMysteres.length());
            		if (!(lettreprise.contains(nombreAleatoire))){
                		lettreprise.add(nombreAleatoire);
                		System.out.println(lettresMysteres.charAt(nombreAleatoire));
                		stop++;
            		}
            		if (stop == lettresMysteres.length()){	
                		co = false;
            		}
        	}
  
        	Scanner reponse = new Scanner(System.in);
       		boolean po = true;
       		while(po){
    	   		motSaisi = reponse.nextLine();
    	   		if(!(motSaisi.toUpperCase().equals(motMagique)) ) {
        	  		System.out.println("Essaie encore");     	 
           		}
			else{
        	   		po = false;
                		System.out.println("Bien vu");
                		System.out.println("le mot magique est bien : " + motMagique);
           		}
       		}
	}
	
	//inclus nombreModeIllimite & niveaux
	public void nombreMagique() {
	
		//choix du mode de jeu
		Scanner saisie = new Scanner(System.in);
		System.out.println("Mode illimité : 1 / Mode limité : 2");
		this.mode = saisie.nextInt();
		if(this.mode == 1) {
			choixNombreMagique();
			nombreModeIllimite();
		}
		else if(this.mode == 2) {
			niveaux();
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
			
			//si dans le mode limité on affiche les tentatives restantes
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
			
			//si dans le mode limité on affiche les tentatives restantes
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
		
		//Enoncé de la règle du jeu
		System.out.println("Vous devez trouver le nombre magique compris entre 0 et " + this.limiteJeu + ".");
		
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
		
		//Ã©noncÃ© de la règle du jeu
		System.out.println("Vous devez trouver le nombre magique compris entre 0 et " + this.limiteJeu + ".");
		//Ã©noncÃ© de la règle du mode limité
		System.out.println("\n" + "Vous avez droit à  " + this.tentativesMax + " tentatives.");

		saisieNombre();
		this.tentative = 1;
		
		//on vérifie le nombre saisi et le nombre de tentatives du joueur
		while (this.nombreSaisi != this.nombreMagique && this.tentative != this.tentativesMax) {
			verifLimiteJeu();
		}
		
		//si le nombre magique est trouvé
		if (this.nombreSaisi == this.nombreMagique || (this.nombreSaisi == this.nombreMagique && this.tentative == this.tentativesMax)) {
			//affichage du résultat 
			System.out.println("\n" + "GAGNE :)");
			System.out.println("Le nombre magique est " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}
		
		//si le nombre magique n'est pas trouvé
		else if (this.tentative == tentativesMax){
			System.out.println("\n" + "PERDU :(");
			System.out.println("Le nombre magique était " + this.nombreMagique); //affichage nombre magique
			System.out.println("Nombre de tentatives : " + this.tentative); //affichage nombre tentative
		}	
	}
	
	//inclus choixNombreMagique & nombreModeLimite
	public void niveaux() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir un niveau : ");
		System.out.println("Très Facile: 1  Facile: 2  Moyen: 3  Difficile: 4");
		this.niveau = sc.nextInt();
		
		if(this.niveau == 1) {
			this.limiteRand = 401;
			this.tentativesMax = 12;
			choixNombreMagique();
			nombreModeLimite();
		}
		else if(this.niveau == 2) {
			this.limiteRand = 501;
			this.tentativesMax = 10;
			choixNombreMagique();
			nombreModeLimite();
		}
		else if(this.niveau == 3) {
			this.limiteRand = 1001;
			this.tentativesMax = 10;
			choixNombreMagique();
			nombreModeLimite();
		}
		else if(this.niveau == 4) {
			this.limiteRand = 2001;
			this.tentativesMax = 10;
			choixNombreMagique();
			nombreModeLimite();
		}
	}
}


