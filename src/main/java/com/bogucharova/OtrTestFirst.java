package com.bogucharova;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OtrTestFirst {
    public static void main(String[] args) {
        try {
            IpAddress ipAddress1 = readIpAddress("Введите первый ip адрес:");
            IpAddress ipAddress2 = readIpAddress("Введите второй ip адрес:");
            System.out.println(IpAddress.getAllIpAddresesInRangeAsString(ipAddress1, ipAddress2));
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private static IpAddress readIpAddress(String s) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String ip;
        System.out.println(s);
        ip = read.readLine();
        return IpAddress.parseIpAddressFromString(ip);
    }

}