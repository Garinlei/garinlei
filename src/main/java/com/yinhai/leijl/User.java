package com.yinhai.leijl;

public class User {

    private String name;
    private String age;
    private String add;

    public User(String name, String age, String add) {
        this.name = name;
        this.age = age;
        this.add = add;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public  boolean isFrom(String value){
        if(this.add.contains(value)){
            return true;
        }
        return false;
    }
}
