package application;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private Slider slider;
	@FXML
	private Label l1;
	@FXML
	private Button b1;
	@FXML
	private TextField tf1;
	@FXML
	private Button b2;
	@FXML
	private TextField tf2;
	@FXML
	private Label l3;

	private int kor;
	private String S;
	HashMap<Integer, ArrayList<String>> h;

	public Controller() {
		h = new HashMap<Integer, ArrayList<String>>();
		S = new String();
	}

	@FXML
	public void drag() {
		l1.setText(Double.toString((int) slider.getValue()));

	}

	@FXML
	public void textchanged() {

	}

	@FXML
	public void click() {
		kor = (int) slider.getValue() % 100;
		S = tf1.getText();
		if (S.equals("")) {
			System.out.println("Error");
		} else {
			ArrayList<String> q = h.get(kor);
			if (q == null) {
				q = new ArrayList<String>();
				q.add(S);
				h.put(kor, q);
			} else {
				q.add(S);
			}
		System.out.println("Inserted "+kor+" "+S);
		}
	}

	@FXML
	public void count() {
		String S = tf2.getText();
		int kor = 0;
		if (S.equals("")) {
			System.out.println("Error");
		} else {
			try {
				kor = Integer.parseInt(tf2.getText()) % 100;
				ArrayList<String> q = h.get(kor);
				if (!h.containsKey(kor)) {
					System.out.println("Nobody was inserted wih that name");
				} else {
					for (int i = 0; i < q.size(); i++) {
						System.out.println(q.get(i));
					}

				}
			} catch (Exception e) {
				System.out.println("It contained other characters than numbers");
			}
		}
	}
}
