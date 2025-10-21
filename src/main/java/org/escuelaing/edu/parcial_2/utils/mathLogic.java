package org.escuelaing.edu.parcial_2.utils;

import java.util.ArrayList;
import java.util.List;

public class mathLogic {
    public static List<String> factores(int n) {
        List<String> answer = new ArrayList<>();
        answer.add("1");
        Integer number = n;
        answer.add(number.toString());
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
        return answer;
    }

    /**
    public static List<String> primos(int n) {
        List<String> answer = new ArrayList<>();
        Integer number = n;
        for (Integer m ; m <= number; m++) {
            if (factores(m).size() == 2) {
                answer.add(m.toString());
            }
        }

        return answer;
    }
     **/
}


