
import java.io.*;

public class Clavier {
	//méthode pour lire une chaîne
	public static String lireString() 
	{
		String ligne_lue=null;
		try
		{
			InputStreamReader lecteur=new InputStreamReader (System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue= entree.readLine();
		}
		catch (IOException err)
		{
			System.exit(0);
		}
		return ligne_lue;
	}
	
	//méthode pour lire un float
	public static float lireFloat() 
	{
		float x=0; //valeur à lire
		try
		{
			String ligne_lue=lireString();
			x=Float.parseFloat(ligne_lue);
		
		}
		catch (NumberFormatException err)
		{
			System.out.println("*** Erreur de donnée ***");
			System.exit(0);
		}
		return x;
	}
	
	//méthode pour lire un double
	public static double lireDouble()
	{
		double x=0; //valeur à lire
		try
		{
			String ligne_lue=lireString();
			x=Double.parseDouble(ligne_lue);				
		}
		catch (NumberFormatException err)
		{
			System.out.println(("*** Erreur de donnée ***"));
			System.exit(0);
		}
		return x;
	}
	
	//méthode pour lire un int
	public static int lireInt()
	{
		int n=0; //valeur à lire
		try
		{
			String ligne_lue=lireString();
			n=Integer.parseInt(ligne_lue);
		}
		catch (NumberFormatException err)
		{
			System.out.println(("*** Erreur de donnée ***"));
			System.exit(0);
		}
		return n;
	}
}