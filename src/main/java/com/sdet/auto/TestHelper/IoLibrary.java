package com.sdet.auto.TestHelper;

import java.net.InetAddress;

public class IoLibrary {

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
}
