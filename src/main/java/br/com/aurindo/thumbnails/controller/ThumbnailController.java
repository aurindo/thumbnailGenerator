package br.com.aurindo.thumbnails.controller;

import br.com.aurindo.thumbnails.service.ThumbnailService;
import br.com.aurindo.thumbnails.vo.ThumbnailParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("thumbnail")
public class ThumbnailController {

    @Autowired
    public ThumbnailService thumbnailService;

    @PostMapping
    @ResponseBody
    public ResponseEntity generateThumbnails(@RequestBody ThumbnailParameter thumbnailParameter) {

        List<byte[]> listImages = thumbnailService.generate(thumbnailParameter);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listImages);
    }

}
