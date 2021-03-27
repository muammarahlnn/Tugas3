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
                    "Python is a high-level, general-purpose and a very popular programming language. Python programming language (latest Python 3) is being used in web development, Machine Learning applications, along with all cutting edge technology in Software Industry. Python Programming Language is very well suited for Beginners, also for experienced programmers with other programming languages like C++ and Java."
                    + "\n\n" +
                    "This specially designed Python tutorial will help you learn Python Programming Language in most efficient way, with the topics from basics to advanced (like Web-scraping, Django, Deep-Learning, etc.) with examples.\n"
            },
            {
                    "JavaScript",
                    "Brendan Eich",
                    "JavaScript is a scripting or programming language that allows you to implement complex features on web pages — every time a web page does more than just sit there and display static information for you to look at — displaying timely content updates, interactive maps, animated 2D/3D graphics, scrolling video jukeboxes, etc. — you can bet that JavaScript is probably involved. It is the third layer of the layer cake of standard web technologies, two of which (HTML and CSS) we have covered in much more detail in other parts of the Learning Area."
                    + "\n\n" +
                    "The core client-side JavaScript language consists of some common programming features that allow you to do things like:\n" +
                            "\n" +
                            "    Store useful values inside variables. In the above example for instance, we ask for a new name to be entered then store that name in a variable called name.\n" +
                            "    Operations on pieces of text (known as \"strings\" in programming). In the above example we take the string \"Player 1: \" and join it to the name variable to create the complete text label, e.g. ''Player 1: Chris\".\n" +
                            "    Running code in response to certain events occurring on a web page. We used a click event in our example above to detect when the button is clicked and then run the code that updates the text label.\n" +
                            "    And much more!\n" +
                            "\n" +
                            "What is even more exciting however is the functionality built on top of the client-side JavaScript language. So-called Application Programming Interfaces (APIs) provide you with extra superpowers to use in your JavaScript code.\n" +
                            "\n" +
                            "APIs are ready-made sets of code building blocks that allow a developer to implement programs that would otherwise be hard or impossible to implement. They do the same thing for programming that ready-made furniture kits do for home building — it is much easier to take ready-cut panels and screw them together to make a bookshelf than it is to work out the design yourself, go and find the correct wood, cut all the panels to the right size and shape, find the correct-sized screws, and then put them together to make a bookshelf."
            },
            {
                    "C",
                    "Dennis Ritchie",
                    "C programming is a general-purpose, procedural, imperative computer programming language developed in 1972 by Dennis M. Ritchie at the Bell Telephone Laboratories to develop the UNIX operating system. C is the most widely used computer language. It keeps fluctuating at number one scale of popularity along with Java programming language, which is also equally popular and most widely used among modern software programmers."
                    + "\n\n" +
                    "C programming language is a MUST for students and working professionals to become a great Software Engineer specially when they are working in Software Development Domain. I will list down some of the key advantages of learning C Programming:\n" +
                            "\n" +
                            "    Easy to learn\n" +
                            "\n" +
                            "    Structured language\n" +
                            "\n" +
                            "    It produces efficient programs\n" +
                            "\n" +
                            "    It can handle low-level activities\n" +
                            "\n" +
                            "    It can be compiled on a variety of computer platforms\n"
                    + "C was initially used for system development work, particularly the programs that make-up the operating system. C was adopted as a system development language because it produces code that runs nearly as fast as the code written in assembly language. Some examples of the use of C are -\n" +
                            "\n" +
                            "    Operating Systems\n" +
                            "\n" +
                            "    Language Compilers\n" +
                            "\n" +
                            "    Assemblers\n" +
                            "\n" +
                            "    Text Editors\n" +
                            "\n" +
                            "    Print Spoolers\n" +
                            "\n" +
                            "    Network Drivers\n" +
                            "\n" +
                            "    Modern Programs\n" +
                            "\n" +
                            "    Databases\n" +
                            "\n" +
                            "    Language Interpreters\n" +
                            "\n" +
                            "    Utilities\n" +
                            "\n"
            },
            {
                    "C++",
                    "Bjarne Stroustrup",
                    "C++ is a middle-level programming language developed by Bjarne Stroustrup starting in 1979 at Bell Labs. C++ runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX. This C++ tutorial adopts a simple and practical approach to describe the concepts of C++ for beginners to advanded software engineers.\n" +
                    "Why to Learn C++\n" +
                    "\n" +
                    "C++ is a MUST for students and working professionals to become a great Software Engineer. I will list down some of the key advantages of learning C++:\n" +
                    "\n" +
                    "    C++ is very close to hardware, so you get a chance to work at a low level which gives you lot of control in terms of memory management, better performance and finally a robust software development.\n" +
                    "\n" +
                    "    C++ programming gives you a clear understanding about Object Oriented Programming. You will understand low level implementation of polymorphism when you will implement virtual tables and virtual table pointers, or dynamic type identification.\n" +
                    "\n" +
                    "    C++ is one of the every green programming languages and loved by millions of software developers. If you are a great C++ programmer then you will never sit without work and more importantly you will get highly paid for your work.\n" +
                    "\n" +
                    "    C++ is the most widely used programming languages in application and system programming. So you can choose your area of interest of software development.\n" +
                    "\n" +
                    "    C++ really teaches you the difference between compiler, linker and loader, different data types, storage classes, variable types their scopes etc.\n" +
                    "\n" +
                    "There are 1000s of good reasons to learn C++ Programming. But one thing for sure, to learn any programming language, not only C++, you just need to code, and code and finally code until you become expert."
            },
            {
                    "C#",
                    "Microsoft Corporation",
                    "C# is a simple, modern, general-purpose, object-oriented programming language developed by Microsoft within its .NET initiative led by Anders Hejlsberg. This tutorial will teach you basic C# programming and will also take you through various advanced concepts related to C# programming language."
                    + "\n\n" +
                    "C# (C Sharp) is one of the most popular programming languages which is widely used for building Windows applications, mobile applications, and games. This course is taught in a practical GOAL oriented way to learn C# programming. It is recommended for you to practice the code assignments given after each C Sharp tutorial to learn C Sharp fast and easily."
                    + "\n\n" +
                    "C# (C Sharp) is a general purpose, multi-paradigm programming language developed by Microsoft that runs on the .NET Framework. C# is widely used for building mobile applications, games and windows applications. "
            },
            {
                    "Kotlin",
                    "JetBrains",
                    "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interopzerate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise."
                    + "\n\n" +
                    "Kotlin is a general purpose, free, open source, statically typed “pragmatic” programming language initially designed for the JVM (Java Virtual Machine) and Android that combines object-oriented and functional programming features. It is focused on interoperability, safety, clarity, and tooling support. Versions of Kotlin targeting JavaScript ES5.1 and native code (using LLVM) for a number of processors are in production as well.\n" +
                    "\n" +
                    "Kotlin originated at JetBrains, the company behind IntelliJ IDEA, in 2010, and has been open source since 2012. The Kotlin team currently has more than 90 full-time members from JetBrains, and the Kotlin project on GitHub has more than 300 contributors. JetBrains uses Kotlin in many of its products including its flagship IntelliJ IDEA."
            },
            {
                    "Dart",
                    "Lars Bak",
                    "Dart is an open source language developed in Google with the aim of allowing developers to use an object-oriented language with static type analysis. Since the first stable release in 2011, Dart has changed quite a bit, both in the language itself and in its primary goals. With version 2.0, Dart's type system went from optional to static, and since its arrival, Flutter (we'll explain later) has become the main target of the language."
                    + "\n\n" +
                    "Unlike many languages, Dart was designed with the goal of making the development process as comfortable and fast as possible for developers. So it comes with a fairly extensive set of built-in tools such as its own package manager, various compilers / transpilers, a parser and formatter. Also, the Dart virtual machine and Just-in-Time build make code changes immediately executable.\n" +
                    "Once in production, the code can be compiled in native language, so no special environment is required to run. In case of web development, Dart is transpiled into JavaScript.\n" +
                    "\n" +
                    "As for the syntax, Dart's is very similar to languages like JavaScript, Java and C ++, so learning Dart by knowing one of these languages is a matter of hours.\n" +
                    "In addition, Dart has great support for asynchrony, and working with generators and iterables is extremely easy."
            },
            {
                    "PHP",
                    "Rasmus Lerdorf",
                    "PHP (recursive acronym for PHP: Hypertext Preprocessor) is a widely-used open source general-purpose scripting language that is especially suited for web development and can be embedded into HTML. "
                    + "\n\n" +
                    " Instead of lots of commands to output HTML (as seen in C or Perl), PHP pages contain HTML with embedded code that does \"something\" (in this case, output \"Hi, I'm a PHP script!\"). The PHP code is enclosed in special start and end processing instructions <?php and ?> that allow you to jump into and out of \"PHP mode.\"\n" +
                    "\n" +
                    "What distinguishes PHP from something like client-side JavaScript is that the code is executed on the server, generating HTML which is then sent to the client. The client would receive the results of running that script, but would not know what the underlying code was. You can even configure your web server to process all your HTML files with PHP, and then there's really no way that users can tell what you have up your sleeve.\n" +
                    "\n" +
                    "The best things in using PHP are that it is extremely simple for a newcomer, but offers many advanced features for a professional programmer. Don't be afraid reading the long list of PHP's features. You can jump in, in a short time, and start writing simple scripts in a few hours.\n" +
                    "\n" +
                    "Although PHP's development is focused on server-side scripting, you can do much more with it. Read on, and see more in the What can PHP do? section, or go right to the introductory tutorial if you are only interested in web programming. "
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
