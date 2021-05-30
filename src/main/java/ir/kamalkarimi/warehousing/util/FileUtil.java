package ir.kamalkarimi.warehousing.util;

import ir.kamalkarimi.warehousing.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Component
public class FileUtil {

    public final static String TEMP_FILE_PATH = "./temp/";

    @Autowired
    public FileUtil() {
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

    public String getFileName(MultipartFile file){
        return StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    }
    public Path getFilePath(String fileName){
        return Paths.get(TEMP_FILE_PATH + fileName);
    }
}
