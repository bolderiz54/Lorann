package model.dao;

import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ILoadedElement;

/**
 * <h1>The class DAO</h1>
 * This class collect all the Element in the DB according to the number of the level
 * @author Hugo
 *
 */
public class DAO extends AbstractDAO {
	private static String sql  = "{call sprite_level(?)}";
	
	/**
	 * This method load a level from the database
	 * @param paramLevel
	 * 			The number of the level to load
	 * @return List<ILoadedElement>
	 * 			The list of the positions and the name of the elements according to the paramLevel
	 * @throws SQLException
	 */
	public static List<ILoadedElement> loadLevel(final int paramLevel) throws SQLException {
		final CallableStatement callStatement = prepareCall(sql);
		ArrayList<ILoadedElement> level = new ArrayList<ILoadedElement>();
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
