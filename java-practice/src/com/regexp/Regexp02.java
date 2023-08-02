package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/2 18:01
 * @注释
 */
public class Regexp02 {
    public static void main(String[] args) {
        String content = "zb2kd";
        String regStr = "[a-z]";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
