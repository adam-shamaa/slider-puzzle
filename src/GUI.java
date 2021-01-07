import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JTextField;

/**
 *
 * @author AdamShamaa
 */

public class GUI extends javax.swing.JFrame implements ActionListener {
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    //GUI initialization - NetBeans V8.2
    private void initComponents() {

        /* Component Declarations */
        //JPanel Declarations
        solutionPanel = new javax.swing.JPanel();
        gridPanel = new javax.swing.JPanel();

        //Output Panel Declarations
        jScrollPane = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();

        //TextField Declarations
        gridSize = new javax.swing.JTextField();

        //JLabel Declarations
        applicationTitleJLabel = new javax.swing.JLabel();
        sizeJLabel = new javax.swing.JLabel();

        //JButton Declarations
        createRandomButton = new javax.swing.JButton();
        showSolutionButton = new javax.swing.JButton();
        solveButton = new javax.swing.JButton();

        jProgressBar = new javax.swing.JProgressBar();

        //JFrame Attributes
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("8Puzzle Solver");

        //Solution Panel Attributes
        solutionPanel.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout solutionPanelLayout = new javax.swing.GroupLayout(solutionPanel);
        solutionPanel.setLayout(solutionPanelLayout);
        solutionPanelLayout.setHorizontalGroup(
            solutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 230, Short.MAX_VALUE));
        solutionPanelLayout.setVerticalGroup(
            solutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 230, Short.MAX_VALUE));

        // Output Panel Attributes
        jScrollPane.setViewportView(output);
        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        output.setWrapStyleWord(true);

        // JButton Attributes
        solveButton.setText("Solve");
        solveButton.setToolTipText("");
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        createRandomButton.setText("Randomize");
        createRandomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRandomButtonActionPerformed(evt);
            }
        });

        showSolutionButton.setText("Play Solution");
        showSolutionButton.setEnabled(false);
        showSolutionButton.setMaximumSize(new java.awt.Dimension(113, 29));
        showSolutionButton.setMinimumSize(new java.awt.Dimension(113, 29));
        showSolutionButton.setPreferredSize(new java.awt.Dimension(113, 29));
        showSolutionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSolutionButtonActionPerformed(evt);
            }
        });

        //Grid Panel Attributes
        javax.swing.GroupLayout gridPanelLayout = new javax.swing.GroupLayout(gridPanel);
        gridPanel.setPreferredSize(new java.awt.Dimension(230, 230));
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 230, Short.MAX_VALUE));
        gridPanelLayout.setVerticalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 230, Short.MAX_VALUE));

        //JTextField Attributes
        gridSize.setText("3");
        gridSize.setMaximumSize(new java.awt.Dimension(0, 1));
        gridSize.setMinimumSize(new java.awt.Dimension(0, 1));
        gridSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridSizeActionPerformed(evt);
            }
        });

        //JLabel Attributes
        sizeJLabel.setText("N x N Grid Size");

        applicationTitleJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        applicationTitleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        applicationTitleJLabel.setText("8 Puzzle Solver");

        //JProgressBar Attributes
        jProgressBar.setSize(new java.awt.Dimension(0, 5000));

        //Mount Components to JFrame (automatically done by NetBeans)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(51, 51, 51).addComponent(sizeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addGap(73, 73, 73).addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(solutionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))).addGap(7, 7, 7)).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(applicationTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(createRandomButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE).addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(58, 58, 58)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(applicationTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(sizeJLabel).addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(createRandomButton)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(solutionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(31, Short.MAX_VALUE)));
        showSolutionPanel(false);
        pack();
    }

    private Board defaultSolvedBoard; // solved board used to generate a random board by performing a number of random moves
    private Solver solve; //solver class
    private JTextField[][] gridValues; //JTextFields displayed to the display panel
    private JTextField[][] solutionGridValues; //JTextFields displayed to the solution panel
    private Stack < Board > solutionStack;

    //JTextField selectors to be moved during replay
    private JTextField JTextFieldA;
    private JTextField JTextFieldB;

    // dimension of the board
    private int dimension;

    // width & height of each JTextField within the board
    private int size;

    //min board dimension
    private int minGridSize = 2;

    //max board dimension 
    private int maxGridSize = 5;

    /* Replay Solution Attributes */
    private int replaySpeedMS = 5;
    private Timer timer = new Timer(replaySpeedMS, this); // timer for use in replaying the solution 
    private int pixelsMoved = 0; //the number of pixels the current tile has moved which is used during the solution replay
    private int valX; //horizontal direction to move JTextFields during replay
    private int valY; //vertical direction to move JTextFields during replay

    /** GUI Controls - Action Performed **/
    //Grid dimension value changed
    private void gridSizeActionPerformed(java.awt.event.ActionEvent evt) {
        dimension = Integer.parseInt(gridSize.getText());
        if (!validBoardSize(dimension, minGridSize, maxGridSize)) { //check if dimension does not meet min/max value
            pushOutput("Invalid Dimension", "Please choose a value between " + minGridSize + "-" + maxGridSize);
        } else {
            createPanel(null); //create a blank board
        }
        defaultSolvedBoard = createDefaultBoard(dimension);
        gridPanel.updateUI();
    }

    //create random board
    private void createRandomButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_createRandomButtonActionPerformed
        Random random = new Random();
        Board[] possibleBoards = new Board[4]; //max number of possible moves per level/iteration 
        int index;
        for (int x = 0; x < 25; x++) { // starting from a solved board, iterates through 25 random moves shuffling the board
            index = 0;
            for (Board neighbor: defaultSolvedBoard.neighbors()) {
                possibleBoards[index++] = neighbor;
            }
            defaultSolvedBoard = possibleBoards[random.nextInt(index)]; //picks a random move by generating an integer between 0 to the # of neighbors and iterates again
        }

        createPanel(defaultSolvedBoard);
        showSolutionPanel(false);
    }

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Board inputBoard = createBoard(gridValues); //creates board from the current grid values from the display panel
        createPanel(inputBoard); //redisplay the board to the user

        // store the start time before the board is solved (used when determining the total time used when solving the board)
        long startTime = System.currentTimeMillis();

        //Pass a reference to the board to the solver class for the 
        solve = new Solver(inputBoard);

        long timeElapsed = System.currentTimeMillis() - startTime; //duration to compute solution

        if (!solve.isSolvable()) {
            pushOutput("The current board is not solvable");
            showSolutionButton.setEnabled(false);
        } else {
            pushOutput("Solved!", "Time Elapsed: " + timeElapsed + " ms", "Number of Moves: " + solve.moves(), "Solution Depth: " + solve.getSolutionDepth(), "Number of Observed Boards: " + solve.getNumObservedBoards());
            showSolutionButton.setEnabled(true);
        }


        initialize();
    }

    private void showSolutionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showSolutionPanel(true);
        animate();
    }


    /** Board Helper Functions (these should ideally be in another class) **/
    public boolean validBoardSize(int gridSize, int minSize, int maxSize) {
        if (gridSize >= minGridSize && gridSize <= maxGridSize) return true;
        else return false;
    }

    // generates a solved board simply starting at index 1 then incrementing & assigning the correct index to each respective panel
    // used when creating a random board (see createRandomButtonActionPerformed for more info)
    private Board createDefaultBoard(int dimension) {
        int[][] defaultArray = new int[dimension][dimension];
        int index = 1;
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                defaultArray[x][y] = index++;
            }
        }
        defaultArray[dimension - 1][dimension - 1] = 0;
        return new Board(defaultArray);
    }

    // generates a board using user-entered values that are modified via input in the displayed tiles
    public Board createBoard(JTextField[][] gridValues) {
        int dimension = gridValues[0].length;
        int integerInput[][] = new int[dimension][dimension];
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                integerInput[x][y] = Integer.parseInt(gridValues[y][x].getText());
            }
        }
        return (new Board(integerInput));
    }



    // Creates & Displays tiles displayed to the user
    private void createPanel(Board board) {
        gridPanel.removeAll();
        solutionPanel.removeAll();
        gridValues = new JTextField[dimension][dimension];
        solutionGridValues = new JTextField[dimension][dimension];
        int size = gridPanel.getWidth() / dimension; //size of each JTextField
        if (board != null) { //Generate the JTextFields for a pre-defined board
            int[][] boardValues = board.getIntegerArray(); //retrieves the current JTextField values in the display JPanel
            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                    createJTextField(Integer.toString(boardValues[y][x]), x, y, size);
                }
            }
        } else { //Generate blank JTextFields for a non-predefined board
            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                    createJTextField("", x, y, size);
                }
            }
        }
    }

    //assign the JTextFields to the display and solution panel
    private void createJTextField(String value, int x, int y, int size) {
        //generate JTextField for the display panel & generate an identical JTextField for the solution panel
        JTextField input = newJTextField(value, x, y, size);
        JTextField inputClone = newJTextField(value, x, y, size);

        //save JTextField to a separate array from the solution JTextFields
        gridValues[x][y] = input;

        //save the clone JTextField to the solution array --> accessed in order to move the JTextFields to the solution panel
        solutionGridValues[x][y] = inputClone;

        //prevent altering of solution values
        inputClone.setEditable(false);

        //mount the JTextFields to the grid and solution panel
        gridPanel.add(input);
        solutionPanel.add(inputClone);
    }

    //initialize new JTextFields
    private JTextField newJTextField(String value, int x, int y, int size) {
        JTextField input = new JTextField();
        input.setSize(size, size);
        input.setBounds(x * size, y * size, size, size);
        input.setText(value);
        input.setHorizontalAlignment((int) input.CENTER_ALIGNMENT);
        return input;
    }

    /** GUI Components Helper Functions (Anything that is directly shown to the user on the JFrame) **/
    // Push any number of string arguments to the displayed console on the JFrame
    private void pushOutput(String...textAr) {
        output.setText(""); //blank the console
        for (String text: textAr) {
            output.append(text + "\n");
        }
    }

    // Unhide the JTextField Tiles/Panels
    public void showSolutionPanel(boolean val) {
        for (Component tile: solutionPanel.getComponents()) {
            tile.setVisible(val);
        }
        solutionPanel.updateUI();
        solutionPanel.validate();
    }

    //Solution Statistics Helper Functions
    //reset all panel values
    private void initialize() {
        jProgressBar.setValue(0);
        pixelsMoved = 0;
        solutionStack = solve.solutionStack();
        size = gridPanel.getWidth() / dimension;
        jProgressBar.setForeground(Color.green);
        jProgressBar.setMaximum(size * solve.moves());
    }

    private void incrementProgressBar() {
        jProgressBar.setValue(jProgressBar.getValue() + 1);
    }

    /** Solution Replay Helper Functions **/
    //Start the replay of the solution
    private void animate() {
        switchVal(); //animates the movement of two switched tiles
        timer.start();
    }

    // switch the appropriate tiles and update internal representations
    private void switchVal() {
        if (solutionStack.isEmpty()) {
            timer.stop();
            return;
        };

        //retrieve the switched tiles 
        int[] switchVal = solutionStack.pop().getSwitchedTiles();

        //save the switched panel indices
        int xIndexPanelA = switchVal[0];
        int yIndexPanelA = switchVal[1];
        int xIndexPanelB = switchVal[2];
        int yIndexPanelB = switchVal[3];

        //switch the panels themselves in the internal array representation
        JTextFieldA = solutionGridValues[xIndexPanelA][yIndexPanelA];
        JTextFieldB = solutionGridValues[xIndexPanelB][yIndexPanelB];
        solutionGridValues[xIndexPanelA][yIndexPanelA] = JTextFieldB; //switch tiles
        solutionGridValues[xIndexPanelB][yIndexPanelB] = JTextFieldA; //switch tiles

        //determine direction to move tiles vertically ex. if tile is switched with the below tile will be positive 1
        valY = yIndexPanelB - yIndexPanelA;
        valX = xIndexPanelB - xIndexPanelA; //determine the direction to move horizontally
    }

    //responsible for the animation of the tile
    public void actionPerformed(ActionEvent e) {
        //updates location of JTextField 1 pixel at a time
        JTextFieldA.setLocation(JTextFieldA.getX() + valX, JTextFieldA.getY() + valY);
        //updates location of JTextField in the opposite direction 1 pixel at a time
        JTextFieldB.setLocation(JTextFieldB.getX() - valX, JTextFieldB.getY() - valY);

        incrementProgressBar();
        solutionPanel.validate();

        //check if the JTextField has moved locations by a full column/row, if so terminates the movement and requests the next tile to be switched
        if (pixelsMoved++ >= size) {
            switchVal();
            pixelsMoved = 0;
        }
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel gridPanel;
    private javax.swing.JPanel solutionPanel;
    private javax.swing.JTextField gridSize;
    private javax.swing.JTextArea output;
    private javax.swing.JLabel applicationTitleJLabel;
    private javax.swing.JLabel sizeJLabel;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton createRandomButton;
    private javax.swing.JButton showSolutionButton;
    private javax.swing.JButton solveButton;
    // End of variables declaration
}