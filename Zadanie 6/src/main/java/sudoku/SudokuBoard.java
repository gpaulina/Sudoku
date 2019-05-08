package sudoku;

import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard {
    private List<List<SudokuField>> Board= Arrays.asList(new List[9]);


    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            Board.set(i, Arrays.asList(new SudokuField[9]));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.Board.get(i).set(j, new SudokuField(0));
            }
        }

    }

    public void randomBoard() {
        Random rand = new Random();
        int number;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                number = rand.nextInt(10);
                this.set(i, j, number);
            }
        }
    }

    public int get(int x, int y) {
        return Board.get(x).get(y).getFieldValue();
    }

    public void set(int x, int y, int value) {
        Board.get(x).get(y).setFieldValue(value);
    }

    public SudokuRow getRow(int y) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            fields.set(i, Board.get(y).get(i));
        }
        SudokuRow row = new SudokuRow(fields);
        return row;
    }

    public SudokuColumn getColumn(int x) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            fields.set(i, Board.get(i).get(x));
        }
        SudokuColumn column = new SudokuColumn(fields);
        return column;
    }

    public SudokuBox getBox(int rowIndex, int columnIndex) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields.set(index, Board.get(rowIndex/3*3 + i).get(columnIndex/3*3 + j));
                index++;
            }
        }
        return new SudokuBox(fields);
    }

    //sprawdzamy czy liczba moze zostac wpisana ( polaczenie warunkow wyzej)
    public boolean isAllowed(int row, int column, int number) {
        return !(getRow(row).containsInItself(number) || getColumn(column).containsInItself(number) || getBox(row, column).containsInItself(number));
    }

    //sprawdzamy czy liczba moze zostac wpisana ( polaczenie warunkow wyzej)
    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (!getRow(i).verify() && !getColumn(i).verify() && !getBox(i/3, j).verify()) return false;
            }
        }
        return true;
    }

//    public boolean solve() {
//        Random rand = new Random();
//        for (int row = 0; row < 9; row++){
//            for (int col = 0; col < 9; col++) {
//                if (this.get(row,col) == 0) {
//                    for (int number = 1; number <= 9; number++) {
//                        number = rand.nextInt(9)+1  ;
//                        if (isAllowed(row, col, number)) {
//                            this.set(row, col, number);
//                            if (solve()) {
//                                return true;
//                            } else {
//                                this.set(row, col, 0);
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public void display() {
        {
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 0 && i != 0) {
                    System.out.println("----------------------------------\n");
                }
                for (int j = 0; j < 9; j++) {
                    if (j % 3 == 0 && j != 0) {
                        System.out.print(" | ");
                    }
                    System.out.print(" " + Board.get(i).get(j).getFieldValue() + " ");

                }

                System.out.println();
            }
            System.out.println("\n\n_____________________________________\n\n");
        }
    }
    @Override
    public boolean equals(final Object obj) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (((SudokuBoard) obj).get(i, j) != get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode()*2;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(getRow(i).getFields().get(j));
            }
        }

        return result.toString();
    }

    public static void main(String[] args){}
}