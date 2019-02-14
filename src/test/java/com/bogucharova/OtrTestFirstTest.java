package com.bogucharova;

import org.junit.Test;

import static org.junit.Assert.*;

public class OtrTestFirstTest {

    @Test
    public void testIpAdressRangeCount() throws Exception {
        IpAddress ip1 = IpAddress.parseIpAddressFromString("192.168.0.1");
        IpAddress ip2 = IpAddress.parseIpAddressFromString("192.168.0.5");
        int ipSize = IpAddress.getAllIpAddresesInRange(ip1, ip2).size();
        int actual = 3;
        assertEquals(ipSize, actual);
    }


}