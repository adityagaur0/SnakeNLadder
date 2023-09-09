package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Win extends Main 
{

	public static void win(String string) 
	{
		Stage stage = new Stage();
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,Color.BEIGE);
		Image l = new Image("bg.jfif");
		ImageView winimage = new ImageView(l);
		root.getChildren().add(winimage);
		Image bg = new Image("win.jfif");
		ImageView backg = new ImageView(bg);
		backg.setFitWidth(300);
		backg.setFitHeight(300);
		root.getChildren().add(backg);
		
		Button exit = new Button("Exit");
		root.setRight(exit);
		
		exit.setOnAction(e -> 
		{
            if(e.getSource() == exit)
            {
            	stage.close();
            }
        });
		
		BorderPane.setMargin(exit,new Insets(0,0,0,180));
		stage.setWidth(300);
		stage.setHeight(300);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle(string);
		stage.show();
	}

}