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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   
    //GUI initialization - NetBeans V8.2
    private void initComponents() {
        solutionPanel = new javax.swing.JPanel();
        gridPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        gridSize = new javax.swing.JTextField();
        applicationTitleJLabel = new javax.swing.JLabel();
        sizeJLabel = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        createRandomButton = new javax.swing.JButton();
        showSolutionButton = new javax.swing.JButton();
        solveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("8Puzzle Solver");

        applicationTitleJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        applicationTitleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        applicationTitleJLabel.setText("8 Puzzle Solver");

        solutionPanel.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout solutionPanelLayout = new javax.swing.GroupLayout(solutionPanel);
        solutionPanel.setLayout(solutionPanelLayout);
        solutionPanelLayout.setHorizontalGroup(
                solutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 230, Short.MAX_VALUE)
                );
        solutionPanelLayout.setVerticalGroup(
                solutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 230, Short.MAX_VALUE)
                );

        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        output.setWrapStyleWord(true);
        jScrollPane.setViewportView(output);

        solveButton.setText("Solve");
        solveButton.setToolTipText("");
        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        gridPanel.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout gridPanelLayout = new javax.swing.GroupLayout(gridPanel);
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
                gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 230, Short.MAX_VALUE)
                );
        gridPanelLayout.setVerticalGroup(
                gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 230, Short.MAX_VALUE)
                );

        createRandomButton.setText("Randomize");
        createRandomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRandomButtonActionPerformed(evt);
            }
        });

        gridSize.setText("3");
        gridSize.setMaximumSize(new java.awt.Dimension(0, 1));
        gridSize.setMinimumSize(new java.awt.Dimension(0, 1));
        gridSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridSizeActionPerformed(evt);
            }
        });

        sizeJLabel.setText("N x N Grid Size");

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

        jProgressBar.setSize(new java.awt.Dimension(0, 5000));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(sizeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(solutionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(7, 7, 7))
                .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(applicationTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(createRandomButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(applicationTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(sizeJLabel)
                                                .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(showSolutionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(createRandomButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(solutionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))
                );
        showSolutionPanel(false);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    Random random = new Random();
    private Timer timer = new Timer(5,this);   //speed of solution replay
    
    private Board defaultSolvedBoard; //solved board --> used to generate a random board
    private Solver solve;   //solver class
    
    
    private JTextField[][] gridValues;  //store JTextFields displayed in display panel
    private JTextField[][] solutionGridValues;  //identical JTextFields displayed in the solution panel
    
    private Stack<Board> solutionStack; 

    private int valX;   //horizontal direction to move JTextFields during replay
    private int valY;   //vertical direction to move JTextFields during replay
    
    //JTextField selectors to be moved during replay
    private JTextField JTextFieldA; 
    private JTextField JTextFieldB;
    
    private int dimension;  // dimension of board
    private int size;   // width/height of each JTextField within the board
    private int pixelsMoved = 0;    //pixels moved used during solution replay
    
    private int minGridSize = 2;    //min board dimension
    private int maxGridSize = 5;    //max board dimension

    

    private void pushOutput(String... textAr) { //pushes any number of string arguments to the displayed console
        output.setText(""); //blank the console
        for (String text: textAr) {
            output.append(text + "\n");
        }   
    }

    private void gridSizeActionPerformed(java.awt.event.ActionEvent evt) {  //grid dimension value changed
        dimension = Integer.parseInt(gridSize.getText());
        if (!validBoardSize(dimension,minGridSize,maxGridSize)) {  //check if dimension does not meet min/max value
            pushOutput("Invalid Dimension","Please choose a value between " + minGridSize + "-" + maxGridSize);
        }else { 
            createPanel(null);  //create a blank board
        }
        defaultSolvedBoard = createDefaultBoard(dimension);
        gridPanel.updateUI();
    }

    private Board createDefaultBoard(int dimension) {   //generates a solved board by iterating 1 through the # of panels
        int[][] defaultArray = new int[dimension][dimension];
        int index = 1;
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                defaultArray[x][y] = index++;
            }
        }
        defaultArray[dimension-1][dimension-1] = 0;
        return new Board(defaultArray);
    }
    private void createPanel(Board board) {
        gridPanel.removeAll();     
        solutionPanel.removeAll();
        gridValues = new JTextField[dimension][dimension];
        solutionGridValues = new JTextField[dimension][dimension];
        int size = gridPanel.getWidth()/dimension;      //size of each JTextField

        if (board != null) {   //Generate the JTextFields for a pre-defined board
            int[][] boardValues = board.getIntegerArray();  //retrieves the current JTextField values in the display JPanel
            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                    createJTextField(Integer.toString(boardValues[y][x]), x, y, size);
                }
            }
        }else {             //Generate blank JTextFields for a non-predefined board
            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                    createJTextField("", x, y, size);
                }
            }
        }
    }

    //create random board
    private void createRandomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRandomButtonActionPerformed
        Board[] possibleBoards = new Board[4];  //max number of possible moves per level/iteration 
        int index;
        for (int x = 0; x < 500; x++) { // iterates through 500 random moves from a solved board
            index = 0;
            for (Board neighbor : defaultSolvedBoard.neighbors()) {
                possibleBoards[index++] = neighbor;
            }
            defaultSolvedBoard = possibleBoards[random.nextInt(index)]; //picks a random move by generating an integer between 0 to the # of neighbors and iterates again
        }
        createPanel(defaultSolvedBoard);
    }//GEN-LAST:event_createRandomButtonActionPerformed

    private void solveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveButtonActionPerformed
        Board inputBoard = createBoard(gridValues);    //creates board from the current grid values from the display panel
        long startTime = System.currentTimeMillis();    
        solve = new Solver(inputBoard); //solves board --> also determines if unsolvable
        long timeElapsed = System.currentTimeMillis() - startTime;  //duration to compute solution

        if (!solve.isSolvable()) {
            pushOutput("The current board is not solvable");
            showSolutionButton.setEnabled(false);  
        }else {
            pushOutput("Solved!","Time Elapsed: " + timeElapsed + " ms","Number of Moves: " + solve.moves(), "Solution Depth: " + solve.getSolutionDepth(), "Number of Observed Boards: " + solve.numObservedGraphs);
            showSolutionButton.setEnabled(true);
        }
        initialize();
    }//GEN-LAST:event_solveButtonActionPerformed

    public void showSolutionPanel(boolean val) {    //un-hide solution JTextFields when solution button pressed
        for (Component x: solutionPanel.getComponents()) { 
            x.setVisible(val);
        }
    }

    private void initialize() { //reset all panel values
        jProgressBar.setValue(0);  
        pixelsMoved=0;
        solutionStack = solve.solutionStack();
        size = gridPanel.getWidth()/dimension;
        jProgressBar.setForeground(Color.green);
        jProgressBar.setMaximum(size*solve.moves());
    }

    private void incrementProgressBar() {
        jProgressBar.setValue(jProgressBar.getValue()+1);
    }

    private void showSolutionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSolutionButtonActionPerformed
        showSolutionPanel(true);
        animate();
    }//GEN-LAST:event_showSolutionButtonActionPerformed



    private void animate() {    //start the solution replay
        switchVal();
        timer.start();
    }

    private void switchVal() {
        int[] switchVal = solutionStack.pop().getSwitchedTiles();   //retrieve the switched tiles 
        int xIndexPanelA = switchVal[0]; int yIndexPanelA = switchVal[1]; int xIndexPanelB = switchVal[2]; int yIndexPanelB = switchVal[3];

        JTextFieldA = solutionGridValues[xIndexPanelA][yIndexPanelA];  
        JTextFieldB = solutionGridValues[xIndexPanelB][yIndexPanelB];
        solutionGridValues[xIndexPanelA][yIndexPanelA] = JTextFieldB;  //switch tiles
        solutionGridValues[xIndexPanelB][yIndexPanelB] = JTextFieldA;  //switch tiles

        valY = yIndexPanelB - yIndexPanelA; //determine direction to move tiles vertically ex. if tile is switched with the below tile will be positive 1
        valX = xIndexPanelB - xIndexPanelA; //determine horizontal move direction 
    }

    public void actionPerformed(ActionEvent e) {
        JTextFieldA.setLocation(JTextFieldA.getX()+valX, JTextFieldA.getY()+valY); //updates location of JTextField 1 pixel at a time
        JTextFieldB.setLocation(JTextFieldB.getX()-valX, JTextFieldB.getY()-valY); //updates location of JTextField in the opposite direction 1 pixel at a time
        incrementProgressBar(); 
        solutionPanel.validate();
        if (pixelsMoved++ >= size) {    //check if the JTextField has moved locations by a full column/row 
            switchVal();
            pixelsMoved = 0;
        } 
    }

    private void createJTextField(String value, int x, int y, int size) {   //assign the JTextFields to display and solution panel
        JTextField input = newJTextField(value,x,y,size); //generate JTextField for the display panel
        JTextField inputClone = newJTextField(value,x,y,size);   //generate an identical JTextField for the solution panel
        gridValues[x][y] = input;   //save JTextField to a separate array from the solution JTextFields --> to implement a current feature not supported of replaying the solution as many times as a user would like
        solutionGridValues[x][y] = inputClone;  //save the clone JTextField to the solution array --> accessed in order to move the JTextFields in the solution panel
        inputClone.setEditable(false);  //prevent altering of solution values
        gridPanel.add(input);
        solutionPanel.add(inputClone);

    }

    private JTextField newJTextField(String value, int x, int y, int size) {  //initialize new JTextFields
        JTextField input = new JTextField();
        input.setSize(size,size);  
        input.setBounds(x*size, y*size, size, size);
        input.setText(value);
        input.setHorizontalAlignment((int)input.CENTER_ALIGNMENT);
        return input;
    }
    
    public boolean validBoardSize(int gridSize, int minSize, int maxSize){
        if (gridSize < 5 && gridSize > 1) return true;
        else return false;
    }
    
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables


}
