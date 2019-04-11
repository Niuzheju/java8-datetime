package com.niuzj.demo;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * java8日期/时间API
 */
public class Test1 {

    /**
     * 日期
     * 格式:yyyy-MM-dd
     */
    @Test
    public void test01() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.of(2018, 1, 2);
        System.out.println(localDate1);
        //指定市区的当前时间
        LocalDate localDate2 = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(localDate2);
        //格林尼治时间加指定天数
        LocalDate localDate3 = LocalDate.ofEpochDay(365);
        System.out.println(localDate3);
        //某年的第xxx天的日期
        LocalDate localDate4 = LocalDate.ofYearDay(2019, 180);
        System.out.println(localDate4);
    }

    /**
     * 时间
     * 默认格式是hh:mm:ss.zzz
     */
    @Test
    public void test02() {
        //当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //指定时间
        LocalTime localTime1 = LocalTime.of(12, 20, 11, 1);
        System.out.println(localTime1);
        //指定时区的当前时间
        LocalTime localTime2 = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(localTime2);
        //距离今天0点指定秒数的时间
        LocalTime localTime3 = LocalTime.ofSecondOfDay(60);
        System.out.println(localTime3);
    }

    /**
     * 日期时间
     * 格式:yyyy-MM-dd-HH-mm-ss.zzz
     */
    @Test
    public void test03(){
        //当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //使用LocalDate,LocalTime构造LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime1);
        //自定义日期时间
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, Month.JUNE, 20, 12, 12, 12, 11);
        System.out.println(localDateTime2);
        //指定时区的日期时间
        LocalDateTime localDateTime3 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime3);
        //距离格林尼治时间后指定秒数的日期时间
        LocalDateTime localDateTime4 = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println(localDateTime4);
    }

    /**
     * Instant封装一个时间戳
     * 默认时区为0时区
     */
    @Test
    public void test04(){
        //获取当前时间的Instant实例
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant instant5 = Instant.now(Clock.system(ZoneId.systemDefault()));
        System.out.println(instant5);
        //转换为long类型的时间戳
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);
        //通过毫秒构造Instant
        Instant instant1 = Instant.ofEpochMilli(1554903171000L);
        //通过秒构造Instant
        Instant instant2 = Instant.ofEpochSecond(1554903171L);
        //通过秒和纳秒构造Instant
        Instant instant3 = Instant.ofEpochSecond(1554903171, 1);
        System.out.println(instant2);
        //获取东八区的时间戳
        Instant instant4 = instant.plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println(instant4);
    }

    /**
     * TimeUnit操作时间单位
     * 可以把不同时间单位进行转换
     */
    @Test
    public void test05(){
        //把小时转换为天数
        System.out.println(TimeUnit.HOURS.toDays(24));
        //把小时转换为秒
        System.out.println(TimeUnit.HOURS.toSeconds(1));
    }

    /**
     * 毫秒和LocalDateTime的转换
     */
    @Test
    public void test06(){
        //LocalDateTime转换为毫秒
        long epochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(epochMilli);
        //毫秒转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    /**
     * LocalDateTime和字符串之间的转换
     */
    @Test
    public void test07(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = localDateTime.format(formatter);
        System.out.println(s);
        localDateTime = LocalDateTime.parse(s, formatter);
        System.out.println(localDateTime);
        System.out.println(ZoneId.systemDefault());
    }


}
