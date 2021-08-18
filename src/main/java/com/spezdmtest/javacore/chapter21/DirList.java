package com.spezdmtest.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "example";
        try (DirectoryStream<Path> dirstrm =
                     Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Каталог " + dirname);

            for(Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry,BasicFileAttributes.class);

                if(attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("     ");
                System.out.println(entry.getName(1));
            }
        }catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        }catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода вывода: " + e);
        }
    }
}
