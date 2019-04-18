package br.com.aurindo.thumbnails.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PDFManager {

    public List<byte[]> generateImageFromPDF(byte[] inputStream, String extension) {
        List<byte[]> listImages = new ArrayList<>() ;

        try (
                PDDocument document = PDDocument.load(inputStream)
        ){
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImage(
                        page, 0.5f, ImageType.RGB);
                listImages.add(toByteArrayAutoClosable(bim, extension));
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: Throws exception
        }

        return listImages;
    }

    private byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            ImageIO.write(image, type, out);
            return out.toByteArray();
        }
    }

}
