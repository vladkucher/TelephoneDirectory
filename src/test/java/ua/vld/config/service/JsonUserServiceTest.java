package ua.vld.config.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import ua.vld.config.AbstractUserServiceTest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@ActiveProfiles({"jsondata", "default"})
public class JsonUserServiceTest extends AbstractUserServiceTest{
    @Value("${file.name}")
    private String fileName;

    @Before
    public void before(){
        try(PrintWriter writer = new PrintWriter(fileName);)
        {
            writer.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
