import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private static final ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientName;

    public ClientHandler(Socket socket){

        try {

            this.socket = socket;
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientName = reader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SERVER: " + clientName + " has joined the chat!");

        } catch (IOException e) {
            closeEverything(socket, reader, writer);
        }

    }

    public void broadcastMessage(String message){

        for (ClientHandler clientHandler : clientHandlers){
            try {
                if (!clientHandler.clientName.equals(clientName)){
                    clientHandler.writer.println(message);
                }
            } catch (Exception e) {
                closeEverything(socket, reader, writer);
            }
        }

    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + "\"" + clientName + "\"" + " has left the chat");
    }

    public void closeEverything(Socket socket, BufferedReader reader, PrintWriter writer){
        removeClientHandler();

        try{

            if(reader != null)
                reader.close();

            if(writer != null)
                writer.close();

            if(socket != null)
                socket.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        String messageFromClient;

        while(socket.isConnected()){
            try{
                messageFromClient = reader.readLine();
                broadcastMessage(messageFromClient);
            }catch (IOException e){
                closeEverything(socket, reader, writer);
                break;
            }

        }

    }

}
