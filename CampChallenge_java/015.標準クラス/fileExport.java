
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class fileExport {
    public static void main(String[] args) throws IOException {
        // ファイルオープン 
        File fp = new File("task.txt");
        
        // FileWriter作成
        FileWriter fw = new FileWriter(fp);
        // 書き込み
        fw.write("私の名前は渡邊です。");
        fw.write("よろしくお願いします。");
        
        // クローズ
        fw.close();
    }
}
