
import java.util.Date;
import java.text.SimpleDateFormat;

class Sample {

    public static void main(String[] args) {
        
        // Date型変数の宣言
        Date now = new Date();
        
        // 取得した日時を以下のフォーマット形式にする為に作成 
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

        // 現在の日時を上記のフォーマット形式で画面に表示
        System.out.print(sdf.format(now));
        
    }
}
