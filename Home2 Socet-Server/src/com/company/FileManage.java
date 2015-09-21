package com.company;

import java.io.File;
import java.io.IOException;

public class FileManage {
    private String currentDir;
    FileManage(){
        currentDir = System.getProperty("user.dir");
    }
    public String convertToAbsolutPath(String path){
        CharSequence cs1 = "\\";
        if (path.contains(cs1) ){ //The filename contains path
            return path;

        }else{
            return currentDir + "\\" + path;

        }
    }
    public String splitArg(String arg, int position){
        arg = arg.trim();
        String[] commandArg = arg.split(" +");
        String out = "";
        try{
            out = commandArg[position];

        }catch(ArrayIndexOutOfBoundsException ex){
            return out;
        }

        return out;
    }

    public String listDir(String dir){
        StringBuilder out = new StringBuilder();
        File folder;
        if (dir.isEmpty()) {
            folder = new File(currentDir);
        }else{
           folder = new File(dir);
        }

        if(!folder.exists()){
            return "Directory "+ folder +" is not exists";

        }
        out.append(folder + "\n");
        out.append(".\n");
        for (File fileEntry: folder.listFiles()){
            out.append(fileEntry.getName() + "\n");
        }
        return out.toString();
    }


    public String changeDir(String dir) {
        StringBuilder out = new StringBuilder();
        File folder;
        if (dir.isEmpty()) {
            out.append("Please enter directory\n");
            return out.toString();
        }
        folder = new File(dir);
        if(!folder.exists()){
            out.append("Directory "+ dir +" is not exists\n");
            out.append("Current Directory is "+ currentDir + "\n");
            return out.toString();
        }else{
            currentDir = dir;
            out.append("Current Directory is "+ currentDir + "\n");
            return out.toString();
        }



    }

    public String makeFile(String fileName) {
        StringBuilder out = new StringBuilder();
        File folder;
        CharSequence cs1 = "\\";

        if (fileName.isEmpty()) {// parameter is not specified
            out.append("Please enter file name\n");
            return out.toString();
        }

        if (fileName.contains(cs1) ){ //The filename contains path
            File f;
            f = new File(fileName);
            try {
            f.getParentFile().mkdirs();
                f.createNewFile();
                System.out.println("1");
                out.append("File "+f.getAbsoluteFile() + " created \n");
                return out.toString();
            } catch (IOException e) {
                e.printStackTrace();
                out.append("Error file creation "+f.getAbsoluteFile() + " \n");
                return out.toString();
            }
        }else{
        folder = new File(currentDir + "\\" + fileName);
            try {
                folder.createNewFile();
                out.append("File "+folder.getAbsoluteFile() + " created \n");
                return out.toString();
            } catch (IOException e) {
                e.printStackTrace();
                out.append("Error file creation "+folder.getAbsoluteFile() + " \n");
                return out.toString();
            }
        }



    }

    public String deleteFile(String fileName) {
        StringBuilder out = new StringBuilder();
        File folder;


        if (fileName.isEmpty()) {// parameter is not specified
            out.append("Please enter file name\n");
            return out.toString();
        }
        folder = new File(convertToAbsolutPath(fileName));

        if(!folder.isFile()){
            out.append(folder.getAbsoluteFile() + "This not is file \n");
            return out.toString();
        }

        if(folder.delete()){
            out.append(folder.getAbsoluteFile() + " is deleted!");
        }else{
            out.append(folder.getAbsoluteFile() + "Delete operation is failed.");
        }

        return out.toString();

    }

    public String moveFile(String sourceName, String destinationName) {
        StringBuilder out = new StringBuilder();
        sourceName = convertToAbsolutPath(sourceName);
        destinationName = convertToAbsolutPath(destinationName);
        File sourceFile = new File(sourceName);
        File destinationFile = new File(destinationName);
        if (!sourceFile.exists()){
            out.append("This is in not exists " + sourceFile.getAbsoluteFile() + "\n");
            return out.toString();
        }
        if (!sourceFile.isFile()){
            out.append("This is in not file " + sourceFile.getAbsoluteFile() +"\n");
            return out.toString();
        }
        destinationFile.getParentFile().mkdirs();
        if (sourceFile.renameTo(new File(destinationName))){
            out.append("Renamed\n");
            out.append("Source file " + sourceName + "\n");
            out.append("Destination file " + destinationName + "\n");
        }else{
            out.append("Cant be renamed\n");
            out.append("Source file " + sourceName + "\n");
            out.append("Destination file " + destinationName + "\n");
        }
        return out.toString();
    }
}
