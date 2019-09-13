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
		//les différents choix possibles x y
		int YPossible = 0;
		int x = 0;
		YPossible = 0;
		
		//mouvement différent suivant le joueur
		if(j.isCouleurIsWhite() == true){
			x = 1;
		}else{
			x = -1;			
		}
		//création de la liste des possibilités, le pion en a qu'une
		int liste[] = new int[2];
		//ajout l'un après l'autre des coordonnées x y
		liste[0] = x;
		liste[1] = YPossible;
		return liste;
	}
	

}
