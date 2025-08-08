package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        char[] str = skus.toCharArray() , hash = new char[26];
        int total = 0;

        for(char x : str){
            hash[ x - 'A']++;

        }



    }
}

