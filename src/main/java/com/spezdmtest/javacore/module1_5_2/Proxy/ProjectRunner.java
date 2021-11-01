package com.spezdmtest.javacore.module1_5_2.Proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.github.com/proselytear/realProject");
        project.run();
    }
}
