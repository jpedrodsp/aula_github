import java.util.*;
import java.io.*;

public class Client {
    private String cpf;
    private String name;
    private Dictionary<Integer, Account> accounts;
    
    // Constructor
    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
        this.accounts = new Hashtable<Integer, Account>();
    }

    // Getters
    public String getCPF() {
        return this.cpf;
    }
    public String getName() {
        return this.name;
    }

    // Setters
    /*
    public void setCPF(String newCPF) {
        this.cpf = newCPF;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    */

    // Retrieve account
    public Account getAccount(int accountId) {
        Account retrievedAccount = accounts.get(accountId);
        return retrievedAccount;
    }

    // Register accounts
    public boolean registerAccount(Account account) {
        // Only adds the account if it there isn't anyone with the same id
        int targetId = account.getId();
        Account checkReference = accounts.get(targetId);
        if (checkReference == null) {
            accounts.put(targetId, account);
            return true;
        }
        return false;
    }

    public boolean registerAccount(int id) {
        // Only adds the account if it there isn't anyone with the same id
        Account checkReference = accounts.get(id);
        if (checkReference == null) {
            Account newAccount = new Account(id);
            accounts.put(targetId, newAccount);
            return true;
        }
        return false;
    }
}