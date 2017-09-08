
import java.io.*;

public class fileReading {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Fileオープン
        File fp = new File("task.txt");
        // FileReader作成
        FileReader fr = new FileReader(fp);
        // BufferReader作成
        BufferedReader br = new BufferedReader(fr);
        // 1行読み出し
        System.out.print(br.readLine());
    }
}
