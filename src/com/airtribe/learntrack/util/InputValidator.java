package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {
    public static void validateString(String input, String fieldName){
        if(input==null || input.trim().isEmpty()){
            throw new InvalidInputException(fieldName+" Cannot be empty ");
        }
    }
}
