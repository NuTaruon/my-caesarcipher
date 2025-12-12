package org.example.caesar.core;


import org.example.caesar.model.ProcessingResult;
import org.example.caesar.service.ValidationService;

public class CaesarCoder {
    private final ValidationService validationService;
    private int positionShift = 1;

    public CaesarCoder(ValidationService validationService) {
        this.validationService = validationService;
    }

    public ProcessingResult encodeText(String text){
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

    public ProcessingResult decodeText(String caesarCode){
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

    public void setPositionShift(int positionShift) {
        if(positionShift >= Alphabet.ALPHABET.length || positionShift <= 0) {
            System.out.println("Задданное значение не поподает в нужный диапозон. Ключ взят по умолчанию и равен 1");
            this.positionShift = 1;
        }
        else {
            System.out.println("Новое значение установленно");
            this.positionShift = positionShift;
        }
    }

    public int getPositionShift() {
        return positionShift;
    }
}
