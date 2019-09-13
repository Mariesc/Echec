import java.util.ArrayList;


public class Cavalier extends Piece{

	private boolean isDroite;
	
	Cavalier(String Nom,boolean CouleurIsWhite,int x, int y, boolean _isDroite ){
		super(Nom,CouleurIsWhite,x,y);
		isDroite = _isDroite;
	}
	
	public boolean getisDroite() {
		return isDroite;
	}


	public void setisDroite(boolean isDroite) {
		this.isDroite = isDroite;
	}


	public String charPiece(){
		String StringPiece = "";
		if (this.isCouleurIsWhite() == true){
			StringPiece = "C";
		}else{
			StringPiece = "c";
		}
		
		return StringPiece;
	}
	
	public int[]  mouvementValide(Joueur j){
		//les différents choix possibles
		int liste[] = new int[16];
		liste[0] = -2;
		liste[1] = 1;
		
		liste[2] = -1;
		liste[3] = 2;
		
		liste[4] = 1;
		liste[5] = 2;
		
		liste[6] = 2;
		liste[7] = 1;
		
		liste[8] = 2;
		liste[9] = -1;
		
		liste[10] = 1;
		liste[11] = -2;
		
		liste[12] = -1;
		liste[13] = -2;
		
		liste[14] = -2;
		liste[15] = -1;
		return liste;
	}

}
