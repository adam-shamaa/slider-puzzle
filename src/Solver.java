import java.util.Comparator;

public class Solver {
    private Node solution;

    private class Node {
        Board boardItem;
        int numOfMoves;
        Node prevNode;
        int priority;
        int manhattan;
        int depth;

        public Node(Board board, int numMoves, Node prev,int depth) {
            numOfMoves = numMoves;
            boardItem = board;
            manhattan = board.manhattan();
            priority = manhattan + numOfMoves;
            prevNode = prev;
            this.depth = depth;
        }

        private boolean isGoal() {
            return manhattan == 0;
        }
    }

    int numObservedGraphs;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        MinPQ <Node> originPQ = new MinPQ <>(new SolverStepComparator());   //One PQ for the input board
        MinPQ <Node> twinPQ = new MinPQ <>(new SolverStepComparator());     //PQ for the twin version of the input board, used to determine if the current board is solvable

        Board twin = initial.twin();
        Node currentNode = new Node(initial, 0, null,0);
        Node twinNode = new Node(twin, 0, null,0);
        originPQ.insert(currentNode);
        
        while (true) {
            if (currentNode.isGoal()) {     //solved board
                solution = currentNode;
                break;
            } else if (twinNode.isGoal()) { //unsolvable board
                break;
            } else {
                for (Board x: currentNode.boardItem.neighbors()) {  //Iterates through the possible neighbors of each board
                    if (currentNode.prevNode == null || !(x.equals(currentNode.prevNode.boardItem))) {
                        Node next = new Node(x, currentNode.numOfMoves + 1, currentNode, currentNode.depth + 1);
                        originPQ.insert(next);
                    }
                }
                for (Board x: twinNode.boardItem.neighbors()) {
                    if (twinNode.prevNode == null || !(x.equals(twinNode.prevNode.boardItem))) {   //second condition prevents repeating boards -> checks the prev board does not equal the  
                        Node next = new Node(x, twinNode.numOfMoves + 1, twinNode, 0);
                        twinPQ.insert(next);
                    }
                }
            }
            numObservedGraphs++;
            currentNode = originPQ.delMin();    //Iterates through the board with the lowest manhattan and hamming sum
            twinNode = twinPQ.delMin();
        }
    }

    public int numOfObservedGraphs() {
        return numObservedGraphs;
    }

    private class SolverStepComparator implements Comparator <Node> {
        public int compare(Node step1, Node step2) {
            return step1.priority - step2.priority;
        }
    }

    public int getSolutionDepth() {
        return solution.depth;
    }

    public boolean isSolvable() {
        return solution != null;
    }

    public int moves() {
        if (solution != null) {
            return solution.numOfMoves;
        }
        return - 1;
    }
    
    public Stack<Board> solutionStack(){
        Stack<Board> stack = new Stack<Board> ();
        Node currentN = solution;
        while (currentN.prevNode != null) {
            stack.push(currentN.boardItem);
            currentN = currentN.prevNode;
        }
        return stack;
    }

    public Iterable <Board> solution() {
        return solutionStack();
    }

}