package com.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    private CacheDriver<String> c;
    private Scanner s;

    public static void main(String[] args) {
        Test t = new Test();
        t.start(args);
        return;
        /**Scanner input = new Scanner(System.in);
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
                    t.start(args);
                    break;
                default:
                    c.addToTop(user);
                    break;
            }
            System.out.println(c.toString());
        }*/
    }

    public Test() {

    }

    public void start(String[] args) {
        init(args);
        cycle();
        printCache();
    }

    public void init(String[] args) {
        /**
         * Initializes CacheDriver with args
         */
        if (args.length == 3) {
            try {
                c = new CacheDriver(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            } catch (IllegalArgumentException e) {
                printUsage();
                System.exit(1);
            }
        } else if (args.length == 4) {
            try {
                c = new CacheDriver(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]));
            } catch (IllegalArgumentException e) {
                printUsage();
                System.exit(1);
            }
        }
        /**
         * Get input file
         */
        try {
            s = new Scanner(new File(args[args.length - 1]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            printUsage();
            System.exit(1);
        }
    }

    public void cycle() {
        String temp;
        while (s.hasNext()) {
            temp = s.next();
            c.search(temp);
        }
    }

    public void printCache() {
        System.out.println("\nCache 1:\n" + c.getCache1().toString());
        if (c.getLevel() == 2) {
            System.out.println("\nCache 2:\n" + c.getCache2().toString());
        }
    }

    private static void printUsage() {
        System.out.println("How to use this program:\n" +
                "java Test <1-2 cache levels> <cache1 max length>" +
                " <cache2 max length (optional)> <file>");
    }
}
