package com.grey.ssm.wechat.model;

public class GroupMembers {
    private int GID;
    private int UID;
    private String status;
    private String privilege;

    public GroupMembers() {
    }

    public GroupMembers(int GID, int UID, String status, String privilege) {

        this.GID = GID;
        this.UID = UID;
        this.status = status;
        this.privilege = privilege;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "GroupMembers{" +
                "GID=" + GID +
                ", UID=" + UID +
                ", status='" + status + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
