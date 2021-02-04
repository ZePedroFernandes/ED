package graphs;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
class Pair implements Comparable<Pair>{

    protected int vertex;

    protected int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Pair() {

    }


    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}
