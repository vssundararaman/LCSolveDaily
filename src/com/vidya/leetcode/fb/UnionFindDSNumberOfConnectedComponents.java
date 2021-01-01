package com.vidya.leetcode.fb;

import java.util.HashSet;
import java.util.Set;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Time Complexity : O(N + M*log(N)) With Path Compression
 * M is number of Edges and N is number of Nodes
 * Space complexity: O(N) where N is number of Nodes
 */
public class UnionFindDSNumberOfConnectedComponents {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        System.out.println(connectedComponents(n, edges));
    }

    static int connectedComponents(int n, int[][] edges) {

        int[] ids = new int[n];

        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ids.length; i++) {
            set.add(find(ids[i], ids));
        }

        return set.size();

    }

    static void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    static int find(int edge, int[] ids) {
        if (ids[edge] != edge) {
            ids[edge] = find(ids[edge], ids);
        }
        return ids[edge];
    }
}
