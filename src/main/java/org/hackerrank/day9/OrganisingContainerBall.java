package org.hackerrank.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrganisingContainerBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();

        for (int q = 0; q < queries; q++) {
            int n = sc.nextInt();
            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sc.nextInt());
                }
                container.add(row);
            }

            System.out.println(sol(container));
        }
    }
    static String sol(List<List<Integer>> container){
        int[] capacity=new int[container.size()];
        int[] balls=new int[container.size()];

        for (int i = 0; i < container.size(); i++) {
            List<Integer> row = container.get(i);
            for (int j = 0; j < container.size(); j++) {
                capacity[i] += row.get(j);
                balls[j] += row.get(j);
            }
        }

        Arrays.sort(capacity);
        Arrays.sort(balls);

        for (int i = 0; i < container.size(); i++) {
            if (capacity[i] != balls[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
