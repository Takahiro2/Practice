package org.mypackage;

import java.util.*;

public abstract class Human {

    public abstract int open();

    public abstract void setCard(ArrayList<Integer> setCard);

    public abstract boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<>();
}
