package sudoku;

import java.io.IOException;

public class SudokuBoardDaoFactory extends SudokuBoardDao {
    Dao GetFileDao(String fileName){
        SudokuBoardDao x = new SudokuBoardDao(fileName);
        return  x;
    };
}
