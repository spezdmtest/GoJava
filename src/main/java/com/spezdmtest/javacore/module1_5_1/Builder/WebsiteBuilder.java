package com.spezdmtest.javacore.module1_5_1.Builder;

public abstract class WebsiteBuilder {
    Website website;

    void createWebsite() {
        website = new Website();
    }
    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    Website getWebsite() {
        return website;
    }
}
