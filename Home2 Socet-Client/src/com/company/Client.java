package com.company;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;


public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 4040);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        PrintStream writer = new PrintStream(os, true);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));

        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true){
            String input = consoleReader.readLine();
            System.out.println("Enter");
            System.out.println("input message " + input);
            writer.println(input);
            writer.flush();

            if("exit".equals(input)){
                break;
            }

            String output;
            System.out.println("output message ");
            output = reader.readLine();
            System.out.println(output);
            while (reader.ready()) {
                output = reader.readLine();
                System.out.println(output);
            }

        }
        socket.close();
    }
}