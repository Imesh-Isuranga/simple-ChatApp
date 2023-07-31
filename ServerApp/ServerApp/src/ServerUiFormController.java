import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUiFormController {
    public TextArea txtshowArea;
    public TextField txtmsgToSend;

    private static ServerSocket serverSocket = null;
    private static Socket socket = null;
    private static DataInputStream dataInputStream = null;
    private static DataOutputStream dataOutputStream = null;

    private void initServer(){
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(5000);
                socket = serverSocket.accept();
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = "";
                while(!message.equals("exit")){
                    message = dataInputStream.readUTF();
                    txtshowArea.setText(txtshowArea.getText()+"\n Client :\t"+message);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void initialize(){
        initServer();
    }

    public void sendOnAction(ActionEvent actionEvent) throws IOException {
        String messageToSend = "";
        messageToSend = txtmsgToSend.getText().trim();
        dataOutputStream.writeUTF(messageToSend);
    }
}
