import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Node{
    int index;
    ArrayList<Node> adjacentNodes;

    Node(int index)
    {
        this.index = index;
        adjacentNodes = new ArrayList<>();
    }
}

class Graph{
    ArrayList<Node> graph;
    int nVertex;

    Graph(){
        graph = new ArrayList<Node>();
        nVertex = 0;
    }

    void addVertex(){
        graph.add(new Node(graph.size()));
    }

    void addEdge(int source, int destination, boolean isDirected)
    {
        if(source < graph.size() && destination < graph.size())
        {
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);
            sourceNode.adjacentNodes.add(destinationNode);
            if(!isDirected)
                destinationNode.adjacentNodes.add(sourceNode);
        }
    }

    void bfs(int source, boolean[] visited)
    {
        // boolean[] visited = new boolean[this.graph.size()];
        Queue<Node> q = new LinkedList<>();

        q.add(this.graph.get(source));
        while(!q.isEmpty())
        {
            Node popped = q.remove();
            if(visited[popped.index] == false){
                System.out.print(popped.index+" ");
                visited[popped.index] = true;
                for(Node n : popped.adjacentNodes)
                {
                    if(visited[n.index] == false)
                    {
                        q.add(n);
                    }
                }
            }
        }
        System.out.println();
    }

    void dfs(int source, boolean[] visited)
    {
        // boolean[] visited = new boolean[this.graph.size()];
        Stack<Node> st = new Stack<>();
        st.push(this.graph.get(source));
        while(!st.isEmpty())
        {
            Node popped = st.pop();
            if(visited[popped.index] == false)
            {
                System.out.print(popped.index+" ");
                visited[popped.index] = true;
                for(Node n : popped.adjacentNodes){
                    if(visited[n.index] == false){
                        st.push(n);
                    }
                }
            }
        }
        System.out.println();
    }

    void bfsForDisconnectedGraph()
    {
        boolean[] visited = new boolean[this.graph.size()];
        for(int i=0;i<this.graph.size();i++)
        {
            if(visited[i] == false)
                bfs(i,visited);
        }
    }

    boolean hasCycle(Node src, boolean[] visited, int parentIndex, boolean[] inStack){
        
        if(inStack[src.index])
            return true;
        
        visited[src.index] = true;
        inStack[src.index] = true;
        for(Node n : src.adjacentNodes)
        {
            if(!visited[n.index])
            {
                if(hasCycle(n,visited, src.index, inStack))
                    return true;
            }
            // works fine for undirected.
            // else if(n.index != parentIndex){
            //      return true;
            // }

            // but for directed graph, we need to rely on the inStack value.
            if(inStack[n.index])
                return true;
        }

        inStack[src.index] = false;
        return false;
    }

    boolean isCyclePresent()
    {

        boolean[] visited = new boolean[this.graph.size()];
        boolean[] inStack = new boolean[this.graph.size()];

        for(int i=0;i<this.graph.size();i++)
        {
            if(!visited[i])
            {
                if(hasCycle(this.graph.get(i), visited,-1, inStack)){
                    return true;
                }
            }
        }

        return false;
    }
}

public class GraphImplementation {
    public static void main(String[] args)
    {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0,1, false);
        g.addEdge(0,2,false);
        // g.addEdge(1,2,false);
        g.addEdge(2,4, false);
        g.addEdge(1,3, false);
        // boolean[] visited = new boolean[g.graph.size()];
        // g.bfs(0,visited);
        // visited = new boolean[g.graph.size()];
        // g.dfs(0, visited);
        g.bfsForDisconnectedGraph();
        System.out.println(g.isCyclePresent());
    }
}
