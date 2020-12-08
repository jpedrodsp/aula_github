import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// This is our temporary way of storing client data in our program
		Dictionary<String, Client> clients = new Hashtable<String, Client>();
		
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		System.out.println(mainMenu.getSelection() + "foi selecionada");
		System.out.println("Fim");
	}

}
