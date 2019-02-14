package com.bogucharova;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {
    private List<Integer> octetList = new ArrayList<Integer>();

    public static IpAddress parseIpAddressFromString(String ip) {
        IpAddress ipAddress = new IpAddress();
        String[] split = ip.split("\\.");
        if (split.length != 4) throw new IllegalArgumentException("Некорректный ip адрес");
        for (int i = 0; i < 4; i++) {
            ipAddress.octetList.add(Integer.parseInt(split[i]));
        }
        if(ipAddress.octetList.get(3) >255){
            throw new RuntimeException("Последний октет больше 255");
        }
        return ipAddress;
    }

    public static String getAllIpAddresesInRangeAsString(IpAddress firstIp, IpAddress secondIp) {
        checkIpRange(firstIp, secondIp);
        StringBuilder result= new StringBuilder();
        List<IpAddress> addreses = getAllIpAddresesInRange(firstIp, secondIp);
        for (int i = 0; i < addreses.size(); i++) {
            result.append(addreses.get(i)).append("\r\n");
        }
        return result.toString();
    }

    private static void checkIpRange(IpAddress firstIp, IpAddress secondIp) {
        if(!firstIp.getPrefix().equals(secondIp.getPrefix())){
            throw  new RuntimeException("Первые три октета в заданном диапозоне должны совпадать");
        }
    }

    public static List<IpAddress> getAllIpAddresesInRange(IpAddress firstIp, IpAddress secondIp) {
        List<IpAddress> ipAddressList = new ArrayList<IpAddress>();
        for (int i = firstIp.getLastNumber() + 1; i < secondIp.getLastNumber(); i++) {
            ipAddressList.add(IpAddress.parseIpAddressFromString(firstIp.getPrefix() + i));
        }
        return ipAddressList;
    }

    public String getPrefix() {
        return octetList.get(0) + "." + octetList.get(1) + "." + octetList.get(2) + ".";
    }

    public Integer getLastNumber() {
        return octetList.get(3);
    }

    @Override
    public String toString() {
        return octetList.get(0) + "." + octetList.get(1) + "." + octetList.get(2) + "." + octetList.get(3);
    }

}
