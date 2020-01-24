package com.sdet.auto.TestHelper;

import java.io.File;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IoLibrary {

    private static String _testName;

    public static String getTestName(){
        return _testName;
    }

    public static void setTestName(String testName){
        _testName = testName;
    }

    public static void writeLine(String text){
        System.out.println(" ");
        System.out.println(String.format("### %s ###", text));
    }

    public static void writelineEnd() {
        System.out.println(("############"));
        System.out.println(" ");
    }

    public static String getUserName(){
        String returnVal = "";
        InetAddress localMachine = null;
        System.getProperty("user.name");
        try{
            localMachine = java.net.InetAddress.getLocalHost();
            returnVal = localMachine.getHostName();
        } catch(Exception ex){
            System.out.println("Not able to retrieve Hostname of local machine");
            returnVal = "userNameNotFound";
        }
        return returnVal;
    }

    public static String getUniqueIdentifier(){
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        return(dateFormat.format(date));
    }

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getDirPath(){
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String absolutePath = currentDirectory.getAbsolutePath();
        return absolutePath.substring(0, absolutePath.length() - 2);
    }
}
