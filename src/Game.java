import java.util.ArrayList;

public class Game {

	
	public static void main(String[] args) {
		//initialisation du tableau
		Echiquier e = new Echiquier();
		
		//cr�ation des joueurs
		Joueur JB = new Joueur("Tom",true);
		Joueur JN = new Joueur("Max",false);
				
		//////////cr�ation des pi�ces Blanches + ajout des pi�ces au joueur Blanc///////
		//Pion Blanc cr�ation
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
		
		//Tour Blanc cr�ation
		//Tour droite
		Piece tb0 = new Tour("Tour",true,0,0,true);
		JB.ajoutPiece(tb0);
		//Tour gauche
		Piece tb1 = new Tour("Tour",true,0,7,false);
		JB.ajoutPiece(tb1);
		
		//Cavalier Blanc cr�ation
		Piece cb0 = new Cavalier("Cavalier",true,0,1,true);
		JB.ajoutPiece(cb0);
		Piece cb1 = new Cavalier("Cavalier",true,0,6,false);
		JB.ajoutPiece(cb1);
		
		//Fou Blanc cr�ation
		Piece fb0 = new Fou("Fou",true,0,2,true);
		JB.ajoutPiece(fb0);
		Piece fb1 = new Fou("Fou",true,0,5,false);
		JB.ajoutPiece(fb1);
		
//		//Reine Blanc cr�ation
		Piece qb0 = new Reine("Reine",true,0,3);
		JB.ajoutPiece(qb0);
		
		//Roi Blanc cr�ation
		Piece rb0 = new Roi("Roi",true,0,4);
		JB.ajoutPiece(rb0);

		//////////cr�ation des pi�ces Noires + ajout des pi�ces au joueur Noir///////		
		//Pion Noir cr�ation
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
		
		//Tour Noir cr�ation
		//Tour droite
		Piece tn0 = new Tour("Tour",false,7,0,true);
		JN.ajoutPiece(tn0);
		//Tour gauche
		Piece tn1 = new Tour("Tour",false,7,7,false);
		JN.ajoutPiece(tn1);
		
		//Cavalier Noir cr�ation
		Piece cn0 = new Cavalier("Cavalier",false,7,1,true);
		JN.ajoutPiece(cn0);
		Piece cn1 = new Cavalier("Cavalier",false,7,6,false);
		JN.ajoutPiece(cn1);
		
		//Fou Noir cr�ation
		Piece fn0 = new Fou("Fou",false,7,2,true);
		JN.ajoutPiece(fn0);
		Piece fn1 = new Fou("Fou",false,7,5,false);
		JN.ajoutPiece(fn1);
		
		//Reine Noir cr�ation
		Piece qn0 = new Reine("Reine",false,7,3);
		JN.ajoutPiece(qn0);
		
		//Roi Noir cr�ation
		Piece rn0 = new Roi("Roi",false,7,4);
		JN.ajoutPiece(rn0);
		
		////////placer pi�ces sur l'�chiquier visuellement et dans les cases/////////////
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
		
		//Cr�ation liste des joueurs pour g�rer les tours par tours
		ArrayList<Joueur> ListeJoueur = new ArrayList<Joueur>();
		//le blanc en premier car c'est lui qui commence
		ListeJoueur.add(JB);
		ListeJoueur.add(JN);
		
		//coordonn�es de la pi�ce que veut d�placer le joueur
		int ligne = 0;
		int colonne = 0;
		String NomGagnant ="";
		//coordonn�es o� il veut d�placer la pi�ce
		int x = 0;
		int y = 0;
		
		//si mouvement bon, boolean passe � true, on ne reboucle pas dans les deux while
		boolean retour = false;
		
		//sert � g�rer la fin du jeu si l'un des roi � son attribut flag en true
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

			System.out.println("Donne les coordonn�es de la pi�ce que tu veux d�placer");
			
			//tant qu'il n'y a pas de bonne pi�ce selectionn�e on boucle
			while(retour != true){
				//on r�cup�re les coordonn�es o� se trouverait sa pi�ce sur l'�chiquier
				System.out.println(" ligne : ");
				ligne = Clavier.lireInt();
					
				System.out.println(" colonne : ");
				colonne = Clavier.lireInt();	
					
				//retour true si la pi�ce existe et qu'elle est de la bonne couleur du joueur qui joue
				if(e.v�rifPiece(joueurTour,ligne,colonne) == true){
					retour = true;
				}else{
					System.out.println("La pi�ce n'existe pas ou ne t'appartient pas");
				}
			}
			
			//on remet � false pour le while suivant
			retour = false;
			
			
			
			////////////////choix du d�placement////////////////
			System.out.println("Donne les coordonn�es de la case que tu veux atteindre");
			
			while(retour != true){
				//on r�cup�re les coordonn�es o� le joueur voudrait d�placer sa pi�ce sur l'�chiquier
				System.out.println(" ligne : ");
				x = Clavier.lireInt();
					
				System.out.println(" colonne : ");
				y = Clavier.lireInt();	
				
				//retour true si elle existe sur l'�chiquier
				if(e.v�rifPasPiece(joueurTour,x,y)==true){
					//retour true si la case appartient au mouvement valide de la pi�ce
					if(e.mouvementPossible(joueurTour,ligne,colonne,x,y) == true){
						retour = true;
					}else{
						System.out.println("Mouvement non valide pour la pi�ce ");
					}
				}else{
					System.out.println("Case occup�e par une de tes pi�ces ou sortie de l'�chiquier ");
				}
			}
			

			////////////////d�placement pi�ce////////////////			
			
			//arriver ici : x et y sont les coordonn�es valide de d�placement de la pi�ce s�lectionn�e
			//permet de mettre � jour le d�placement de la pi�ce dans le tableau d'affichage et
			//le contenu des cases de l'�chiquier
			e.deplacerPiece(ListeJoueur.get(player),ligne,colonne,x,y);
			
			//transformation du pion en reine
			e.transformationPiece(ListeJoueur.get(player),x,y);
			
			//echec et mat
			boolean Liste[] = new boolean[2];
			Liste = e.gagnant(ListeJoueur,player,couleurGagnant,echecMat);
			couleurGagnant = Liste[0];
			echecMat = Liste[1];
			
			System.out.println("Pi�ce d�plac�e !");
			
			//on remet � false car l'on boucle sur le joueur suivant
			//on en aura besoin pour les autres while
			retour = false;
			
			
			//on r�affiche l'�chiquier pour le joueur suivant
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
			System.out.println("Le gagnant est : "+NomGagnant+". F�licitations !!");
			e.Affiche();
			////FIN du game
		}

		
	}

}
