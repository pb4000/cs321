package com.project1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user;
        Cache c = new Cache(10);
        while (true) {
            System.out.println("Enter a command:");
            user = input.next();
            user = Character.toString(user.charAt(0));
            switch (user) {
                case "q":
                    return;
                case "0":
                    c.write(0);
                    break;
                case "r":
                    c.remove();
                    break;
                case "s":
                    c.search("i");
                    break;
                case "`":
                    start();
                    break;
                default:
                    c.addToTop(user);
                    break;
            }
            System.out.println(c.toString());
        }
    }

    public static void start() {

    }
}
