package com.github.andreunifi;


public class SumThread extends Thread{
    private int finalsum;
    private int[] numberstosum;
    private int maxbound;
    private int minbound;

    public SumThread(int numbersarray[],int min, int max) {
        finalsum=0;
        this.numberstosum=numbersarray;
        this.minbound=min;
        this.maxbound=max;

    }

    public int[] getNumberstosum() {
        return numberstosum;
    }

    public void setNumberstosum(int[] numberstosum) {
        this.numberstosum = numberstosum;
    }

    public int getMaxbound() {
        return maxbound;
    }

    public int getMinbound() {
        return minbound;
    }

    @Override
    public void run() {
        //Method never throws InterruptedException, why?
            for(int i=minbound;i<this.minbound + this.maxbound;i++)
                finalsum+=numberstosum[i];
    }

    public int getFinalsum() {
        return finalsum;
    }

    public void setFinalsum(int finalsum) {
        this.finalsum = finalsum;
    }
}
