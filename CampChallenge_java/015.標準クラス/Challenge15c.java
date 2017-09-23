package org.mypackage;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class Sample {

    public static void main(String[] args) throws ParseException {

        // 取得したdate型データを以下のような表示にする為フォーマットを作成
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

        // 2016年11月4日 10時0分0秒 を上記のフォーマット形式で d に収納
        Date d = sdf.parse("2016年11月04日 10時:00分:00秒");

        // dを画面に表示
        System.out.print(sdf.format(d));
    }
}
