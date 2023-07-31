import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientUiFormController {
    public TextArea txtshowArea;
    public TextField txtmsgToSend;


    private static Socket socket = null;
    private static DataInputStream dataInputStream = null;
    private static DataOutputStream dataOutputStream = null;

    private void initServer(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost",5000);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = "";
                while(!message.equals("exit")){
                    message = dataInputStream.readUTF();
                    txtshowArea.setText(txtshowArea.getText()+"\n Server :\t"+message);
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
