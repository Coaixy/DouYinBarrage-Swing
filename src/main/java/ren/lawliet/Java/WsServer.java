package ren.lawliet.Java;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;

/**
 * @author Coaixy
 * @createTime 2024-06-01
 * @packageName ren.lawliet.Java
 */

public class WsServer extends WebSocketServer {
    private JTextArea text;
    public WsServer(int port) {
        super(new InetSocketAddress(port));
    }

    public void setAreaObj(JTextArea obj){
        this.text = obj;
    }
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<MsgType> messages = objectMapper.readValue(s, objectMapper.getTypeFactory().constructCollectionType(List.class, MsgType.class));
            for (MsgType message : messages) {
                if(Objects.equals(message.type, "message")){
                    String content = message.nickname + " : " + message.content;
                    this.text.append(content + "\n");
                    this.text.setCaretPosition(this.text.getDocument().getLength());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {
        System.out.println("WebSocket Server Start");
        setConnectionLostTimeout(100);
    }
}
