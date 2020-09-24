package Graph;

public class Test {

    public static void main(String[] args) {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        // 10 - 30,70
        // 20 - 10,30,50,60 
        // 40 - 20
        graph.addEdge(10, 30);
        graph.addEdge(10, 70);
        // graph.addEdge(10, 30);       // makes isSimple false, same edge
        // graph.addEdge(10, 10);       // makes isSimple false, loop

        graph.addEdge(20, 10);
        graph.addEdge(20, 30);
        graph.addEdge(20, 50);
        graph.addEdge(20, 60);

        System.out.println("isSimple : " + graph.isSimple());

        Vertex<Integer> vertex40 = new Vertex<>(40);
        graph.addVertex(vertex40);
        graph.addEdge(40, 20);

        graph.bfsTraversal(vertex40);
        graph.clearVisits();
        graph.dfsTraversal(vertex40);
        graph.clearVisits();

        System.out.println("isBalanced : " + graph.isBalanced());
        System.out.println("isConnected : " + graph.isConnected());

        graph.clearVisits();
        System.out.println("path(40, 70) : " + graph.path(40, 70));
        graph.clearVisits();
        System.out.println("path(10, 40) : " + graph.path(10, 40));
        graph.clearVisits();
        System.out.println("path(20, 30) : " + graph.path(20, 30));
    }
}