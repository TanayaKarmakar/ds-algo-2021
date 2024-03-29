package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class CloneGraphLeetcode133 {
  static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  private static Node cloneGraph(Node node) {
    if(node == null)
      return null;
    Map<Node, Node> nodeMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    populateMap(node, nodeMap, visited);
    visited.clear();
    connectLink(node, nodeMap, visited);
    return nodeMap.get(node);
  }

  private static void connectLink(Node node, Map<Node, Node> nodeMap, Set<Integer> visited) {
    List<Node> neighbors = node.neighbors;
    visited.add(node.val);

    for(Node nei: neighbors) {
      nodeMap.get(node).neighbors.add(nodeMap.get(nei));
    }

    for(Node nei: neighbors) {
      if(!visited.contains(nei.val)) {
        connectLink(nei, nodeMap, visited);
      }
    }
  }

  private static void populateMap(Node node, Map<Node, Node> nodeMap, Set<Integer> visited) {
    visited.add(node.val);
    nodeMap.put(node, new Node(node.val));
    List<Node> neighbors = node.neighbors;
    if(!neighbors.isEmpty()) {
      for(Node nei: neighbors) {
        if(!visited.contains(nei.val)) {
          populateMap(nei, nodeMap, visited);
        }
      }
    }
  }


  public static void main(String[] args) {

  }
}
