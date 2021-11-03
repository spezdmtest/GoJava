package com.spezdmtest.javacore.module1_5_3.Iterator;

public class JavaDeveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Java","Spring","Hibernate","Maven","PostgreSQL"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Dmitry Ostapenko", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("Skills: ");

        while(iterator.hasNext()) {
            System.out.print(iterator.next().toString() + " ");
        }
    }
}
