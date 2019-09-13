import java.util.ArrayList;
import java.util.Random;

public class Echiquier {

	private String tableau[][];
	private Piece tableauPiece[][];
	
	Echiquier(){
		//affichage plateau
		tableau = new String [8][8];
		tableauPiece = new Piece [8][8];
		
		int tailleTabl = tableau.length;
		int i =0;
		int j = 0;
		
		String n = "#";
		String b = ".";
		String caseColor ="";
				
		//remplir le tableau
		while (i < tailleTabl)
		{
		  j = 0;
		  while(j < tailleTabl)
		  {
			if((i+j)%2 !=0){
				caseColor = b;
			}else{
				caseColor = n;
			}
		    tableau[i][j] = caseColor ;
		    j++;
		  }
		  i++;
		}
	}
	
	

	public Piece[][] getTableauPiece() {
		return tableauPiece;
	}


	public void setTableauPiece(Piece[][] tableauPiece) {
		this.tableauPiece = tableauPiece;
	}


	public String[][] getTableau() {
		return tableau;
	}

	public void setTableau(String[][] tableau) {
		this.tableau = tableau;
	}


	//affiche echiquier avec les lettres des pièces
	public void Affiche(){
		int taille = tableau.length;
		for(int l = 0 ; l < taille; l++)
		{
		  for(int c = 0 ; c < taille ; c++)
		  {
		    System.out.print(tableau[l][c]);
		  }
		  System.out.println("");
		}	
	}
	
	//return true si la pièce existe et appartient au joueur qui joue sinon false 
	public boolean vérifPiece(Joueur j,int ligne, int colonne){
		if(this.tableauPiece[ligne][colonne] != null){
			if(j.isCouleurIsWhite() == tableauPiece[ligne][colonne].isCouleurIsWhite()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	//return true si la case existe sur l'échiquier
	public boolean vérifPasPiece(Joueur j,int ligne, int colonne){
		if(ligne <= this.tableauPiece.length | colonne <= this.tableauPiece.length){
			if(this.tableauPiece[ligne][colonne] == null){
				return true;
			}
			else{
				if(this.tableauPiece[ligne][colonne].isCouleurIsWhite() != j.isCouleurIsWhite()){
					return true;
				}
				else{
					return false;
				}
			}
		}
		else{
			return false;
		}
	}
	
	//retour true si mouvement possible avec (x,y) de la pièce
	public boolean mouvementPossible(Joueur j,int ligne, int colonne,int x, int y){
		//pièce temp de la pièce ciblée par le joueur
		Piece p  = this.tableauPiece[ligne][colonne];
		int i = 0;
		//compteur pour récupérer les info par couples x y
		int compteurdouble = 0;
		int z = 0;
		int k = 0;
		boolean retour = false;
		
		//on récupère les mouvements valident de la pièce dans une liste
		int liste[] = new int[p.mouvementValide(j).length];
		liste = p.mouvementValide(j);
		
		//la liste est formée comme ceci : [x][y][x][y] ...
		//on compare les coordonnées des mouvements valident 
		//aux coordonnées du mouvement voulu par le joueur
		
		while ( i < liste.length & retour == false){
			if(i%2 == 0 ){
				
				z = liste[i];
			}
			else{
				if(i%2 != 0){
					
					k = liste[i];
				}
				
			}
			
			i = i+1;
			//permet de récupérer les coordonnées par couples x y
			compteurdouble = compteurdouble +1;
			
			if (compteurdouble == 2){
				//si la somme des coordonnées voulu + les coordonnées du déplacement du mouvement valide
				// = coordonnées de la case ciblée  pour fin de déplacement
				//alors le mouvement est OK
				if((ligne+z) == x & (k+colonne) == y){
					retour = true;
				}
				else{
					compteurdouble = 0;
					retour = false;
				}
			}
		}
		return retour;
	
	}
	
	
	
	//rétablit l'affichage par defaut de l'échiquier
	public void affichageDefaut(int ligne, int colonne){
		//on remplit la case où il y avait l'affichage de la pièce par l'affichage defaut de l'échiquier
		//dans le tableau temp
		if((ligne+colonne)%2 ==0){//impair
			tableau[ligne][colonne] = "#";
		}else{//pair
			tableau[ligne][colonne] = ".";
		}	
	}
	
	
	
	
	//met à jour les deux tableaux de l'échiquier avec deux tableaux temp
	public void miseAJourTableaux (String tableau[][],Piece tableauPiece[][]){
		//mise à jour du contenu des cases de l'échiquier
		this.setTableauPiece(tableauPiece);
		//mise à jour de l'affichage
		this.setTableau(tableau);
	}
	
	public void transformationPiece(Joueur j,int ligne, int colonne){
		Piece tableauPiece[][];
		String tableau [][];
		tableau = this.tableau;
		tableauPiece = this.tableauPiece;
		
		Piece pTemp = tableauPiece[ligne][colonne];
		if(pTemp.getNom().equals("Pion")){
			if(pTemp.isCouleurIsWhite()== true){
				if(ligne == this.getTableauPiece().length-1){
					pTemp =null;
					pTemp = new Reine("Reine",true,ligne,colonne);
				}
				
			}else{
				if(ligne == 0){
					pTemp =null;
					pTemp = new Reine("Reine",false,ligne,colonne);
				}
			}
			
			tableauPiece[ligne][colonne] = null;
			tableauPiece[ligne][colonne] = pTemp;
			this.setTableauPiece(tableauPiece);
			tableau[ligne][colonne] = null;
			tableau[ligne][colonne] = pTemp.charPiece();
			this.setTableau(tableau);
			j.ajoutPiece(pTemp);
			
		}
	}
	
	
	//permet le déplacement de pièce sur les cases et l'affichage
	public void deplacerPiece(Joueur j,int ligne, int colonne,int x, int y){
		// ligne et colonne des anciennes coordonnées
		//on créer des tableaux qui servent de tableau temp
		
		//celui ci gère l'affichage de l'échiquier
		String tableau[][];
		//celui gère le contenu des cases de l'échiquier
		Piece tableauPiece[][];
		
		//on remplit les tableaux temp par les tableaux de l'échiquier
		tableau = this.getTableau();
		tableauPiece = this.getTableauPiece();
		
		//création d'une pièce temp
		Piece pTemp;
		Piece pSupp;
		
		//on récupère la pièce selectionner dans la pièce temp
		pTemp = tableauPiece[ligne][colonne];
		pSupp = tableauPiece[x][y];
		int index =0;
		//on place la pièce selectionnée dans la nouvelle case demander précédement par le joueur
		pTemp.placerEchiquier(pTemp,this,x,y);//la pièce est donc placer dans les tableaux initiaux
		if(pSupp != null){
			for(int i = 0; i < j.getCollectionPiece().size(); i++){
				for(Piece p : j.getCollectionPiece()){
					if(p.getNom() == pSupp.getNom()){
						index = i;
					}
				}	
			}
			j.suppPiece(index);
		}
//		System.out.println("piece supprimée : "+pSupp);
//		System.out.println("collection de pièce du joueur : "+j.getCollectionPiece());
		//on met la case où était la pièce à null dans le tableauPiece temp
		tableauPiece[ligne][colonne] = null;
		
		affichageDefaut(ligne,colonne);

		//les tableaux qui nous servaient de temp mettent à jour les tableaux actuels
		miseAJourTableaux(tableau,tableauPiece);
	}
	
	
	
	
	//vérifi si il y a un perdant, return liste de boolean
	//boolean 1 = return la couleur du gagnant, true = blanc , false = noir
	//boolean 2 = return true si echec et mat
	public boolean[] gagnant(ArrayList<Joueur> ListeJoueur,int player,boolean couleurGagnant,boolean echecMat){
		int o = 0;
		boolean  Liste[] = new boolean[2];
		for(int m =0; m < ListeJoueur.size() ;m++){
			for(Piece p : ListeJoueur.get(player).getCollectionPiece()){//pour chaque joueur
				if(p.getNom() == "Roi"){// si il a un roi
					o = o+1;  // on ajoute un o
				}
			}
			if(o == 0){//après chaque pièce du joueur si il n'a pas de roi
				couleurGagnant = ListeJoueur.get(player).isCouleurIsWhite();
				echecMat = true;
				Liste[0] = couleurGagnant;
				Liste[1] = echecMat;
			}
			o = 0;
		}
		return Liste;
	}


}
