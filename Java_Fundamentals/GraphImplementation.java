import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


class Node{
    int index;
    ArrayList<Node> adjacentNodes;
    ArrayList<Edge>  edges;

    Node(int index)
    {
        this.index = index;
        adjacentNodes = new ArrayList<>();
    }
}


class EdgeComparator implements Comparator<Edge>{

    public int compare(Edge e1, Edge e2)
    {
        return e1.weight - e2.weight;
    }
}

class Edge{

    int source;
    int destination;
    int weight;
    boolean isDirected;

    // for undirected, unweighted graph.
    Edge(int source, int destination)
    {
        this.source = source;
        this.destination = destination;
        this.weight = 0;
        this.isDirected = false;
    }

    // for undirected, weighted graph.
    Edge(int source, int destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.isDirected = false;
    }
}

class DisjointSet
{
    int[] parent;
    DisjointSet(int nodes)
    {
        parent = new int[nodes];
        for(int i=0;i<nodes;i++)
            parent[i] = i;
    }

    int find(int x)
    {
        if(parent[x] == x)
            return x;
        
        int px = parent[x];
        return find(px);
    }

    void union(int x, int y)
    {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
    }
}

class Graph{
    ArrayList<Node> graph;
    int nVertex;
    ArrayList<Edge> edges;
    DisjointSet ds;
    ArrayList<Edge> mst;

    Graph(){
        graph = new ArrayList<Node>();
        nVertex = 0;
        edges = new ArrayList<>();
        mst = new ArrayList<>();
    }

    void buildDisjointSet(){
        ds = new DisjointSet(this.nVertex);
        for(Edge e : this.edges){
            if(ds.find(e.destination) != ds.find(e.source)){
                ds.union(e.source, e.destination);
            }
        }
    }

    void addVertex(){
        graph.add(new Node(graph.size()));
        this.nVertex++;
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

    void addEdge(int source, int destination, int weight)
    {
        if(source < graph.size() && destination < graph.size())
        {
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);
            sourceNode.adjacentNodes.add(destinationNode);
            destinationNode.adjacentNodes.add(sourceNode);
            this.edges.add(new Edge(source, destination, weight));
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

    // using kruskal's algorithm.
    int minimumSpanningTree(){
        int minimumCost = 0;
        ds = new DisjointSet(this.nVertex);
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        pq.addAll(this.edges);
        int count = 0;
        while(count < this.nVertex - 1)
        {
            if(pq.isEmpty())
            {
                this.mst.clear();
                return -1;
            }
            Edge poppedEdge = pq.remove();
            if(ds.find(poppedEdge.source) != ds.find(poppedEdge.destination)){
                minimumCost += poppedEdge.weight;
                mst.add(poppedEdge);
                count++;
                ds.union(poppedEdge.source,poppedEdge.destination);
            }

        }
        return minimumCost;
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
        g.addEdge(0,1,3);
        g.addEdge(0,2,6);
        g.addEdge(2,4,8);
        g.addEdge(1,3,2);
        g.addEdge(1,2,9);
        g.addEdge(2,4,12);
        g.addEdge(0,4,5);
        // g.buildDisjointSet();
        // System.out.println(g.ds.find(0));
        // System.out.println(g.ds.find(1));
        System.out.println(g.minimumSpanningTree());

    }
}
