import java.util.ArrayList;


public abstract class Piece {
	
	protected String Nom;
	protected boolean CouleurIsWhite;
	protected int x;
	protected int y;

	Piece(String _Nom,boolean _CouleurIsWhite,int _x, int _y){
		Nom = _Nom;
		CouleurIsWhite = _CouleurIsWhite;
		x = _x;
		y = _y;
	}



	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}


	public boolean isCouleurIsWhite() {
		return CouleurIsWhite;
	}

	public void setCouleurIsWhite(boolean couleurIsWhite) {
		CouleurIsWhite = couleurIsWhite;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	//return une liste de mouvements possibles pour la pi�ce
	public abstract int[] mouvementValide(Joueur j);
	
	
	//return l'affichage de la pi�ce 
	public abstract String charPiece();
	
	
	//permet de placer les pi�ces sur l'�chiquier visuellement
	//permet de placer les objets pi�ces sur chaque case de l'�chiquier
	public void placerEchiquier(Piece p, Echiquier e, int l, int c){
		String tableauAffichage [][] = e.getTableau();
		Piece tableauPiece [][] = e.getTableauPiece();
		
		tableauAffichage[l][c] = p.charPiece();
		tableauPiece[l][c] = p;
		
		e.setTableau(tableauAffichage);
		e.setTableauPiece(tableauPiece);
	}

	public void placerIHM(Piece p, Echiquier e, int l, int c){
		Piece tableauPiece [][] = e.getTableauPiece();
		tableauPiece[l][c] = p;
		e.setTableauPiece(tableauPiece);
	}


}
