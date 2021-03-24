package com.ardnn.tugas3;

import java.util.ArrayList;

public class ProgrammingLanguagesData {
    private static String[][] datas = {
            // name, creater, desc
            {
                    "Java",
                    "James Gosling",
                    "Java is one of the world's most widely used computer language. Java is a simple, general-purpose, object-oriented, interpreted, robust, secure, architecture-neutral, portable, high-performance, multithreaded computer language. It is intended to let application developers \"write once, run anywhere\" (WORA), meaning that code that runs on one platform does not need to be recompiled to run on another. Java technology is both a programming language and a platform.\n" +
                            "\n" +
                            "Java is a high level, robust, secured and object-oriented programming language. And any hardware or software environment in which a program runs, is known as a platform. Since Java has its own runtime environment (JRE) and API, it is called platform.\n" +
                            "\n" +
                            "In the Java programming language, all source code is first written in plain text files ending with the .java extension. Those source files are then compiled into .class files by the javac compiler. A .class file does not contain code that is native to your processor; it instead contains bytecodes — the machine language of the Java Virtual Machine1 (Java VM). The java launcher tool then runs your application with an instance of the Java Virtual Machine.\n" +
                            "\n" +
                            "Because the Java VM is available on many different operating systems, the same .class files are capable of running on Microsoft Windows, the Solaris™ Operating System (Solaris OS), Linux, or Mac OS. Through the Java VM, the same application is capable of running on multiple platforms."
            },
            {
                    "Python",
                    "Guido van Rossum",
                    "Random description...."
            },
            {
                    "JavaScript",
                    "Brendan Eich",
                    "Random description...."
            },
            {
                    "C",
                    "Dennis Ritchie",
                    "Random description...."
            },
            {
                    "C++",
                    "Bjarne Stroustrup",
                    "Random description...."
            },
            {
                    "C#",
                    "Microsoft Corporation",
                    "Random description...."
            },
            {
                    "Kotlin",
                    "JetBrains",
                    "Random description...."
            },
            {
                    "Dart",
                    "Lars Bak",
                    "Random description...."
            },
            {
                    "PHP",
                    "Rasmus Lerdorf",
                    "Random description...."
            }
    };

    private static int[] dataImages = {
        R.drawable.java,
        R.drawable.python,
        R.drawable.javascript,
        R.drawable.c,
        R.drawable.cpp,
        R.drawable.csharp,
        R.drawable.kotlin,
        R.drawable.dart,
        R.drawable.php,
    };

    static ArrayList<ProgrammingLanguage> getListData() {
        ArrayList<ProgrammingLanguage> listData = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            String name = datas[i][0];
            String creator = datas[i][1];
            String desc = datas[i][2];
            int image = dataImages[i];

            ProgrammingLanguage data = new ProgrammingLanguage(name, creator, desc, image);
            listData.add(data);
        }
        return listData;
    }
}
