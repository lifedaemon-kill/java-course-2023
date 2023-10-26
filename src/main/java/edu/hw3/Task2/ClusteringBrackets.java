package edu.hw3.Task2;

import java.util.ArrayList;

public final class ClusteringBrackets {
    private ClusteringBrackets() {
    }

    public static ArrayList<String> clusterize(String line) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();

        int left = 0;
        int right = 0;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);

            if (symbol == '(') {
                left++;
                cluster.append(symbol);

            } else if (symbol == ')' && left > right) {
                right++;
                cluster.append(symbol);

                if (left == right) {
                    result.add(cluster.toString());
                    cluster = new StringBuilder();
                    left = 0;
                    right = 0;
                }
            }
        }

        return result;
    }
}
