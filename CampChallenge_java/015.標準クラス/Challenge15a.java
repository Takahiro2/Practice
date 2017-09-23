
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class sample {
    public static void main(String[] args) throws ParseException {
        
        // データ形式を所定のフォーマットにする為のsdfを作成
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        // 2016年1月1日　0時0分0秒をフォーマット形式にしてdayに収納
        Date day = sdf.parse("2016/1/1 0:0:0");
        
        // 画面に表示
        System.out.println(day);
        
    }
}