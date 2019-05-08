package sudoku;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver{
    private static final int EMPTY = 0;
    public boolean solve(SudokuBoard NewBoard){
        Random rand = new Random();
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column++){
                if (NewBoard.get(row,column) == EMPTY) {
                    for(int number=1;number<=9;number++){
                        number = rand.nextInt(9)+1;
                        if(NewBoard.isAllowed(row,column,number)){
                            NewBoard.set(row,column,number);
                            if(solve(NewBoard)){
                                return true;
                            }
                            else{
                                NewBoard.set(row,column,EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

}
