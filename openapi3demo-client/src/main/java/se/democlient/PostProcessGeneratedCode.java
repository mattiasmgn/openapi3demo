package se.democlient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PostProcessGeneratedCode {
    public static void main(String[] args) {
        String pathName="./target/generated-sources/swagger/src/main/java/se/democlient/DemoControllerApi.java";
        File file = new File(pathName);
        if (!file.exists()){
            System.out.println("Could not find source code file");
            System.exit(1);
        }
        String src = "";
        try {
            src = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            src= src.replaceAll("InlineResponse200","OneOfinlineResponse200");
           Files.writeString(Paths.get(file.getAbsolutePath()),src) ;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
