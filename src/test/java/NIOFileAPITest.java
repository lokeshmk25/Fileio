import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static String HOME=System.getProperty("user.home");
    private static String PLAY_WITH_NIO="TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        //check file exists
        Path homePath= Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        //delete file and check file not exist
        Path playpath=Paths.get(HOME + "/" +PLAY_WITH_NIO);
        if(Files.exists(playpath)) Files.delete(playpath.toFile().toPath());

        //crete directory
        Files.createDirectory(playpath);
        Assertions.assertTrue(Files.exists(playpath));

        //create file
        IntStream.range(1,10).forEach(cntr ->{
            Path tempFile=Paths.get(playpath + "/temp"+cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            }
            catch (IOException e){
                Assertions.assertTrue(Files.exists(tempFile));
            }
        });
    }
}
