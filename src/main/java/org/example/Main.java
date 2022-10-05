package org.example;

import adapteur.DataAdapter;
import adapteur.DataAdapterImpl;
import adapteur.HexadecimalData;
import chaineDeResponsabilite.*;
import fabriqueAbstraite.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static ChairClient configureAbstractFactory(String chairType) {
        ChairFactory factory;
        ChairClient chairClient;
        if (chairType == "gaming") {
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

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Abstract Factory");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Initialisation d'une chaise de type Gaming : ");
        ChairClient chairClient;
        chairClient = configureAbstractFactory("gaming");
        chairClient.getChairInformation();

        System.out.println("Initialisation d'une chaise de type Office : ");
        chairClient = configureAbstractFactory("office");
        chairClient.getChairInformation();

        System.out.println("Initialisation d'une chaise de type Rockingchair : ");
        chairClient = configureAbstractFactory("rockingChair");
        chairClient.getChairInformation();



        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Adapter");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();

        HexadecimalData objectWhoServHexadecimalData = new HexadecimalData();

        System.out.println("resultat de la méthode getData avant utilisation de l\' adapter : " + objectWhoServHexadecimalData.getData());
        DataAdapter objectWhoServeByteArray = new DataAdapterImpl(objectWhoServHexadecimalData);
        System.out.println("resultat de la méthode getData après utilisation de l\' adapter : ");
        System.out.println(Arrays.toString(objectWhoServeByteArray.getData()));



        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Chain of responsibility");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();

        //create chain of responsability
        RegisterProcessor chain = new PasswordProcessor(new EmailProcessor(new UsernameProcessor(null)));

        RegisterRequest badPasswordRequest = new RegisterRequest("toto", "totoemail@.com", "pass");
        RegisterRequest badEmailRequest = new RegisterRequest("toto", "totoemail.com", "passhttg");
        RegisterRequest badUsernameRequest = new RegisterRequest("toto$", "totoemail@.com", "passsfsfs");
        RegisterRequest correctrequest = new RegisterRequest("toto", "totoemail@.com", "passsfsfs");

        ArrayList<RegisterRequest> registerRequests = new ArrayList<>();

        registerRequests.add(badEmailRequest);
        registerRequests.add(badPasswordRequest);
        registerRequests.add(badUsernameRequest);
        registerRequests.add(correctrequest);

        int i = 0;
        for(RegisterRequest request: registerRequests) {
            System.out.println("reception de la requete " + i );
            chain.canRegister(request);
            i++;
        }


    }
}
