package br.com.aurindo.thumbnails.service;

import br.com.aurindo.thumbnails.vo.ThumbnailParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThumbnailService {

    @Autowired
    private FileManager fileManager;

    @Autowired
    private PDFManager pdfManager;

    public List<byte[]> generate(ThumbnailParameter thumbnailParameter) {

        byte[] inputStream = fileManager.loadBytes(thumbnailParameter.getUrl());

        List<byte[]> listImages = pdfManager.generateImageFromPDF(inputStream, thumbnailParameter.getType());

        return listImages;
    }

}
