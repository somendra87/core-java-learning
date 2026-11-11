package com.zorvex.core.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By : somendra Created On : 26-09-2026 Year       : 2026 Package    : com.zorvex.core.datastructures.graph
 * Project    : core-java-learning
 */

public class Graph {

  public Map<Integer, List<Integer>> buildUndirected(List<List<Integer>> edgeList) {

    Map<Integer, List<Integer>> adj = new HashMap<>();

    for (List<Integer> edge : edgeList) {
      Integer u = edge.getFirst();
      Integer v = edge.get(1);
      //populateGraph(adj, u, v);
      List<Integer> nu = adj.computeIfAbsent(u, k -> new ArrayList<>());
      if (!nu.contains(v)) {
        nu.add(v);
      }
      List<Integer> nv = adj.computeIfAbsent(v, k -> new ArrayList<>());
      if (!nv.contains(u)) {
        nv.add(u);
      }
    }
    return adj;
  }



  private static void populateGraph(Map<Integer, List<Integer>> adj, Integer u, Integer v) {
    if (!adj.containsKey(u)) {
      adj.put(u, new ArrayList<>());
    }
    adj.get(u).add(v);

    if (!adj.containsKey(v)) {
      adj.put(v, new ArrayList<>());
    }
    adj.get(v).add(u);
  }

}
