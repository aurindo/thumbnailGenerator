package br.com.aurindo.thumbnails.service;

import br.com.aurindo.thumbnails.vo.ThumbnailParameter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThumbnailServiceTests {

    @Autowired
    private ThumbnailService thumbnailService;

    @Test
    public void generateWithSuccess() {

        ThumbnailParameter thumbnailParameter = new ThumbnailParameter();
        thumbnailParameter.setType("jpg");
        thumbnailParameter.setUrl("http://caetanoneto.com.br/m2o/files/2pages.pdf");

        long start = new Date().getTime();
        List<byte[]> listImages = thumbnailService.generate(thumbnailParameter);
        long end = new Date().getTime();

        System.out.println("--------> total time: " + (end - start));

        Assert.assertEquals(2, listImages.size());
    }

}
