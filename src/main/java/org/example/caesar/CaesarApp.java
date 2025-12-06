package org.example.caesar;

import org.example.caesar.core.CaesarCoder;
import org.example.caesar.exception.CaesarException;
import org.example.caesar.model.ProcessingResult;
import org.example.caesar.service.FileService;
import org.example.caesar.service.ValidationService;
import java.util.Scanner;

public class CaesarApp {

    private final CaesarCoder caesarCoder;
    private final FileService fileService;
    private final Scanner scanner;

    public CaesarApp() {
        this.caesarCoder = new CaesarCoder(new ValidationService());
        this.fileService = new FileService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CaesarApp caesarApp = new CaesarApp();
        caesarApp.run();
    }

    public void run(){
        boolean running = true;
        printWelcomeMassage();
        while (running){
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    processEncodeFile();
                    break;
                case "2":
                    processDecodeFile();
                    break;
                case "3": {
                    System.out.println("Всего доброго!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }

    }

    private void printWelcomeMassage(){
        System.out.println("CaesarCoder v1.0");

    }

    private void showMainMenu(){
        System.out.println("Главное меню:");
        System.out.println("1. Кодирование файла.");
        System.out.println("2. Декодирование файла.");
        System.out.println("3. Выход.");
        System.out.print("Введите нужную операцию: ");

    }

    private void processEncodeFile(){
        try {
            System.out.println("_".repeat(30));
            System.out.println("Кодирование файла");
            String inputFile =  getInputPathFile();
            String outputFile = getOutputPathFile();
            String content = fileService.readFile(inputFile);
            ProcessingResult result = caesarCoder.encodeText(content,10);
            fileService.writeFile(result.getOutputPreview(),outputFile);
            displaySuccessResult(result,inputFile,outputFile);
        } catch (CaesarException e) {
            displayErrorMassage(e.getMessage());
        }

    }

    private void processDecodeFile(){
        try {
            System.out.println("_".repeat(30));
            System.out.println("Декодирование файла");
            String inputFile = getInputPathFile();
            String outputFile = getOutputPathFile();
            String content = fileService.readFile(inputFile);
            ProcessingResult result = caesarCoder.decodeText(content, 10);
            fileService.writeFile(result.getOutputPreview(), outputFile);
            displaySuccessResult(result,inputFile,outputFile);
        }catch (CaesarException e){
            displayErrorMassage(e.getMessage());
        }
    }

    private String getInputPathFile(){
        System.out.print("Введите путь к исходному файлу: ");
            return scanner.nextLine();

    }

    private String getOutputPathFile(){
        System.out.print("\nВведите путь к файлу для записи: ");
        return scanner.nextLine();
    }

    private void displaySuccessResult(ProcessingResult result, String inputFile, String outputFile){
        if(result.isSuccess()) {
            System.out.println("\nОперация выполнена!\n\n" + "Файл исходника: " + inputFile +
                    "\nФайл загрузки: " + outputFile);
            System.out.println("\nИсходный текст файла: " + caesarCoder.getPreview(result.getInputPreview()));
            System.out.println("Загруженый в файл текст: " + caesarCoder.getPreview(result.getOutputPreview()));
        }
        else
            System.out.println("Операция не была выполнена!");
        System.out.println();
    }

    private void displayErrorMassage(String message){
        System.out.println("ERROR: " + message + "\n");
    }
}