import java.io.PrintWriter;

public class Human{
    public String name = "";
    public int height = 0;
    
    public void setHuman(String name,int height){
        name = "Watanabe";
        height = 173;
    }public void print(PrintWriter pw){
        pw.print(name);
        pw.print(height);
    }
}
