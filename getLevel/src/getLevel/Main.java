package getLevel;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
		ArrayList<LoadedElement> list = new ArrayList<LoadedElement>();
		BufferedWriter buffer;
		String line;
		
		list = DAO.loadLevel(3);
		
		try {
			buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../lorannMap.csv")));
			for (LoadedElement elem : list) {
				line = elem.getName()+";"+elem.getPosition().x+";"+elem.getPosition().y+"\n";
				buffer.write(line);;
			}
			buffer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
