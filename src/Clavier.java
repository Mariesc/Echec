
import java.io.*;

public class Clavier {
	//m�thode pour lire une cha�ne
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
	
	//m�thode pour lire un float
	public static float lireFloat() 
	{
		float x=0; //valeur � lire
		try
		{
			String ligne_lue=lireString();
			x=Float.parseFloat(ligne_lue);
		
		}
		catch (NumberFormatException err)
		{
			System.out.println("*** Erreur de donn�e ***");
			System.exit(0);
		}
		return x;
	}
	
	//m�thode pour lire un double
	public static double lireDouble()
	{
		double x=0; //valeur � lire
		try
		{
			String ligne_lue=lireString();
			x=Double.parseDouble(ligne_lue);				
		}
		catch (NumberFormatException err)
		{
			System.out.println(("*** Erreur de donn�e ***"));
			System.exit(0);
		}
		return x;
	}
	
	//m�thode pour lire un int
	public static int lireInt()
	{
		int n=0; //valeur � lire
		try
		{
			String ligne_lue=lireString();
			n=Integer.parseInt(ligne_lue);
		}
		catch (NumberFormatException err)
		{
			System.out.println(("*** Erreur de donn�e ***"));
			System.exit(0);
		}
		return n;
	}
}