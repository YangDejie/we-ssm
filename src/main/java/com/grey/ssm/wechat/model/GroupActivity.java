package com.grey.ssm.wechat.model;

import java.util.Date;

public class GroupActivity {
    private int GID;
    private int AID;
    private int CreateID;
    private int numbers;
    private String title;
    private Date time;
    private String content;

    public GroupActivity(int GID, int AID, int createID, int numbers, String title, Date time, String content) {
        this.GID = GID;
        this.AID = AID;
        CreateID = createID;
        this.numbers = numbers;
        this.title = title;
        this.time = time;
        this.content = content;
    }

    public GroupActivity() {
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getCreateID() {
        return CreateID;
    }

    public void setCreateID(int createID) {
        CreateID = createID;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GroupActivity{" +
                "GID=" + GID +
                ", AID=" + AID +
                ", CreateID=" + CreateID +
                ", numbers=" + numbers +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
