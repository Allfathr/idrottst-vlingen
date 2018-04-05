// Anton Sandström ansa6928
// Jesper Jönsson jeja6606

public class SportsMethods {
	
	// Denna metod tar bort whitespace före och efter input-strängen och sedan kapitaliserar den första 
	// bokstaven och omvandlar resten av strängen till gemener.
	public String capitalizeTrim(String original) {
		original = original.trim();
		original = original.substring(0,1).toUpperCase() + original.substring(1).toLowerCase();
		return original;
	}
	
	public void message(String longText) {
		System.out.println("############################################################");
		System.out.println(String.format("%-58s #", "#"));
		// Strängen som skrivs ut kan ej vara bredare än 56 karaktärer
		System.out.println(String.format("# %-56.56s #", longText.toUpperCase()));
		System.out.println(String.format("%-58s #", "#"));
		System.out.println("############################################################");
	}
	
	public void sysExit() {
		System.out.println("Programmet avslutas");
		System.exit(0);
		}
}
