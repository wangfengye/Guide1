package com.ascend.wangfeng.guide;

/**
 * Created by fengye on 2017/7/19.
 * email 1040441325@qq.com
 */

public class Scenery {
    private int img;
    private String title;
    private String event;
    private String restaurant;

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getEvent() {
        return event;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Scenery(int img, String title, String event, String restaurant) {
        this.img = img;
        this.title = title;
        this.event = event;
        this.restaurant = restaurant;
    }
}
