package org.mypackage.sample;

import java.io.Serializable;
import java.util.Date;

/**
 * 現在日時や占いの結果の情報を持ちまわる Javabeans
 */
public class ResultData implements Serializable {

    // 変数の宣言
    private Date d;
    private String luck;

    // コンストラクタを呼ぶ
    public ResultData() {
    }

    // 現在時刻
    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    // 引いたおみくじの中身
    public String getLuck() {
        return luck;
    }

    void setLuck(String luck) {
        this.luck = luck;
    }
}
