import java.io.PrintWriter;
// クラスの作成
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
// クラスの継承    
}class Human2 extends Human{
    public void Delete(){
        this.name = "";
        this.height = 0;
    }
}
