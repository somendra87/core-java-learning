package com.zorvex.core.datastructures.graph;

import java.util.List;
import java.util.Map;

/**
 * Created By : somendra Created On : 26-09-2026 Year       : 2026 Package    : com.zorvex.core.datastructures.graph
 * Project    : core-java-learning
 */
public class GraphApplication {

  static List<List<Integer>> edgeList = List.of(
          List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(1, 5),
          List.of(2, 1), List.of(2, 4), List.of(2, 6),
          List.of(3, 1), List.of(3, 4),
          List.of(4, 1), List.of(4, 2), List.of(4, 3), List.of(4, 6),
          List.of(5, 1),
          List.of(6, 2), List.of(6, 4)
  );

  static List<List<Integer>> star = List.of(
          List.of(1, 2),
          List.of(1, 3),
          List.of(1, 4),
          List.of(1, 5)
  );
  public static void main(String[] args) {

    Graph g = new Graph();
    Map<Integer, List<Integer>> graph = g.buildUndirected(star);
/*
    System.out.println("Displaying the graph from edge list using Adjacency list: ");
    System.out.println("-----------------------------------------------------------");
    GraphUtils.displayGraph(graph);
    System.out.println("-----------------------------------------------------------");
*/

    System.out.println("BFS traversal on teh graph:");
    System.out.println("-----------------------------------------------------------");
    System.out.println(BreadthFirstSearch.bfs(graph));
    System.out.println("-----------------------------------------------------------");
  }
}


