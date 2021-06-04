package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> cList;
    private Interface anInterface;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> cList, Interface anInterface) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);
        this.cList = cList;
        this.anInterface = anInterface;
    }
    @Override
    public void run() {
        try{
            while(true){
                String msg = in.readLine();
                anInterface.serverChatOutput.append("\n"+client.getRemoteSocketAddress()+" : "+msg);
                if(msg.equals("/help")){
                    out.println("Use the following commands to communicate with the server : \n /all");
                }else if(msg.startsWith("/all")){
                    outToAllClients(msg);
                }else if(msg.contains("x")){
                    out.println("Goodbye!");
                    client.close();
                }else{
                    out.println("\nType /help for commands.");
                }
            }
        }catch (IOException e){
            System.err.println("Exception in clientHandler");
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void serverMessage(String msg){
        for(ClientHandler client : cList){
            client.out.println(msg);
        }
    }

    private void outToAllClients(String msg){
        String outString = client.getRemoteSocketAddress()+ " says : ";
        outString+=msg;
        for (ClientHandler client : cList){
            client.out.println(outString);
        }
    }
}
