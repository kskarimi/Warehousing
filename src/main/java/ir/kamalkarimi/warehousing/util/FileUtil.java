package ir.kamalkarimi.warehousing.util;

import com.google.gson.Gson;
import ir.kamalkarimi.warehousing.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Component
public class FileUtil {

    public final static String TEMP_FILE_PATH = "./temp/";

    private final Gson gson;
    @Autowired
    public FileUtil(Gson gson) {
        this.gson = gson;
    }

    public void uploadFile(MultipartFile file) throws BaseException {
        if (file.isEmpty())
            throw new BaseException("FileUtil: file is empty");
        try {
            Files.copy(file.getInputStream(),this.getFilePath(getFileName(file)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            throw new BaseException("FileUtil: copy failed !");
        }
    }

    public <T> T readFile(String fileName,Class<T> tClass){
        if (!StringUtils.hasLength(fileName))
            return null;
        String path = this.getFilePath(fileName).toString()+".json";
        try(Reader reader = new FileReader(path)){
            return this.gson.fromJson(reader,tClass);
        }catch (IOException ex){
            System.out.println(ex);
            return null;
        }
    }

    public String getFileName(MultipartFile file){
        return StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    }
    public Path getFilePath(String fileName){
        return Paths.get(TEMP_FILE_PATH + fileName);
    }
}
