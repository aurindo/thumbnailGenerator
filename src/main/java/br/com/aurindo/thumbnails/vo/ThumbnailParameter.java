package br.com.aurindo.thumbnails.vo;

import java.io.Serializable;

public class ThumbnailParameter implements Serializable {

    private String url;
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
