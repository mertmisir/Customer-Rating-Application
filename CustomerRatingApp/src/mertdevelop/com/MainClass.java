package mertdevelop.com;

import java.sql.*;

public class MainClass {

    public static void main(String[] args) {

        /* !! ALL THE GIVEN CONDITIONS HAVE BEEN CHECKED HERE !!
         *    PS: NOT IN AN ASCENDING ORDER */

        //testing condition 6 in PDF
        Customer c1 = new Customer();
        c1.setID(1000);
        c1.setUserName("Mert Misir");
        c1.setOrigin("Europe (None-EU)");
        c1.setResidence("Others");
        c1.setDateOfBirth(1995, 5, 8); // Enter in (year, month, date) format!
        c1.setSex("Male");
        c1.setCreationDate();
        System.out.println("Customer profile created on: " + c1.getCreationDate());
        System.out.println(c1.getUserName() + "'s rating: " + c1.getRating());

        System.out.println("====================================================");

        //testing condition 1 in PDF
        Customer c2 = new Customer();
        c2.setID(1001);
        c2.setUserName("Leo Messi");
        c2.setOrigin("EU");
        c2.setResidence("US/CA");
        c2.setDateOfBirth(1987, 10, 9);
        c2.setSex("Male");
        c2.setCreationDate();
        System.out.println("Customer profile created on: " + c2.getCreationDate());
        System.out.println(c2.getUserName() + "'s rating: " + c2.getRating());

        System.out.println("====================================================");

        //testing condition 2 in PDF
        Customer c3 = new Customer();
        c3.setID(1002);
        c3.setUserName("Cristiano Ronaldo");
        c3.setOrigin("EU");
        c3.setResidence("Others");
        c3.setDateOfBirth(1985, 5, 3);
        c3.setSex("Male");
        c3.setCreationDate();
        System.out.println("Customer profile created on: " + c3.getCreationDate());
        System.out.println(c3.getUserName() + "'s rating: " + c3.getRating());

        System.out.println("====================================================");

        //testing condition 9 in PDF
        Customer c4 = new Customer();
        c4.setID(1003);
        c4.setUserName("Pele");
        c4.setOrigin("US/CA");
        c4.setResidence("EU");
        c4.setDateOfBirth(1940, 5, 3);
        c4.setSex("Male");
        c4.setCreationDate();
        System.out.println("Customer profile created on: " + c4.getCreationDate());
        System.out.println(c4.getUserName() + "'s rating: " + c4.getRating());

        System.out.println("====================================================");

        //testing condition 10 in PDF
        Customer c5 = new Customer();
        c5.setID(1004);
        c5.setUserName("Madonna");
        c5.setOrigin("US/CA");
        c5.setResidence("US/CA");
        c5.setDateOfBirth(1935, 6, 4);
        c5.setSex("Female");
        c5.setCreationDate();
        System.out.println("Customer profile created on: " + c5.getCreationDate());
        System.out.println(c5.getUserName() + "'s rating: " + c5.getRating());

        System.out.println("====================================================");

        //testing condition 7 in PDF
        Customer c6 = new Customer();
        c6.setID(1005);
        c6.setUserName("LeBron James");
        c6.setOrigin("Others");
        c6.setResidence("US/CA");
        c6.setDateOfBirth(1984, 9, 10);
        c6.setSex("Male");
        c6.setCreationDate();
        System.out.println("Customer profile created on: " + c6.getCreationDate());
        System.out.println(c6.getUserName() + "'s rating: " + c6.getRating());

        System.out.println("====================================================");

        //testing the last condition in PDF
        Customer c7 = new Customer();
        c7.setID(1006);
        c7.setUserName("Kareem Abdul-Jabbar");
        c7.setOrigin("Others");
        c7.setResidence("Europe (None-EU)");
        c7.setDateOfBirth(1945, 1, 2);
        c7.setSex("Male");
        c7.setCreationDate();
        System.out.println("Customer profile created on: " + c7.getCreationDate());
        System.out.println(c7.getUserName() + "'s rating: " + c7.getRating());

        System.out.println("====================================================");

        //testing condition 3 in PDF
        Customer c8 = new Customer();
        c8.setID(1007);
        c8.setUserName("Michael Jordan");
        c8.setOrigin("US/CA");
        c8.setResidence("EU");
        c8.setDateOfBirth(1975, 2, 3);
        c8.setSex("Male");
        c8.setCreationDate();
        System.out.println("Customer profile created on: " + c8.getCreationDate());
        System.out.println(c8.getUserName() + "'s rating: " + c8.getRating());

        System.out.println("====================================================");

        //testing condition 4 in PDF
        Customer c9 = new Customer();
        c9.setID(1008);
        c9.setUserName("Ronaldinho Gaucho");
        c9.setOrigin("US/CA");
        c9.setResidence("Europe (None-EU)");
        c9.setDateOfBirth(1980, 12, 31);
        c9.setSex("Male");
        c9.setCreationDate();
        System.out.println("Customer profile created on: " + c9.getCreationDate());
        System.out.println(c9.getUserName() + "'s rating: " + c9.getRating());

        System.out.println("====================================================");

        //testing condition 5 in PDF
        Customer c10 = new Customer();
        c10.setID(1009);
        c10.setUserName("Frida Kahlo");
        c10.setOrigin("Europe (None-EU)");
        c10.setResidence("EU");
        c10.setDateOfBirth(1977, 7, 6);
        c10.setSex("Female");
        c10.setCreationDate();
        System.out.println("Customer profile created on: " + c10.getCreationDate());
        System.out.println(c10.getUserName() + "'s rating: " + c10.getRating());

        System.out.println("====================================================");

        //testing condition 8 in PDF/*
        Customer c11 = new Customer();
        c11.setID(1010);
        c11.setUserName("Leonardo Da Vinci");
        c11.setOrigin("Others");
        c11.setResidence("Europe (None-EU)");
        c11.setDateOfBirth(1990, 11, 11);
        c11.setSex("Male");
        c11.setCreationDate();
        System.out.println("Customer profile created on: " + c11.getCreationDate());
        System.out.println(c11.getUserName() + "'s rating: " + c11.getRating());

        System.out.println("====================================================");

        DatabaseStorage dbStorage = new DatabaseStorage(); //if Customer Table gets the customer details successfully!
        try {
            //to store the customer datas in database:
            dbStorage.insertCustomerToDatabase(c1);
            dbStorage.insertCustomerToDatabase(c2);
            dbStorage.insertCustomerToDatabase(c3);
            dbStorage.insertCustomerToDatabase(c4);
            dbStorage.insertCustomerToDatabase(c5);
            dbStorage.insertCustomerToDatabase(c6);
            dbStorage.insertCustomerToDatabase(c7);
            dbStorage.insertCustomerToDatabase(c8);
            dbStorage.insertCustomerToDatabase(c9);
            dbStorage.insertCustomerToDatabase(c10);
            dbStorage.insertCustomerToDatabase(c11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}