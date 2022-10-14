package com.example.model.dto;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariableMartingale {

    Double intendedProfit;
    List<Double> oddsSequential;


    public double loseMaximum(){

        double value = 0;
        double stake = intendedProfit;

        if(Objects.isNull(oddsSequential) || oddsSequential.isEmpty()){
            return value;
        }

        for(int i=0;i<oddsSequential.size();i++){
           if(i!=0){
               stake = (intendedProfit+value)/(oddsSequential.get(i)-1);
           }

           value += stake;
        }

        return value;

    }

}
