package csvmodifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CSVModifier { //Imports CSV file, assigns values to CSVInfo class object, then instantiates those values to CSVInfo indexes.
	
	public static String csvImport = filePath; //Input custom file path here
		
	public static void main(String[] args) {
		BufferedReader csvReader = null;
		String str = "";
		Map<String, CSVInfo> userMap = new HashMap<String, CSVInfo>();
				
		try {
			csvReader = new BufferedReader(new FileReader(csvImport)); //Imports CSV file using provided file path, then reads each line of file and splits data to individual data points.
			while ((str = csvReader.readLine()) != null) { 
				String[] userInfo = str.split(",");
				
				CSVInfo userData = new CSVInfo(userInfo[0], userInfo[1], userInfo[2], Integer.parseInt(userInfo[3]), userInfo[4]); //Assigns individual data points to specific array index.
				
				if (userMap.containsKey(userData.getUserID())) { //If CSV lines contain a user ID at index 0 as well as version number at index 3, stores only highest version number.
					if (userData.getVersion() > userMap.get(userData.getUserID()).getVersion()) {
						userMap.put(userData.getUserID(), userData);
					}
				} else {
					userMap.put(userData.getUserID(), userData);
				}
			}
		} catch (FileNotFoundException fnfe) { //If CSV file has any issue being imported or read, will throw exception.
			System.out.println("Your file cannot be found. Please try again.");
		} catch (IOException ioe) {
			System.out.println("There is an issue importing your file.");
		} finally {
			try {
				csvReader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		while (!userMap.isEmpty()) { //Iterates through CSV data to group information by insurance company.
			List<CSVInfo> userList = new ArrayList<CSVInfo>();
			Iterator<Map.Entry<String, CSVInfo>> mapItr = userMap.entrySet().iterator();
			Map.Entry<String, CSVInfo> mapEntry = mapItr.next();
			CSVInfo mapUser = mapEntry.getValue();
			userList.add(mapUser);
			mapItr.remove();
			
			while (mapItr.hasNext()) {
				mapEntry = mapItr.next();
				if (mapEntry.getValue().getInsCompany().contentEquals(mapUser.getInsCompany())) {
					userList.add(mapEntry.getValue());
					mapItr.remove();
				}
			}
			
			Collections.sort(userList);
			CSVWriter(mapUser, userList);
		}
	}
	
	private static void CSVWriter(CSVInfo user, List<CSVInfo> userList) { //Writes filtered and sorted data into individual CSV files.
		try {
			FileWriter csvWriter = new FileWriter(newFilePath + user.getInsCompany() + ".csv"); //Input new custom file path here.
			for (CSVInfo userData : userList) {
				csvWriter.write(userData.toString() + "\n");
			}
			csvWriter.close();
		} catch (IOException ioe) {
			System.out.println("There is an issue saving your data to new files.");
		}
	}
}
