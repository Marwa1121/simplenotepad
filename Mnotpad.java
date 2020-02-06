/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnotpad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType; 
import javafx.scene.control.*; 
import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.Desktop;
 

/**
 *
 * @author Acer
 */
public class Mnotpad extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MenuBar bar = new MenuBar ();
        
        Menu file =new Menu ("File");
        Menu edit =new Menu ("Edit");
        Menu help =new Menu ("Help");
        
        MenuItem newItem = new MenuItem("New");
        MenuItem openFileItem = new MenuItem("Open ");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");

        MenuItem undoItem = new MenuItem("Undo");
        MenuItem cutItem = new MenuItem("cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem deleteItem = new MenuItem("delete");
        MenuItem selectallItem = new MenuItem("SelectAll");

        MenuItem AboutMnotpad= new MenuItem("AboutMnotpad");

        bar.getMenus() .addAll(file, edit, help);
        file.getItems().addAll(newItem,openFileItem,exitItem,saveItem);
        edit.getItems().addAll(copyItem,pasteItem,undoItem,cutItem,deleteItem,selectallItem);
        help.getItems().addAll(AboutMnotpad);
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        
        
        TextArea textArea = new TextArea();
        
        
        BorderPane root = new BorderPane();
        Scene scene= new Scene(root, 500, 500);

       
       
        root.setTop(bar);
        root.setCenter(textArea);
        
        /*exit*/
    exitItem.setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
        System.exit(0);
    }
});
      
      /*NEWITEM*/  
      newItem.setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
   textArea.clear();
    }
});
       
      /*delet*/  
deleteItem.setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
        textArea.clear();
    }
}); 

/* help */
 Alert a = new Alert(AlertType.NONE); 
  
        // action event 
        EventHandler<ActionEvent> event1 = new 
                         EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                // set alert type 
                a.setAlertType(AlertType.CONFIRMATION); 
                a.setContentText("this is a text editor app"); 
                // show the dialog 
                a.show(); 
            } 
        }; 
        
        AboutMnotpad.setOnAction(event1);
  

/*save*/

 Alert a1 = new Alert(AlertType.NONE); 
  
     FileChooser fileChooser = new FileChooser();
    // action event 
        EventHandler<ActionEvent> event2 = new 
                         EventHandler<ActionEvent>() { 
              public void handle(ActionEvent e) 
            { 
                File selectedFile = fileChooser.showSaveDialog(primaryStage);
                  if (selectedFile != null) 
                  {
                             fileChooser.setTitle("save file"); 
                      textArea.appendText(""+selectedFile.getName()); 
              /**********modified*//////   
                      try {
            PrintWriter writer;
            writer = new PrintWriter(selectedFile);
            writer.println(textArea.getText());
            writer.close();
                             } 
               catch (Exception ex) {
            Logger.getLogger(SaveFileWithFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}};
              saveItem .setOnAction(event2);
       
       

/*open*/
 FileChooser fileChooser1 = new FileChooser();
EventHandler<ActionEvent> event3 = new 
              
                   EventHandler<ActionEvent>() { 
            private Desktop desktop = Desktop.getDesktop();

            public void handle(ActionEvent e) 
            { 
                File selectedFile = fileChooser1.showOpenDialog(primaryStage);
                  if (selectedFile != null) 
                  {
                       fileChooser1.setTitle("Open Resource File"); 
                      textArea.appendText(""+selectedFile.getName()); 
                      try {
            desktop.open(selectedFile);
                         } 
                      catch (Exception ex) {
            Logger.getLogger(
                FileChooserSample.class.getName()).log(Level.SEVERE, null, ex );
        }
    }
}};
       openFileItem .setOnAction(event3);
       
       
    selectallItem.setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
               textArea.selectAll();
    }
});    
  copyItem .setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
               textArea.copy();
    }
});
  cutItem .setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
               textArea.cut();
    }
}); 
 undoItem .setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
               textArea.undo();
    }
});           
 undoItem .setOnAction(new EventHandler<ActionEvent>() {
              @Override
    public void handle(ActionEvent event) {
               textArea.paste();
    }
});        
       
   


/***************************************/
        primaryStage.setTitle("Mnotpad");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }
    
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Application.launch(args);
    }
    
}
