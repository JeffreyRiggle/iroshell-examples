package examples.sharedui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class NotepadView extends AnchorPane implements Initializable {

	@FXML
	private Button save;
	
	@FXML
	private Button open;
	
	@FXML
	private TextArea notepad;
	
	public NotepadView() {
		FXMLLoader notepadLoader = new FXMLLoader(getClass().getResource("NotepadView.fxml"));
		notepadLoader.setRoot(this);
		notepadLoader.setController(this);
		
		try {
			notepadLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		save.setOnAction((e) -> {
			saveContents();
		});
		
		open.setOnAction((e) -> {
			openContents();
		});
	}
	
	private void saveContents() {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Text file", "*.txt"));
		File saveFile = chooser.showSaveDialog(super.getScene().getWindow());
		
		if (saveFile == null) {
			return;
		}
		
		try {
			FileOutputStream outputStream;
			outputStream = new FileOutputStream(saveFile);
			byte[] data = notepad.getText().getBytes();
			outputStream.write(data);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void openContents() {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Text file", "*.txt"));
		File content = chooser.showOpenDialog(super.getScene().getWindow());
		
		if (content == null) {
			return;
		}
		
		try {
			notepad.setText(getFileContent(content));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getFileContent(File file) throws IOException {
		String output = new String();
		FileInputStream inputStream = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = new String();
		
		while((line = reader.readLine()) != null) {
			output += line;
			output += "\n";
		}
		
		reader.close();
		return output;
	}
}