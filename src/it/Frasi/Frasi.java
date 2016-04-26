package it.Frasi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Frasi {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.out.println("Start reading file.");
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){
		    String line;
		    while ((line = br.readLine()) != null) {
		       add(line);
		    }
		}
		System.out.println("File readed successfully.\nWriting it in a new file.");
		System.out.println("Previsione output:\n");
		System.out.println(completo+"\n");
	    	File f = new File("output");
	    	if(f.exists() && !f.isDirectory()){} else {
	    		System.out.println("File \"output\" not found. Creating it.");
	    		newFile("output");
	    		System.out.println("File \"output\" created successfully.");
	    	}
		if(writer(completo, "output")==true){
			System.out.println("Output file writed successfully."); 
			System.out.print("All done!\n Exit...");
		} else {
			System.out.println("An error occoured while creating the output file");
			System.out.println("Exit...");
		}
		return;
	}
	public static String completo = "";
	public static void add(String text){
		completo = completo + text;
	}
	public static Boolean writer(String text, String path){
    	try {
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(text);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
    }
	public static Boolean newFile(String path){
    	File file = new File(path);
    	boolean blnCreated = false;
        try{
          blnCreated = file.createNewFile();
        }
        catch(IOException ioe){
        	System.out.println("Error while creating a new empty file :" + ioe);
        }
        //System.out.println(blnCreated);
        return blnCreated;
    }
}