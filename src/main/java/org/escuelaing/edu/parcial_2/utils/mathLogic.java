package org.escuelaing.edu.parcial_2.utils;

import java.util.ArrayList;
import java.util.List;

public class mathLogic {
    public static List<String> factores(int n) {
        List<String> answer = new ArrayList<>();
        Integer a = 1;
        Integer b = 1;
        answer.add(a.toString());
        answer.add(b.toString());
        if (n == 1) {
            answer.remove(1);
            return answer;
        }
        System.out.println(answer);

        for (int i = 3; i <= n; i++) {
            System.out.println(a);
            System.out.println(b);
            Integer c = a + b;
            System.out.println(c);
            answer.add(c.toString());
            System.out.println(answer);
            a = b;
            b = c;
        }
        return answer;
    }
}
