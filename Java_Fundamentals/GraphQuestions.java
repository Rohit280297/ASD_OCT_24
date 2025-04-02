
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
class Graph{
    int nVertex;
    int[][] graph;

    Graph(int n)
    {
        this.nVertex = n;
        graph = new int[n][n];
    }

    void addEdge(int source, int destination, int weight)
    {
        graph[source][destination] = weight;
        graph[destination][source] = weight; 
    }

    void bfs(){
        boolean[] visited = new boolean[this.nVertex];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty())
        {
            int popped = q.remove();
            if(visited[popped])
                continue;
            visited[popped] = true;
            System.out.print(popped+" ");
            for(int i=0;i<this.nVertex;i++)
            {
                if(graph[popped][i] == 1 && visited[i] == false){
                    // System.out.print("sdjk "+ popped+" "+i);
                    q.add(i);
                }
            }
        }
        System.out.println();
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
            for(int j=0;j<this.nVertex;j++)
            {
                int x = graph[p.index][j]; // weight of edge connecting p and the index j.
                if(x!= 0 && visited[j] == false)
                {
                    if(cost[j] > p.cost + x){
                        cost[j] = p.cost + x;
                        pq.add(new Pair(j, cost[j]));
                    }
                }
            } 
        }
        return cost;
    }

    void minTimeToReceiveAlert(int source, int speed){
        for(int i=0;i<this.nVertex;i++)
        {
            for(int j=0;j<this.nVertex;j++)
            {
                this.graph[i][j] /= (speed * 1.0);
            }
        }

        int[] times = this.dijkstraAlgorithm(source);
        for(int i=0;i<this.nVertex;i++)
        {
            System.out.println(i+" "+times[i]);
        }
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

public class GraphQuestions {
    public static void main(String[] args)
    {
        Graph g = new Graph(5);
        g.addEdge(0, 1,12);
        g.addEdge(0, 2, 8);
        g.addEdge(2, 3,4);
        g.addEdge(1, 3, 17);
        g.addEdge(1, 4, 6);
        g.addEdge(3, 4,2);

        // g.bfs();
        g.minTimeToReceiveAlert(0, 2);

    }
}
