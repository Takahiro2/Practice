package org.mypackage;

import java.util.*;

public class Dealer extends Human {

    public ArrayList<Integer> cards = new ArrayList<>(); // 山札cardsの作成

    Dealer() {
        for (int mark = 1; mark <= 4; mark++) {
            for (int num = 1; num <= 13; num++) {
                if (num <= 10) {
                    cards.add(num);
                } else {
                    cards.add(10);
                }
            }
        }
    }

    //乱数randを作成
    Random rand = new Random();

    public ArrayList<Integer> deal() { // 配ったカードdealの作成
        //ArreyList dealcardsを作成
        ArrayList<Integer> dealcards = new ArrayList<>();

        int draw1 = rand.nextInt(cards.size()); //ドロー1枚目
        dealcards.add(cards.get(draw1));
        cards.remove(draw1);

        int draw2 = rand.nextInt(cards.size()); //ドロー2枚目
        dealcards.add(cards.get(draw2));
        cards.remove(draw2);
        return dealcards;
    }

    public ArrayList<Integer> hit() { // 追加ドローhitの作成
        ArrayList<Integer> hitcards = new ArrayList<>();
        int draw3 = rand.nextInt(cards.size());

        hitcards.add(cards.get(draw3));
        cards.remove(draw3);
        return hitcards;
    }

    @Override
    public int open() { //カードの合計値
        int total = 0;
        for (int i = 0; i < myCards.size(); i++) {
            total += myCards.get(i);
        }
        return total;
    }

    @Override
    public boolean checkSum() { // open12以下でhitする
        int checkTotal = open();
        return checkTotal <= 12;
    }

    @Override
    public void setCard(ArrayList<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }
}
