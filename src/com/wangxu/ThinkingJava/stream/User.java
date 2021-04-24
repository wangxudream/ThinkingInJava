package com.wangxu.ThinkingJava.stream;


/**
 * @ClassName User
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/11 22:48
 * @Version V1.0
 **/
public class User {
    private String name;
    private Integer age;
    private String address;
    private Boolean gender;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }
}
