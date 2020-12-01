package maze;

import java.util.Comparator;

public class Sortbyweight implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
