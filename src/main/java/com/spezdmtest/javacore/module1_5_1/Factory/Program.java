package com.spezdmtest.javacore.module1_5_1.Factory;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpecialty("php");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpecialty(String speciality) {
        if(speciality.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        }else if(speciality.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        }else if(speciality.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else {
            throw new RuntimeException(speciality + " is unknown speciality. ");
        }
    }
}
