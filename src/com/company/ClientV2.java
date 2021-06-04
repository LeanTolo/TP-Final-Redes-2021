package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientV2 {
    private static final String serverIp = "127.0.0.1";
    private static final int serverPort = 3000;

    public static void main(String args[]) throws IOException {
        Interface anInterface = new Interface("Client");

        try{
            Socket socket = new Socket(serverIp,serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            anInterface.SendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        String msgout;
                        msgout = anInterface.serverChatInput.getText().trim();
                        out.println(msgout);
                        anInterface.serverChatOutput.append("\nMe: "+msgout);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            });

            String serverResponse;
            try{
                while(true) {
                    serverResponse = in.readLine();
                    if(serverResponse == null)break;
                    anInterface.serverChatOutput.append("\nServer says: " + serverResponse);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            socket.close();
            System.exit(0);

        }catch(Exception e){
            anInterface.serverChatOutput.append(e.getMessage());
        }



    }
}