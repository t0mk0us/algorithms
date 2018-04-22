package com.bank.model;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        
        int[] result = new int[2];
            
            for(int i = 0; i < list.length; i++){
                
                for(int j = 0; j < list.length; j++){
                    if (i !=j && list[i]+list[j] == sum){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
                    
            }
                        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
