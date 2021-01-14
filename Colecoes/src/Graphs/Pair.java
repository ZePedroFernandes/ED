package Graphs;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
class Pair<T1, T2> {

    protected T1 start;

    protected T2 end;

    public Pair(T1 start, T2 end) {
        this.start = start;
        this.end = end;
    }

    public Pair() {
    }

    public T1 getStart() {
        return start;
    }

    public void setStart(T1 start) {
        this.start = start;
    }

    public T2 getEnd() {
        return end;
    }

    public void setEnd(T2 end) {
        this.end = end;
    }

    
}
