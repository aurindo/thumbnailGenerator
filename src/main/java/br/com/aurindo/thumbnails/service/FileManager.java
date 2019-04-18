package br.com.aurindo.thumbnails.service;

import com.google.common.io.ByteStreams;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class FileManager {

    public InputStream loadStream(String path) {
        URL url = createURL(path);

        InputStream inputStreamResult = null;
        try (
                InputStream is = url.openStream()
        ) {
            inputStreamResult = is;
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: Thorws exception
        }

        return inputStreamResult;
    }

    public byte[] loadBytes(String path) {
        URL url = createURL(path);

        byte[] targetArray = {};
        try (
                InputStream inputStream = url.openStream()
        ) {
            targetArray = ByteStreams.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: Thorws exception
        }

        return targetArray;
    }

    private URL createURL(String path) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO: Throws exception
        }
        return url;
    }

}
