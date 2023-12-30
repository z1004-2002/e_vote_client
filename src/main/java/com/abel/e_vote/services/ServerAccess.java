package com.abel.e_vote.services;

import com.abel.e_vote.Main;
import com.abel.e_vote.models.Parti;
import com.abel.e_vote.models.Region;
import com.abel.e_vote.models.RegionParti;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerAccess {
    public static InetAddress getAdressServer() throws UnknownHostException {
        return Main.address;
    }
    public static List<Region> getAllRegions(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","get_all_regions");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

            buf = new byte[5120];
            packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);
            List<Map<String, Object>> result = Service.transformToListOfMap(packet.getData());
            List<Region> regionList = new ArrayList<>();
            for (Map<String, Object> rs:result){
                regionList.add(
                        new Region(
                                (Integer) rs.get("id_region"),
                                (String) rs.get("nom"),
                                (Integer) rs.get("electeurs")
                        )
                );
            }
            return regionList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Parti> getAllPartis(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","get_all_partis");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

            buf = new byte[5120];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            List<Map<String, Object>> result = Service.transformToListOfMap(packet.getData());
            List<Parti> partiList = new ArrayList<>();
            for (Map<String, Object> rs:result){
                partiList.add(
                        new Parti(
                                (Integer) rs.get("id_parti"),
                                (String) rs.get("nom")
                        )
                );
            }
            return partiList;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<RegionParti> getVoteByRegion(Integer id_region){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","resultat_region");
            request.put("id_region",id_region);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

            buf = new byte[5120];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            List<Map<String, Object>> result = Service.transformToListOfMap(packet.getData());
            List<RegionParti> resultatVote = new ArrayList<>();
            for (Map<String, Object> rs:result){
                resultatVote.add(
                        new RegionParti(
                                (Integer) rs.get("id_region"),
                                (Integer) rs.get("id_parti"),
                                (String) rs.get("nom_representant"),
                                (String) rs.get("nom_parti"),
                                (Integer) rs.get("vote")
                        )
                );
            }
            return resultatVote;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addRegion(String nom){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","add_region");
            request.put("to_add",nom);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addParti(String nom){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","add_parti");
            request.put("to_add",nom);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteRegion(Integer id_region){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","delete_region");
            request.put("to_delete",id_region);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteParti(Integer id_parti){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","delete_parti");
            request.put("to_delete",id_parti);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addRepresantant(Integer id_region,Integer id_parti,String nom_representant){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","add_reprerentant");
            request.put("id_region",id_region);
            request.put("id_parti",id_parti);
            request.put("represantant",nom_representant);
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addElecteur(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","add_electeur");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void makeVote(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","make_vote");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void dropDataBase(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","drop_data_base");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String login(String username,String password){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ad2 = getAdressServer();
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","login");
            request.put("username",username);
            request.put("password",password);

            byte [] buf = Service.transformToByte(request);
            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

            buf = new byte[5120];
            packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);
            Map<String, Object> result = Service.transformToMap(packet.getData());
            return (String) result.get("message");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}