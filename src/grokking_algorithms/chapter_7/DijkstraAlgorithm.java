package grokking_algorithms.chapter_7;

import java.util.ArrayList;
import java.util.HashMap;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        graph.put("start", new HashMap<String, Integer>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.put("a", new HashMap<String, Integer>());
        graph.get("a").put("fin", 1);

        graph.put("b", new HashMap<String, Integer>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);

        graph.put("fin", new HashMap<String, Integer>());


        HashMap<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);

        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        dijkstraAlgorithm(graph, costs, parents);
        System.out.println(costs.get("fin"));
    }

    public static void dijkstraAlgorithm(HashMap<String, HashMap<String, Integer>> graph,
                                         HashMap<String, Integer> costs,
                                         HashMap<String, String> parents) {
        ArrayList<String> processed = new ArrayList<>();
        String node = findLowestCostNode(costs, processed);

        while (node != null) {
            int cost = costs.get(node);
            HashMap<String, Integer> neighbors = graph.get(node);

            for (String neighbor :
                    neighbors.keySet()) {
                int newCost = cost + neighbors.get(neighbor);
                if (costs.get(neighbor) > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, node);
                }
            }

            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }
    }

    private static String findLowestCostNode(HashMap<String, Integer> costs, ArrayList<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (String node :
                costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }
}
