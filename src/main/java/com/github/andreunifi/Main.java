package com.github.andreunifi;

import java.util.Random;

public class Main {




    public static void main(String[] args) {
        int finalesums[]=new int[GlobalVariables.NTH];
        int arrayofnumbers[]=new int[GlobalVariables.N];

        //Populates the Array with numbers from 0-100
        for(int i=0; i<GlobalVariables.N;i++){
            arrayofnumbers[i]= new Random().nextInt(GlobalVariables.randomNumbersBound);
            System.out.println(String.valueOf(arrayofnumbers[i]));
        }

        //MultiThreadSum
        multiThreadSum(arrayofnumbers,finalesums);

        //MultiThreadValueSearch
        int value=10;
        multiThreadSearchValue(arrayofnumbers,value);







    }
    public static void multiThreadSum(int numbersToSum[], int finalsums[]){

        //defines a interval of the array for each thread to sum the numbers.
        int maxbound= GlobalVariables.N/GlobalVariables.NTH;
        int min=0;

        //Try/Catch block for InterruptedException
        try {
            for(int i=0;i<GlobalVariables.NTH;i++){
                if(GlobalVariables.N%GlobalVariables.NTH ==0){
                    SumThread sumThread= new SumThread(numbersToSum,min,maxbound);
                    sumThread.start();
                    min+=maxbound;
                    sumThread.join();
                    finalsums[i]=sumThread.getFinalsum();
                    System.out.println("Thread number "+ String.valueOf(i) + " has summed " +  String.valueOf(sumThread.getMaxbound())
                            + " values and the result is: " + String.valueOf(finalsums[i]));

                }else{
                    System.out.println("Each thread should have a even set of numbers to sum");
                }

            }
        }catch (InterruptedException exception){
            exception.printStackTrace();

        }
    }

    public static void multiThreadSearchValue(int numberstosearch[],int value){

        //defines a interval of the array for each thread to sum the numbers.
        int maxbound= GlobalVariables.N/GlobalVariables.NTH;
        int min=0;

        //Try/Catch block for InterruptedException
        try {
            for(int i=0;i<GlobalVariables.NTH;i++){
                if(GlobalVariables.N%GlobalVariables.NTH ==0){
                    SearchThread searchThread= new SearchThread(numberstosearch,value,min,maxbound);
                    searchThread.start();
                    searchThread.join();
                    min+=maxbound;
                    if(searchThread.hasValueBeenFound())
                        System.out.println("The value has been found in thread " + String.valueOf(i) + " at the position(s): " +
                                searchThread.getPositions().toString() + " and was found " + searchThread.getTimesValuesIsFound() + " times");

                }else{
                    System.out.println("Each thread should have a even set of numbers to sum");
                }

            }
        }catch (InterruptedException exception){
            exception.printStackTrace();

        }
    }





}
