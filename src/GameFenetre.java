import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFenetre {
 
	private static final int PREFERRED_SIZE = 64;
	private static String TourJoueur = "WHITE";
	private static final Color WHITE_CASE = new Color(0xff, 0xcc, 0x66);
	private static final Color BLACK_CASE  = new Color(0x8b, 0x31, 0x03);
	private static final Color SELECTION_COLOR = new Color(0xb7, 0xe1, 0xa1);
	public static final ImageIcon BLACK_PION = new ImageIcon(GameFenetre.class.getResource("ressources/black_pion.png"));
	public static final ImageIcon WHITE_PION = new ImageIcon(GameFenetre.class.getResource("ressources/white_pion.png"));
	public static final ImageIcon BLACK_TOUR = new ImageIcon(GameFenetre.class.getResource("ressources/black_tour.png"));
	public static final ImageIcon WHITE_TOUR = new ImageIcon(GameFenetre.class.getResource("ressources/white_tour.png"));
	public static final ImageIcon BLACK_CAVALIER = new ImageIcon(GameFenetre.class.getResource("ressources/black_cavalier.png"));
	public static final ImageIcon WHITE_CAVALIER = new ImageIcon(GameFenetre.class.getResource("ressources/white_cavalier.png"));
	public static final ImageIcon BLACK_FOU = new ImageIcon(GameFenetre.class.getResource("ressources/black_fou.png"));
	public static final ImageIcon WHITE_FOU = new ImageIcon(GameFenetre.class.getResource("ressources/white_fou.png")); 
	public static final ImageIcon BLACK_REINE = new ImageIcon(GameFenetre.class.getResource("ressources/black_reine.png"));
	public static final ImageIcon WHITE_REINE = new ImageIcon(GameFenetre.class.getResource("ressources/white_reine.png")); 
	public static final ImageIcon BLACK_ROI = new ImageIcon(GameFenetre.class.getResource("ressources/black_roi.png"));
	public static final ImageIcon WHITE_ROI = new ImageIcon(GameFenetre.class.getResource("ressources/white_roi.png")); 
	
	
	
	/////Echiquier///////
	public static class Plateau extends JPanel {
 
		private static final long serialVersionUID = 1L;
		private final Joueur JB;
		private final Joueur JN;
		private final Echiquier e;
		private final int nbColumns;
		private final int nbLines;
		private final Controller controller;
 
		public Plateau(int nbColumns, int nbLines, Echiquier e,Joueur JB, Joueur JN) {
			super(new GridLayout(nbLines, nbColumns));
			this.nbColumns=nbColumns;
			this.nbLines=nbLines;
			this.e = e;
			this.JB = JB;
			this.JN = JN;
			this.controller = new Controller(this, e,JB,JN);
			setPreferredSize(new Dimension(nbColumns*PREFERRED_SIZE,nbLines*PREFERRED_SIZE));
		}
 
		public int getNbLines() {
			return nbLines;
		}
 
		public int getNbColumns() {
			return nbColumns;
		}
 
		public void setPiecePlateau(int column, int line, PiecePlateau piece) {
			controller.setPiece(column, line, piece);
		}
 
		public Case getCase(int column, int line) {
			return controller.getCase(column, line);
		}
 
	}
 
	
	/////Joueurs///////
	public enum Player {
		WHITE,
		BLACK;
	}
 
	
	///////Pièces///////
	public enum PieceType {
		PION(WHITE_PION,BLACK_PION),
		TOUR(WHITE_TOUR,BLACK_TOUR),
		CAVALIER(WHITE_CAVALIER,BLACK_CAVALIER),
		FOU(WHITE_FOU,BLACK_FOU),
		REINE(WHITE_REINE,BLACK_REINE),
		ROI(WHITE_ROI,BLACK_ROI)
		;
 
		private final ImageIcon whiteImage;
		private final ImageIcon blackImage;
 
		private PieceType(ImageIcon whiteImage, ImageIcon blackImage) {
			this.whiteImage=whiteImage;
			this.blackImage=blackImage;
		}
 
		public ImageIcon getImage(Player player) {
			switch(player) {
			case BLACK:
				return blackImage;
			case WHITE:
				return whiteImage;
			default:
				throw new IllegalStateException("player inconnu "+player);
			}
		}
 
	}
 
	///////Piece sur échiquier///////
	public static abstract class PiecePlateau {
 
		private final Player player;
		private final PieceType type;
		public PiecePlateau(PieceType type, Player player) {
			this.type=type;
			this.player=player;
		}
 
		public PieceType getType() {
			return type;
		}
 
		public Player getPlayer() {
			return player;
		}
 
		public ImageIcon getImage() {
			return getType().getImage(player);
		} 
 
	}
 
	///////Piece Pion///////
	public static class PION extends PiecePlateau {
		public PION(Player player) {
			super(PieceType.PION,player);
		}
	}
	
	///////Piece Roi///////
	public static class ROI extends PiecePlateau {
		public ROI(Player player) {
			super(PieceType.ROI,player);
		}
	}
	
	///////Piece Reine///////
	public static class REINE extends PiecePlateau {
		public REINE(Player player) {
			super(PieceType.REINE,player);
		}
	}
 
	///////Piece Fou///////
	public static class FOU extends PiecePlateau {
		public FOU(Player player) {
			super(PieceType.FOU,player);
		}
	}
	
	///////Piece Cavalier///////
	public static class CAVALIER extends PiecePlateau {
		public CAVALIER(Player player) {
			super(PieceType.CAVALIER,player);
		}
	}
 
	///////Piece Tour///////
	public static class TOUR extends PiecePlateau {
		public TOUR(Player player) {
			super(PieceType.TOUR,player);
		}
	}
 
	/////////////gestion des cases de l'échiquier/////////////
	public static class Case extends JPanel {
 
		private static final long serialVersionUID = 1L;
 
		private final Color color;
		private final int column;
		private final int line;
		private PiecePlateau piece; 
 
		public Case(int column, int line, Color color) {
			super(new BorderLayout());
			this.color=color;
			setBackground(color);
			this.column=column;
			this.line=line;
			setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
		}
 
		public int getLine() {
			return line;
		}
 
		public int getColumn() {
			return column;
		}
 
		public void setPiecePlateau(PiecePlateau piece) {
			this.piece=piece;
			if ( piece==null ) {
				removeAll();
			}
			else {
				add(new JLabel(piece.getImage()));
				revalidate();
			}
		}
 
		public PiecePlateau getPiecePlateau() {
			return piece;
		}
 
		public boolean isEmpty() {
			return piece==null;
		}
 
		public void setSelection(boolean selection) {
			setBackground(selection?SELECTION_COLOR:color);
		} 
 
	}
 
	
	
	public static class Controller {
		private final Echiquier ech;
		private final Plateau platea;
		private final Joueur JB;
		private final Joueur JN;
		private final Case[][] cases;
		private Case mouvementCase;
 
		public Controller(final Plateau platea,final Echiquier ech,final Joueur JB,final Joueur JN) {
			this.platea=platea;
			this.ech = ech;
			this.JB = JB;
			this.JN = JN;
			final Echiquier e = new Echiquier();
			this.cases=new Case[platea.getNbLines()][platea.getNbColumns()];
			final int nbPieces=platea.getNbLines()*platea.getNbColumns();
			for(int i=0; i<nbPieces; i++) {
				final int line = i/platea.getNbColumns();
				final int column = i%platea.getNbColumns();
				final Case Case = new Case(column, line, i%2==line%2?WHITE_CASE :BLACK_CASE );
				platea.add(Case);
				cases[line][column]=Case;
			}
			
			
			MouseAdapter mouseAdapter = new MouseAdapter() {
 
				@Override
				public void mouseClicked(MouseEvent event) {
					 // Enregistre quel bouton de la souris est enfoncé.
				    int buttonDown = event.getButton();
				    if (buttonDown == MouseEvent.BUTTON1) {
	
						Case Case = (Case) event.getSource();
							if ( !Case.isEmpty() ) {
								if ( isMoving() ) {// il y a un mouvement
									if ( Case.getPiecePlateau().getPlayer()==mouvementCase.getPiecePlateau().getPlayer() ) {
										JOptionPane.showMessageDialog(platea, "Une pièce à vous est déjà dans cette case","Mouvement impossible", JOptionPane.WARNING_MESSAGE);
									}//le mouvement de la pièce est valide
									
									else if ( moveValide(ech,JB,JN,mouvementCase.getPiecePlateau(), mouvementCase, Case) == true ) {
										//déplace la pièce et supprime son objet dans l'ancienne case
										moveTo(platea,ech,JB,JN,mouvementCase, Case);
										stopMove();
										platea.repaint();
									}else if ( moveValide(ech,JB,JN,mouvementCase.getPiecePlateau(), mouvementCase, Case) == false){
										JOptionPane.showMessageDialog(platea, "Mouvement non valide pour cette pièce ","Mouvement impossible", JOptionPane.WARNING_MESSAGE);
									}
								}
								else {
									startMove(Case);
									platea.repaint();
								}
							}
							else if ( isMoving() ) {
									moveTo(platea,ech,JB,JN,mouvementCase, Case);
									stopMove();
									platea.repaint();
							}
						
					}else if(buttonDown == MouseEvent.BUTTON3) {
				    	stopMove();
				    	platea.repaint();
				    }
				}
			};
			for(Case[] line : cases) {
				for(Case Case : line) {
					Case.addMouseListener(mouseAdapter);
				}
			}
		}
 
		public void setPiece(int column, int line, PiecePlateau piece) {
			if ( cases[column][line].isEmpty() ) {
				cases[column][line].setPiecePlateau(piece);
			}
			else {
				throw new IllegalStateException("Case occupée");
			}
		}
		
		
		private boolean ColorPlayer(Case c,Echiquier e){
			Piece tableauPiece[][] = e.getTableauPiece();
			Piece P = tableauPiece[c.getLine()][c.getColumn()];
			if(P.isCouleurIsWhite()==true){
				return true;
			}else{
				return false;
			}
		}
		
		
		private void moveTo(Plateau platea,Echiquier e,Joueur JB,Joueur JN, Case caseDeb, Case caseFin) {
			final PiecePlateau pieceDeb = caseDeb.getPiecePlateau();
			final PiecePlateau pieceFin = caseFin.getPiecePlateau();
			Piece tableauPiece[][] = e.getTableauPiece();
			Piece pieceTempDeb = tableauPiece[caseDeb.getLine()][caseDeb.getColumn()];
			Piece pieceTempFin = tableauPiece[caseFin.getLine()][caseFin.getColumn()];

			if ( pieceDeb ==null )throw new IllegalStateException("Pas de pièce dans la case de départ");
			if ( moveValide(ech,JB,JN,pieceDeb, caseDeb, caseFin) ) {
				
				//si la pièce de fin existe on la supprime
				caseFin.setPiecePlateau(null);
				caseFin.setPiecePlateau(pieceDeb);
				//dans tous les cas on vide la pièce de début 
				caseDeb.setPiecePlateau(null);
				if(caseFin != null){
					tableauPiece[caseFin.getLine()][caseFin.getColumn()] = null;
					tableauPiece[caseFin.getLine()][caseFin.getColumn()] = pieceTempDeb;
					e.setTableauPiece(tableauPiece);
					
				}
				if(TourJoueur =="WHITE"){
					if(tableauPiece[caseFin.getLine()][caseFin.getColumn()].getNom().equals("Pion")){
						if(caseFin.getLine()== 7){
							caseFin.setPiecePlateau(new REINE(Player.WHITE)) ; 
						}
					}
					TourJoueur = "BLACK";
				}else{
					if(tableauPiece[caseFin.getLine()][caseFin.getColumn()].getNom().equals("Pion")){
						if(caseFin.getLine()== 0){
							caseFin.setPiecePlateau(new REINE(Player.BLACK)) ; 
						}
					}
					TourJoueur = "WHITE";
				}
				
			}
			else {
				JOptionPane.showMessageDialog(platea, "Mouvement non autorisé pour cette pièce ","Mouvement impossible", JOptionPane.WARNING_MESSAGE);
			}
		
			
		}
 
		
		
		
		private void stopMove() {
			if ( mouvementCase!=null ) {
				mouvementCase.setSelection(false);
				mouvementCase=null;
			}
		} 
		
		
		
		
		// temp
		private void doCapture(Case Case) {
			
			Case.setPiecePlateau(null); 
		}
 
		
		
		
		private boolean moveValide(Echiquier e,Joueur JB,Joueur JN,PiecePlateau piece, Case caseDeb, Case caseFin) {
			//tableau temp du tableau de pièce de l'échiquier
			Piece tableauPiece[][] = e.getTableauPiece();
			//pièce temp de la pièce ciblée par le joueur
			Piece p  = tableauPiece[caseDeb.getLine()][caseDeb.getColumn()];
			Piece pfin = tableauPiece[caseFin.getLine()][caseFin.getColumn()];
			
			int m = 0;
			//compteur pour récupérer les info par couples x y
			int compteurdouble = 0;
			int z = 0;
			int k = 0;
			int liste[];
			boolean retour = false;
			boolean ColorPlayer;
	
			//on récupère les mouvements valident de la pièce dans une liste suivant le joueur
			if(String.valueOf(piece.getPlayer()) == "WHITE"){
				ColorPlayer = true;
				liste = new int[p.mouvementValide(JB).length];
				liste = p.mouvementValide(JB);	
			}else{
				ColorPlayer = false;
				liste = new int[p.mouvementValide(JN).length];
				liste = p.mouvementValide(JN);					
			}
			
			//la liste est formée comme ceci : [x][y][x][y] ...
			//on compare les coordonnées des mouvements valident 
			//aux coordonnées du mouvement voulu par le joueur
			
			while ( m < liste.length & retour == false){
				if(m%2 == 0 ){
					
					z = liste[m];
				}
				else{
					if(m%2 != 0){
						
						k = liste[m];
					}
					
				}
				
				m = m+1;
				//permet de récupérer les coordonnées par couples x y
				compteurdouble = compteurdouble +1;
				
				if (compteurdouble == 2){
					//si la somme des coordonnées voulu + les coordonnées du déplacement du mouvement valide
					// = coordonnées de la case ciblée  pour fin de déplacement
					//alors le mouvement est OK
					if((caseDeb.getLine()+z) == caseFin.getLine() & (k+caseDeb.getColumn()) == caseFin.getColumn()){
						if(pfin == null){
							if(ColorPlayer == true){
								e.deplacerPiece(JB,caseDeb.getLine(), caseDeb.getColumn(), caseFin.getLine(), caseFin.getColumn());
							}else{
								e.deplacerPiece(JN,caseDeb.getLine(), caseDeb.getColumn(), caseFin.getLine(), caseFin.getColumn());
							}
							
							///gérer la transformation du pion
				
						}else{
							
						}
						
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
 
		public Case getCase(int column, int line) {
			return cases[line][column];
		}
 
		public boolean isMoving() {
			return mouvementCase!=null;
		}
 
		private void startMove(Case Case) {
			if ( mouvementCase!=null ) {
				stopMove();
			}
			mouvementCase=Case;
			Case.setSelection(true);
		}
 
	} 
	
	
	public static void main(String[] args) {
		 
		JFrame frame = new JFrame("Jeu échec");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//initialisation du tableau. on Ré-utilise l'échiquier du jeu sur terminal sans l'afficher ni utiliser l'autre tableau///
		Echiquier e = new Echiquier();
	
		//////////////////////CREATION JOUEUR et Piece en objet//////////////////////////
		//création des joueurs
		Joueur JB = new Joueur("Blanc",true);
		Joueur JN = new Joueur("Noir",false);
		
		//creation echiquier Visuel//
		Plateau plat = new Plateau(8,8,e,JB,JN);
		
		//////////////////////Creation Piece visuel du plateau//////////////////////////
		//Pion
		for(int i=0;i<8; i++) {
			plat.setPiecePlateau(1,i,new PION(Player.WHITE));
			plat.setPiecePlateau(6,i,new PION(Player.BLACK));
		}
		//Tour
		plat.setPiecePlateau(0,0,new TOUR(Player.WHITE));
		plat.setPiecePlateau(0,7,new TOUR(Player.WHITE));
		plat.setPiecePlateau(7,0,new TOUR(Player.BLACK));
		plat.setPiecePlateau(7,7,new TOUR(Player.BLACK));
		
		//Cavalier
		plat.setPiecePlateau(0,1,new CAVALIER(Player.WHITE));
		plat.setPiecePlateau(0,6,new CAVALIER(Player.WHITE));
		plat.setPiecePlateau(7,1,new CAVALIER(Player.BLACK));
		plat.setPiecePlateau(7,6,new CAVALIER(Player.BLACK));
		
		//Fou
		plat.setPiecePlateau(0,2,new FOU(Player.WHITE));
		plat.setPiecePlateau(0,5,new FOU(Player.WHITE));
		plat.setPiecePlateau(7,2,new FOU(Player.BLACK));
		plat.setPiecePlateau(7,5,new FOU(Player.BLACK));
		
		//Reine
		plat.setPiecePlateau(0,4,new REINE(Player.WHITE));
		plat.setPiecePlateau(7,4,new REINE(Player.BLACK));
		
		//Roi
		plat.setPiecePlateau(0,3,new ROI(Player.WHITE));
		plat.setPiecePlateau(7,3,new ROI(Player.BLACK));
		
				
		//////////création des pièces Blanches + ajout des pièces au joueur Blanc///////
		//Pion Blanc création
		Piece pb0 = new Pion("Pion",true,1,0);
		JB.ajoutPiece(pb0);
		Piece pb1 = new Pion("Pion",true,1,1);
		JB.ajoutPiece(pb1);
		Piece pb2 = new Pion("Pion",true,1,2);
		JB.ajoutPiece(pb2);
		Piece pb3 = new Pion("Pion",true,1,3);
		JB.ajoutPiece(pb3);
		Piece pb4 = new Pion("Pion",true,1,4);
		JB.ajoutPiece(pb4);
		Piece pb5 = new Pion("Pion",true,1,5);
		JB.ajoutPiece(pb5);
		Piece pb6 = new Pion("Pion",true,1,6);
		JB.ajoutPiece(pb6);
		Piece pb7 = new Pion("Pion",true,1,7);
		JB.ajoutPiece(pb7);
		
		//Tour Blanc création
		//Tour droite
		Piece tb0 = new Tour("Tour",true,0,0,true);
		JB.ajoutPiece(tb0);
		//Tour gauche
		Piece tb1 = new Tour("Tour",true,0,7,false);
		JB.ajoutPiece(tb1);
		
		//Cavalier Blanc création
		Piece cb0 = new Cavalier("Cavalier",true,0,1,true);
		JB.ajoutPiece(cb0);
		Piece cb1 = new Cavalier("Cavalier",true,0,6,false);
		JB.ajoutPiece(cb1);
		
		//Fou Blanc création
		Piece fb0 = new Fou("Fou",true,0,2,true);
		JB.ajoutPiece(fb0);
		Piece fb1 = new Fou("Fou",true,0,5,false);
		JB.ajoutPiece(fb1);
		
		//Reine Blanc création
		Piece qb0 = new Reine("Reine",true,0,3);
		JB.ajoutPiece(qb0);
		
		//Roi Blanc création
		Piece rb0 = new Roi("Roi",true,0,4);
		JB.ajoutPiece(rb0);
		
		//////////création des pièces Noires + ajout des pièces au joueur Noir///////		
		//Pion Noir création
		Piece pn0 = new Pion("Pion",false,6,0);
		JN.ajoutPiece(pn0);
		Piece pn1 = new Pion("Pion",false,6,1);
		JN.ajoutPiece(pn1);
		Piece pn2 = new Pion("Pion",false,6,2);
		JN.ajoutPiece(pn2);
		Piece pn3 = new Pion("Pion",false,6,3);
		JN.ajoutPiece(pn3);
		Piece pn4 = new Pion("Pion",false,6,4);
		JN.ajoutPiece(pn4);
		Piece pn5 = new Pion("Pion",false,6,5);
		JN.ajoutPiece(pn5);
		Piece pn6 = new Pion("Pion",false,6,6);
		JN.ajoutPiece(pn6);
		Piece pn7 = new Pion("Pion",false,6,7);
		JN.ajoutPiece(pn7);
		
		//Tour Noir création
		//Tour droite
		Piece tn0 = new Tour("Tour",false,7,0,true);
		JN.ajoutPiece(tn0);
		//Tour gauche
		Piece tn1 = new Tour("Tour",false,7,7,false);
		JN.ajoutPiece(tn1);
		
		//Cavalier Noir création
		Piece cn0 = new Cavalier("Cavalier",false,7,1,true);
		JN.ajoutPiece(cn0);
		Piece cn1 = new Cavalier("Cavalier",false,7,6,false);
		JN.ajoutPiece(cn1);
		
		//Fou Noir création
		Piece fn0 = new Fou("Fou",false,7,2,true);
		JN.ajoutPiece(fn0);
		Piece fn1 = new Fou("Fou",false,7,5,false);
		JN.ajoutPiece(fn1);
		
		//Reine Noir création
		Piece qn0 = new Reine("Reine",false,7,3);
		JN.ajoutPiece(qn0);
		
		//Roi Noir création
		Piece rn0 = new Roi("Roi",false,7,4);
		JN.ajoutPiece(rn0);
		////////////////////////////////////////FIN//////////////////////////////
		
		
		////////placer pièces sur les cases de l'échiquier/////////////
		//Joueur Blanc placer
		//Pion Blanc placer placerPieceEchiquier
		pb0.placerEchiquier(pb0,e,pb0.getX(),pb0.getY());
		pb1.placerEchiquier(pb1,e,pb1.getX(),pb1.getY());
		pb2.placerEchiquier(pb2,e,pb2.getX(),pb2.getY());
		pb3.placerEchiquier(pb3,e,pb3.getX(),pb3.getY());
		pb4.placerEchiquier(pb4,e,pb4.getX(),pb4.getY());
		pb5.placerEchiquier(pb5,e,pb5.getX(),pb5.getY());
		pb6.placerEchiquier(pb6,e,pb6.getX(),pb6.getY());
		pb7.placerEchiquier(pb7,e,pb7.getX(),pb7.getY());
		
		//Tour Blanc placer
		tb0.placerEchiquier(tb0, e, tb0.getX(), tb0.getY());
		tb1.placerEchiquier(tb1, e, tb1.getX(), tb1.getY());
		
		//Cavalier Blanc placer
		cb0.placerEchiquier(cb0, e, cb0.getX(), cb0.getY());
		cb1.placerEchiquier(cb1, e, cb1.getX(), cb1.getY());
		
		//Fou Blanc placer
		fb0.placerEchiquier(fb0, e, fb0.getX(), fb0.getY());
		fb1.placerEchiquier(fb1, e, fb1.getX(), fb1.getY());
		
		//Reine Blanc placer
		qb0.placerEchiquier(qb0, e, qb0.getX(), qb0.getY());
		
		//Roi Blanc placer
		rb0.placerEchiquier(rb0, e, rb0.getX(), rb0.getY());		
		
		//Joueur Noir placer
		//Pion Noir placer
		pn0.placerEchiquier(pn0,e,pn0.getX(),pn0.getY());
		pn1.placerEchiquier(pn1,e,pn1.getX(),pn1.getY());
		pn2.placerEchiquier(pn2,e,pn2.getX(),pn2.getY());
		pn3.placerEchiquier(pn3,e,pn3.getX(),pn3.getY());
		pn4.placerEchiquier(pn4,e,pn4.getX(),pn4.getY());
		pn5.placerEchiquier(pn5,e,pn5.getX(),pn5.getY());
		pn6.placerEchiquier(pn6,e,pn6.getX(),pn6.getY());
		pn7.placerEchiquier(pn7,e,pn7.getX(),pn7.getY());
		
		//Tour Noir placer
		tn0.placerEchiquier(tn0, e, tn0.getX(), tn0.getY());
		tn1.placerEchiquier(tn1, e, tn1.getX(), tn1.getY());
		
		//Cavalier Noir placer
		cn0.placerEchiquier(cn0, e, cn0.getX(), cn0.getY());
		cn1.placerEchiquier(cn1, e, cn1.getX(), cn1.getY());
		
		//Fou Noir placer
		fn0.placerEchiquier(fn0, e, fn0.getX(), fn0.getY());
		fn1.placerEchiquier(fn1, e, fn1.getX(), fn1.getY());
		
		//Reine Noir placer
		qn0.placerEchiquier(qn0, e, qn0.getX(), qn0.getY());
		
		//Roi Noir placer
		rn0.placerEchiquier(rn0, e, rn0.getX(), rn0.getY());
		////////////////////////////////////////FIN//////////////////////////////
		
	
		frame.add(plat);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
 
	}
	
	
}