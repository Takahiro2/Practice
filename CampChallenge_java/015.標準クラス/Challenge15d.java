
package org.mypackage;

import static java.lang.System.out;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


class fromto {
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        Date dateTo = null;
        Date dateFrom = null;
        
        dateTo = sdf.parse("2015年12月31日 23時59分59秒");
        dateFrom = sdf.parse("2015年01月01日 00時00分00秒");
        
        long dateToTime = dateTo.getTime();
        long dateFromTime = dateFrom.getTime();
        
        long To = ( dateToTime - dateFromTime);

        out.println(To);
    }
}
