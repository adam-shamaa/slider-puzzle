import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.StringBuilder;

public class Board {
    private final int[][] tileArray;

    private int boardDimension;
    private int xIndexOfSpace;
    private int yIndexOfSpace;

    private int[] switched;
    private int[] switchedPrev;

    private int hammingSum;
    private int manhattanSum;

    public Board(int[][] tiles) {
        tileArray = new int[tiles.length][tiles.length];
        boardDimension = tiles.length;

        //create a deep copy of the array representation of the board for internal use
        for (int col = 0; col < boardDimension; col++) {
            for (int row = 0; row < boardDimension; row++) {
                tileArray[col][row] = tiles[col][row];
                if (tileArray[col][row] == 0) {
                    xIndexOfSpace = col;
                    yIndexOfSpace = row;
                }
            }
        }

        //compute & store the manhattan and hamming attributes locally
        computeHammingAndManhattan();
    }

    //compute the manhattan and hamming sums, saving the attributes locally as global variables
    private void computeHammingAndManhattan() {
        int hammingSum = 0;
        int manhattanSum = 0;
        int currentTileNumber = 0;

        //check each board tile
        for (int x = 0; x < boardDimension; x++) {
            for (int y = 0; y < boardDimension; y++) {
                //misplaced tile found (skip over the space/zero tile)
                if (tileArray[x][y] != (currentTileNumber + 1) && currentTileNumber < (boardDimension * boardDimension) && tileArray[x][y] != 0) {
                    //update hamming sum
                    hammingSum++;
                    //update manhattan sum
                    manhattanSum += Math.abs((tileArray[x][y] - 1) / boardDimension - (currentTileNumber / boardDimension)) + Math.abs((tileArray[x][y] - 1) % boardDimension - (currentTileNumber % boardDimension));
                }
                //increment the tile index ex. starts 
                currentTileNumber++;
            }
        }

        this.hammingSum = hammingSum;
        this.manhattanSum = manhattanSum;
    }

    //returns the double array version of the board
    public int[][] getIntegerArray() {
        return tileArray;
    }

    // dimension of the board (ex. a 4 x 4 board would have a dimension of 4)
    public int dimension() {
        return boardDimension;
    }

    public int hamming() {
        return this.hammingSum;
    }

    public int manhattan() {
        return this.manhattanSum;
    }

    public boolean isGoal() {
        return (hamming() == 0);
    }

    public int[] getSwitchedTiles() {
        return switched;
    }

    public String toString() {
        StringBuilder returnVal = new StringBuilder(boardDimension + "\n");
        for (int column = 0; column < boardDimension; column++) {
            for (int row = 0; row < boardDimension; row++) {
                returnVal.append(tileArray[column][row] + " ");
            }
            returnVal.append("\n");
        }
        return returnVal.toString();
    }

    public boolean equals(Object item) {
        if (!(item instanceof Board)) return false;

        Board compareTo = (Board) item;
        if (compareTo.tileArray.length != tileArray.length) return false;

        for (int column = 0; column < boardDimension; column++) {
            for (int row = 0; row < boardDimension; row++) {
                if (tileArray[column][row] != compareTo.tileArray[column][row]) return false;
            }
        }

        return true;
    }

    //returns a twin version of the board with two tiles that are not next to each other switch (used to determine if a board is unsolvable)
    public Board twin() {
        int[][] twinArray = copyTileArray();
        switchTile(twinArray, Math.abs(1 - xIndexOfSpace), yIndexOfSpace, xIndexOfSpace, Math.abs(1 - yIndexOfSpace));
        return (new Board(twinArray));
    }

    private void switchTile(int[][] array, int column1, int row1, int column2, int row2) {
        int tempVal = array[column2][row2];
        array[column2][row2] = array[column1][row1];
        array[column1][row1] = tempVal;
    }

    private void saveSwitch(int column1, int row1, int column2, int row2) {
        switchedPrev = new int[4];
        switchedPrev[0] = row1;
        switchedPrev[1] = column1;
        switchedPrev[2] = row2;
        switchedPrev[3] = column2;
    }

    private void switchTileAndSave(int[][] array, int column1, int row1, int column2, int row2) {
        switchTile(array, column1, row1, column2, row2);
        saveSwitch(column1, row1, column2, row2);
    }
    private int[][] copyTileArray() {
        int copy[][] = new int[tileArray.length][];
        for (int x = 0; x < boardDimension; x++) {
            copy[x] = Arrays.copyOf(tileArray[x], tileArray.length);
        }
        return copy;
    }

    //Iterator returning all possible board choices per level ex. an open corner will iterate through two possible moves
    public Iterable < Board > neighbors() {
        return new Iterable < Board > () {
            public Iterator < Board > iterator() {
                return new NeighborIterator();
            }
        };
    }

    private class NeighborIterator implements Iterator < Board > {
        int numNeighbors;
        public NeighborIterator() { //Identifies location of tile ex. a middle tile has four neighbors
            if (xIndexOfSpace == 0 || xIndexOfSpace == boardDimension - 1) { //tile located on first or last column
                if (yIndexOfSpace == 0 || yIndexOfSpace == boardDimension - 1) { //tile located on first or last row i.e. corner tile
                    numNeighbors = 2;
                } else { //middle tile hugging a wall
                    numNeighbors = 3;
                }
            } else if (yIndexOfSpace == 0 || yIndexOfSpace == boardDimension - 1) { //middle tile hugging a wall 
                numNeighbors = 3;
            } else { //middle tile
                numNeighbors = 4;
            }
        }

        public boolean hasNext() {
            return (numNeighbors != 0);
        }

        public Board next() {
            if (numNeighbors == 0) throw new NoSuchElementException();

            int[][] nextTileArray = copyTileArray();

            //logic: each open-space must have at least one open neighbor above/below and/or to the left/right
            //If contains 3+ neighbors inverse conditions to target the opposite tile
            if (numNeighbors == 1) {
                if (xIndexOfSpace == 0) {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace + 1, yIndexOfSpace); //switches open-space with tile to the right
                } else {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace - 1, yIndexOfSpace); //switch the open-space with tile to the left
                }
            } else if (numNeighbors == 2) {
                if (yIndexOfSpace == 0) {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace, yIndexOfSpace + 1); //switch the open-space with tile below it
                } else {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace, yIndexOfSpace - 1); //switch the open-space with tile above it
                }
            } else if (numNeighbors == 3) {
                if (xIndexOfSpace == 0 || xIndexOfSpace == boardDimension - 1) {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace, yIndexOfSpace + 1); //switch the open-space with the tile below it
                } else {
                    switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace + 1, yIndexOfSpace); //switch open-space with tile to the right of it
                }
            } else {
                //switch the open-space tile with tile below it
                switchTileAndSave(nextTileArray, xIndexOfSpace, yIndexOfSpace, xIndexOfSpace, yIndexOfSpace + 1);
            }
            Board nextBoard = new Board(nextTileArray);
            nextBoard.switched = switchedPrev; //saves the index of the switched tiles as an attribute
            numNeighbors--;

            return nextBoard;
        }
    }
}