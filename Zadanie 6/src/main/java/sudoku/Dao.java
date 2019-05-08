package sudoku;

import java.io.IOException;

public interface Dao<T> {
   public T read();
   public boolean write(T object);
}
