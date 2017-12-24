package com.company;

import java.util.ArrayList;

public class EmailValidator {

    public EmailValidator(){

    }


    public boolean validateEmail (String input){
        char[] charArray = input.toCharArray();

        if (Character.isLetter(charArray[0])){
            return validateAt(input, charArray);
        }else return false;
    }

    private boolean validateAt (String input, char[] array) {
        int atCounter = 0;
        for (char i : array){
            if (i == '@') {atCounter++;}
        }
        if (atCounter == 1){

            int atIndx = 0;

            for (int i = 0; i <array.length; i++) {
                if (array[i] == '@') {
                    atIndx = i;
                    break;

                }
            }

            return validateDot(input, array, atIndx);
        }

        else return false;
    }

    private boolean validateDot (String input, char[] array, int atIndx) {


        int dotCounter = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(atIndx);

        for (int i = atIndx; i < array.length; i++) {
            if (array[i] == '.') {
                dotCounter++;
                list.add(i);
            }

        }

        if (dotCounter > 0) {



            for (int a = 1; a < list.size() - 1; a++) {

                String temp = input.substring(list.get(a) + 1, list.get(a + 1));
                char[] tempArray = temp.toCharArray();

                for (char i : tempArray) {

                    if (!(Character.isLetter(i))) {
                        return false;
                    }
                }
            }

            String temp = input.substring(list.get(list.size() - 1) + 1, array.length );
            char[] tempArray = temp.toCharArray();

            for (char i : tempArray) {

                if (!(Character.isLetter(i))) {
                    return false;
                }

            }

            return true;

        }

        else return false;
    }
}
