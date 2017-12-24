package com.company;

public class Main {

    private static String input1 = "44051401458";
    private static String input2 = "66010230802";
    private static String input3 = "unvios22@gmail.com";
    private static String input4 = "kajetan.jozwiak@microsoft.wsei.edu.pl";

    public static void main(String[] args) {

        Pesel pesel1 = new Pesel(input1);
        Pesel pesel2 = new Pesel(input2);
        PeselValidator validator = new PeselValidator();
        validator.validatePesel(pesel1);
        validator.validatePesel(pesel2);
        EmailValidator emailValidator = new EmailValidator();


        System.out.println("PESEL 1");
        System.out.println("Is PESEL valid: " + pesel1.isValid());

        if (pesel1.isValid()) {
            System.out.println("Birthdate: " + pesel1.getYear() + "." + pesel1.getMonth() + "." + pesel1.getDay() + "\nSex: " + pesel1.getSex());
        }

        System.out.println("PESEL 2");
        System.out.println("Is PESEL valid: " + pesel2.isValid());

        if (pesel2.isValid()) {
            System.out.println("Birthdate: " + pesel2.getYear() + "." + pesel2.getMonth() + "." + pesel2.getDay() + "\nSex: " + pesel2.getSex());
        }

        System.out.println(emailValidator.validateEmail(input3));
        System.out.println(emailValidator.validateEmail(input4));
    }
}




