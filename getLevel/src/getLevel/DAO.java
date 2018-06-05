package getLevel;

import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import getLevel.LoadedElement;

/**
 * This class collect all the Element in the DB according to the number of the level
 * @author Hugo
 *
 */
public class DAO extends AbstractDAO {
	private static String sql  = "{call sprite_level(?)}";
	
	/**
	 * This method 
	 * @param paramLevel
	 * @return the positions and the element according to the paramLevel
	 * @throws SQLException
	 */
	public static ArrayList<LoadedElement> loadLevel(final int paramLevel) throws SQLException {
		final CallableStatement callStatement = prepareCall(sql);
		ArrayList<LoadedElement> level = new ArrayList<LoadedElement>();
	    callStatement.setInt(1, paramLevel);
	    if (callStatement.execute()) {
	    	final ResultSet result = callStatement.getResultSet();
	    	for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
	    		level.add(new LoadedElement(result.getString("Element"), new Point(result.getInt("X"), result.getInt("Y"))));
	    	}
	    	result.close();
	    }
	    return level;
	}
	
}
