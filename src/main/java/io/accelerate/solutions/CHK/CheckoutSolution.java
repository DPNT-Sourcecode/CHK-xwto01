package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.*;

public class CheckoutSolution {

    public static void main(String[] args){
        System.out.println(checkout("AAABB"));
    }
    public static Integer checkout(String skus) {
        char[] str = skus.toCharArray() ;
        int total = 0 ,index , discount = 0;
        int[] values = new int[]{50,30,20,15,40,10,20,10,35,60,80,90,15,40,10,50,30,50,30,20,40,50,20,90,10,50},
                hash = new int[26] ;
        int[][] tempLs;
        Map<Integer,int[][]> deals = new HashMap<>();
        deals.put((int) 'A' - 'A',new int[][]{{3,20} , {5,50}});
        deals.put((int) 'B' - 'A',new int[][]{{2,15}});
        deals.put((int) 'H' - 'A',new int[][]{{5,5},{10,20}});
        deals.put((int) 'K' - 'A',new int[][]{{2,10}});
        deals.put((int) 'P' - 'A',new int[][]{{5,50}});
        deals.put((int) 'Q' - 'A',new int[][]{{3,10}});
        deals.put((int) 'V' - 'A',new int[][]{{2,10}, {3,20}});

        for(char x : str){
            index = x - 'A';
            if(index > 25 || index < 0 ){
                return -1;
            }
            hash[index]++;

            total += values[index];

        }

        for(int i = hash.length - 1; i >= 0 ; i--){

            if(i == 4){
                int mul = hash[4] / 2;
                System.out.println(Arrays.toString(hash));
                int num = Math.max(hash[1] - mul, 0);
                discount += (hash[1] - num) * values[1] ;
                hash[1] = num;
                continue;
            }

            if(i == 5){
                int mul = hash[5] / 3;
                discount += mul * values[5] ;
                hash[5] -= mul;
                continue;
            }

            if(i == 13){
                int mul = hash[13] / 3;
                int num = Math.max(hash[12] - mul, 0);
                discount += (hash[12] - num) * values[12] ;
                hash[12] = num;
                continue;
            }

            if(i == 17){
                int mul = hash[17] / 3;
                int num = Math.max(hash[16] - mul, 0);
                discount += (hash[16] - num) * values[16] ;
                hash[16] = num;
                continue;
            }

            if(i == 20){
                int mul = hash[20] / 3;
                int num = Math.max(hash[19] - mul, 0);
                discount += (hash[19] - num) * values[19] ;
                hash[19] = num;
                continue;
            }



            if(!deals.containsKey(i)){
                continue;
            }

            tempLs = deals.get(i);

            for(int j = tempLs.length -1 ; j >= 0; j -- ){
                int mul = hash[i] / tempLs[j][0];
                discount += mul * tempLs[j][1];
                hash[i] -= mul*tempLs[j][0];
            }
        }


        return total - discount;
    }


}

