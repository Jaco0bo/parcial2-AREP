package org.escuelaing.edu.parcial_2.utils;

import java.util.ArrayList;
import java.util.List;

public class mathLogic {
    public static List<String> factores(int n) {
        List<String> answer = new ArrayList<>();
        answer.add("1");
        Integer number = n;
        if (n == 1) {
            return answer;
        }
        System.out.println(answer);

        for (Integer i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                answer.add(i.toString());
            }
            System.out.println(answer);
        }
        answer.add(number.toString());
        return answer;
    }

    public static List<String> primos(int n) {
        List<String> answer = new ArrayList<>();
        Integer number = n;
        for (Integer m = 1; m <= number; m++) {
            if (factores(m).size() == 2) {
                answer.add(m.toString());
            }
        }

        return answer;
    }
}


