package com.company;

public class PeselValidator {

    public PeselValidator(){

    }

    public Pesel validatePesel(Pesel pesel){
        PeselValidate validatorInternal = new PeselValidate(pesel);

        return pesel;
    }
}
