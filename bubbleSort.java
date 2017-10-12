package Practice;

/**
 * バブルソート（基本交換法）のメソッド
 * @author Takahiro
 */
public class bubbleSort {

    // 今回は昇順
    public static void main(String[] args) {

        // 適当な数字を収納
        int[] figure = {95246, 6433, 624, 679, 43, 657, 410, 1};

        // 入っている数字分だけ繰り返す
        for (int i = 0; i < figure.length - 1; i++) {
            for (int j = 0; j < figure.length - i - 1; j++) {
                // 前の数字が大きい場合入れ替える
                if (figure[j] > figure[j + 1]) {
                    int box = figure[j]; // 前の数字を一次的に変数へ入れ
                    figure[j] = figure[j + 1]; // 後の数字を前に
                    figure[j + 1] = box; // 変数に入れておいた数字を後へ

                }
            }
        }

        // ソート後の結果を画面に出力
        for (int i = 0; i < figure.length; i++) {
            System.out.println(figure[i] + " ");

        }
    }
}
