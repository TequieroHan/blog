package com.myong.blog.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 获取MAC地址
 */
public class LOCALMAC {

    public static String getLocMac(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer sb = new StringBuffer("");
            System.out.println(hardwareAddress.toString());
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i!=0) {
                    sb.append("-");
                }
                int temp = hardwareAddress[i]&0xff;
                String hexString = Integer.toHexString(temp);
                System.out.println("hexString = "+hexString);
                if (hexString.length() == 1) {
                    sb.append("0"+hexString);
                }else{
                    sb.append(hexString);
                }
            }
            return sb.toString().toUpperCase();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}
