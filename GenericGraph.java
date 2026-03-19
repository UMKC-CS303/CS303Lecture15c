import java.util.*;

public class GenericGraph<V> extends AbstractGraph<V> {

    // Graph Attributes
    private final boolean directed;
    private final boolean weighted;

    // Default Constructor
    public GenericGraph(boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
    }

    // Overloaded Constructor
    //PRE:  accepts the settings for directed & weighted
    //      accepts vertice & edge arrays 
    //POST: sets directed & undirected
    //      adds vertices to adjList
    //      adds edges to adjList 
    public GenericGraph(boolean directed, boolean weighted,
            V[] initialVertices, int[][] initialEdges) {
        this.directed = directed;
        this.weighted = weighted;

        // Add vertices
        for (V v : initialVertices) {
            addVertex(v);
        }
        // Add edges
        for (int[] e : initialEdges) {
            if (e.length < 2) {
                throw new IllegalArgumentException("Each edge must have at least from and to indices");
            }

            int fromIndex = e[0];
            int toIndex = e[1];

            V from = initialVertices[fromIndex];
            V to   = initialVertices[toIndex];

            if (weighted) {
                if (e.length != 3) {
                    throw new IllegalArgumentException("Weighted edges must include a weight");
                }
                addEdge(from, to, e[2]);
            } else {
                addEdge(from, to);
            }
        }

    }

    
    // Overloaded Constructor
    //PRE:  accepts the settings for directed & weighted
    //      accepts vertice & edge arrays 
    //POST: sets directed & undirected
    //      adds vertices to adjList
    //      adds edges to adjList 
    public GenericGraph(boolean directed, boolean weighted,
            V[] initialVertices, double[][] initialEdges) {
        this.directed = directed;
        this.weighted = weighted;

        // Add vertices
        for (V v : initialVertices) {
            addVertex(v);
        }
        // Add edges
        for (double[] e : initialEdges) {
            if (e.length < 2) {
                throw new IllegalArgumentException("Each edge must have at least from and to indices");
            }

            int fromIndex = (int) e[0];
            int toIndex = (int)e[1];

            V from = initialVertices[fromIndex];
            V to   = initialVertices[toIndex];

            if (weighted) {
                if (e.length != 3) {
                    throw new IllegalArgumentException("Weighted edges must include a weight");
                }
                addEdge(from, to, e[2]);
            } else {
                addEdge(from, to);
            }
        }

    }
    
    //PRE:  none
    //POST: returns status of directed
    @Override public boolean isDirected() { return directed; }

    //PRE:  none
    //POST: returns status of weighted    
    @Override public boolean isWeighted() { return weighted; }


    //@Override
    //PRE:  accepts from & to vertices
    //POST: both vertices must exist
    //      if edge does not exist, throw illegal arguement
    //      if edge exists, return weight
    public double getWeight(V from, V to) {
        // Works for both weighted + unweighted (unweighted edges will be 1.0)
        requireVertex(from);
        requireVertex(to);

        Double w = adjList.get(from).get(to);
        if (w == null) throw new IllegalArgumentException("Edge not found: " + from + " -> " + to);
        return w;
    }

    //PRE:  none
    //POST: prints all edges for every vertex

    public void printEdges() {
        System.out.println("Graph edges:");
        List<V> verts = vertices(); 

        for (V from : verts) {
            for (Map.Entry<V, Double> toEntry : adjList.get(from).entrySet()) {
                V to = toEntry.getKey();
                double w = toEntry.getValue();

                // Skip mirrored edges in undirected graphs (print one direction only)
                if (!directed && verts.indexOf(from) > verts.indexOf(to)) continue;

                if (weighted) {
                    System.out.println(from + " -> " + to + " (weight " + w + ")");
                } else {
                    System.out.println(from + " -> " + to);
                }
            }
        }
    }

    //PRE:  none
    //POST: prints adjacency list
    public void printAdjacencyList() {
        List<V> verts = vertices();

        for (V v : verts) {
            System.out.print(v + " -> [");

            boolean first = true;

            // if you want neighbors printed in the same order as verts:
            for (V n : verts) {
                if (containsEdge(v, n)) {
                    if (!first) System.out.print(", ");

                    if (weighted) System.out.print(n + "(" + getWeight(v, n) + ")");
                    else System.out.print(n);

                    first = false;
                }
            }
            System.out.println("]");
        }
    }

    //PRE:  Provide the starting vertex
    //POST: verify starting vertex
    //      return a list containing nodes visited in BFS order
    public List<V> breadthFirstSearch(V start) {
        System.out.println("BFS needs to be coded");
        requireVertex(start);

        List<V> visited = new ArrayList<>();
        Queue<V> queue  = new ArrayDeque<>();

        return visited;
    }

    //PRE:  accepts a starting and ending vertex
    //POST: will return a List of Vertices representing the shortest path
    public List<V> getShortestPathUnweighted(V start, V target) {
        System.out.println("getShortestPath needs to be coded");
        requireVertex(start);
        requireVertex(target);

        if (weighted) {
            throw new UnsupportedOperationException(
                    "Use Dijkstra for weighted graphs."
            );
        }

        Queue<V> queue = new ArrayDeque<>();
        List<V> visited = new ArrayList<>();
        //Set<V> visited = new HashSet<>();
        Map<V, V> previous = new HashMap<>();
        List<V> path = new ArrayList<>();
 

        return path;
    }

}
