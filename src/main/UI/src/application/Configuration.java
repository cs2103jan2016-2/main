package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Configuration extends Application 
{
	private static final String CONFIG_FIRSTLINE_VIRGIN_TRUE = "VIRGIN = TRUE";
	private static final String CONFIG_FIRSTLINE_VIRGIN_FALSE = "VIRGIN = FALSE";
	private static final String CONFIG_SECONDLINE_DIRECTORY_UNKNOWN = "DBDIR = EMPTY";
	private static final String CONFIG_SECONDLINE_DIRECTORY_KNOWN = "DBDIR = %1$s";
	
	final static public String configFileName = "Config.txt";
	final static public File file = new File(configFileName);
	public FileOutputStream outputStream;
	public boolean virgin;
	public ArrayList<String> listOfConfigs = new ArrayList<String>();
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			fileCheckCreate();
			readToList();
			
		} 
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	/**
	 *	if exist, proceed.
	 *	else, create config file.
	 * @throws IOException 
	 */	
	public void fileCheckCreate() throws IOException 
	{
		if(!checkFileExist())
		{
			createConfigFile();
			writeFormattedConfigFile();
		}
	}
	/**
	 *	write config file in a particular format:
	 *	VIRGIN: TRUE/FALSE
	 *	DBDIR: the directory link
	 * @throws IOException 
	 */	
	private void writeFormattedConfigFile() throws IOException 
	{
		outputStream.write((CONFIG_FIRSTLINE_VIRGIN_TRUE + System.getProperty("line.separator")).getBytes());
		outputStream.write((CONFIG_SECONDLINE_DIRECTORY_UNKNOWN + System.getProperty("line.separator")).getBytes());
	}
	private void readToList() throws IOException 
	{
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String text="";
		while ((text = bufferReader.readLine()) != null) 
		{
			listOfConfigs.add(text);
		}
		bufferReader.close();		
	}
	private void createConfigFile() 
	{
		try 
		{
			outputStream = new FileOutputStream(configFileName, true);
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
	}
	/**
	 *	check for config file existence.
	 */	
	public boolean checkFileExist() 
	{
		boolean exist = file.exists();
		return exist;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
