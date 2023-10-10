package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer LOCALHOST_PORT = 8880;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)){
            System.out.println("Server started");
            while (true){
                try (Socket socket  = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    System.out.println("New connection accepted");

                    String name = in.readLine();
                    out.println("Привет, " + name + "!");

                    int age = Integer.parseInt(in.readLine());
                    if (age < 18){
                        out.println(name + ", давай поиграем");
                    } else if (age >= 18 && age <= 21){
                        out.println("Это хороший возраст. ");
                        String studies = in.readLine();
                        if (studies.equalsIgnoreCase("да")) {
                            out.println("Хорошей учебы");
                        } else {
                            out.println("Надеюсь ты уже полуил все необходимые знания");
                        }
                    } else {
                        out.println("Ты уже достаточно взрослый. ");
                        String work = in.readLine();
                        if (work.equalsIgnoreCase("да")){
                            out.println("Я надеюсь, тебе нравится твоя работа");
                        } else {
                            out.println("Удачных поисков!");
                        }
                    }
                }
            }
        }
    }
}