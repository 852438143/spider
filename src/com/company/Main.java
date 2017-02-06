package com.company;

/**
 * 第一次用java爬虫，不知道为什么爬下来的网页原始页面：“会消失出现//值得深入学习
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Pattern pattern = Pattern.compile("(src=//)(.*?\\.gif)");
        String str_url = "https://www.baidu.com";
        URL url = new URL(str_url);
        InputStream in = url.openStream();
        BufferedReader read = new BufferedReader((new InputStreamReader(in)));
        String temp;
        while ((temp = read.readLine()) != null) {

            //System.out.println(temp + "\n");
            Matcher matcher = pattern.matcher(temp);
            System.out.println(matcher.groupCount());
            while (matcher.find()) {
                //注意group方法必须写在find方法后面，不知道为什么
                System.out.println(matcher.group(2) + "------------------------------");
            }
        }
    }
}
