package com.ko.playermatch.service;

import com.ko.playermatch.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AlgorithmUtilsTeat {
    
    @Test
    void test() {
        List<String> tagList1 = Arrays.asList("一号位", "外线", "状元");
        List<String> tagList2 = Arrays.asList("一号位", "外线", "榜眼");
        List<String> tagList3 = Arrays.asList("三号位", "内线", "榜眼");

        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }
}
