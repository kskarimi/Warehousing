package ir.kamalkarimi.warehousing.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.kamalkarimi.warehousing.exception.BaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Service
public class FileService {


    private final String TEMP_DIRECTORY_NAME = "temp";
    private final String TEMP_DIRECTORY_PATH = "./temp/";
    private final String FILE_FORMAT = ".json";

    @Autowired
    public FileService() {
    }

    public void upload(MultipartFile file,String name) throws BaseException {
        try {
            if (file == null || file.isEmpty())
                throw new BaseException("File is Empty.");

            InputStream inputStream ;
            inputStream = file.getInputStream();

            File currentDir     = new File(".");
            String path         = currentDir.getAbsolutePath();
            String tempDir      = path.substring(0,path.length()-1) + this.TEMP_DIRECTORY_NAME;
            String fileLocation = tempDir + "/" + name + ".json";

            File dir = new File(tempDir);
            if (!dir.exists())
                dir.mkdir();

            FileOutputStream outputStream;
            outputStream = new FileOutputStream(fileLocation);

            int ch = 0 ;
            while ((ch = inputStream.read()) != -1){
                outputStream.write(ch);
            }
            outputStream.flush();
            outputStream.close();

        }catch (IOException exception){
            throw new BaseException(exception.getMessage());
        }
    }

//    public <T extends BaseDTO> Map<String,List<T>> read(String filename){
//        try(Reader reader = new FileReader(this.filePath(filename))){
//            Type type = new TypeToken<Map<String,List<T>>>(){}.getType();
//            return new Gson().fromJson(reader,type);
//        }catch (IOException exception){
//            System.out.println(exception.getMessage());
//        }
//        return null;
//    }

//    private String filePath(String filename){
//        return TEMP_DIRECTORY_PATH+filename+FILE_FORMAT;
//    }
}
