
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class sample {
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        Date day = sdf.parse("2016/1/1 0:0:0");
        System.out.println(day);
    }
}