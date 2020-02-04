package com.customdrawer.app;

public class MenuItems {

    String id;
    String itemName;
    String imgUrl;
    String type;

    //C=> Category not clickable
    //L=> Draws only separator
    //I=> Items


    public MenuItems(String id, String itemName, String imgUrl, String type) {
        this.id = id;
        this.itemName = itemName;
        this.imgUrl = imgUrl;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
