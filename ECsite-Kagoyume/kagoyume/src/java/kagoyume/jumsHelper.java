package kagoyume;

public class jumsHelper {

    // topへのリンクを定数として設定
    private final String topURL = "top.jsp";

    // searchへのリンクを定数として設定
    private final String searchURL = "search.jsp";

    // itemへのリンクを定数として設定
    private final String itemURL = "item.jsp";

    // mydataへのリンクを定数として設定
    private final String mydataURL = "mydata.jsp";

    // インタンス生成
    public static jumsHelper getInstance() {
        return new jumsHelper();
    }

    // トップへのリンクを返却 home()
    public String top() {
        return "<a href=\"" + topURL + "\">トップへ戻る</a>";
    }

    // 検索結果へのリンクを返却 search()
    public String search() {
        return "<a href=\"" + searchURL + "\">検索結果へ</a>";
    }

    // 商品詳細へのリンクを返却 item()
    public String item() {
        return "<a href=\"" + itemURL + "\">商品詳細へ</a>";
    }

    // 会員情報へのリンクを返却 mydata()
    public String mydata() {
        return "<a href=\"" + mydataURL + "\">会員画面へ</a>";
    }
}
