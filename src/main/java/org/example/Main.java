package org.example;

import java.util.Scanner;
public class Main {
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


    public static void main(String[] args) {

    }
}