import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

class Node{
    int index;
    ArrayList<Node> adjacentNodes;
    ArrayList<Edge>  edges;

    Node(int index)
    {
        this.index = index;
        adjacentNodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    int getWeight(int destination)
    {
        for(Edge e : this.edges)
        {
            if(e.destination == destination){
                return e.weight;
            }
        }
        return Integer.MAX_VALUE;
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
            this.edges.add(new Edge(source, destination, 0));
            if(!isDirected){
                destinationNode.adjacentNodes.add(sourceNode);
                this.edges.add(new Edge(destination, source, 0));
            }
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
            Edge newEdge = new Edge(source, destination, weight);
            this.edges.add(newEdge);
            sourceNode.edges.add(newEdge);
            // below line is the old code which is not correct. Since, in the destinationNode, the edge added should be of type (destination, source, weight).
            // However, we were adding edge of type (source, destination, weight) to the destinationNode as well which was the actual problem.
            // Replacing line 148 with line 149 will fix Djikstra's algorithm code without any other changes.
            // destinationNode.edges.add(newEdge);
            destinationNode.edges.add(new Edge(destination, source, weight));
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
    int minimumSpanningTreeUsingKruskal(){
        mst.clear();
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

    int minimumSpanningTreeUsingPrim()
    {
        mst.clear();
        int minimumCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        boolean[] visited = new boolean[this.nVertex];
        for(Edge e : this.graph.get(0).edges)
        {
            pq.add(e);
        }
        visited[0] = true;
        while(!pq.isEmpty())
        {
            Edge e = pq.remove();
            if(visited[e.destination])
                continue;
            
            visited[e.destination] = true;
            mst.add(e);
            minimumCost += e.weight;
            for(Edge newEdge : this.graph.get(e.destination).edges)
            {
                if(visited[newEdge.destination] == false)
                    pq.add(newEdge);
            }
        }

        return minimumCost;
    }

    int[] bellmanFordAlgorithm(int source)
    {
        int[] cost = new int[this.nVertex];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[source] = 0;
        for(int i=0;i<this.nVertex-1;i++)
        {
            for(Edge e : this.edges)
            {
                if(cost[e.destination] > cost[e.source]+e.weight)
                {
                    // relaxation of edges.
                    cost[e.destination] = cost[e.source] + e.weight;
                }
            }
        }

        for(Edge e : this.edges)
        {
            if(cost[e.destination] > cost[e.source]+e.weight)
            {
                // relaxation of edges.
                cost[e.destination] = cost[e.source] + e.weight;
                return new int[0];
            }
        }
        return cost;
    }

    int[] dijkstraAlgorithm(int source){
        int[] cost = new int[this.nVertex];
        Arrays.fill(cost, Integer.MAX_VALUE);
        boolean[] visited = new boolean[this.nVertex];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        cost[source] = 0;
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty())
        {
            Pair p = pq.remove();
            visited[p.index] = true;
            for(Node x : this.graph.get(p.index).adjacentNodes)
            {
                if(visited[x.index] == false)
                {
                    // the pure blunder was not because of Djisktra's algorithm. But the implementation of how the edges were getting added to the node. 
                    // Look at line number 145 for more explanation.
                    if(cost[x.index] > p.cost + this.graph.get(p.index).getWeight(x.index)){
                        cost[x.index] = p.cost + this.graph.get(p.index).getWeight(x.index);
                        pq.add(new Pair(x.index, cost[x.index]));
                    }
                }
            } 
        }
        return cost;
    }

    void applyDfs(int i, boolean[] visited, Stack<Integer> st)
    {
        visited[i] = true;
        for(Node x : this.graph.get(i).adjacentNodes)
        {
            if(visited[x.index] == false)
                applyDfs(x.index, visited, st);
        }
        st.push(i);
    }

    void topologicalSorting()
    {
        boolean[] visited = new boolean[this.nVertex];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<this.nVertex;i++)
        {
            if(visited[i] == false)
                applyDfs(i, visited, st);
        }

        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
        System.out.println();
    }

    void kahnAlgorithm()
    {
        int[] inDegree = new int[this.nVertex];
        Queue<Integer> q = new LinkedList<>();
        for(Edge e : this.edges)
        {
            inDegree[e.destination]++;
        }

        for(int i=0;i<this.nVertex;i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty())
        {
            int pop = q.remove();
            System.out.print(pop+" ");
            for(Node x : this.graph.get(pop).adjacentNodes)
            {
                inDegree[x.index]--;
                if(inDegree[x.index] == 0)
                    q.add(x.index);
            }
        }
        System.out.println();

    }
}

class Pair{
    int index;
    int cost;
    Pair(int index, int cost)
    {
        this.index = index;
        this.cost = cost;
    }
}


class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2)
    {
        return p1.cost - p2.cost;
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
        g.addEdge(0,1,true);
        g.addEdge(1,2,true);
        g.addEdge(3,4,true);
        g.addEdge(3,2,true);
        // g.addEdge(1,2,9);
        // g.addEdge(0,4,5);
        // g.buildDisjointSet();
        // System.out.println(g.ds.find(0));
        // // System.out.println(g.ds.find(1));
        // System.out.println(g.minimumSpanningTreeUsingKruskal());
        // System.out.println(g.minimumSpanningTreeUsingPrim());

        // int[] minCosts = g.dijkstraAlgorithm(0);
        // for(int i=0;i<g.nVertex;i++)
        // {
        //     System.out.println(i+" "+minCosts[i]);
        // }

        // System.out.println("****");
        // int[] minCostsUsingBellmanFord = g.bellmanFordAlgorithm(0);
        // for(int i=0;i<g.nVertex;i++)
        // {
        //     System.out.println(i+" "+minCostsUsingBellmanFord[i]);
        // }

        g.topologicalSorting();
        g.kahnAlgorithm();
    }
}
