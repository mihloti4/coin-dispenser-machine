package com.coindispenser.assessment.service;

import com.coindispenser.assessment.repository.CoinDispenseryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/*
 *CoinDispenserySevice calculate minimum number of coins needed to make change for a give amount.
 *It contains a method called calculateMinCoinsForGivenAmount that takes two parameters coins and amount.
 *Note, this assumes an infinite amount of each denomination is available.
 *The solution uses dynamic programming botton up approach.
 * Check if coins param is not null or array length is 0 then throw new IllegalArgumentException.
 *  Check if amount is zero(0) then throw new IllegalArgumentException.
 *
 * @author : Mihloti Rose
 *
 */
@Service
public class CoinDispenserySevice implements CoinDispenseryInterface {

   private static final  Logger logger = LoggerFactory.getLogger(CoinDispenserySevice.class);

    @Override
    public int calculateMinCoinsForGivenAmount(int[] coins, int amount) {

        logger.trace("calculateMinCoinsForGivenAmount method******INPUTS******:" +Arrays.toString(coins) +"&&" +amount);


       //   create dp array  of int type and give it a size of a given amount + 1.
        int[] dp = new int[amount +1];

        //fill dp array with amount given.
        Arrays.fill(dp, amount);

        //initialize dp array element [0]  with zero(0)
        dp[0] = 0;

        /*
           Check if param coins is null or coins length is zero(0) or if coins param contains zero(0) in any of its elements then
           throw new IllegalArgumentException with a string message.
           Check if param amount is zero(0) then throw new IllegalArgumentException with a string message.
         */
        if (coins == null) throw new IllegalArgumentException("COINS ARRAY IS NULL");
        if (coins.length == 0) throw new IllegalArgumentException("NO COINS VALUES ");
        if(amount  == 0)throw new IllegalArgumentException("AMOUNT CANNOT BE ZERO(O)");
        for (int i = 0; i<coins.length; i++){
            if(coins[i] == 0){
                throw new IllegalArgumentException("NO COINS VALUES!!!!! ");
            }
        }
        try{

            // outer for loop for each coin given .
            for (int coin: coins) {

                /*
                inner for loop.
                iterate through the dp[] array  starting from a given coin .
                 */
                for(int i = coin; i <= amount; i++){


                   // Update dp[] array value with a minimum of dp[i] or dp[i -coin] + 1

                    dp[i] = Math.min(dp[i], dp[i - coin] +1);
                }

            }
        }catch (Exception e) {
            logger.error("something went wrong while calculating minimum number of coins required for a given amount ");
        }

        // Return minimum number of coins needed.
        logger.trace("MINIMUM NUMBER OF COINS NEEDED : **********"+(dp[amount]));
        return dp[amount] ;

    }
}
