package org.example;

import adapteur.DataAdapter;
import adapteur.DataAdapterImpl;
import adapteur.HexadecimalData;
import chaineDeResponsabilite.*;
import fabriqueAbstraite.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

   private static ChairClient configureAbstractFactory(String chairType) {
       ChairFactory factory;
       ChairClient chairClient;
       if(chairType == "gaming") {
           factory = new GamingChairFactory();
       } else if (chairType == "office") {
           factory = new OfficeChairFactory();
       } else if (chairType == "rockingChair") {
           factory = new RockingChairFactory();
       } else {
           //error handle
           throw new IllegalArgumentException("Le type de chaise n'existe pas");
       }

       chairClient = new ChairClient(factory);
       return chairClient;

   }

    public static void main(String[] args) {
        ChairClient chairClient;
        chairClient = configureAbstractFactory("gaming");
        chairClient.getChairInformation();

        chairClient = configureAbstractFactory("office");
        chairClient.getChairInformation();

        chairClient = configureAbstractFactory("rockingChair");
        chairClient.getChairInformation();


        HexadecimalData objectWhoServHexadecimalData = new HexadecimalData();

        System.out.println("resultat de la méthode getData avant utilisation de l\' adapter : " + objectWhoServHexadecimalData.getData());
        DataAdapter objectWhoServeByteArray = new DataAdapterImpl(objectWhoServHexadecimalData);
        System.out.println("resultat de la méthode getData après utilisation de l\' adapter : ");
        System.out.println(Arrays.toString(objectWhoServeByteArray.getData()));

        //create chain of responsability
        RegisterProcessor chain = new PasswordProcessor(new EmailProcessor(new UsernameProcessor(null)));

        RegisterRequest badPasswordRequest = new RegisterRequest("toto", "totoemail@.com", "pass");
        RegisterRequest badEmailRequest = new RegisterRequest("toto", "totoemail.com", "passhttg");
        RegisterRequest badUsernameRequest = new RegisterRequest("toto$", "totoemail@.com", "passsfsfs");

        chain.canRegister(badPasswordRequest);
        chain.canRegister(badEmailRequest);
        chain.canRegister(badUsernameRequest);
        RegisterProcessor registerProcessor = new PasswordProcessor(null);

    }
}
