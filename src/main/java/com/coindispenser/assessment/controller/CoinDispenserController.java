package com.coindispenser.assessment.controller;

import com.coindispenser.assessment.service.CoinDispenserySevice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

/*
CoinDispenserController Rest controller that contains integer  array coin param
and integer amount param .
and calls coinDispenserySevice.calculateMinCoinsForGivenAmount(coins,amount)
 */
@RestController
@RequestMapping("/api/coindispensery")
public class CoinDispenserController {

    private static final Logger logger = LoggerFactory.getLogger(CoinDispenserController.class);

    @Autowired
    CoinDispenserySevice coinDispenserySevice;

    @ApiOperation(httpMethod = "POST",
            value = "Calculate minimum number of coins needed to give change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Coins Calculated"),
            @ApiResponse(code = 201, message = "Calculated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Technical Error")
    }
    )

    @PostMapping(value = "/calculateMinNumOfCoinForAmount", produces = "application/json")

    public int  calculateMinNumOfCoinForAmount(@RequestParam(name = "coins",value = "coins")  int[] coins,
                                              @RequestParam(name= "amount",value = "amount")  int amount)  {

        logger.trace("Entering class  ========" +getClass().getName());
        logger.trace("Method call:=============coinDispenserySevice.calculateMinCoinsForGivenAmount" );


        /*
           I call coinDispenserySevice.calculateMinCoinsForGivenAmount(coins,amount)
           to calculate minimum number of coins needed to give change to a given amount.
           and return minimum number of coins needed.
         */
        return coinDispenserySevice.calculateMinCoinsForGivenAmount(coins  ,amount);

   }
}

