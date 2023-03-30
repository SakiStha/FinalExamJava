package org.example.model;

public class Attendance {
    String id;
    int classid;
    int userid;

    public Attendance(String id, int classid, int userid) {
        this.id = id;
        this.classid = classid;
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
