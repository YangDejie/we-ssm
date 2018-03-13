package com.grey.ssm.wechat.model;


public class ActivityMembers {
    private int AID;
    private int UID;

    public ActivityMembers() {
    }

    public ActivityMembers(int AID, int UID) {
        this.AID = AID;
        this.UID = UID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    @Override
    public String toString() {
        return "ActivityMembers{" +
                "AID=" + AID +
                ", UID=" + UID +
                '}';
    }
}
