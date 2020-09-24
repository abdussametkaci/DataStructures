package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraph<T> {

    private LinkedList<Vertex<T>> vertices;

    public DirectedGraph() {
        vertices = new LinkedList<>();
    }

    boolean addVertex(Vertex<T> v) {
        if (vertices.contains(v)) {
            return false;
        }

        return vertices.add(v);
    }

    void addEdge(T from, T to) {
        Vertex f = new Vertex(from);
        Vertex t = new Vertex(to);

        if (!vertices.contains(f)) {
            vertices.add(f);
        }
        if (!vertices.contains(t)) {
            vertices.add(t);
        }

        f = vertices.get(vertices.indexOf(f));
        t = vertices.get(vertices.indexOf(t));

        f.addNeighbour(t);
    }

    void bfsTraversal(Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList();

        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> remove = queue.remove();
            System.out.print(remove.data + " ");

            LinkedList<Vertex> neighbours = remove.getNeighbours();

            for (Vertex neighbour : neighbours) {
                if (!neighbour.visited) {
                    queue.add(neighbour);
                    neighbour.visited = true;
                }
            }
        }

        System.out.println();
    }

    void dfsTraversal(Vertex<T> start) {
        dfsRecursive(start);
        System.out.println();
    }

    private void dfsRecursive(Vertex<T> v) {
        System.out.print(v.data + " ");
        v.visited = true;

        LinkedList<Vertex> neighbours = v.getNeighbours();

        for (Vertex neighbour : neighbours) {
            if (!neighbour.visited) {
                dfsRecursive(neighbour);
            }
        }
    }

    void clearVisits() {
        for (Vertex<T> vertex : vertices) {
            vertex.visited = false;
        }
    }

    // no loop + no more than one edge between two vertices
    boolean isSimple() {
        for (Vertex<T> vertex : vertices) {
            LinkedList<Vertex> neighbours = vertex.getNeighbours();

            // control loop condition
            if (neighbours.contains(vertex)) {
                return false;
            }

            //control multiple edge between two vertices
            HashSet<Vertex> uniqueNeighbours = new HashSet(neighbours);
            if (uniqueNeighbours.size() != neighbours.size()) {
                return false;
            }
        }

        return true;
    }

    int indegree(Vertex v) {
        int count = 0;

        for (Vertex<T> vertex : vertices) {
            for (Vertex neighbour : vertex.getNeighbours()) {
                if (neighbour.equals(v)) {
                    count++;
                }
            }
        }

        return count;
    }

    int outdegree(Vertex v) {
        return v.getNeighbours().size();
    }

    // for each vertex; indegree(vertex) = outdegree(vertex)
    boolean isBalanced() {
        for (Vertex<T> vertex : vertices) {
            if (indegree(vertex) != outdegree(vertex)) {
                return false;
            }
        }

        return true;
    }

    boolean isConnected() {
        for (Vertex<T> vertex1 : vertices) {
            for (Vertex<T> vertex2 : vertices) {
                clearVisits();
                if (!path(vertex1, vertex2)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean path(Vertex from, Vertex to) {
        Queue<Vertex<T>> queue = new LinkedList();
        queue.add(from);

        while (!queue.isEmpty()) {
            Vertex<T> remove = queue.remove();
            if (remove.equals(to)) {
                return true;
            }

            LinkedList<Vertex> neighbours = remove.getNeighbours();

            for (Vertex neighbour : neighbours) {
                if (!neighbour.visited) {
                    queue.add(neighbour);
                    neighbour.visited = true;
                }
            }
        }

        return false;
    }

    boolean path(T from, T to) {
        Vertex f = null;
        Vertex t = null;

        for (Vertex<T> vertex : vertices) {
            if (vertex.data.equals(from)) {
                f = vertex;
            } else if (vertex.data.equals(to)) {
                t = vertex;
            }
        }

        if (f != null && t != null) {
            return path(f, t);
        } else {
            System.out.println("Control vertices !!");
            return false;
        }
    }
}