package KnightTour;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Driver {

    final static int rowL = 70;//number of rows for chess board
    final static int colL = 70;//number of cols for chess board
    static MyStack<Location> stack = new MyStack(); //store moves in order (backtrack capability)

    //list of exhausted locations for each location.  Must use method convertLocToIndex to find a Locations proper index
    static ArrayList<ArrayList<Location>> exhausted = new ArrayList<ArrayList<Location>>(rowL*colL);
    static int board[][] = new int[rowL][colL];//2d array used to store the order of moves
    static boolean visited[][] = new boolean[rowL][colL];//2d array used to store what locations have been used
    static Location startLoc;
    static long startTime, endTime;
    static int numOfLoops = 0;
    static int numOfIfs = 0;

    public static void main(String[] args) {

        System.out.println("START");
        initExhausted();
        ArrayList<Location> currentPossible;
        obtainStartLoc();
        System.out.println("Start Loc is " + startLoc);
        startTime = System.currentTimeMillis();

        stack.push(startLoc);
        Location source = startLoc;
        int i = 1;
        int count = 0, row = startLoc.getRow(), col = startLoc.getCol();

        while(stack.size() != rowL * colL && stack.size() != 0) {
            numOfLoops++;
            row = source.getRow();
            col = source.getCol();
            board[row][col] = i;
            visited[row][col] = true;
           /*printExhaustedList(source);
           printPossibleMoveLocations(source,getPossibleMoves(source));
           printBoard();
           printVisited();*/

            Location dest = getBestMove(source,getPossibleMoves(source));
            if(dest == null) {
                count++;
                numOfIfs++;
                board[row][col] = 0;
                visited[row][col] = false;
                clearExhausted(source);
                stack.pop();
                source = stack.peek();
                i--;
            }
            else {
                addToExhausted(source,dest);
                source = dest;
                stack.push(dest);
                i++;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time (ms): " + (endTime-startTime));
        System.out.println("Num of Loops: " + numOfLoops);
        System.out.println("Num of Ifs: " + numOfIfs);

        if(i == rowL * colL) {
            row = source.getRow();
            col = source.getCol();
            board[row][col] = i;
            visited[row][col] = true;
            System.out.println("Solution found from " + startLoc + " after " + (1+ count) + " attempt(s).");
            printExhaustedList(source);
            printPossibleMoveLocations(source,getPossibleMoves(source));
            printBoard();
            printVisited();
        }
        else {
            System.out.print("No solution from " + startLoc);
            System.out.print(" after " + (count + 1)+ " attempt(s).");
        }
    }

    /*
     * Printed out the exhausted list for a given Location
     */
    public static void printExhaustedList(Location loc) {
        int index = convertLocToIndex(loc);
        System.out.print("Exhausted List: ");
        ArrayList<Location> locArray = exhausted.get(index);
        for(int i = 0; i < locArray.size(); i++) {
            Location currentLoc = locArray.get(i);
            System.out.print(currentLoc + " ");
        }
        System.out.println();
    }

    /*
     * Prints out the possible move locations for a given Location
     */
    public static void printPossibleMoveLocations(Location loc, ArrayList<Location> list) {
        System.out.print("Possible Moves: ");
        for (int i = 0; i < list.size(); i++) {
            if (!inExhausted(loc, list.get(i)))
                System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    /*
     * prints out the board (numbers correspond to moves)
     */
    public static void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int a = board[i][j];
                int length = String.valueOf(a).length();
                switch(length) {
                    case 1:
                        System.out.print("    ");
                        break;
                    case 2:
                        System.out.print("   ");
                        break;
                    case 3:
                        System.out.print("  ");
                        break;
                    case 4:
                        System.out.print(" ");
                        break;
                }
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    /*
     * prints out true/false for what spaces have been visited
     */
    public static void printVisited() {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[i].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * clear out the exhausted list for a given Location
     * This needs to be done everytime a Location is removed from the Stack
     */
    public static void clearExhausted(Location loc) {
        int index = convertLocToIndex(loc);
        exhausted.get(index).clear();
    }

    /*
     * set up the exhausted list with empty exhausted lists.
     */
    public static void initExhausted() {
        for (int i = 0; i < rowL * colL; i++) {
            exhausted.add(i,new ArrayList<Location>());
        }
    }

    /*
     * is this dest Location exhausted from the source Location
     */
    public static boolean inExhausted(Location source, Location dest) {
        int index = convertLocToIndex(source);
        //ArrayList<Location> locArray = exhausted.get(index); //copy? deep clone?
        for(int i = 0; i < exhausted.get(index).size(); i++) {
            numOfLoops++;
            //if(dest.equals(exhausted.get(index).get(i)))
            if(dest.getRow() == exhausted.get(index).get(i).getRow() && dest.getCol() == exhausted.get(index).get(i).getCol()) {//dest.equals(exhausted.get(index).get(i))
                numOfIfs++;
                return true;
            }
        }
        return false;
    }

    /*
     * returns the next valid move for a given Location on a given ArrayList of possible moves
     */
    public static Location getNextMove(Location loc, ArrayList<Location> list) {
        for(int i = 0; i < list.size(); i++) {
            numOfLoops++;
            if(!(inExhausted(loc,list.get(i))) && !visited[list.get(i).getRow()][list.get(i).getCol()]) {
                numOfIfs++;
                return list.get(i);
            }
        }
        return null;
    }

    public static Location getBestMove(Location loc, ArrayList<Location> list) {
        ArrayList<Location> possibleMoves = new ArrayList();
        for(int i = 0; i < list.size(); i++) {
            numOfLoops++;
            if(!(inExhausted(loc,list.get(i))) && !visited[list.get(i).getRow()][list.get(i).getCol()]) {
                possibleMoves.add(list.get(i));
                numOfIfs++;
            }
        }
        if(possibleMoves.size() == 0) {
            numOfIfs++;
            return null;
        }

        Location minMovesLoc = possibleMoves.get(0);
        int minMoves = 1000000;

        for(int i = 0; i < possibleMoves.size(); i++) {
            numOfLoops++;
            int locCount = 0;
            Location possibleMove = possibleMoves.get(i);
            ArrayList<Location> possibleMovesForPossibleMove = getPossibleMoves(possibleMove);
            for(int j = 0; j < possibleMovesForPossibleMove.size(); j++) {
                numOfLoops++;
                if (/*!(inExhausted(possibleMove,possibleMovesForPossibleMove.get(j))) &&*/ !visited[possibleMovesForPossibleMove.get(j).getRow()][possibleMovesForPossibleMove.get(j).getCol()]) {
                    locCount++;
                    numOfIfs++;
                    //System.out.print(possibleMovesForPossibleMove.get(j));
                }
            }
            //System.out.println();
            if(locCount < minMoves && locCount != 0) {
                numOfIfs++;
                minMoves = locCount;
                minMovesLoc = possibleMove;
            }
        }
        //System.out.println("Best Move: " + minMovesLoc + " with " + minMoves + " move(s).");
        return minMovesLoc;
    }

    /*
     * converts a (row,col) to an array index for use in the exhausted list
     */
    public static int convertLocToIndex(Location loc) {
        return (loc.getRow() * rowL) + loc.getCol();
    }

    /*
     * adds a dest Location in the exhausted list for the source Location
     */
    public static void addToExhausted(Location source, Location dest) {
        int index = convertLocToIndex(source);
        exhausted.get(index).add(dest);
    }

    /*
     * is this Location a valid one
     */
    public static boolean isValid(Location loc) {
        return !(loc.getCol() > colL-1 || loc.getCol() < 0 || loc.getRow() > rowL-1 || loc.getRow() < 0);
    }

    /*
     * returns another Location for the knight to move in.  If no more possible move
     * locations exist from Location loc, then return null
     */
    public static ArrayList<Location> getPossibleMoves(Location loc) {
        ArrayList<Location> locs = new ArrayList<>();

        locs.add(new Location(loc.getRow() + 1, loc.getCol() - 2));
        locs.add(new Location(loc.getRow() + 1, loc.getCol() + 2));
        locs.add(new Location(loc.getRow() - 1, loc.getCol() - 2));
        locs.add(new Location(loc.getRow() - 1, loc.getCol() + 2));
        locs.add(new Location(loc.getRow() + 2, loc.getCol() - 1));
        locs.add(new Location(loc.getRow() + 2, loc.getCol() + 1));
        locs.add(new Location(loc.getRow() - 2, loc.getCol() + 1));
        locs.add(new Location(loc.getRow() - 2, loc.getCol() - 1));


        for (int i = locs.size() - 1; i >= 0; i--) {
            numOfLoops++;
            Location currentLoc = locs.get(i);
            if(!isValid(currentLoc)) {
                numOfIfs++;
                locs.remove(i);
            }
        }
        return locs;
    }


    /*
     * prompt for input and read in the start Location
     */
    public static void obtainStartLoc() {
        String result = JOptionPane.showInputDialog("Input starting location: (row, col)"); //1,1
        int row = Integer.parseInt(result.substring(0, result.indexOf(",")));
        int col = Integer.parseInt(result.substring(result.indexOf(",") + 1));
       /*String newResult;

       while(row + 1 > rowL || col + 1 > colL)
           newResult = JOptionPane.showInputDialog("Please enter a row and column length within the correct bounds. Input starting location: (row, col)"); //1,1
           row = Integer.parseInt(result.substring(0, result.indexOf(",")));
           col = Integer.parseInt(result.substring(result.indexOf(",") + 1));*/


        startLoc = new Location(row, col);

    }

}
