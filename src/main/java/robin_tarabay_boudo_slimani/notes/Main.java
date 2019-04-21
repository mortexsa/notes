package robin_tarabay_boudo_slimani.notes;

public class Main {
	
	
	/**
	 * Fonction principale du programme 
	 * @param args pour récupérer les commandes saisies par l'utilisateur
	 */
	public static void main( String[] args )
    {
    	GestionNotes gestionNotes = new GestionNotes();
    	SaisieCommand saisie = new SaisieCommand(gestionNotes);
    	saisie.saisieUser(args);
    }

}