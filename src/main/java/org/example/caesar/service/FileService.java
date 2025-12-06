package org.example.caesar.service;

import org.caesar.exception.CaesarException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileService {

    public String readFile (String filePath) {
        try {
            if(!fileExist(filePath))
                throw new IOException();
            Path path = Path.of(filePath);
            if(!Files.exists(path))
                throw new CaesarException("Файл не существует:" + filePath);
            if(!Files.isReadable(path))
                throw new CaesarException("Нет прав для чтения файла:" + filePath);
            return Files.readString(path);

        } catch (IOException e){
            throw new CaesarException("Ошибка чтения файла! ");
        }


    }

    public void writeFile (String content, String filePath) throws CaesarException {
      try {
          if(!fileExist(filePath))
              throw new IOException();
          Path path = Path.of(filePath);
          Path pathDear = path.getParent();
          if(pathDear != null && !Files.exists(pathDear))
              Files.createDirectories(pathDear);
          Files.writeString(path,content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

      } catch (IOException e){
          throw new CaesarException("Ошибка записи файла:");
      }
    }

    public boolean fileExist (String filePath){
        return Files.exists(Path.of(filePath));
    }
}
