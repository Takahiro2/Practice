package org.mypackage;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class Sample {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

        Date d = sdf.parse("2016年11月04日 10時:00分:00秒");

        System.out.print(sdf.format(d));
    }
}
