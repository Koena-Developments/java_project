package functionalities;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.StringConcatException;
import java.util.Random;
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

    public String Account_Number_Generator(String acc_num)
    {
        char[] accArray = acc_num.toCharArray();
        Random rand = new Random();
        for (int i = accArray.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = accArray[i];
            accArray[i] = accArray[j];
            accArray[j] = temp;
        }
        return new String(accArray);
    }

    public String[] Registration() {
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
            else {
                this.AccountNumber = Account_Number_Generator(id_number);
            }

        System.out.println("please wait while we verify...");
        System.out.printf("Welcome %s your new acc_number is %s ", name, this.AccountNumber);

        return new String[]{name,surname,id_number,this.AccountNumber};
    }

    public void dataBase(String Name, String Surname, String Account_number, String id_number)
    {
        try {
            FileWriter writer = new FileWriter("dataBase.txt");
            writer.write("Name:  "+ Name);
            writer.write("\nSurname: "+ Surname);
            writer.write("\nAccNum: "+ Account_number);
            writer.write("\nID_number: "+ id_number);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}



