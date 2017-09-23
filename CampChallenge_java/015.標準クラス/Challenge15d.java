
package org.mypackage;

import static java.lang.System.out;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


class fromto {
    
    public static void main(String[] args) throws ParseException {
        
        // フォーマットを作成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        // 変数の宣言
        Date dateTo = null;
        Date dateFrom = null;
        
        // 以下の日時を収納
        dateTo = sdf.parse("2015年12月31日 23時59分59秒");
        dateFrom = sdf.parse("2015年01月01日 00時00分00秒");
        
        // ミリ秒形式に変換
        long dateToTime = dateTo.getTime();
        long dateFromTime = dateFrom.getTime();
        
        // dateFrom から dateTo までの時間を TO に収納
        long To = ( dateToTime - dateFromTime);

        // 画面に To を出力
        out.println(To);
    }
}
