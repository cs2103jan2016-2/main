import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Configuration extends Application 
{
	private static final String CONFIG_FIRSTLINE_VIRGIN_TRUE = "VIRGIN = TRUE";
	private static final String CONFIG_FIRSTLINE_VIRGIN_FALSE = "VIRGIN = FALSE";
	private static final String CONFIG_SECONDLINE_DIRECTORY_UNKNOWN = "DBDIR = EMPTY";
	private static final String CONFIG_SECONDLINE_DIRECTORY_KNOWN = "DBDIR = %1$s";
	private static final String DIALOG_TITLE = "SAVE DATABASE"; 
	
	private static final int PARAM_FOR_DIR = 8;
	
	final static public String CONFIG_DEFAULT_FILENAME = "Config.txt";
	final static public String DB_DEFAULT_FILENAME = "DODODB";
	final static public File file = new File(CONFIG_DEFAULT_FILENAME);
	final static public FileChooser fileChooser = new FileChooser();
	public boolean virgin;
	public FileOutputStream outputStream;
	public Stage primaryStage;
	public ArrayList<String> listOfConfigs = new ArrayList<String>();
	public String strDBdir = "";
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		try 
		{
			fileCheckCreate(); //CREATE CONFIG FILE
			readToList(); //READ TO ARRAYLIST
			checkVirginity(); //SET VIRGIN TO FALSE
			checkDir(); // SET DIRECTORY
			if(finalCheck())
			{
				writeToConfig();
			}
			else
			{
				System.exit(0);
			}
		} 
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	private void writeToConfig() throws IOException {
		FileOutputStream out = new FileOutputStream(CONFIG_DEFAULT_FILENAME);
		if(!listOfConfigs.isEmpty())
		{
			clearText();
			out.write((listOfConfigs.get(0) + System.getProperty("line.separator")).getBytes());
			out.write((String.format(CONFIG_SECONDLINE_DIRECTORY_KNOWN, listOfConfigs.get(1)) + System.getProperty("line.separator")).getBytes());
		}		
	}
	private void clearText() throws IOException {
		FileWriter fileOut = new FileWriter(CONFIG_DEFAULT_FILENAME);
		fileOut.write("");
		fileOut.close();
	}
	private boolean finalCheck() 
	{
		if(boolVirgin() && boolTxtType() && boolKnownDIR())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean boolKnownDIR() {
		return !listOfConfigs.get(1).equals(CONFIG_SECONDLINE_DIRECTORY_UNKNOWN);
	}
	private boolean boolVirgin()
	{
		return listOfConfigs.get(0).equals(CONFIG_FIRSTLINE_VIRGIN_FALSE);
	}
	private boolean boolTxtType()
	{
		return listOfConfigs.get(1).contains(".txt");
	}
	
	private void checkDir() 
	{
		if(listOfConfigs.get(1).equals(CONFIG_SECONDLINE_DIRECTORY_UNKNOWN))
		{
			strDBdir = chooseDir();
		}
		else 
		{
			strDBdir = retrieveDir(listOfConfigs.get(1));
			
			System.out.println(strDBdir);
		}
	}
	private String chooseDir() 
	{
		initFileChooser();
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file != null)
        {
            SaveFile("", file);
        }
        else if(!file.getPath().contains(".txt"))
        {
          	 chooseDir();
        }
        else
        {
       	 	System.exit(0);
        }
     	 listOfConfigs.set(1, file.getPath());

        return file.getPath();	 
	}
	private void initFileChooser() 
	{
		fileChooser.setTitle(DIALOG_TITLE);
		fileChooser.setInitialFileName(DB_DEFAULT_FILENAME);
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);		
	}
	private void SaveFile(String content, File file)
	{
	        try 
	        {
	            FileWriter fileWriter;
	            fileWriter = new FileWriter(file);
	            fileWriter.write(content);
	            fileWriter.close();
	        } 
	        catch (IOException ex)
	        {
	            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}
	private String retrieveDir(String strRaw)
	{
		return strRaw.substring(PARAM_FOR_DIR, strRaw.length());
	}
	private void checkVirginity() 
	{
		if(listOfConfigs.get(0).equals(CONFIG_FIRSTLINE_VIRGIN_TRUE))
		{
			listOfConfigs.set(0,CONFIG_FIRSTLINE_VIRGIN_FALSE);
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
			outputStream = new FileOutputStream(CONFIG_DEFAULT_FILENAME, true);
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
	public String getDBdir()
	{
		return strDBdir;
	}
	
}
