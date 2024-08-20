package com.example.java.java1.intermediate.object1.equals;

import java.util.Objects;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.object1.equals
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-20         lhd
 */
public class Item {
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public boolean equals(Object o) {
        Item item = (Item) o;
        return itemName.equals(item.getItemName());
    }

}
