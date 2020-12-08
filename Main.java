import java.util.Arrays;
import java.util.Dictionary;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// This is our temporary way of storing client data in our program
		Dictionary<String, Client> clients = new Hashtable<String, Client>();

		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		System.out.println(mainMenu.getSelection() + "foi selecionada");
		System.out.println("Fim");
	}

	public static int IncreaseAccountBalance(Dictionary<String, Client> clients) {
		Scanner s = new Scanner(System.in);
		String str;
		
		// Retrieve client
		System.out.println("Insira o CPF do cliente: ");
		str = s.nextLine();
		// OPTIONAL: PARSE OR VALIDATE CPF?
		Client retrievedClient = clients.get(str);
		if (retrievedClient == null) {
			// Couldn't find client data.
			return -1;
		}

		// Retrieve client account
		System.out.println("Insira o ID da conta: ");
		str = s.nextLine();
		int accountId = -1;
		try {
			accountId = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			// Invalid account id provided.
			return -2;
		}
		Account targetAccount = retrievedClient.getAccount(accountId);
		if (targetAccount == null) {
			// The account provided doesn't exists.
			return -3;
		}

		System.out.println("Insira o valor a ser adicionado a conta: ");
		str = s.nextLine();
		double value = -1;
		try {
			value = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			// Invalid value provided
			return -4;
		}
		if (value < 0) {
			// Negative values shouldn't be provided
			return -5;
		}

		boolean transactionStatus = targetAccount.addBalance(value);
		if (transactionStatus == false) {
			// A invalid add transaction only happens when it inserts a negative value, thus we repeat the returned error code.
			return -5;
		}

		System.out.println("Pronto!");

		return 0;
	}
}
