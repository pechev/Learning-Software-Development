package com.company;

import com.company.loggers.Logger;

import java.util.ArrayList;

public class Board {

    private final ArrayList<BoardItem> items;

    public Board() {
        items = new ArrayList<>();
    }

    public void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException("Item already in the list");
        }
        items.add(item);
    }

    public int totalItems() {
        return items.size();
    }

    public void displayHistory(Logger logger) { // accept an Logger type
        for (BoardItem item : items) {
            // call the log() method and give it a string. (the viewHistory() method returns a String)
            logger.log(item.getHistory());
        }
    }

}
