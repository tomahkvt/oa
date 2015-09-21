package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4040);
        FileManage  fileManage = new FileManage();
        String splitArg;
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Server accept connection");
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));

            PrintStream writer = new PrintStream(os, true);

            while (true) {
                String input = reader.readLine();

                System.out.println("input " + input);

                if("exit".equals(input)){
                    break;
                }

                if (input.startsWith("ls")){
                    splitArg = fileManage.splitArg(input,1);
                    input = fileManage.listDir(splitArg);
                }

                if (input.startsWith("cd")){
                    splitArg = fileManage.splitArg(input,1);
                    input = fileManage.changeDir(splitArg);
                }

                if (input.startsWith("create")){
                    splitArg = fileManage.splitArg(input,1);
                    input = fileManage.makeFile(splitArg);
                }

                if (input.startsWith("delete")){
                    splitArg = fileManage.splitArg(input,1);
                    input = fileManage.makeFile(splitArg);
                }

                if (input.startsWith("move")){
                    String sourceFile = fileManage.splitArg(input, 1);
                    String destinationFile = fileManage.splitArg(input, 2);
                    if (sourceFile.isEmpty()){
                        System.out.println("Enter name Source File");
                        return;
                    }
                    if(destinationFile.isEmpty()){
                        System.out.println("Enter name Destination File");
                        return;
                    }
                    input = fileManage.moveFile(sourceFile, destinationFile);
                }

                System.out.println("send " + input);
                input = input + "\nUse command: ls cd create delete move \n";
                writer.println(input);
                writer.flush();
            }
            System.out.println("Closs connection");
        }
    }

}