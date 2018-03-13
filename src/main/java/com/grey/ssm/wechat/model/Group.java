package com.grey.ssm.wechat.model;

public class Group {
    private int GID;
    private int UID;
    private int InviteCode;
    private String GName;
    public Group(){

    }

    public Group(int GID, int UID, int inviteCode, String GName) {
        this.GID = GID;
        this.UID = UID;
        InviteCode = inviteCode;
        this.GName = GName;
    }

    public int getGID() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID = GID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getInviteCode() {
        return InviteCode;
    }

    public void setInviteCode(int inviteCode) {
        InviteCode = inviteCode;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "GID=" + GID +
                ", UID=" + UID +
                ", InviteCode=" + InviteCode +
                ", GName='" + GName + '\'' +
                '}';
    }
}
