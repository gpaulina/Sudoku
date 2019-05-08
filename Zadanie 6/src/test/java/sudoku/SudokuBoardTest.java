package sudoku;//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.AssertThrows.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    void Verifiable() {

        SudokuBoard sudoku = new SudokuBoard();
        sudoku.randomBoard();
        sudoku.display();
        System.out.print("columns:\n");
        for(int i=0;i<9;i++){
            System.out.print(sudoku.getColumn(i).getFields());
            System.out.print("\n");
        }
        System.out.print("rows:\n");
        for(int i=0;i<9;i++){
        System.out.print(sudoku.getRow(i).getFields());
        System.out.print("\n");
        }
        System.out.print("boxes:\n");
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku.getBox(i, j).getFields());
                System.out.print("\n");
            }
        }
    }

    @Test
    void fillBoardCheck() {


        SudokuBoard sudoku = new SudokuBoard();

        sudoku.display();
        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
        sudoku.display();
        assertEquals(true,sudoku.checkBoard());
    }

    @Test
    void differentBoardCheck() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();

        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
        NewSolver.solve(sudoku2);

        sudoku.display();
        sudoku2.display();
        assertNotEquals(sudoku,sudoku2);
    }

    @Test
    void toStringCheck(){
        SudokuBoard sudoku = new SudokuBoard();
        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
        sudoku.display();
        System.out.print(sudoku);
    }

    @Test
    void hashCodeCheck(){
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
        NewSolver.solve(sudoku2);
        assertNotEquals(sudoku.hashCode(),sudoku2.hashCode());
    }
    @Test
    void equalsCheck(){
        SudokuBoard sudoku = new SudokuBoard();
        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
        assertEquals(true,sudoku.equals(sudoku));
    }
    @Test
    void DaoWriteCheck(){
        SudokuBoard sudoku = new SudokuBoard();
        SudokuSolver NewSolver = new BacktrackingSudokuSolver();
        NewSolver.solve(sudoku);
      SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
      Dao x = factory.GetFileDao("F:\\Moje\\Studia\\Komponentówka\\plikDoZadania\\plik.txt");
      x.write(sudoku.toString());
    }
    @Test
    void DaoReadCheck(){
        SudokuBoard sudoku = new SudokuBoard();
        String st="";
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao x = factory.GetFileDao("F:\\Moje\\Studia\\Komponentówka\\plikDoZadania\\plik.txt");
        st = x.read().toString();
        //x.read();
        int pom = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku.set(i,j,Character.getNumericValue(st.charAt(pom)));
                pom++;
            }
        }
        sudoku.display();
    }
}