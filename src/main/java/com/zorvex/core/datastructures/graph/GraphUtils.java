package com.zorvex.core.datastructures.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created By : somendra Created On : 26-09-2026 Year       : 2026 Package    : com.zorvex.core.datastructures.graph
 * Project    : core-java-learning
 */
public class GraphUtils {
  private GraphUtils(){}

  public static void displayGraph(Map<Integer, List<Integer>> graph){
    for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()){
      System.out.println(e.getKey() + " -> " + e.getValue());
    }
  }
}
