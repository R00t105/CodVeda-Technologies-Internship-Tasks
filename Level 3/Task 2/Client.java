import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientName;

    public Client(Socket socket, String clientName) {

        try{

            this.socket = socket;
            this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientName = clientName;

        }catch(IOException e){
            closeEverything(socket, reader, writer);
        }

    }

    public void sendMessage(){

        try {
            writer.println(clientName);
            Scanner scanner = new Scanner(System.in);

            while(socket.isConnected()){
                String message = scanner.nextLine();
                writer.println(clientName + ": " + message);
            }
        } catch (Exception e) {
            closeEverything(socket, reader, writer);
        }

    }

    public void listenToMessage(){

        new Thread(() -> {
            String messageFromGroup;
            while(socket.isConnected()){
                try {
                    messageFromGroup = reader.readLine();
                    System.out.println(messageFromGroup);
                } catch (IOException e) {
                    closeEverything(socket, reader, writer);
                }
            }
        }).start();

    }

    public void closeEverything(Socket socket, BufferedReader reader, PrintWriter writer){

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

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name to join the chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 5000);
        Client client = new Client(socket, username);
        client.listenToMessage();
        client.sendMessage();
    }

}