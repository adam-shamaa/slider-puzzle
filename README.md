## Slider Puzzle Solver

### Table of Contents
1. [Motivation](#Motivation)
2. [Features](#Features)
3. [Screenshots](#Screenshots)
4. [Background](#Background)
5. [How it works](#How-it-works)
6. [Optimizations](#Optimizations)
7. [Installation/Contribution](#Can-I-contribute-or-try-it-out?)

### Motivation
Like a few of my other projects published on GitHub, I started working on this project while learning about data structures and algorithms <sup>[[1]](#1)</sup>. Part 2 of the referenced course, dives into graph theory including topics such as spanning trees, tries, max/min flow applications and a lot of other good stuff.   

Learning about the applications of algorithims have been extremly interesting and this was a great way to practice it's implementation into a simple application. 


### The Good Stuff
I'll briefly introduce the functionality behind this project, including the backend such as the algorithims implemented and how everything works.

#### Features
- Graphical User Interface
- Statistics 
   - _Minimum number of moves_ required to solve the board
   - _Time taken_ to solve the board
   - _Number of boards_ observed by the algorithim
   - _Depth of the graph_ produced by the algorithim
- Customizable Board Size
- Input Custom or Random Boards
- Detection of Unsolvable Boards
- Playback a step by step solution

#### Screenshots
![Slider Puzzle Demo](https://user-images.githubusercontent.com/61364811/103111398-a1a57000-461a-11eb-87f3-89ba1089c6b3.gif)

#### Background
To solve a board, there are no clear-cut paths except trying...   

At first glance, this may seem like every single combination must be tried until a _solved board_  is reached. But, this is quite resource intensive... 

In any given board, there are a minimum of 2 and maximum of 4 possible moves depending on where the open space is located.  To help illustrate check out the image below:

In a nutshell, this is recursive and the number of boards observed would grow exponentially at each level. (I've included a more detailed section about the analysis of the runtime for those interested.)

_Fortunately we can do better!_ 

Instead of trying every possible combination, techniques can be used to compare available moves, then selecting the most promising move first.

#### How it works

##### Data Structure
A _minimum priority queue_ is the backbone of this implementation, this data structure is optimal for fast inserts and fast removals of the lowest score board. I won't go into too much detail about the background of this data structure as there are many other great resources out there.

##### Scoring Method
Two factors for each board are observed to assign a score that determines how close a board is to its solved state. The first factor is the _Hamming Distance_ followed by the _Manhattan Distance_. Although each factor could be used alone in the algorithim, combining both factors into a single score has produced a much higher efficiency. 

At each level in the algorithim, the board with the lowest score is taken from the minimum priority queue. Then, it is checked to see if it is solved. If so, we're done! Otherwise, the possible moves from the taken board are added to the priority queue and the process repeats itself.

###### Hamming Distance
A hamming distance is the number of misplaced tiles on a given board. 

For example, a perfectly solved board would have a hamming distance of 0, a board with only 2 misplaced tiles would have a hamming distance of 2.

###### Manhattan Distance
A manhattan distance looks at each tile on the board, then calculates the horizontal and vertical distance away from it's correct location. 

For example, a "1" tile that is located in the second row and second column would have a manhattan distance of 2 since it is one column away from column 1, and one row away from row 1. This is done for each tile on the board and added into a single sum to compute the manhattan distance.

##### That's it!
These two factors are iteratively used to choose the most promising move. Each board is then observed, if it is solved then we can return the solution otherwise the next possible moves are added onto the queue.

To playback the optimal solution, the solved board has a reference to it's previous board and so on until the original board is reached. This is then reversed and played back to the user using transitions between each state.

###### Optimizations
The most impactful optimization was making sure an already explored move was not eventually added back onto the queue. The algorithim would still eventually solve the board, but this technique reduces the number of observed boards and the time required to solve a board.

_What would happen if an unsolveable board is used?_
Well, the algorithim would run indefintely...  

This was addressed as a solveable board can be made unsolvable by switching any two tiles that aren't next to an open space. Likewise, any unsolvable board can be made solveable using the same method.

To overcome the program from running indefintely, two boards are observed in the algorithim. The original board _and_ its copy which has a pair of tiles switched.  This means that if the twin is solved first, the board is unsolvable and the program can terminate.

#### Can I contribute or try it out?
Of course!  
* Fork the repository
* Open up your favorite IDE 
* Compile and run "GUI.java" to start the application
* Feel free to submit a pull request with any optimizations or suggestions!

<a id="1">[1]</a> I'd highly recommend checking out [Princeton's Algorithms](https://www.coursera.org/learn/algorithms-part2) courses in combination with their textbook, they are very well versed! 