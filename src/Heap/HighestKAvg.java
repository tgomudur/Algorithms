package Heap;

import java.util.*;
/**
 * Created by tharun on 1/6/17.
 */
class Result {
    int id;
    int value;

    Result (int id, int value) {
        this.id = id;
        this.value = value;
    }
}

class HighestKAvgSolution {
    public Map<Integer, Double> findHighestKAvg(Result[] results, int k) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> marks;
        for (Result result : results) {
            if (!map.containsKey(result.id)) {
                marks = new PriorityQueue<Integer>(k);
                marks.add(result.value);
                map.put(result.id, marks);
            } else {
                marks = map.get(result.id);
                if (marks.size() < k) marks.offer(result.value);
                else {
                    if (marks.peek() < result.value){
                        marks.remove();
                        marks.offer(result.value);
                    }
                }
            }
        }
        System.out.println(map);
        HashMap<Integer, Double> idMarkMap = new HashMap<>();
        int sum;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            sum = 0;
            marks = entry.getValue();
            for (int i = 0; i < k; i++) {
                sum += marks.poll();
            }
            idMarkMap.put(entry.getKey(), sum/5.0);
        }
        return idMarkMap;
    }
}

public class HighestKAvg {
    public static void main (String[] args) {
        Result[] results = new Result[10];
        for (int i = 0; i < 5; i++) {
            results[i] = new Result(1, i*10);
        }

        for (int i = 0; i < 5; i++) {
            results[5 + i] = new Result(2, i*10);
        }

        HighestKAvgSolution s = new HighestKAvgSolution();
        System.out.println(s.findHighestKAvg(results, 3));

    }
}
