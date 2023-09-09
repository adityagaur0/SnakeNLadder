package application;
import javafx.scene.image.Image;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Boxes extends Rectangle
{
	public Boxes(int l, int b)
	{
		setWidth(Main.Box);
		setHeight(Main.Box);
		setFill(Color.PINK);
		setStroke(Color.BLACK);
	}
}
