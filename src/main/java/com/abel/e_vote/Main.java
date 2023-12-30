package com.abel.e_vote;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static InetAddress address;
    public static void main(String[] args) throws UnknownHostException {
        if (args.length!=4){
            byte[] a = new byte[]{127, 0, 0, 1};
            address = InetAddress.getByAddress(a);
            System.out.println(address);
        }else {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            int t = Integer.parseInt(args[3]);
            byte[] a = {(byte) x, (byte) y, (byte) z, (byte) t};
            address = InetAddress.getByAddress(a);
            System.out.println(address);
        }
        HelloApplication.main(args);
    }
}
