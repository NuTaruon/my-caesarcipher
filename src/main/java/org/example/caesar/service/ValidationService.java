package org.example.caesar.service;


import org.example.caesar.exception.CaesarException;

public class ValidationService {

    public void validateTextEncode (String text) throws CaesarException {
        if(text == null || text.trim().isEmpty())
           throw  new CaesarException("Текст не может быть пустым!");


    }

    public void validateCaesarCode (String caesarCode) throws  CaesarException{
        if(caesarCode == null || caesarCode.trim().isEmpty())
            throw new CaesarException("Шифр Цезаря не может быть пустым!");
    }
}
