package Library;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    static Scanner sc;
    static Database database;
    public static void main(String[] args) {

        database = new Database();
        System.out.println("Welcome to LMS!");
        int num;
        do{

            System.out.println("0. Exit\n"+
                    "1. Login\n" +
                    "2. New User\n");
            sc = new Scanner(System.in);
            num = sc.nextInt();

            switch (num){
//                case 0:
//                    System.exit(0);
                case 1:
                    login(); break;
                case 2:
                    newUser(); break;
            }
        }
        while(num != 0);

    }

    private static void newUser() {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter phone number: ");
        String phonenumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();

        System.out.println("1. Admin\n2.Reader");
        int i = sc.nextInt();
        User user;
        if (i == 1){
             user = new Admin(name, email, phonenumber);
        }
        else{
             user = new NormalUser(name, email, phonenumber);
        }
        database.AddUser(user);
        user.menu();

        System.out.println("User created successfully! ");
    }

    private static void login() {
        System.out.println("Enter phone number: ");
        String phonenumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        int n = database.login(phonenumber, email);
        if(n != -1){
            User user = database.getUser(n);
            user.menu();
            System.out.println("Welcome " + user.getName());
        }
        else{
            System.out.print("User doesn't exist!");
        }
    }


}
