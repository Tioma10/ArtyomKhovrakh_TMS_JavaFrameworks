package com.example;

import parser.FileParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileParser parser = new FileParser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 1 — обработать файлы, 2 — показать отчёт:");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            parser.parseFiles();
        } else if (input.equals("2")) {
            parser.printReport();
        } else {
            System.out.println("Неверный ввод.");
        }
    }
}