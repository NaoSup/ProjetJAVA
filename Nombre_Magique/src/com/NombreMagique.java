package com; 

 
import java.awt.Color;
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JTextField; 

public class NombreMagique extends JFrame implements ActionListener 
{ 
	//??
   private static final long serialVersionUID = 1L; 

   private int nombreSaisi; 
   private int nombreMagique; 
   private int tentative; 
   private int tentativesMax = 10;
   private int tentativesRest = tentativesMax - tentative;
   private int limiteRand = 501;
   private int limiteJeu = limiteRand-1;
   private boolean saisieValide = false; 
   
   private JLabel regle; 
   private JTextField caseNombreSaisi; 
   private JLabel labelEtat; 
   
	public int choixNombreMagique() {
		this.nombreMagique = (int) (Math.random()*this.limiteRand);
		return this.nombreMagique;
	}
   
   public NombreMagique() {  
      super(); 
      
      // Obtenir le panneau de contenu et changer son layout en un FlowLayout. 
      Container panel = getContentPane(); 
      panel.setLayout(new FlowLayout()); 
      panel.setBackground(Color.white);
      
      // Créer l'étiquette et le champ texte du nombre à deviner. 
      this.regle = new JLabel("Devinez le nombre qui est compris entre 0 et " + this.limiteJeu + ". " + "Pour cela, vous avez droit à " + this.tentativesMax + " tentatives."); 
      panel.add(this.regle); 
      
      this.caseNombreSaisi = new JTextField(4); 
      this.caseNombreSaisi.setEditable(true); 
      panel.add(this.caseNombreSaisi); 
      this.caseNombreSaisi.addActionListener(this); 
      
      this.labelEtat = new JLabel(""); 
      panel.add(this.labelEtat); 
 
      // Initialiser le nombre à deviner. 
      this.nombreMagique = choixNombreMagique();
      
      this.tentative = 0; 
 
      // Modifie les propriétés de la fenêtre. 
      setTitle("Le Nombre Magique");
      setSize(550, 200);
      setResizable(false); 
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   } 
   
   //Vérification propositions joueur
   public void actionPerformed(ActionEvent actionEvent) 
   { 
      // Convertion nombre saisi 
      try 
      { 
         this.nombreSaisi = Integer.parseInt(this.caseNombreSaisi.getText()); 
         this.saisieValide = true; 
      } 
      // Sila valeur saisie n'est pas un entier
      catch(NumberFormatException e) 
      { 
         this.saisieValide = false; 
      } 
 
      // Vide le champ de saisie 
      this.caseNombreSaisi.setText(""); 
 
      // Affichage message
      afficherMessage(); 
   } 	

	public void afficherMessage() 
   { 
		while(this.nombreSaisi != this.nombreMagique && this.tentative != tentativesMax) {
			
      if(!this.saisieValide) 
      { 
         this.labelEtat.setText("La valeur saisie n'est pas un nombre."); 
      } 
      else 
      {
    	  if(this.nombreSaisi < this.nombreMagique) 
    	   	{ 
    	        	 this.tentative = this.tentative + 1; 
    	            this.labelEtat.setText("Trop petit. " + "Il vous reste " + tentativesRest + " tentatives. " + "Essayez encore."); 
    	            
    	         } 
    	         else 
    	         { 
    	        	 this.tentative = this.tentative + 1;
    	            this.labelEtat.setText("Trop grand. " + "Il vous reste " + tentativesRest + " tentatives. " + "Essayez encore."); 
    	            
    	         } 
    	  }
		}
    			  
    	  if(this.nombreSaisi == this.nombreMagique || (this.nombreSaisi == this.nombreMagique && this.tentative == tentativesMax)) 
      { 
         // Affichage du résultat. 
         this.labelEtat.setText("Félicitation vous avez trouvé. Le nombre magique était " + nombreMagique + " et vous l'avez trouver en " +this.tentative + " tentatives. Vous pouvez recommencer."); 
 
         // Réinitialisation du nombre magique et le nombre d'essais. 
         this.nombreMagique = choixNombreMagique(); 
         
      } 
    	  else if(this.tentative == tentativesMax) 
    	 {
    	// Afficher du résultat. 
          this.labelEtat.setText("Dommage. Vous n'avez pas trouver le nombre magique qui était " + this.nombreMagique + ". Vous pouvez recommencer."); 
  
          // Réinitialisation du nombre magique et le nombre d'essais. 
          this.nombreMagique = choixNombreMagique();
    	 }
      }
   
 
 
   public static void main(String[] args) 
   { 
      NombreMagique fenetre = new NombreMagique(); 
      fenetre.setVisible(true); 
   } 
} 