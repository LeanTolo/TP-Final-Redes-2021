package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewClient {
    private static String serverIp = "127.0.0.1";
    private static final int serverPort = 3000;

    public static void main(String args[]) throws IOException {

        Socket socket = new Socket(serverIp,serverPort);
        ServerConnection serverConnection = new ServerConnection(socket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        new Thread(serverConnection).start();

        while (true){
            String msg = keyboard.readLine();

            if(msg.equals("exit")) break;

            out.println(msg);
        }
        socket.close();
        System.exit(0);

    }
}
