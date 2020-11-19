package towersOfHanoi;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class TowersOfHanoi {

    private final int totalDisks;

    public TowersOfHanoi(int disks) {
        this.totalDisks = disks;
    }

    public void solve() {
        moveTower(totalDisks, 1, 3, 2);
    }

    private void moveTower(int numDisks, int start, int end, int tmp) {
        if (numDisks == 1) {
            moveOneDisk(start, end);
        } else {
            moveTower(numDisks - 1, start, tmp, end);
            moveOneDisk(start, end);
            moveTower(numDisks - 1, tmp, end, start);
        }
    }

    private void moveOneDisk(int start, int end) {
        System.out.println("Move onde disk from " + start + " to " + end);
    }
}
