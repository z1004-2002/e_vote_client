package com.abel.e_vote;

import com.abel.e_vote.services.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress ad2 = InetAddress.getByName("localhost");
            int port = 3000;

            Map<String,Object> request = new HashMap<>();
            request.put("name_request","get_all_partis");
            byte [] buf = Service.transformToByte(request);

            DatagramPacket packet = new DatagramPacket(buf, buf.length,ad2,port);
            socket.send(packet);

            buf = new byte[5120];
            packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);
            List<Map<String, Object>> rs = Service.transformToListOfMap(packet.getData());

            if (!rs.isEmpty()){
                welcomeText.setText(rs.get(0).toString());
            }

        } catch (IOException|ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}