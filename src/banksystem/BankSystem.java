
package banksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    //Two Arrays to store data
    static ArrayList<BankAccount> bankAccounts;
    static ArrayList<Client> clients;
    
    static Scanner input = new Scanner(System.in);
    
    //Method to view all Clients 
    public static void viewAllClients(){
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).view();
        }
    }
    
    //Search Method
    public static int search(int id){
        for (int i = 0; i <bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }
    
  //Method withdraw amount of money  
    public static void withdraw(){
        System.out.println("please enter account ID ");
        int id =  input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("Account Not Found");
        }
        else{
            System.out.println("please enter amount to withdraw");
            double withdraw = input.nextDouble();

            if ( bankAccounts.get(index).withraw(withdraw)) {
            System.out.println("Successful Withdraw");
            }
        }
    }
    
    //Method deposit amount of money
    public static void deposit(){
        System.out.println("please enter account ID");
        int id = input.nextInt();
        int index = search(id);
        if (index == -1) {
            System.out.println("Account Not Found");
        }
        else{
            System.out.println("please enter amount to deposit");
            double deposit = input.nextDouble();
            if (bankAccounts.get(index).deposit(deposit)) {
            System.out.println("Successful Deposit");
            }
        }
    }
    
    
    //Method to add account
    //It allows to user to wrong choice up to 3 times 
    public static void addAccount(){
        String name;
        String address;
        String mobile;
        input.nextLine();
       
        
        System.out.println("please enter client name:");
        name= input.nextLine();
        System.out.println("please enter client address:");
        address = input.nextLine();
        System.out.println("please enter client phone number");
        mobile = input.nextLine();
        
        Client c = new Client(name, address, mobile);
         
        BankAccount b = null;
        
        int choice = 3;
        int counter = 3;
        while (choice!=1 && choice!=2) {            
            if (counter == 0) {
                System.out.println("Worng Choice");
                return;
            }
            counter --;
           System.out.println("please ener 1 to create Basic Bank Account\n"
                + "Enter 2 to create Savings Bank Account");
           choice = input.nextInt();
            if (choice!=1 && choice!=2) continue;
                
            double balance = 0.0;
            System.out.println("please enter balance amount");
            balance = input.nextDouble();
            
            if (choice == 1 ) {
                b = new BankAccount(balance, clients.size());
            }
            if (choice == 2 ) {
                 b = new SavingsBankAccount(balance, clients.size());
            }
            b.setClient(c);
            c.setBankAccount(b);
            bankAccounts.add(b);
            clients.add(c);
        }
    }
    
    
     public static void addData(){
           clients=new ArrayList<>(1);
           bankAccounts= new ArrayList<>(1);
        for (int i = 0; i < 1; i++) {
            
         Client c = new Client("Name "+i, "Address "+i, "Mobile "+i);
         BankAccount b = new BankAccount(3000, i*1);
         c.setBankAccount(b);
         b.setClient(c);
         
         clients.add(c);
         bankAccounts.add(b);
         
        }
    }
     
     
    public static void main(String[] args) {
        
         addData();
        OUTER:
        while (true) {
            System.out.println(
                    "1- view all clients\n"
                            + "2- search BankAccount\n"
                            + "3- remove Bankaccount\n"
                            + "4- add BankAccount\n"
                            + "5- Withdraw\n"
                            + "6- Deposite\n"
                            + "7- Exit");
            int choice= input.nextInt();
            switch (choice) {
                case 1:
                    viewAllClients();
                    break;
                case 2:
                    {
                        System.out.println("please enter account id");
                        int id = input.nextInt();
                        int index = search(id);
                        if (index==-1){
                            System.out.println("account not found");
                        }else {
                            clients.get(index).view();
                        }           
                        break;
                    }
                case 3:
                    {
                        System.out.println("please enter account id");
                        int id = input.nextInt();
                        int index = search(id);
                        if (index==-1){
                            System.out.println("account not found");
                        }else {
                            clients.remove(index);
                            bankAccounts.remove(index);
                        }           break;
                    }
                case 4:
                    addAccount();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    deposit();
                    break;
                case 7:
                    break OUTER;
                default:
                    break;
            }
        }
    }
   
}
