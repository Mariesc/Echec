import java.util.ArrayList;


public class Roi extends Piece {

	//flag permet de savoir si la pièce est en echec et mat

	
	Roi(String Nom,boolean CouleurIsWhite,int x, int y){
		super(Nom,CouleurIsWhite,x,y);
	}
	
	
	public String charPiece(){
		String StringPiece = "";
		if (this.isCouleurIsWhite() == true){
			StringPiece = "R";
		}else{
			StringPiece = "r";
		}
		
		return StringPiece;
	}
	
	public int[]  mouvementValide(Joueur j){
		//les différents choix possibles
		int liste[] = new int[16];
		liste[0] = 1;
		liste[1] = 0;
		
		liste[2] = 0;
		liste[3] = 1;
		
		liste[4] = -1;
		liste[5] = 0;
		
		liste[6] = 0;
		liste[7] = -1;
		
		liste[8] = 1;
		liste[9] = -1;
		
		liste[10] = -1;
		liste[11] = 1;
		
		liste[12] = 1;
		liste[13] = 1;
		
		liste[14] = -1;
		liste[15] = -1;
		
		return liste;
	}
}
