public class Solver {
    private Node solution;
    private int numObservedGraphs;

    private class Node implements Comparable {
        Board board;
        int numOfMoves;
        Node prevNode;
        int priority;
        int depth;

        public Node(Board board, int numOfMoves, Node prevNode, int depth) {
            this.numOfMoves = numOfMoves;
            this.board = board;
            this.priority = numOfMoves + board.manhattan() + board.hamming();
            this.prevNode = prevNode;
            this.depth = depth;
        }

        private boolean isGoal() {
            return board.hamming() == 0;
        }

        @Override
        public int compareTo(Object object) {
            if (!(object instanceof Node)) return -1;
            return this.priority - ((Node) object).priority;
        }
    }

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        MinPQ < Node > mainPQ = new MinPQ < Node > (); //PQ for the main board
        MinPQ < Node > twinPQ = new MinPQ < Node > (); //PQ for the twin version of the input board, used to determine if the current board is solvable

        Board twin = initial.twin();
        Node currentNode = new Node(initial, 0, null, 0);
        Node twinNode = new Node(twin, 0, null, 0);

        mainPQ.insert(currentNode);

        while (true) {
            if (currentNode.isGoal()) { //solved board
                solution = currentNode;
                break;
            } else if (twinNode.isGoal()) { //unsolvable board
                break;
            } else {
                for (Board x: currentNode.board.neighbors()) { //Iterates through the possible neighbors of each board
                    if (currentNode.prevNode == null || !(x.equals(currentNode.prevNode.board))) {
                        Node nextBoard = new Node(x, currentNode.numOfMoves + 1, currentNode, currentNode.depth + 1);
                        mainPQ.insert(nextBoard);
                    }
                }
                for (Board x: twinNode.board.neighbors()) {
                    if (twinNode.prevNode == null || !(x.equals(twinNode.prevNode.board))) { //second condition prevents repeating boards -> checks the prev board does not equal the  
                        Node next = new Node(x, twinNode.numOfMoves + 1, twinNode, 0);
                        twinPQ.insert(next);
                    }
                }
            }
            numObservedGraphs++;
            currentNode = mainPQ.delMin(); //Iterate through the board with the lowest manhattan and hamming sum
            twinNode = twinPQ.delMin();
        }
    }

    public int numOfObservedGraphs() {
        return numObservedGraphs;
    }
    public int getSolutionDepth() {
        return solution.depth;
    }
    public boolean isSolvable() {
        return solution != null;
    }

    public int moves() {
        if (solution == null) return -1;
        return solution.numOfMoves;
    }

    public Stack < Board > solutionStack() {
        Stack < Board > stack = new Stack < Board > ();
        Node currentNode = solution;
        while (currentNode.prevNode != null) {
            stack.push(currentNode.board);
            currentNode = currentNode.prevNode;
        }
        return stack;
    }

    public Iterable < Board > solution() {
        return solutionStack();
    }
    public int getNumObservedBoards() {
        return numObservedGraphs;
    }

}