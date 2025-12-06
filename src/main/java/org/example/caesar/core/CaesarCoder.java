package org.example.caesar.core;

import org.caesar.model.ProcessingResult;
import org.caesar.service.ValidationService;

public class CaesarCoder {
    private final ValidationService validationService;

    public CaesarCoder(ValidationService validationService) {
        this.validationService = validationService;
    }

    public ProcessingResult encodeText(String text, int positionShift){
        validationService.validateTextEncode(text);
        char[] charsText = text.toLowerCase().toCharArray();
        StringBuilder coderCaesarText = new StringBuilder();
        for(char roll: charsText){
            boolean mark = false;
            for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                if(roll == Alphabet.ALPHABET[i]){
                    if(i + positionShift < Alphabet.ALPHABET.length)
                        coderCaesarText.append(Alphabet.ALPHABET[i+positionShift]);
                    else {
                        int result = i + positionShift - Alphabet.ALPHABET.length;
                        coderCaesarText.append(Alphabet.ALPHABET[result]);
                    }
                    mark = true;
                }
            }
            if(!mark)
                coderCaesarText.append(roll);
        }
        return new ProcessingResult(true,"Текст закодирован!", text,coderCaesarText.toString());
    }

    public ProcessingResult decodeText(String caesarCode, int positionShift){
        validationService.validateCaesarCode(caesarCode);
        char[] charsCaesar = caesarCode.toCharArray();
        StringBuilder decodeCaesarText = new StringBuilder();
        for(char roll: charsCaesar){
            boolean mark = false;
            for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                if(roll == Alphabet.ALPHABET[i]){
                    if(i - positionShift >= 0)
                        decodeCaesarText.append(Alphabet.ALPHABET[i-positionShift]);
                    else {
                        int result = i-positionShift + Alphabet.ALPHABET.length;
                        decodeCaesarText.append(Alphabet.ALPHABET[result]);
                    }
                    mark = true;
                }

          }
            if(!mark)
                decodeCaesarText.append(roll);
        }
        return new ProcessingResult(true, "Код успешно декодирован, ", caesarCode,decodeCaesarText.toString());
    }

    public String getPreview(String text){
        if (text.length() <= 120){
            return text;
        }
        return text.substring(0,120) + " ...";
    }
}
