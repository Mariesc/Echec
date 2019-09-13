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


	//affiche echiquier avec les lettres des pi�ces
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
	
	//return true si la pi�ce existe et appartient au joueur qui joue sinon false 
	public boolean v�rifPiece(Joueur j,int ligne, int colonne){
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
	
	//return true si la case existe sur l'�chiquier
	public boolean v�rifPasPiece(Joueur j,int ligne, int colonne){
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
	
	//retour true si mouvement possible avec (x,y) de la pi�ce
	public boolean mouvementPossible(Joueur j,int ligne, int colonne,int x, int y){
		//pi�ce temp de la pi�ce cibl�e par le joueur
		Piece p  = this.tableauPiece[ligne][colonne];
		int i = 0;
		//compteur pour r�cup�rer les info par couples x y
		int compteurdouble = 0;
		int z = 0;
		int k = 0;
		boolean retour = false;
		
		//on r�cup�re les mouvements valident de la pi�ce dans une liste
		int liste[] = new int[p.mouvementValide(j).length];
		liste = p.mouvementValide(j);
		
		//la liste est form�e comme ceci : [x][y][x][y] ...
		//on compare les coordonn�es des mouvements valident 
		//aux coordonn�es du mouvement voulu par le joueur
		
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
			//permet de r�cup�rer les coordonn�es par couples x y
			compteurdouble = compteurdouble +1;
			
			if (compteurdouble == 2){
				//si la somme des coordonn�es voulu + les coordonn�es du d�placement du mouvement valide
				// = coordonn�es de la case cibl�e  pour fin de d�placement
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
	
	
	
	//r�tablit l'affichage par defaut de l'�chiquier
	public void affichageDefaut(int ligne, int colonne){
		//on remplit la case o� il y avait l'affichage de la pi�ce par l'affichage defaut de l'�chiquier
		//dans le tableau temp
		if((ligne+colonne)%2 ==0){//impair
			tableau[ligne][colonne] = "#";
		}else{//pair
			tableau[ligne][colonne] = ".";
		}	
	}
	
	
	
	
	//met � jour les deux tableaux de l'�chiquier avec deux tableaux temp
	public void miseAJourTableaux (String tableau[][],Piece tableauPiece[][]){
		//mise � jour du contenu des cases de l'�chiquier
		this.setTableauPiece(tableauPiece);
		//mise � jour de l'affichage
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
	
	
	//permet le d�placement de pi�ce sur les cases et l'affichage
	public void deplacerPiece(Joueur j,int ligne, int colonne,int x, int y){
		// ligne et colonne des anciennes coordonn�es
		//on cr�er des tableaux qui servent de tableau temp
		
		//celui ci g�re l'affichage de l'�chiquier
		String tableau[][];
		//celui g�re le contenu des cases de l'�chiquier
		Piece tableauPiece[][];
		
		//on remplit les tableaux temp par les tableaux de l'�chiquier
		tableau = this.getTableau();
		tableauPiece = this.getTableauPiece();
		
		//cr�ation d'une pi�ce temp
		Piece pTemp;
		Piece pSupp;
		
		//on r�cup�re la pi�ce selectionner dans la pi�ce temp
		pTemp = tableauPiece[ligne][colonne];
		pSupp = tableauPiece[x][y];
		int index =0;
		//on place la pi�ce selectionn�e dans la nouvelle case demander pr�c�dement par le joueur
		pTemp.placerEchiquier(pTemp,this,x,y);//la pi�ce est donc placer dans les tableaux initiaux
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
//		System.out.println("piece supprim�e : "+pSupp);
//		System.out.println("collection de pi�ce du joueur : "+j.getCollectionPiece());
		//on met la case o� �tait la pi�ce � null dans le tableauPiece temp
		tableauPiece[ligne][colonne] = null;
		
		affichageDefaut(ligne,colonne);

		//les tableaux qui nous servaient de temp mettent � jour les tableaux actuels
		miseAJourTableaux(tableau,tableauPiece);
	}
	
	
	
	
	//v�rifi si il y a un perdant, return liste de boolean
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
			if(o == 0){//apr�s chaque pi�ce du joueur si il n'a pas de roi
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
