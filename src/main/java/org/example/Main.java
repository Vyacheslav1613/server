package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket("netology.homework", Server.LOCALHOST_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Введите ваше имя:  ");
            String name = scan.nextLine();
            writer.println(name);
            System.out.println(reader.readLine());

            System.out.print("Сколько вам лет? ");
            int age = Integer.parseInt(scan.nextLine());
            writer.println(age);
            System.out.println(reader.readLine());
           if (age >= 18 && age <= 21){
               System.out.println("Ты еще учишься? ");
               String studies = scan.nextLine();
               writer.println(studies);
               System.out.println(reader.readLine());
           }
           else if (age > 21){
               System.out.println("Ты уже нашел работу?");
               String work = scan.nextLine();
               writer.println(work);
               System.out.println(reader.readLine());
           }
        }
    }
}