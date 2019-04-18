package br.com.aurindo.thumbnails.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PDFManagerTest {

    @Autowired
    private PDFManager pdfManager;

    @Autowired
    private FileManager fileManager;

    @Test
    public void generateImageFromPDFTest() {
        String path = "http://caetanoneto.com.br/m2o/files/2pages.pdf";
        byte[] inputStream = fileManager.loadBytes(path);

        List<byte[]> listImages = pdfManager.generateImageFromPDF(inputStream, "jpg");

        Assert.assertEquals(2, listImages.size());
    }

}
