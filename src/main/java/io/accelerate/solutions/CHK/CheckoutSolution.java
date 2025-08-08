package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        char[] str = skus.toCharArray() , hash = new char[4];
        int total = 0 ,index;
        int[] values = new int[]{50,30,20,15};
        int[][] deals = new int[][]{{3,20}, {2,15} , {Integer.MAX_VALUE,0}, {Integer.MAX_VALUE,0}};

        for(char x : str){
            index = x - 'A';
            if(index > 3 || index < 0 ){
                return -1;
            }
            hash[index]++;

            total += values[index];

            if(hash[index] % deals[index][0] == 0 ){
                total -= deals[index][1];
            }

        }


        return total;
    }
}
