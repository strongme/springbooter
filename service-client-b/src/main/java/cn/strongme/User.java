package cn.strongme;

import java.io.Serializable;

/**
 * Created by 阿水 on 2017/5/27 09:55.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1702820727963231247L;

    private int id;
    private String name;
    private String mobile;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("\n名字：%s，电话： %s，地址：%s\n", this.name, this.mobile, this.address);
    }
}
