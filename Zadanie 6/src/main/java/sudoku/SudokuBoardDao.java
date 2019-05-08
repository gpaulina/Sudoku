package sudoku;

import java.io.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SudokuBoardDao implements Dao<String>, AutoCloseable{
    public void close() throws Exception {
        System.out.println("Closing!");
    }
    SudokuBoardDao(){};
    private String fileName;

    SudokuBoardDao(String fileName){
        this.fileName=fileName;
    };

    public String read(){
        String contents="";
        try
        {
            contents = new String(Files.readAllBytes(Paths.get(fileName)));
        }catch (IOException x)
        {
            System.out.println(x);
        }
        return contents;
    };
   public boolean write(String board){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(board);
            writer.close();
            return true;
        }catch (IOException x)
        {
            System.out.println(x);
            return false;
        }
   };
}
