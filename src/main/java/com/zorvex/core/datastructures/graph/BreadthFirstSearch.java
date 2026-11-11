package com.zorvex.core.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created By : somendra Created On : 26-09-2026 Year       : 2026 Package    : com.zorvex.core.datastructures.graph
 * Project    : core-java-learning
 */
public class BreadthFirstSearch {

  /**
   * choose a source node , in this case its 1
   * put it in a queue data structure
   * mark it as visited in the visited array
   * while the queue is not empty
   * pop the source node
   * find its neighbours
   * iterate over the neighbours and check if they are present in the visited array
   * if they are not present in the visited array
   * mart them as visited in the visited array
   * add them to the queue
   *
   * @param graph
   */
  public static List<Integer> bfs(Map<Integer, List<Integer>> graph){
    Set<Integer> visited = new HashSet<>();
    Integer sourceKey = 5;
    List<Integer> result = new ArrayList<>();

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(sourceKey);
    visited.add(sourceKey);

    while(!queue.isEmpty()) {
      Integer polledKey = queue.poll();
      result.add(polledKey);
      List<Integer> nbrs = graph.getOrDefault(polledKey, List.of());
      for (Integer nbr : nbrs){
        if (visited.add(nbr)){
          queue.offer(nbr);
        }
      }
    }
    return result;
  }
}
