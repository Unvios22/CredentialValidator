package com.company;

public class Pesel {

    private int[] peselArray;
    private boolean isValid;
    private int month;
    private int year;
    private int day;
    private String sex;

    Pesel(String input) {
        tryParseInt(input);
        peselArray = parsePeselToIntArray(input);
    }

    public static boolean tryParseInt(String value) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private int[] parsePeselToIntArray(String input) {
        String[] inputArray = input.split("");
        peselArray = new int[inputArray.length];

        for (int i = 0; i < peselArray.length; i++) {
            peselArray[i] = Integer.parseInt(inputArray[i]);
        }
        return peselArray;
    }


    public int[] getPeselArray() {
        return peselArray;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public String getSex() {
        return sex;
    }


    public void setPeselArray(int[] peselArray) {
        this.peselArray = peselArray;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}









