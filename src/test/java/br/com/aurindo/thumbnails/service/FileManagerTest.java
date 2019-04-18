package br.com.aurindo.thumbnails.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileManagerTest {

    @Autowired
    private FileManager fileManager;

    @Test
    public void test() {
        String path = "http://caetanoneto.com.br/m2o/files/2pages.pdf";

        InputStream inputStream = fileManager.loadStream(path);

        Assert.assertNotNull(inputStream);
    }

}
