ШИФР ЦЕЗАРЯ
USE Case1: Кодировка файла 
USE Case2: Декадировка файла

1. Core - бизнес логика, константы.
[Alphabet.java](src/main/java/org/example/caesar/core/Alphabet.java)
[CaesarCoder.java](src/main/java/org/example/caesar/core/CaesarCoder.java)
2. Model - модель данных.
[ProcessingResult.java](src/main/java/org/example/caesar/model/ProcessingResult.java)
3. Service - работа с файлами, валидация.
[FileService.java](src/main/java/org/example/caesar/service/FileService.java)
[ValidationService.java](src/main/java/org/example/caesar/service/ValidationService.java)
4. Exception - кастомные икслючения для логики.
[CaesarException.java](src/main/java/org/example/caesar/exception/CaesarException.java)
5. Ресурсы - настройки

// Тесты.