package Library;

import java.util.Scanner;

public class Main {

    static Scanner sc;
    static Database database;
    public static void main(String[] args) {

        database = new Database();
        System.out.println("Welcome to Library Management System!");
        int num;
            System.out.println("0. Exit\n"+
                    "1. Login\n" +
                    "2. New User\n");
            sc = new Scanner(System.in);
            num = sc.nextInt();

            switch (num){
                case 1:
                    login(num); break;
                case 2:
                    newUser(); break;
            }
    }


    private static void login(int i) {
        System.out.println("Enter phone number: ");
        String phonenumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        int n = database.login(phonenumber, email);
        if(n != -1){
            User user = database.getUser(n);
            user.menu(database, user);
        }
        else{
            System.out.print("User doesn't exist!");
        }
    }


    private static void newUser() {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter phone number: ");
        String phonenumber = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();

        System.out.println("1. Admin\n2. Reader");
        User user;
        int i = sc.nextInt();

        if (i == 1){
             user = new Admin(name, email, phonenumber);
        }
        else {
            user = new NormalUser(name, email, phonenumber);
        }
        database.AddUser(user);
        user.menu(database, user);
    }


}
