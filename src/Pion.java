import java.util.ArrayList;


public class Pion extends Piece {
	
	
	Pion(String Nom,boolean CouleurIsWhite,int x, int y){
		super(Nom,CouleurIsWhite,x,y);
	}
	
	public String charPiece(){
		String StringPiece = "";
		if (this.isCouleurIsWhite() == true){
			StringPiece = "P";
		}else{
			StringPiece = "p";
		}
		
		return StringPiece;
	}
	
	
	public int[]  mouvementValide(Joueur j){
		//les diff�rents choix possibles x y
		int YPossible = 0;
		int x = 0;
		YPossible = 0;
		
		//mouvement diff�rent suivant le joueur
		if(j.isCouleurIsWhite() == true){
			x = 1;
		}else{
			x = -1;			
		}
		//cr�ation de la liste des possibilit�s, le pion en a qu'une
		int liste[] = new int[2];
		//ajout l'un apr�s l'autre des coordonn�es x y
		liste[0] = x;
		liste[1] = YPossible;
		return liste;
	}
	

}
