package model.dao;

import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ILoadedElement;

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
	 public static ArrayList<ILoadedElement> loadLevel(final int paramLevel) throws SQLException {
		 final CallableStatement callStatement = prepareCall(sql);
		 ArrayList<ILoadedElement> level = new ArrayList<ILoadedElement>();
	     callStatement.setInt(1, paramLevel);
	     if (callStatement.execute()) {
	    	 final ResultSet result = callStatement.getResultSet();
	    	 while (result.next()) {
	    		 level.add(new LoadedElement(result.getString("Element"), new Point(result.getInt("X"), result.getInt("Y"))));
	    	 }
	    	 result.close();
	     }
	     return level;
	 }
	 
	 public static Point test() throws SQLException {
		 final CallableStatement callStatement = prepareCall("call test()");
		 Point level = new Point(0, 0);
	     if (callStatement.execute()) {
	    	 final ResultSet result = callStatement.getResultSet();
	    	 while (result.next()) {
	    		 level = new Point(result.getInt(1), result.getInt(2));
	    	 }
	    	 result.close();
	     }
	     return level;
	 }
}
