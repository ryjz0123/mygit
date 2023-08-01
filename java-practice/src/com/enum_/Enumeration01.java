package com.enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}
class Season {
    private String name;
    private String desc;
    //定义对象
    public static Season SPRING = new Season("春天","温暖");
    public static Season SUMMER = new Season("夏天","炎热");
    public static Season AUTUMN = new Season("秋天","凉爽");
    public static Season WINTER = new Season("冬天","寒冷");

    //1.构造器私有化
    //2.去掉setXXX方法，防止属性被修改
    //3.在Season内部，直接创建固定的对象
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}