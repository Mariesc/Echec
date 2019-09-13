import java.util.ArrayList;


public class Tour extends Piece {

	private boolean isDroite;
	
	Tour(String Nom,boolean CouleurIsWhite,int x, int y, boolean _isDroite ){
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
			StringPiece = "T";
		}else{
			StringPiece = "t";
		}
		
		return StringPiece;
	}
	
	
	public int[]  mouvementValide(Joueur j){
		//les différents choix possibles
		int liste[] = new int[56];
		int i =0;
		int l =0;
		//verticale haut
		for (int z =0; z < 14; z++){
			
			if((z%2) != 0){
				liste[z] = i;
				
			}else{
				l = l -1;
				liste[z] = l;
			}
			
		}

		
		i =0;
		l =0;
		//verticale bas
		for (int z =14; z < 28; z++){
			
			if((z%2) != 0){
				liste[z] = i;
				
			}else{
				l = l +1;
				liste[z] = l;
			}
			
		}
		
		i =0;
		l =0;
		//horizontale droite
		for (int z =28; z < 42; z++){
			
			if((z%2) != 0){
				i =i +1;
				liste[z] = i;
				
			}else{
				
				liste[z] = l;
			}
			
		}
		
		i =0;
		l =0;
		//horizontale gauche
		for (int z =42; z < 56; z++){
			
			if((z%2) != 0){
				i =i -1;
				liste[z] = i;
				
			}else{
				
				liste[z] = l;
			}
			
		}
		return liste;
	}


}
