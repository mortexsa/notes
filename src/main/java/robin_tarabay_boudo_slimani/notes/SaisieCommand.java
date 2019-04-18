package robin_tarabay_boudo_slimani.notes;

import java.util.*;

/**
 * SaisieCommand.java : Classe permettant de saisir des notes
 * 
 * @author robin_tarabay_boudo_slimani
 * @version 1.0
 */


public class SaisieCommand {
	
	private Scanner saisie;
	private final Map<String, Command> commands;
	private App app;
	
	/**
	 * Constructeur par défaut
	 * @param a qui prend en paramètre App
	 */
	public SaisieCommand(App a)
	{
		this.saisie = new Scanner(System.in);
		this.commands = new HashMap<>();
		this.app = a;
	}
	
	/**
	 * Permet de stocker et d'exécuter la commande
	 * @param nom qui permet de passer un nom en paramètre
	 * @param cmd qui permet de passer une cmd en paramètre
	 */
	public void storeAndExecute(String nom, Command cmd)
	{
		this.commands.put(nom, cmd);
	    this.commands.get(nom).execute();   
	}
	
	/**
	 * Permet d'executer la commande
	 * @param nom qui permet de passer un nom en paramètre
	 */
	public void executeCommand(String nom)
	{
		this.commands.get(nom).execute();       
	}
	
	/**
	 * Permet d'afficher le Menu
	 */
	public void afficheInfo()
	{
		System.out.println("\n" + 
				"\n" + 
				" __    __              __                         \n" + 
				"/  \\  /  |            /  |                        \n" + 
				"$$  \\ $$ |  ______   _$$ |_     ______    _______ \n" + 
				"$$$  \\$$ | /      \\ / $$   |   /      \\  /       |\n" + 
				"$$$$  $$ |/$$$$$$  |$$$$$$/   /$$$$$$  |/$$$$$$$/ \n" + 
				"$$ $$ $$ |$$ |  $$ |  $$ | __ $$    $$ |$$      \\ \n" + 
				"$$ |$$$$ |$$ \\__$$ |  $$ |/  |$$$$$$$$/  $$$$$$  |\n" + 
				"$$ | $$$ |$$    $$/   $$  $$/ $$       |/     $$/ \n" + 
				"$$/   $$/  $$$$$$/     $$$$/   $$$$$$$/ $$$$$$$/  \n" + 
				"                                                  \n" + 
				"                                                  \n" + 
				"                                                  \n" + 
				"\n" + 
				"");
		System.out.println("Bienvenue sur notre application de prises de Notes !\n\n"+
		"	Voici les différentes commandes que vous pouvez effectuer:\n\n"+
		"		-Créer ou éditer un Fichier: Tapez e ou edit suivi du nom de votre Fichier \n"+
		"		-Visualiser un Fichier: Tapez v ou view suivi du nom de votre Fichier\n"+
		"		-Lister le contenu du répertoire Document: Tapez ls ou list\n"+
		"		-Supprimer un Fichier: Tapez d ou delete suivi du nom de votre Fichier \n");
		
		System.out.println("Que souhaitez-vous faire? ");
	}
	
	/**
	 * Permet l'interaction entre l'application et l'utilisateur
	 * @param args qui permet à l'utilisateur d'interagir avec l'application
	 */
	public void saisieUser(String[] args)
	{
		if(args.length != 0)
		{
//			String s = saisie.nextLine();
			String cmd = args[0];
			String note = "";
			if(args.length != 1)
			{
				 note = args[1];
			}
			System.out.println(cmd);
			System.out.println(note);
			
			
//			try
//			{
//					
//			}catch(IOException e)
//			{
//				System.out.println(e.getMessage());
//			}
				
			switch (cmd)
			{
				case "edit":
				case "e":
					if(this.commands.containsKey(note))
					{
						executeCommand(note);
					}
					else
					{
						Command command = new EditNotesCommand(app,note);
						storeAndExecute(note, command);
					}
					break;
						
				case "view":
				case "v":
					if(this.commands.containsKey(note))
					{
						System.out.println("if");
						executeCommand(note);
					}
					else
					{
						System.out.println("else");
						Command command = new ViewNotesCommand(app,note);
						storeAndExecute(note, command);
					}
					break;
					
				case "list":
				case "ls":
					app.liste();
					break;
					
				case "delete":
				case "d":
					app.delete(note);
					break;
					

				default:
					break;
				}
			}
		else
		{
			afficheInfo();
			String note = "";
			String cmd = saisie.next();
			if(cmd != "ls" || cmd != "list")
			{
				 note = saisie.nextLine();
			}
			System.out.println(cmd);
			System.out.println(note);
			 if(note.length() != 0)
			 {
				 note = note.substring(1,note.length());
			 }
			
			switch (cmd)
			{
				case "edit":
				case "e":
					if(this.commands.containsKey(note))
					{
						executeCommand(note);
					}
					else
					{
						Command command = new EditNotesCommand(app,note);
						storeAndExecute(note, command);
					}
					break;
						
				case "view":
				case "v":
					if(this.commands.containsKey(note))
					{
						System.out.println("if");
						executeCommand(note);
					}
					else
					{
						System.out.println("else");
						Command command = new ViewNotesCommand(app,note);
						storeAndExecute(note, command);
					}
					break;
					
				case "list":
				case "ls":
					app.liste();
					break;
					
				case "delete":
				case "d":
					app.delete(note);
					break;

				default:
					break;
				}
		}
			saisie.close();
		
	}
	
	/**
	 * Fonction principale du programme 
	 * @param args pour récupérer les commandes saisies par l'utilisateur
	 */
	public static void main( String[] args )
    {
    	App app = new App();
    	SaisieCommand saisie = new SaisieCommand(app);
    	saisie.saisieUser(args);
    }
}
