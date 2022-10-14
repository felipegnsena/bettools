package com.example.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CombinacaoLinear {

    int positions;
    List<Integer> possibilities;

    //List<Integer> l = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    //printCombinations(l, 2);

    private List<List<Integer>> combinations(List<Integer> list, int maxLength) {
        return combinations(list, maxLength, new ArrayList(), new ArrayList());
    }

    private List<List<Integer>> combinations(List<Integer> list, int length, List<Integer> current, List<List<Integer>> result) {
        if (length == 0) {
            List<List<Integer>> newResult =  new ArrayList<>(result);
            newResult.add(current);
            return newResult;
        }

        List<List<List<Integer>>> res3 = new ArrayList<>();
        for (Integer i : list) {
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(i);
            res3.add(combinations(list, length - 1, newCurrent, result));
        }

        List<List<Integer>> res2 = new ArrayList<>();
        for (List<List<Integer>> lst : res3) {
            res2.addAll(lst);
        }
        return res2;
    }

    public String getcombinations() {
        StringBuilder combinations = new StringBuilder();
        List<List<Integer>> combs = combinations(possibilities, positions);
        for (List<Integer> lst : combs) {
            String line = "";
            for (Integer i : lst) {
                line += i;
            }
            combinations.append(line+" - ");
        }
        return combinations.toString();
    }

    public Integer getNumberOfcombinations() {
        List<List<Integer>> combs = combinations(possibilities, positions);
        return combs.size();
    }


}
