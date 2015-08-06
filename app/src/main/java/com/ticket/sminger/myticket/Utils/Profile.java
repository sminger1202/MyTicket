package com.ticket.sminger.myticket.Utils;

public class Profile {
    // 脚本打包需要，使用的PID需要放到第一行。
    private static final String Wireless_pid = "34d185b5c1336e16"; //

    public static final String Analytics_APPID = "c21b5c0b69b1187b";

    public static String VER = "5.0";// 版本号 2.1通用版

    public static final boolean Debug = true; // 值为 true 时打印log，值为 false 时关闭log
    // 此处应有空格
    public static final boolean isTestHost = true; // 值为 true 时使用测试服务器，值为 false

    /** 防盗链密钥 */
    public static final String YOUCANGUESS = "094b2a34e812a4282f25c7ca1987789f";

    public static String getPid(){
        return Wireless_pid ;
    }

}