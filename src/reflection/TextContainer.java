package reflection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "text.txt")
public class TextContainer {
    private String str = "Hello World";


    @Saver
    public void save(String pth) {
        File file = new File(pth);
        try (FileWriter fw = new FileWriter(file)){
            fw.write(str);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
