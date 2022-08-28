package grokking_algorithms.chapter_8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashSet<String> statesNeeded = new HashSet<>(
                Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        HashMap<String, HashSet<String>> stations = new HashMap<>();
        stations.put("kone", new HashSet<>());
        stations.get("kone").addAll(Arrays.asList("id", "nv", "ut"));

        stations.put("ktwo", new HashSet<>());
        stations.get("ktwo").addAll(Arrays.asList("wa", "id", "mt"));

        stations.put("kthree", new HashSet<>());
        stations.get("kthree").addAll(Arrays.asList("or", "nv", "ca"));

        stations.put("kfour", new HashSet<>());
        stations.get("kfour").addAll(Arrays.asList("nv", "ut"));

        stations.put("kfive", new HashSet<>());
        stations.get("kfive").addAll(Arrays.asList("ca", "az"));

        System.out.println(findBestStations(statesNeeded, stations));
    }

    public static HashSet<String> findBestStations(HashSet<String> statesNeeded,
                                                   HashMap<String, HashSet<String>> stations) {
        HashSet<String> finalStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            HashSet<String> statesCovered = new HashSet<>();

            for (String station :
                    stations.keySet()) {
                HashSet<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(stations.get(station));
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }

            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }

        return finalStations;
    }
}
