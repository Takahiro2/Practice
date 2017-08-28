package jums;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

public class UserDataBeans implements Serializable {

    public UserDataBeans() {
    }

    private String name = "";

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    
    private String year = "";

    public String getYear() {
        return this.year;
    }

    public void setYear(String y) {
        this.year = y;
    }

    
    private String month = "";

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String m) {
        this.month = m;
    }

    
    private String day = "";

    public String getDay() {
        return this.day;
    }

    public void setDay(String d) {
        this.day = d;
    }

    
    private int type = 0;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    
    private String tell = "";

    public String getTell() {
        return this.tell;
    }

    public void setTell(String t) {
        this.tell = t;
    }

    
    private String comment = "";

    public String getComment() {
        return this.comment;
    }

    public void setComment(String c) {
        this.comment = c;
    }
}
