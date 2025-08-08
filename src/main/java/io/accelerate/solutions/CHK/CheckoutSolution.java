package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        char[] str = skus.toCharArray() , hash = new char[5];
        int total = 0 ,index;
        int[] values = new int[]{50,30,20,15,40} ;
        int[][] tempLs;
        List<int[][]> deals = new ArrayList<>();
        deals.add(new int[][]{{3,20} , {5,30}});
        deals.add(new int[][]{{2,15}});
        deals.add(new int[][]{{0,0}});
        deals.add(new int[][]{{0,0}});
        deals.add(new int[][]{{0,0}});

        for(char x : str){
            index = x - 'A';
            if(index > 4 || index < 0 ){
                return -1;
            }
            hash[index]++;

            total += values[index];

            tempLs = deals.get(index);

            if(index == 4 && hash[index] % 2 == 0){
                hash[1]++;
            }

            for(int i = tempLs.length - 1; i >= 0 ; i--){
                if(tempLs[i][0] != 0 && hash[index] % tempLs[i][0] == 0){
                    total -= tempLs[i][1];
                    break;
                }
            }

        }


        return total;
    }


}



