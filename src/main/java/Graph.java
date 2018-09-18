package main.java;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    // No. of vertices in graph
    private int v;

    // adjacency list
    private List<Integer> []adjList;

    public Graph(int vertices){
        this.v = vertices;
        initAdjList();
    }

    private void initAdjList()
    {
        adjList = new ArrayList[v];

        for(int i = 0; i < v; i++)
        {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        adjList[u].add(v);
    }

    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(int s, int d, boolean[] isVisited, ArrayList<Integer> pathList) {
        isVisited[s] = true;
        if (s == d)
            printPathList(pathList);

        for (int vertex : adjList[s]) {
            if (!isVisited[vertex]) {
                pathList.add(vertex);
                printAllPathsUtil(vertex, d, isVisited, pathList);
                pathList.remove(vertex);
            }
        }
        isVisited[s] = false;
    }

    private void printPathList(ArrayList<Integer> pathList) {
        for (int vertex : pathList)
            System.out.print(vertex+", ");
        System.out.println("");
    }
}
