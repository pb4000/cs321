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
            switch (user) {
                case "quit":
                    return;
                case "0":
                    c.write(0);
                    break;
                case "r":
                    c.remove();
                    break;
                default:
                    c.add(user);
                    break;
            }
            System.out.println(c.toString());
        }
    }
}
