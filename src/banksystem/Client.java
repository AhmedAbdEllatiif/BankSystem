
package banksystem;


public class Client {
    
    String name;
    String address;
    String phoneNumber;
    BankAccount bankAccount;

    public Client() {
    }

    
    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    
    public void view(){
        System.out.println("Name: " + name + "\n");
        System.out.println("Address: " + address + "\n");
        System.out.println("Mobile: " + phoneNumber + "\n");
        System.out.println("Account ID: " + bankAccount.getID() + "\n");
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("/////////////////////////////////////////////");
    }
    
}
