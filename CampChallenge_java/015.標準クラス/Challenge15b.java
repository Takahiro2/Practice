
import java.util.Date;
import java.text.SimpleDateFormat;

class Sample {

    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

        System.out.print(sdf.format(now));
    }
}
