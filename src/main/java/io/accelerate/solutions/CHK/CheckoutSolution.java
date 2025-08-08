package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.*;

public class CheckoutSolution {

    public static void main(String[] args){
        System.out.println(checkout("EEBB"));
    }
    public static Integer checkout(String skus) {
        char[] str = skus.toCharArray() ;
        int total = 0 ,index , discount = 0;
        int[] values = new int[]{50,30,20,15,40}, hash = new int[5] ;
        int[][] tempLs;
        List<int[][]> deals = new ArrayList<>();
        deals.add(new int[][]{{3,20} , {5,50}});
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



        }

        for(int i = 0 ; i < hash.length ; i++){
            tempLs = deals.get(i);
            if(i == 4){
                int mul = hash[4] / 2;
                System.out.println(Arrays.toString(hash));
                discount += (hash[1] - Math.max(hash[1] - mul, 0)) * values[1] ;
                continue;
            }

            if(tempLs[0][0] == 0){
                continue;
            }

            for(int j = tempLs.length -1 ; j >= 0; j -- ){
                int mul = hash[i] / tempLs[j][0];
                discount += mul * tempLs[j][1];
                hash[i] -= mul*tempLs[j][0];
            }
        }


        return total - discount;
    }


}

