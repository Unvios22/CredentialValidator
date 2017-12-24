package com.company;

public class PeselValidate {

    private Pesel pesel;

    PeselValidate(Pesel pesel){
        this.pesel = pesel;
        if (validatePeselFormat(pesel.getPeselArray())) {
            pesel.setValid(true);
        }else pesel.setValid(false);
        returnPesel(pesel);
    }

    public boolean validatePeselFormat (int[] peselArray){

        if (peselArray.length == 11) {

            int temp =  peselArray[0] + 3 * peselArray[1] + 7 * peselArray[2]
                    + 9 * peselArray[3] +  peselArray[4] + 3 * peselArray[5]
                    + 7 * peselArray[6] + 9 * peselArray[7] +  peselArray[8]
                    + 3 * peselArray[9] +  peselArray[10];

            int check = (10 - (temp % 10)) % 10;

            if (check == 0) {

                return extractAndValidatePeselData(peselArray);
            }
        }

        return false;

    }

    private boolean extractAndValidatePeselData(int[] peselArray) {

        int day = 10* peselArray[4] + peselArray[5];

        int month = 10 * peselArray[2] + peselArray[3];

        int year = 10 * peselArray[0] + peselArray[1];

        String sex = "";

        boolean dataValidation = true;

        // extracting year value and validating month
        if (month > 80 && month < 93) {
            year += 1800;

        }else if (month > 0 && month < 13) {
            year += 1900;

        }else if (month > 20 && month < 33) {
            year += 2000;

        }else if (month > 40 && month < 53) {
            year += 2100;

        }else if (month > 60 && month < 73) {
            year += 2200;

        }else dataValidation = false;


        // extracting month value
        if (month > 80 && month < 93) {
            month -= 80;

        }else if (month > 20 && month < 33) {
            month -= 20;

        }else if (month > 40 && month < 53) {
            month -= 40;

        }else if (month > 60 && month < 73) {
            month -= 60;

        }

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // validating day value
        if (isLeapYear(year)) {months[1]++;}
        if (!(day > 0 && day <= months[month -1])){
            dataValidation = false;
        }

        // extracting sex
        if (peselArray[9] % 2 == 0){
            sex = "female";
        }

        else sex = "male";

        pesel.setDay(day);
        pesel.setMonth(month);
        pesel.setYear(year);
        pesel.setSex(sex);

        return dataValidation;

    }

    private static boolean isLeapYear (int year){
        if ((year % 4 == 0) && year % 100 != 0) {
            return true;
        }else if (year % 400 == 0) {
            return true;
        }else return false;
    }

    public Pesel returnPesel (Pesel pesel){
        return pesel;
    }


}