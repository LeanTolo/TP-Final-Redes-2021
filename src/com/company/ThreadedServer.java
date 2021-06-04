package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServer {
//    private static String[] nicknames = {"Lord","Master","Slave"};
    private static final int PORT = 3000;
    private static Interface anInterface = new Interface("Server");

    private static ArrayList<ClientHandler> clientList = new ArrayList<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(6);

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        anInterface.SendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String msgout = "";
                    msgout = anInterface.serverChatInput.getText().trim();
                    clientList.get(0).serverMessage(msgout);
                    anInterface.serverChatOutput.append("\nServer: "+msgout);
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }
        });
        while(true){
            anInterface.serverChatOutput.append("\nServer: Waiting...");
            Socket socket = serverSocket.accept();
            anInterface.serverChatOutput.append("\nClient "+socket.getRemoteSocketAddress()+" connected.");
            ClientHandler clientHandler = new ClientHandler(socket, clientList, anInterface);
            clientList.add(clientHandler);
            threadPool.execute(clientHandler);
        }
    }
}