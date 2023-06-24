package com.example.controleS;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
public class scene2controller {

        @FXML
        private TextField MymsgID;
        @FXML
        private TextField PortID;

    @FXML
    private Button disconnectButton;

        @FXML
        private TextField HostID;
        PrintWriter pw;
        @FXML
        private ListView testview;

        @FXML
        protected void onconnect() throws IOException {
            String host=HostID.getText();
            int port = Integer.parseInt(PortID.getText());
            Socket s = new Socket(host,port);
            InputStream is = s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);
            OutputStream os = s.getOutputStream();
            String Ip = s.getRemoteSocketAddress().toString();
            pw = new PrintWriter(os,true);
            new Thread(()->{
                while(true){
                    try {
                        String reponse = br.readLine();
                        Platform.runLater(()->{
                            testview.getItems().add(reponse);
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
            disconnectButton.setVisible(true);
        }
    @FXML
    public void onDisconnect() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) disconnectButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
        @FXML
        public void onsubmit(){
            String message=MymsgID.getText();
            pw.println(message);
        }



}
