import java.util.ArrayList;


public class Reine extends Piece {

	
	Reine(String Nom,boolean CouleurIsWhite,int x, int y){
		super(Nom,CouleurIsWhite,x,y);
	}
	
	public String charPiece(){
		String StringPiece = "";
		if (this.isCouleurIsWhite() == true){
			StringPiece = "Q";
		}else{
			StringPiece = "q";
		}
		
		return StringPiece;
	}
	
	
	public int[]  mouvementValide(Joueur j){
		//les différents choix possibles
		int liste[] = new int[112];
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
		
		i =0;
		l =0;
		//verticale haut
		for (int z =56; z < 70; z++){
			
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
		for (int z =70; z < 84; z++){
			
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
		for (int z =84; z < 98; z++){
			
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
		for (int z =98; z < 112; z++){
			
			if((z%2) != 0){
				i =i -1;
				liste[z] = i;
				
			}else{
				
				liste[z] = l;
			}
			
		}
		return liste;
	}
	
	
	
	
	public static void main(String[] args) {
		

		
	}


}
