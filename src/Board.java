import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.StringBuilder;

public class Board {
    private final int[][] input;
    private final int boardSize;
    private int indexOfSpaceX;
    private int indexOfSpaceY;
    private int[] switched;
    private int[] switchedPrev;
    
    public Board(int[][] tiles) {   //initialization 
        input = new int[tiles.length][tiles.length];
        boardSize = tiles.length;
        for (int col = 0; col < boardSize; col++) {
            for (int row = 0; row < boardSize; row++) {
                input[col][row] = tiles[col][row];
                if (input[col][row] == 0) {
                    indexOfSpaceX = col;
                    indexOfSpaceY = row;
                }
            }
        }
    }

    public int hamming() {  //the number of misplaced tiles
        int outOfPlace = 0;
        int currentIndex = 0;
        int gridLength = boardSize * boardSize;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (input[x][y] == 0) {} else if (input[x][y] != (currentIndex + 1) && currentIndex < gridLength) {
                    outOfPlace++;
                }
                currentIndex++;
            }
        }
        return outOfPlace;
    }

    public int manhattan() {    //the sum of the distance of all misplaced tiles to their correct tile index
        int manhattanSum = 0;
        int currentIndex = 0;
        int gridLength = boardSize * boardSize;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (input[x][y] == 0) { 
                    
                } else if (input[x][y] != (currentIndex + 1) && currentIndex < gridLength) {  //if the 
                    manhattanSum += Math.abs((input[x][y] - 1) / boardSize - (currentIndex / boardSize)) + Math.abs((input[x][y] - 1) % boardSize - (currentIndex % boardSize));
                }
                currentIndex++;
            }
        }
        return manhattanSum;
    }

    public String toString() {
        StringBuilder returnVal = new StringBuilder(boardSize + "\n");
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                returnVal.append(input[x][y] + " ");
            }
            returnVal.append("\n");
        }
        return (returnVal.toString());
    }

    public boolean isGoal() {
        return (hamming() == 0);
    }
    
    public int dimension() {
        return boardSize;
    }
    
    public int[][] getIntegerArray(){   //returns the double array version of the board
        return input;
    }

    public boolean equals(Object item) {
        if (! (item instanceof Board)) {
            return false;
        }
        Board compareTo = (Board) item;
        if (compareTo.input.length != input.length) {
            return false;
        }
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (input[x][y] != compareTo.input[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board twin() {   //returns  alternate version of the board i.e. if a board is unsolvable will return a solvable version
        int[][] twinArray = copyArray();
        switchVal(twinArray, Math.abs(1 - indexOfSpaceX), indexOfSpaceY, indexOfSpaceX, Math.abs(1 - indexOfSpaceY));
        return (new Board(twinArray));
    }
    
    public int[] getSwitchedTiles() {
        if (switched == null) {
            return null;
        }else {
            return switched;
        }
    }

    private void switchVal(int[][] array, int a1, int a2, int b1, int b2) {
        int tempInt = array[b1][b2];
        array[b1][b2] = array[a1][a2];
        array[a1][a2] = tempInt;
    }
    
    private void saveSwitch(int[][] array, int a1, int a2, int b1, int b2) {
        switchedPrev = new int[4];
        switchedPrev[0] = a2; switchedPrev[1] = a1; switchedPrev[2] = b2; switchedPrev[3] = b1; 
    }
    
    private int[][] copyArray() {
        int copy[][] = new int[input.length][];
        for (int x = 0; x < boardSize; x++) {
            copy[x] = Arrays.copyOf(input[x], input.length);
        }
        return copy;
    }
    
    //Iterator returning all possible board choices per level ex. an open corner will iterate through two possible moves
    public Iterable <Board> neighbors() {
        return new Iterable <Board> () {
            public Iterator <Board> iterator() {
                return new NeighborIterator();
            }
        };
    }

    private class NeighborIterator implements Iterator <Board> {
        int numNeighbors;   
        public NeighborIterator() { //Identifies location of tile ex. a middle tile has four neighbors
            if (indexOfSpaceX == 0 || indexOfSpaceX == boardSize - 1) { //tile located on first or last column
                if (indexOfSpaceY == 0 || indexOfSpaceY == boardSize - 1) { //tile located on first or last row i.e. corner tile
                    numNeighbors = 2;
                } else {  //middle tile hugging a wall
                    numNeighbors = 3; 
                }
            } else if (indexOfSpaceY == 0 || indexOfSpaceY == boardSize - 1) { //middle tile hugging a wall 
                numNeighbors = 3;
            } else {   //middle tile
                numNeighbors = 4;
            }
        }

        public boolean hasNext() {
            return (numNeighbors != 0);
        }

        public Board next() {
            if (numNeighbors == 0) {
                throw new NoSuchElementException();
            }
            int[][] tileRepTemp = copyArray();
            
            //logic: each open-space must have at least one open neighbor above/below and/or to the left/right
            //If contains 3+ neighbors inverse conditions to target the opposite tile
            if (numNeighbors == 1) {
                if (indexOfSpaceX == 0) {   //switches open-space with tile to the right
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX + 1, indexOfSpaceY);     //switch open tile with a neighbor
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX + 1, indexOfSpaceY);    //saves switch in a separate array for the solution
                } else {    //switches open-space with tile to the left
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX - 1, indexOfSpaceY);
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX - 1, indexOfSpaceY);
                }
            } else if (numNeighbors == 2) {
                if (indexOfSpaceY == 0) {   //switches open-space with tile below
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
                } else {    //switches open-space with tile above
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY - 1);
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY - 1);
                }
            } else if (numNeighbors == 3) {
                if (indexOfSpaceX == 0 || indexOfSpaceX == boardSize -1) { //switches open-space with tile below
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
                } else {    //switches open-space with tile to the right
                    switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX + 1, indexOfSpaceY);
                    saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX + 1, indexOfSpaceY);
                }
            } else {//switches tile with tile below
                switchVal(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
                saveSwitch(tileRepTemp, indexOfSpaceX, indexOfSpaceY, indexOfSpaceX, indexOfSpaceY + 1);
            }
            numNeighbors--;
            Board newBoard = new Board(tileRepTemp);
            newBoard.switched = switchedPrev;   //saves the indexs of the switched tiles as an attribute
            return newBoard;
        }
    }
}