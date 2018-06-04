package model.dao;

import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	        ArrayList<LoadedElement> sql = new ArrayList<LoadedElement>();
	        callStatement.setInt(1, paramLevel);
	        if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                sql.add(new LoadedElement(result.getString(1), new Point(result.getInt(2), result.getInt(3))));
	            }
	            result.close();
	        }
	        return sql;
	    }
}
