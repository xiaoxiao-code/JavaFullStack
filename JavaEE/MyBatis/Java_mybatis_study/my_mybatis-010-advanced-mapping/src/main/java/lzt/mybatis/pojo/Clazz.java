package lzt.mybatis.pojo;

import java.util.List;

public class Clazz {
    private Integer cid;
    private String cname;

    // 一对多：一个班级有多个学生，这里体现为关联一个 Student 的 List 集合
    private List<Student> stus;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname, List<Student> stus) {
        this.cid = cid;
        this.cname = cname;
        this.stus = stus;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }
}