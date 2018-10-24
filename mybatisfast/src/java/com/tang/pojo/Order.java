package com.tang.pojo;

public class Order {

    private String id;  //int(11) NOT NULL AUTO_INCREMENT,
    private String userId;  //int(11) NOT NULL COMMENT '下单用户id',
    private String number;  //varchar(32) NOT NULL COMMENT '订单号',
    private String createtime;  //datetime NOT NULL COMMENT '创建订单时间',
    private String note;  //varchar(100) DEFAULT NULL COMMENT '备注',

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", number='" + number + '\'' +
                ", createtime='" + createtime + '\'' +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }
}
