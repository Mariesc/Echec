import java.util.ArrayList;


public class Fou extends Piece {

	private boolean isDroite;
	
	Fou(String Nom,boolean CouleurIsWhite,int x, int y, boolean _isDroite ){
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
			StringPiece = "F";
		}else{
			StringPiece = "f";
		}
		
		return StringPiece;
	}
	
	
	public int[]  mouvementValide(Joueur j){
		//les différents choix possibles
		int liste[] = new int[56];
		int i = 0;
		//coordonnées négatives : diago gauche haut
		for (int z =0; z < 14; z++){
			i =i -1;
			if((z%2) != 0){
				liste[z] = i+1;
				i =i +1;
			}else{
				liste[z] = i;
			}
			
		}
		i = 0;
		//coordonnées positives : diago droite bas
		for (int z =14; z < 28; z++){
			i =i +1;
			if((z%2) != 0){
				liste[z] = i-1;
				i =i -1;
			}else{
				liste[z] = i;
			}
			
		}
		
		i = 0;
		int l = 0;
		//coordonnées positives_negatives : diago gauche bas
		for (int z =28; z < 42; z++){
			
			if((z%2) != 0){
				l = l -1;
				liste[z] = l;
				
			}else{
				i =i +1;
				liste[z] = i;
			}
			
		}
		
		i =0;
		l =0;
		//coordonnées positives_negatives : diago droit haut
		for (int z =42; z < 56; z++){
			
			if((z%2) != 0){
				i =i +1;
				liste[z] = i;
				
			}else{
				l = l -1;
				liste[z] = l;
			}
			
		}
		return liste;
	}

	public static void main(String[] args) {
		int liste[] = new int[56];
		int i = 0;
		//coordonnées négatives : diago gauche haut
		for (int z =0; z < 14; z++){
			i =i -1;
			if((z%2) != 0){
				liste[z] = i+1;
				i =i +1;
			}else{
				liste[z] = i;
			}
			
		}
		i = 0;
		//coordonnées positives : diago droite bas
		for (int z =14; z < 28; z++){
			i =i +1;
			if((z%2) != 0){
				liste[z] = i-1;
				i =i -1;
			}else{
				liste[z] = i;
			}
			
		}
		
		i = 0;
		int l = 0;
		//coordonnées positives_negatives : diago gauche bas
		for (int z =28; z < 42; z++){
			
			if((z%2) != 0){
				l = l -1;
				liste[z] = l;
				
			}else{
				i =i +1;
				liste[z] = i;
			}
			
		}
		
		i =0;
		l =0;
		//coordonnées positives_negatives : diago droit haut
		for (int z =42; z < 56; z++){
			
			if((z%2) != 0){
				i =i +1;
				liste[z] = i;
				
			}else{
				l = l -1;
				liste[z] = l;
			}
			
		}
		//affiche
		for(int b = 0; b < liste.length; b++){
			System.out.println(liste[b]);
		}
	
	
	}

}
