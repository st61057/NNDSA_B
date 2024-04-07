package org.example;

import java.io.*;
import java.util.*;

public class Statistics {
    List<Integer> dataList;

    public Statistics(List<Integer> dataList) {
        this.dataList = dataList;
    }

    public Double average() {
        return new Double(((dataList.stream().mapToInt(Integer::intValue).sum()) / dataList.size()));
    }

    public Integer max() {
        return Collections.max(dataList);
    }

    public Integer min() {
        return Collections.min(dataList);
    }

    public List<Integer> modus() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : dataList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                modes.clear();
                modes.add(entry.getKey());
                maxFrequency = frequency;
            } else if (frequency == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }

    public List<Double> cumulative_average() {
        List<Double> current = new ArrayList<>();
        double actualNumber = 0;
        for (int i = 0; i < dataList.size(); i++) {
            actualNumber += dataList.get(i);
            current.add(actualNumber / i);
        }
        return current;
    }
}
