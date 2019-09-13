import java.util.ArrayList;


public class Joueur {

	//cette collection sert à gérer les transformations des pions en bout d'échiquier
	//et lorsque le joueur perd des pièces
	//sa taille est limitée à 16 pièces
	private ArrayList<Piece> CollectionPiece;
	private boolean CouleurIsWhite;
	private String nom;
	
	Joueur(String _nom,boolean _CouleurIsWhite){
		CouleurIsWhite = _CouleurIsWhite;
		CollectionPiece = new ArrayList<Piece>(16);
		nom = _nom;
	};
	
	
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public ArrayList<Piece> getCollectionPiece() {
		return CollectionPiece;
	}



	public void setCollectionPiece(ArrayList<Piece> collectionPiece) {
		CollectionPiece = collectionPiece;
	}



	public boolean isCouleurIsWhite() {
		return CouleurIsWhite;
	}

	public void setCouleurIsWhite(boolean couleurIsWhite) {
		CouleurIsWhite = couleurIsWhite;
	}


	
	public void suppPiece(int index){
		CollectionPiece.remove(index);
	}
	
	public void ajoutPiece( Piece P){
		CollectionPiece.add(P);
	}
	
	

}
