import java.util.ArrayList;

public class Game {

	
	public static void main(String[] args) {
		//initialisation du tableau
		Echiquier e = new Echiquier();
		
		//création des joueurs
		Joueur JB = new Joueur("Tom",true);
		Joueur JN = new Joueur("Max",false);
				
		//////////création des pièces Blanches + ajout des pièces au joueur Blanc///////
		//Pion Blanc création
		Piece pb0 = new Pion("Pion",true,1,0);
		JB.ajoutPiece(pb0);
		Piece pb1 = new Pion("Pion",true,1,1);
		JB.ajoutPiece(pb1);
		Piece pb2 = new Pion("Pion",true,1,2);
		JB.ajoutPiece(pb2);
		Piece pb3 = new Pion("Pion",true,1,3);
		JB.ajoutPiece(pb3);
		Piece pb4 = new Pion("Pion",true,1,4);
		JB.ajoutPiece(pb4);
		Piece pb5 = new Pion("Pion",true,1,5);
		JB.ajoutPiece(pb5);
		Piece pb6 = new Pion("Pion",true,1,6);
		JB.ajoutPiece(pb6);
		Piece pb7 = new Pion("Pion",true,1,7);
		JB.ajoutPiece(pb7);
		
		//Tour Blanc création
		//Tour droite
		Piece tb0 = new Tour("Tour",true,0,0,true);
		JB.ajoutPiece(tb0);
		//Tour gauche
		Piece tb1 = new Tour("Tour",true,0,7,false);
		JB.ajoutPiece(tb1);
		
		//Cavalier Blanc création
		Piece cb0 = new Cavalier("Cavalier",true,0,1,true);
		JB.ajoutPiece(cb0);
		Piece cb1 = new Cavalier("Cavalier",true,0,6,false);
		JB.ajoutPiece(cb1);
		
		//Fou Blanc création
		Piece fb0 = new Fou("Fou",true,0,2,true);
		JB.ajoutPiece(fb0);
		Piece fb1 = new Fou("Fou",true,0,5,false);
		JB.ajoutPiece(fb1);
		
//		//Reine Blanc création
		Piece qb0 = new Reine("Reine",true,0,3);
		JB.ajoutPiece(qb0);
		
		//Roi Blanc création
		Piece rb0 = new Roi("Roi",true,0,4);
		JB.ajoutPiece(rb0);

		//////////création des pièces Noires + ajout des pièces au joueur Noir///////		
		//Pion Noir création
		Piece pn0 = new Pion("Pion",false,6,0);
		JN.ajoutPiece(pn0);
		Piece pn1 = new Pion("Pion",false,6,1);
		JN.ajoutPiece(pn1);
		Piece pn2 = new Pion("Pion",false,6,2);
		JN.ajoutPiece(pn2);
		Piece pn3 = new Pion("Pion",false,6,3);
		JN.ajoutPiece(pn3);
		Piece pn4 = new Pion("Pion",false,6,4);
		JN.ajoutPiece(pn4);
		Piece pn5 = new Pion("Pion",false,6,5);
		JN.ajoutPiece(pn5);
		Piece pn6 = new Pion("Pion",false,6,6);
		JN.ajoutPiece(pn6);
		Piece pn7 = new Pion("Pion",false,6,7);
		JN.ajoutPiece(pn7);
		
		//Tour Noir création
		//Tour droite
		Piece tn0 = new Tour("Tour",false,7,0,true);
		JN.ajoutPiece(tn0);
		//Tour gauche
		Piece tn1 = new Tour("Tour",false,7,7,false);
		JN.ajoutPiece(tn1);
		
		//Cavalier Noir création
		Piece cn0 = new Cavalier("Cavalier",false,7,1,true);
		JN.ajoutPiece(cn0);
		Piece cn1 = new Cavalier("Cavalier",false,7,6,false);
		JN.ajoutPiece(cn1);
		
		//Fou Noir création
		Piece fn0 = new Fou("Fou",false,7,2,true);
		JN.ajoutPiece(fn0);
		Piece fn1 = new Fou("Fou",false,7,5,false);
		JN.ajoutPiece(fn1);
		
		//Reine Noir création
		Piece qn0 = new Reine("Reine",false,7,3);
		JN.ajoutPiece(qn0);
		
		//Roi Noir création
		Piece rn0 = new Roi("Roi",false,7,4);
		JN.ajoutPiece(rn0);
		
		////////placer pièces sur l'échiquier visuellement et dans les cases/////////////
		//Joueur Blanc placer
		//Pion Blanc placer placerPieceEchiquier
		pb0.placerEchiquier(pb0,e,pb0.getX(),pb0.getY());
		pb1.placerEchiquier(pb1,e,pb1.getX(),pb1.getY());
		pb2.placerEchiquier(pb2,e,pb2.getX(),pb2.getY());
		pb3.placerEchiquier(pb3,e,pb3.getX(),pb3.getY());
		pb4.placerEchiquier(pb4,e,pb4.getX(),pb4.getY());
		pb5.placerEchiquier(pb5,e,pb5.getX(),pb5.getY());
		pb6.placerEchiquier(pb6,e,pb6.getX(),pb6.getY());
		pb7.placerEchiquier(pb7,e,pb7.getX(),pb7.getY());
		
		//Tour Blanc placer
		tb0.placerEchiquier(tb0, e, tb0.getX(), tb0.getY());
		tb1.placerEchiquier(tb1, e, tb1.getX(), tb1.getY());
		
		//Cavalier Blanc placer
		cb0.placerEchiquier(cb0, e, cb0.getX(), cb0.getY());
		cb1.placerEchiquier(cb1, e, cb1.getX(), cb1.getY());
		
		//Fou Blanc placer
		fb0.placerEchiquier(fb0, e, fb0.getX(), fb0.getY());
		fb1.placerEchiquier(fb1, e, fb1.getX(), fb1.getY());
		
		//Reine Blanc placer
		qb0.placerEchiquier(qb0, e, qb0.getX(), qb0.getY());
		
		//Roi Blanc placer
		rb0.placerEchiquier(rb0, e, rb0.getX(), rb0.getY());		
		
		//Joueur Noir placer
		//Pion Noir placer
		pn0.placerEchiquier(pn0,e,pn0.getX(),pn0.getY());
		pn1.placerEchiquier(pn1,e,pn1.getX(),pn1.getY());
		pn2.placerEchiquier(pn2,e,pn2.getX(),pn2.getY());
		pn3.placerEchiquier(pn3,e,pn3.getX(),pn3.getY());
		pn4.placerEchiquier(pn4,e,pn4.getX(),pn4.getY());
		pn5.placerEchiquier(pn5,e,pn5.getX(),pn5.getY());
		pn6.placerEchiquier(pn6,e,pn6.getX(),pn6.getY());
		pn7.placerEchiquier(pn7,e,pn7.getX(),pn7.getY());
		
		//Tour Noir placer
		tn0.placerEchiquier(tn0, e, tn0.getX(), tn0.getY());
		tn1.placerEchiquier(tn1, e, tn1.getX(), tn1.getY());
		
		//Cavalier Noir placer
		cn0.placerEchiquier(cn0, e, cn0.getX(), cn0.getY());
		cn1.placerEchiquier(cn1, e, cn1.getX(), cn1.getY());
		
		//Fou Noir placer
		fn0.placerEchiquier(fn0, e, fn0.getX(), fn0.getY());
		fn1.placerEchiquier(fn1, e, fn1.getX(), fn1.getY());
		
		//Reine Noir placer
		qn0.placerEchiquier(qn0, e, qn0.getX(), qn0.getY());
		
		//Roi Noir placer
		rn0.placerEchiquier(rn0, e, rn0.getX(), rn0.getY());			
		
		
		//affichage du tableau
		System.out.println("Echiquier :");
		System.out.println("");
		e.Affiche();
		System.out.println("");
		
		//Création liste des joueurs pour gérer les tours par tours
		ArrayList<Joueur> ListeJoueur = new ArrayList<Joueur>();
		//le blanc en premier car c'est lui qui commence
		ListeJoueur.add(JB);
		ListeJoueur.add(JN);
		
		//coordonnées de la pièce que veut déplacer le joueur
		int ligne = 0;
		int colonne = 0;
		String NomGagnant ="";
		//coordonnées où il veut déplacer la pièce
		int x = 0;
		int y = 0;
		
		//si mouvement bon, boolean passe à true, on ne reboucle pas dans les deux while
		boolean retour = false;
		
		//sert à gérer la fin du jeu si l'un des roi à son attribut flag en true
		boolean echecMat = false;
		boolean couleurGagnant = true;
		
		//compteur joueur pour passer les tours
		int player = 0;
		
		
		////DEBUT du game
		
		
		////////////////tours de jeu////////////////
		
		//tant qu'il n'y a pas d'echec et mat on boucle
		while(echecMat != true){
			Joueur joueurTour = ListeJoueur.get(player);
		
			System.out.println("Au tour du joueur "+joueurTour.getNom());

			System.out.println("Donne les coordonnées de la pièce que tu veux déplacer");
			
			//tant qu'il n'y a pas de bonne pièce selectionnée on boucle
			while(retour != true){
				//on récupère les coordonnées où se trouverait sa pièce sur l'échiquier
				System.out.println(" ligne : ");
				ligne = Clavier.lireInt();
					
				System.out.println(" colonne : ");
				colonne = Clavier.lireInt();	
					
				//retour true si la pièce existe et qu'elle est de la bonne couleur du joueur qui joue
				if(e.vérifPiece(joueurTour,ligne,colonne) == true){
					retour = true;
				}else{
					System.out.println("La pièce n'existe pas ou ne t'appartient pas");
				}
			}
			
			//on remet à false pour le while suivant
			retour = false;
			
			
			
			////////////////choix du déplacement////////////////
			System.out.println("Donne les coordonnées de la case que tu veux atteindre");
			
			while(retour != true){
				//on récupère les coordonnées où le joueur voudrait déplacer sa pièce sur l'échiquier
				System.out.println(" ligne : ");
				x = Clavier.lireInt();
					
				System.out.println(" colonne : ");
				y = Clavier.lireInt();	
				
				//retour true si elle existe sur l'échiquier
				if(e.vérifPasPiece(joueurTour,x,y)==true){
					//retour true si la case appartient au mouvement valide de la pièce
					if(e.mouvementPossible(joueurTour,ligne,colonne,x,y) == true){
						retour = true;
					}else{
						System.out.println("Mouvement non valide pour la pièce ");
					}
				}else{
					System.out.println("Case occupée par une de tes pièces ou sortie de l'échiquier ");
				}
			}
			

			////////////////déplacement pièce////////////////			
			
			//arriver ici : x et y sont les coordonnées valide de déplacement de la pièce sélectionnée
			//permet de mettre à jour le déplacement de la pièce dans le tableau d'affichage et
			//le contenu des cases de l'échiquier
			e.deplacerPiece(ListeJoueur.get(player),ligne,colonne,x,y);
			
			//transformation du pion en reine
			e.transformationPiece(ListeJoueur.get(player),x,y);
			
			//echec et mat
			boolean Liste[] = new boolean[2];
			Liste = e.gagnant(ListeJoueur,player,couleurGagnant,echecMat);
			couleurGagnant = Liste[0];
			echecMat = Liste[1];
			
			System.out.println("Pièce déplacée !");
			
			//on remet à false car l'on boucle sur le joueur suivant
			//on en aura besoin pour les autres while
			retour = false;
			
			
			//on réaffiche l'échiquier pour le joueur suivant
			e.Affiche();

			//ajouter condition si roi flag en true alors fin du jeu
			player = player + 1;
			
			if(player == 2 ){
				player = player -2;
			}
			
			
		}
		
		
		if(echecMat == true){
			for(Joueur m : ListeJoueur){
				if(m.isCouleurIsWhite() == couleurGagnant){
					NomGagnant = m.getNom();
				}
			}

			//affichage du nom du gagnant
			System.out.println("Le gagnant est : "+NomGagnant+". Félicitations !!");
			e.Affiche();
			////FIN du game
		}

		
	}

}
