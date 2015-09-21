package com.company;

/**
 * Created by user on 19.09.2015.
 */
public class Test {
    public static void main(String[] args){
        FileManage  fileManage = new FileManage();

        String comm;
        /*
        String command = " ls  c:\\";
        comm = fileManage.splitArg(command,1);

            System.out.println(comm);
        */
        String input = " cd c:\\1";
        String splitArg = fileManage.splitArg(input, 1);

        comm = fileManage.changeDir(splitArg);

        System.out.println(comm);

        input = "ls";
        System.out.println(input);
        splitArg = fileManage.splitArg(input, 1);

        comm = fileManage.listDir(splitArg);

        System.out.println(comm);

        input = "make c:\\2\\2";
        System.out.println(input);
        splitArg = fileManage.splitArg(input, 1);

        comm = fileManage.makeFile(splitArg);

        System.out.println(comm);

        input = "dir c:\\2";
        System.out.println(input);
        splitArg = fileManage.splitArg(input, 1);

        comm = fileManage.changeDir(splitArg);

        System.out.println(comm);
/*
        input = "delete 2";
        System.out.println(input);
        splitArg = fileManage.splitArg(input, 1);

        comm = fileManage.deleteFile(splitArg);

        System.out.println(comm);
*/
        input = "move 3 c:\\4\\4";
        System.out.println(input);

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
        comm = fileManage.moveFile(sourceFile,destinationFile);

        System.out.println(comm);
        //System.out.println(fileManage.listDir("c:\\"));
    }
}
