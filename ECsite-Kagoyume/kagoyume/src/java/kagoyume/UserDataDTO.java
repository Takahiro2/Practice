package kagoyume;

import java.sql.Timestamp;

public class UserDataDTO {

    // 変数の宣言
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int deleteFlg;
    private String session_id;
    private int loginFlg;

    // UserID() ユーザー ID情報
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Name() 名前 情報
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Password() パスワード 情報
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Mail() メールアドレス 情報
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Address() 住所 情報
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Total() 総購入金額 情報
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // Date() ToDo
    public Timestamp getNewDate() {
        return newDate;
    }

    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

    // getDeleteFlg() ToDo
    public int getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(int deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    // Session_ID() ToDo
    public String getSession_ID() {
        return session_id;
    }

    public void setSession_ID(String session_id) {
        this.session_id = session_id;
    }

    // LoginFlg() ToDo
    public int LoginFlg() {
        return loginFlg;
    }
    
    public void setLoginFlg(int loginFlg) {
        this.loginFlg = loginFlg;
    }
}
