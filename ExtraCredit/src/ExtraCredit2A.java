import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.util.Duration;
import java.util.Random;
public class ExtraCredit2A extends Application {
	static int num=0;

	public static void main (String []args){
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception, InterruptedException {
		Pane p = new Pane();
		Image []d = new Image[6];
		d[5] = new Image	("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Dice-6a.svg/557px-Dice-6a.svg.png");
		d[4] = new Image	("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Dice-5.svg/600px-Dice-5.svg.png");
		d[3] = new Image	("https://upload.wikimedia.org/wikipedia/commons/a/a9/Dice-4.png");
		d[2] = new Image	("https://upload.wikimedia.org/wikipedia/commons/4/40/Dice-3E.png");
		d[1] = new Image	("https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Dice-2a-b.svg/120px-Dice-2a-b.svg.png");
		d[0] = new Image	("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Dice-1-b.svg/2000px-Dice-1-b.svg.png");
		Image dq = new Image ("https://teens.drugabuse.gov/sites/default/files/styles/medium/public/blog/shutterstock_57736897_0.jpg?itok=VXPlPiyZ");

		
		
		

		//Dice Pics	
		ImageView dice = new ImageView();
		
		ImageView q = new ImageView(dq);

		dice.setVisible(false);

		//Set Size and Position
		dice.setFitHeight(300);
		dice.setFitWidth(300);
		dice.setX(150);
		dice.setY(150);



		q.setFitHeight(300);
		q.setFitWidth(300);
		q.setX(150);
		q.setY(150);

		Random ran = new Random();
		num = ran.nextInt(6);
		System.out.println(num);


		//Text to enter number
		TextField txt = new TextField();
		txt.setPrefSize(30, 30);
		txt.setLayoutX(175);
		txt.setLayoutY(550);
		txt.setTextFormatter(new TextFormatter<String>((Change change) -> {
			String newText = change.getControlNewText();
			if (newText.length() > 1) {
				return null ;
			} else {
				return change ;
			}
		}));

		Button guess = new Button("Guess");
		guess.setLayoutX(100);
		guess.setLayoutY(550);

		Timeline tl = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(dice.imageProperty(),d[0])),
				new KeyFrame(Duration.seconds(.1),new KeyValue(dice.imageProperty(),d[2])),
				new KeyFrame(Duration.seconds(.2),new KeyValue(dice.imageProperty(),d[1])),
				new KeyFrame(Duration.seconds(.3),new KeyValue(dice.imageProperty(),d[3])),
				new KeyFrame(Duration.seconds(.4),new KeyValue(dice.imageProperty(),d[1])),
				new KeyFrame(Duration.seconds(.5),new KeyValue(dice.imageProperty(),d[5])),
				new KeyFrame(Duration.seconds(.6), new KeyValue(dice.imageProperty(),d[0])),
				new KeyFrame(Duration.seconds(.7),new KeyValue(dice.imageProperty(),d[5])),
				new KeyFrame(Duration.seconds(.8),new KeyValue(dice.imageProperty(),d[2])),
				new KeyFrame(Duration.seconds(.9),new KeyValue(dice.imageProperty(),d[4])),
				new KeyFrame(Duration.seconds(1), new KeyValue(dice.imageProperty(),d[3])),
				new KeyFrame(Duration.seconds(1.1),new KeyValue(dice.imageProperty(),d[1])),
				new KeyFrame(Duration.seconds(1.2),new KeyValue(dice.imageProperty(),d[5])),
				new KeyFrame(Duration.seconds(1.3),new KeyValue(dice.imageProperty(),d[3])),
				new KeyFrame(Duration.seconds(1.4),new KeyValue(dice.imageProperty(),d[1])),
				new KeyFrame(Duration.seconds(1.5),new KeyValue(dice.imageProperty(),d[0])),
				new KeyFrame(Duration.seconds(1.6), new KeyValue(dice.imageProperty(),d[4])),
				new KeyFrame(Duration.seconds(1.7),new KeyValue(dice.imageProperty(),d[0])),
				new KeyFrame(Duration.seconds(1.8),new KeyValue(dice.imageProperty(),d[1])),
				new KeyFrame(Duration.seconds(1.9),new KeyValue(dice.imageProperty(),d[4])),
				new KeyFrame(Duration.seconds(2.0),new KeyValue(dice.imageProperty(),d[2])),
				new KeyFrame(Duration.seconds(2.1),new KeyValue(dice.imageProperty(),d[5])),
				new KeyFrame(Duration.seconds(2.2),new KeyValue(dice.imageProperty(),d[2])),
				new KeyFrame(Duration.seconds(2.3), new KeyValue(dice.imageProperty(),d[0])),
				new KeyFrame(Duration.seconds(2.4),new KeyValue(dice.imageProperty(),d[num]))
			);
		
		
		
		

		Text text = new Text("Guess a number 1-6:");
		text.setX(25);
		text.setY(100);
		Button ng = new Button("New Game");
		ng.setLayoutX(25);
		ng.setLayoutY(520);
		ng.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try {
					start(primaryStage);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Button e = new Button("Exit");
		e.setLayoutX(25);
		e.setLayoutY(550);
		e.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				System.exit(0);
			}
		});


		guess.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				q.setVisible(false);
				dice.setVisible(true);
				
				tl.play();
				int rnum = num;
				
				if((rnum)==(Integer.valueOf(txt.getText())-1)){
					text.setText("You Win!");
					guess.setVisible(false);
				}
				else{
					text.setText("You Lose!");
					guess.setVisible(false);
					
				}
				
				
			}

		});





		p.getChildren().addAll(e,text,txt,guess,q,dice,ng);

		Scene s = new Scene(p,600,600);

		primaryStage.setScene(s);
		primaryStage.show();

	}

	
}
