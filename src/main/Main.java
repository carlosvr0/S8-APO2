package main;

import java.io.IOException;
import java.util.Scanner;

import model.CountryList;

public class Main{

    private static CountryList olympicsInfo;

    public static Scanner LECTOR; 

//C:\Users\USER2\Desktop\countries.txt
    public static void main(String[] args) throws IOException { 
        
        LECTOR = new Scanner(System.in);
        olympicsInfo = new CountryList();
    
        System.out.println("***************************");
	    System.out.println("*      SEGUIMIENTO 8      *");
	    System.out.println("*                         *");
        System.out.println("*       ORDENAMIENTO      *");
	    System.out.println("***************************");
	    System.out.println("");


        System.out.println("Enter the test document path");
        String path = LECTOR.nextLine();
        olympicsInfo.loadData(path);
        System.out.println("");
        
        olympicsInfo.sortMaleMedals();
        print(1);

        olympicsInfo.sortFemaleMedals();
        print(2);

        olympicsInfo.sortByGoldMedals();
        print(3);
    }


    public static void print(int option){
        if(option == 1){
            System.out.println("----- MASCULINO -----");
            
            for(int m = 0; m < olympicsInfo.getListC().size(); m++){
                System.out.println(" " + olympicsInfo.getListC().get(m).toString(1));
            }

            System.out.println("---------------------"); 
            System.out.println("");
        }else if(option == 2){
            System.out.println("----- FEMENINO -----");
            
            for(int m = 0; m < olympicsInfo.getListC().size(); m++){
                System.out.println(" " + olympicsInfo.getListC().get(m).toString(2));
            }

            System.out.println("---------------------");
            System.out.println(""); 
        }else{
            System.out.println("----- COMBINADO -----");
            
            for(int m = 0; m < olympicsInfo.getListC().size(); m++){
                System.out.println(" " + olympicsInfo.getListC().get(m).toString(3));
            }

            System.out.println("---------------------");
            System.out.println(""); 
        }
        
        
    }
}