package maze;

import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static Random random;
    private static ArrayList<Edge> edges;
    private static ArrayList<Edge> tree;
    private static Map<Vertex, Integer> components;

    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the size of a maze");
        n = scanner.nextInt();
        m = scanner.nextInt();
        random = new Random(System.currentTimeMillis());
        initiateEdges();
        buildSpanningTree();
        drawMaze();
    }

    public static void drawMaze() {
        // generate random entrance and exit
        Vertex entrance = generateGate();
        Vertex exit = generateGate();
        while (entrance.equals(exit)) {
            exit = generateGate();
        }

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == entrance.getRow() && j == entrance.getCol() || i == exit.getRow() && j == exit.getCol()) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }

                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static Vertex generateGate() {
        Vertex gate = new Vertex();
        gate.setRow(random.nextInt(n));

        if (gate.getRow() == 0 || gate.getRow() == n - 1) {
            if (m > 2) {
                gate.setCol(random.nextInt(m - 2) + 1);
            } else {
                gate.setCol(random.nextInt(m));
            }
        } else {
            gate.setCol(random.nextInt() < 0.5 ? 0 : m - 1);
        }
        return gate;
    }

    public static void buildSpanningTree() {
        // массив вершина - ее компонента
        components = new HashMap<>();
        int componentIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                components.put(new Vertex(i, j), componentIndex++);
            }
        }
        // строим дерево
        tree = new ArrayList<>();
        for (Edge edge : edges) {
            if (!hasEqualComponents(edge.getV1(), edge.getV2())) {
                tree.add(edge);
                Integer value1 = components.get(edge.getV1());
                Integer value2 = components.get(edge.getV2());
                components.replaceAll((key, value) -> value.equals(value2) ? value1 : value);
            }
        }
    }

    private static boolean hasEqualComponents(Vertex v1, Vertex v2) {
        return components.get(v1).equals(components.get(v2));
    }

    public static void initiateEdges() {
        edges = new ArrayList<>();

        // горизонтальные ребра
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                int weight = random.nextInt(n * m);
                edges.add(new Edge(weight, new Vertex(i, j), new Vertex(i, j + 1)));
            }
        }
        // вертикальные ребра
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                int weight = random.nextInt(n * m);
                edges.add(new Edge(weight, new Vertex(j, i), new Vertex(j + 1, i)));
            }
        }
        edges.sort(new Sortbyweight());
    }

}
