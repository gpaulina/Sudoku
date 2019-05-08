package sudoku;

import java.util.ArrayList;
import java.util.List;

public abstract class Verifiable {
    private List<sudoku.SudokuField> fields;
    public Verifiable(final List<sudoku.SudokuField> fields) {
        this.fields = fields;
    }


    boolean verify() {
        int x = 0;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (fields.get(i).getFieldValue() == j) {
                    x++;
                }
            }
            if (x == 1) {
                return true;
            }
//            x = 0;
        }
        return false;
    }

    boolean containsInItself(int x) {
        for (int i = 0; i < 9; i++) {
            if (fields.get(i).getFieldValue() == x) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> getFields() {
        List<Integer> valueList = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            valueList.add(fields.get(i).getFieldValue());
        }

        return valueList;
    }

}
