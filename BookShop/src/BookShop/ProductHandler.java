package BookShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductHandler {
	
	private	BufferedReader inputstream = null;
	private String filename = null;
	
	public ProductHandler(String filename){
		try {
			this.filename = filename;
			File file = new File(filename);
			file.createNewFile();
			inputstream = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
	}
	public String readLine(){
		String line = null;
		try {
			line = inputstream.readLine();
		} catch (IOException e) { e.printStackTrace(); }
		return line;
	}
	public void writeFile(String file){
		FileWriter outputstream = null;
		try {
			outputstream = new FileWriter(filename);
			outputstream.write(file);
		} catch (IOException e) { e.printStackTrace(); }
	}
}