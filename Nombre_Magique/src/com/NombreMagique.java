package com; 

 
import java.awt.Color;
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JTextField; 

public class NombreMagique extends JFrame implements ActionListener 
{ 
	//??
   private static final long serialVersionUID = 1L; 

   private int nombreSaisi = 0; 
   private int nombreMagique = 0; 
   private int tentatives; 
   private int tentativesMax = 10;
   private int tentativesRest = tentativesMax - tentatives;
   private int limiteRand = 501;
   private int limiteJeu = limiteRand - 1;
   private boolean saisieValide = false; 
   
   private JLabel regle; 
   private JTextField fieldNombre; 
   private JLabel labelEtat; 
 
 
   public NombreMagique() 
   {  
      super(); 
 
      // Obtenir le panneau de contenu et changer son layout en un FlowLayout. 
      Container panel = getContentPane(); 
      panel.setLayout(new FlowLayout()); 
      panel.setBackground(Color.white);
 
      // Cr�er l'�tiquette et le champ texte du nombre � deviner. 
      this.regle = new JLabel("Devinez le nombre qui est compris entre 0 et " + limiteJeu + ". " + "Pour cela, vous avez droit � " + tentativesMax + " tentatives."); 
      panel.add(this.regle); 
      
      this.fieldNombre = new JTextField(4); 
      this.fieldNombre.setEditable(true); 
      panel.add(this.fieldNombre); 
      this.fieldNombre.addActionListener(this); 
      
      this.labelEtat = new JLabel(""); 
      panel.add(this.labelEtat); 
 
      // Initialiser le nombre � deviner. 
      this.nombreMagique = initNombreMagique(); 
      
      this.tentatives = 0; 
 
      // Modifie les propri�t�s de la fen�tre. 
      setTitle("Le Nombre Magique");
      setSize(550, 200);
      setResizable(false); 
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   } 
 
 
   //V�rification propositions joueur
   public void actionPerformed(ActionEvent actionEvent) 
   { 
      // Convertir le nombre entr� par l'utilisateur. 
      try 
      { 
         this.nombreSaisi = Integer.parseInt(this.fieldNombre.getText()); 
         this.saisieValide = true; 
      } 
      // Effectue un traitement particulier lorsque la valeur saisie n'est pas un entier. 
      catch(NumberFormatException e) 
      { 
         this.saisieValide = false; 
      } 
 
      // Vider le champ de la proposition de l'utilisateur. 
      this.fieldNombre.setText(""); 
 
      // Afficher un message d'�tat du jeu. 
      afficherMessage(); 
   } 
 
 
   /** 
    * <p>Initialiser le nombre � deviner.</p> 
    * @return Le nombre � deviner. 
    */ 
   public int initNombreMagique() 
   { 
      return ((int) (Math.random()*limiteRand)); 
   } 
 
 
   /** 
    * <p>D�termine si l'utilisateur a trouv� le nombre et affiche le message ad�quat dans la barre 
    * d'�tat.</p> 
    */ 
   public void afficherMessage() 
   { 
      if(!this.saisieValide) 
      { 
         this.labelEtat.setText("La valeur saisie n'est pas un nombre."); 
      } 
      else if(this.nombreSaisi == this.nombreMagique) 
      { 
         String commentaire; 
 
         // Afficher un message de f�licitation dans la barre d'�tat. 
         this.labelEtat.setText("F�licitation vous avez trouv�. Le nombre magique �tait " + nombreMagique + ". " + "Vous pouvez recommencer."); 
 
         // D�terminer le commentaire � afficher. 
         if(this.tentatives == 10) 
         { 
            commentaire = "D'accord, vous connaissez le secret!"; 
         } 
         else if(this.tentatives < 10) 
         { 
            commentaire = "Soit vous connaissez le secret, soit vous �tes chanceux!"; 
         } 
         else 
         { 
            commentaire = "Vous pouvez certainement faire mieux!"; 
         } 
 
         // Afficher la phrase al�atoire. 
         JOptionPane.showMessageDialog(null, commentaire, "Commmentaire", 
               JOptionPane.INFORMATION_MESSAGE); 
 
         // R�initialiser le nombre � deviner et le nombre d'essais. 
         this.nombreMagique = initNombreMagique(); 
         
      } 
      // Afficher une aide pour trouver le nombre et incr�menter le nombre d'essais. 
      else 
      { 
         if(this.nombreSaisi < this.nombreMagique) 
         { 
        	 this.tentatives++; 
            this.labelEtat.setText("Trop petit. " + "Il vous reste " + tentativesRest + " tentatives. " + "Essayez encore."); 
            
         } 
         else 
         { 
        	 this.tentatives = this.tentatives + 1;
            this.labelEtat.setText("Trop grand. " + "Il vous reste " + tentativesRest + " tentatives. " + "Essayez encore."); 
            
         } 
      } 
   } 
 
 
   public static void main(String[] args) 
   { 
      NombreMagique fenetre = new NombreMagique(); 
      fenetre.setVisible(true); 
   } 
} 