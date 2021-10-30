package com.spezdmtest.javacore.module1_5.Builder;

public class VisitCardWebSiteBuilder extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("Visit Card");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }
    @Override

    void buildPrice() {
        website.setPrice(500);
    }
}
