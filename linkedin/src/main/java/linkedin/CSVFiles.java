package linkedin;

import java.io.FileReader;
import java.io.FileWriter; 
import java.util.List;
import com.opencsv.CSVWriter;
 
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class CSVFiles {

	public static Object[][] readCSVFile(String filePath)throws Exception{ 
		
		CSVReader csvReader; 
		List<String[]> allElements = new ArrayList<>();
    	csvReader = new CSVReader(new FileReader(filePath));  
		allElements=csvReader.readAll(); 
    	String[][] data=new String[allElements.size()][allElements.get(0).length]; //[rows][columns]
    	
    	for (int j = 0; j < allElements.size(); j++)
    		for (int i = 0; i <allElements.get(0).length; i++)
    		data[j][i]=allElements.get(j)[i]; 
    	
    	return data; 
	}
	
	public static void writeToCSVFile(String filePath, List<String[]> entries) throws Exception{
		  
        CSVWriter writer = new CSVWriter(new FileWriter(filePath));  
        writer.writeAll(entries,true); 
        writer.close();
	}
	 
}
