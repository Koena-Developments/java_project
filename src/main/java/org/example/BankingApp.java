package org.example;
import functionalities.banking_feautres;
import org.json.simple.JSONObject;

public class BankingApp {


    public static void main(String[] args) {

        banking_feautres customer = new banking_feautres();
        String[] registrationInfo = customer.Registration();

        String name = registrationInfo[0];
        String surname = registrationInfo[1];

        String id_number = registrationInfo[2];
        String account_number = registrationInfo[3];

        String pin = registrationInfo[4];
        customer.dataBase(name, surname, account_number,id_number, pin);

        customer.Login();


    }
}