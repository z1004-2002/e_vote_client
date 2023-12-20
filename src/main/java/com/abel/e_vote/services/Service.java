package com.abel.e_vote.services;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Service {
    public static byte [] transformToByte(Map<String, Object> requete){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(requete);
            oos.flush();
            return bos.toByteArray();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Map<String,Object>> transformToListOfMap(byte [] tmp) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bis = new ByteArrayInputStream(tmp);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return  (List<Map<String, Object>>) ois.readObject();
    }
    public static Map<String,Object> transformToMap(byte [] tmp) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bis = new ByteArrayInputStream(tmp);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return  (Map<String, Object>) ois.readObject();
    }
}
