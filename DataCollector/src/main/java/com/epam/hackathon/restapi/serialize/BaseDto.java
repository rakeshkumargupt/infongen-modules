package com.epam.hackathon.restapi.serialize;

import java.util.UUID;

public class BaseDto {

    private String id;
    private String date;
    private String content;
    private String link;
    private String tag;
    private String time;
    private String senPositiveCount;
    private String senNegetiveCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenPositiveCount() {
        return senPositiveCount;
    }

    public void setSenPositiveCount(String senPositiveCount) {
        this.senPositiveCount = senPositiveCount;
    }

    public String getSenNegetiveCount() {
        return senNegetiveCount;
    }

    public void setSenNegetiveCount(String senNegetiveCount) {
        this.senNegetiveCount = senNegetiveCount;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", tag='" + tag + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BaseDto() {

        id = UUID.randomUUID().toString();

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
