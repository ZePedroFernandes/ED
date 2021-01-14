package Graphs;

import java.util.Objects;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Vertex {

    String name;

    int info;

    public Vertex() {

    }

    public Vertex(String name, int info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex{" + "name=" + name + ", info=" + info + '}';
    }

    public String getName() {
        return name;
    }
}
