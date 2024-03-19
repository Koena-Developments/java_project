package functionalities;

import java.util.Scanner;

public class banking_feautres {
    private String name;
    private String surname;
    private String Pin;
    private String AccountNumber;


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
    Scanner input = new Scanner(System.in);

    public void Login()
    {
        System.out.println("Welcome to LenX Bank \n");

        System.out.println("Please enter your Acoount Number here:  \n");
        String AccountNUmber = input.nextLine();

        System.out.println("Please enter your 4-digit Pin here:  \n");
        String Pin = input.nextLine();

        if (Pin.length() != 4)
        {
            System.out.println("Your Pin can not be more or less than 4 digits");
            Pin = input.nextLine();
        }

    }

    public void Registration() {
        boolean condition = true;

//        while (condition) {
            System.out.printf("Please enter your Name: ");
            String name = input.nextLine();

            System.out.println("please enter your Surname: ");
            String surname = input.nextLine();

            System.out.println("please enter your South African ID_Number: ");
            String id_number = input.nextLine();

            if (id_number.length() < 13 || id_number.length() > 13)
            {
                System.out.println("ID_number must be 13 digits: ");
                id_number = input.nextLine();
            }

        System.out.println("please wait while we verify...");
            //        }
    }

    public static void main(String[] args) {

    }
}



