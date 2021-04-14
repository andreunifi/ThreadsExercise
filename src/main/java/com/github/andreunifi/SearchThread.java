package com.github.andreunifi;

import java.util.ArrayList;

public class SearchThread extends Thread{
    private int timesValuesIsFound=0;
    private boolean hasValueBeenFound=false;
    private int arrayToSearch[];
    private int searchedValue;
    private int maxbound;
    private int minboud;
    private ArrayList<Integer> positions= new ArrayList<>();

    public SearchThread(int[] arrayToSearch,int valueToSearch,int minboud,int maxbound) {
        this.arrayToSearch = arrayToSearch;
        this.searchedValue=valueToSearch;
        this.minboud=minboud;
        this.maxbound=maxbound;
    }

    public int getMaxbound() {
        return maxbound;
    }

    public int getMinboud() {
        return minboud;
    }

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    @Override
    public void run() {
        for(int i=minboud;i<minboud+maxbound;i++){
            if(this.arrayToSearch[i]==searchedValue){
                timesValuesIsFound++;
                hasValueBeenFound=true;
                positions.add(i);
            }
        }
    }

    public int getTimesValuesIsFound() {
        return timesValuesIsFound;
    }

    public boolean hasValueBeenFound() {
        return hasValueBeenFound;
    }

    public int[] getArrayToSearch() {
        return arrayToSearch;
    }

    public void setArrayToSearch(int[] arrayToSearch) {
        this.arrayToSearch = arrayToSearch;
    }
}
