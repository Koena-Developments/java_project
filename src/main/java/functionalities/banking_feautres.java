package functionalities;
import java.io.*;
//import java.lang.invoke.StringConcatException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Random;
import java.util.Scanner;

public class banking_feautres {
    private String name;
    private String surname;
    private String Pin;
    private String AccountNumber;

    public String[] birthDayRetriver(String id_num)
    {
        /*
            The intention of this method is to return the year and the day and the month when given the
            correct id_number of 13 characters
            it returns an array of strings that we need to unpack when writing to the json file
         */
        if(id_num.isEmpty() == true)
        {
            System.out.println("There is no ID number provided: ");
        }
            // 9906165353086
            // 012345678910
            String year = id_num.substring(0,3);
            String Month = id_num.substring(3,5);
            String Day = id_num.substring(5,7);

            return new String[]{year, Month, Day};

    }

    public String pinGenerator()
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(); // Generate a random integer
            sb.append(randomNumber);
            if (i < 3) {
                sb.append(", ");
            }
        }
//        this.Pin = sb.toString();
        return sb.toString().substring(0,4);
    }

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
        JSONParser retrieving = new JSONParser();
        try {
            /*
                seem not to be reading from the json file
             */
            JSONObject database = (JSONObject) retrieving.parse(new FileReader("database.json"));
            String clientAccNum = (String) database.get("Client_Account_number");
            String clientPin = (String) database.get("Client_pin");
            if(AccountNUmber.equals(clientAccNum) && Pin.equals(clientPin))
            {
                System.out.println("Welcome Your are Logged in !!");
            }
            else{
                System.out.println("oops seems like youre not a member wanna register? Y/N");
                String option = input.nextLine();

                if (option == "Y")
                {
                    Registration();
                }
                else {
                    System.out.println("Please try again next time BYE! ");
                    System.exit(0);
                }
            }
        }catch (IOException | ParseException r)
        {
            r.printStackTrace();
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
        return new String(accArray).substring(0,10);
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
//                this.Pin = pinGenerator();
            }

        System.out.println("please wait while we verify...");
        System.out.printf("Welcome %s your new acc_number is %s ", name, this.AccountNumber);

        return new String[]{name,surname,id_number,this.AccountNumber, pinGenerator()};
    }

    public JSONObject dataBase(String Name, String Surname, String Account_number, String id_number, String pin)
    {
        JSONObject database = new JSONObject();
        database.put("Client_Name", Name);
        database.put("\n"+"Client_Surname", Surname);
        database.put("Client_Account_number", Account_number);
        database.put("Client_ID_number", id_number);
        database.put("Client_pin", pin);
        try
        {
            FileWriter jsonwriter = new FileWriter("database.json");
            jsonwriter.write(database.toJSONString());

            jsonwriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.printf("Registered!!! welcome %s ", Name);
    return database;
    }
}



