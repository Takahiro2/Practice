/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.util.*;
public class User extends Human{
    @Override
    public int open(){ //カードの合計値
        int total = 0;
        for( int i = 0 ; i < myCards.size() ; i++ ){
            total += myCards.get(i);
        }
            return total;
    }@Override
    public boolean checkSum(){ // open12以下でhitする
        int checkTotal = open();
        return checkTotal <= 12;
    }@Override
    public void setCard(ArrayList<Integer>dealcards){
        for( int i = 0 ; i < dealcards.size() ; i++ ){
        myCards.add(dealcards.get(i));
        }
    }
}
