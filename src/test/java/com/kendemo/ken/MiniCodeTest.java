package com.kendemo.ken;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MiniCodeTest {

    @Test
    public void testCode() {
        String[][] base = {
                {},
                {},
                {"A", "B", "C"},
                {"D", "E", "F",},
                {"G", "H", "I"},
                {"J", "K", "L"},
                {"M", "N", "O"},
                {"P", "Q", "R", "S"},
                {"T", "U", "V"},
                {"W", "X", "Y", "Z"},
        };
        int[] inputArr = {23, 45, 89};

        List<List<String>> allList = getAllList(base, inputArr);

        Set<String> set = new TreeSet<>();

        calCombination(allList, 0, new String[allList.size()], set);

        System.out.println(set);
    }

    public static List<List<String>> getAllList(String[][] base, int[] inputArr) {
        List<List<String>> allList = new ArrayList<>();
        for (int input : inputArr) {
            if (input < 0 || input > 99) {
                throw new IllegalArgumentException("The value entered needs to be greater than 0 and less than 99");
            }
            if (input == 0 || input == 1 || input == 11) {
                continue;
            }
            if (input > 10) {
                List<String> bit = new ArrayList<>(Arrays.asList(base[input % 10]));
                List<String> ten = Arrays.asList(base[input / 10]);
                bit.addAll(ten);
                allList.add(bit);
            } else {
                allList.add(Arrays.asList(base[input]));
            }
        }
        return allList;
    }

    public static void calCombination(List<List<String>> allList, int beginIndex, String[] arr, Set<String> set) {
        if (beginIndex == allList.size()) {
            set.add(StringUtils.join(arr).toLowerCase());
            return;
        }
        for (String t : allList.get(beginIndex)) {
            arr[beginIndex] = t;
            calCombination(allList, beginIndex + 1, arr, set);
        }
    }
}
