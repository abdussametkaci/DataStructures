package Graph;

import java.util.LinkedList;

class Vertex<T> {

    T data;
    private LinkedList<Vertex> neighbours;
    boolean visited;

    public Vertex(T data) {
        this.data = data;
        this.neighbours = new LinkedList<>();
    }

    void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    public LinkedList<Vertex> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object obj) {
        return data == ((Vertex) obj).data;
    }

    @Override
    public String toString() {
        return data + "";
    }

}