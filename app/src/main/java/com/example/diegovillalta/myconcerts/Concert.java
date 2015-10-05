package com.example.diegovillalta.myconcerts;

/**
 * Created by diegovillalta on 9/28/15.
 */
public class Concert {

    private String title;
    private String link;
    private String imageLink;

    public Concert(String title, String link, String imageLink) {
        this.title = title;
        this.link = link;
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImageLink() {
        return imageLink;
    }
}
