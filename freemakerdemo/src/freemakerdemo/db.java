package freemakerdemo;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

public class db {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/information_schema","root","");
		return conn;
		
	}
	// 获取数据库中所有表的表名，并添加到列表结构中。
	public static List getTableList(Connection conn) throws SQLException {
	    List<Map> tableList = new ArrayList<Map>();

	    String sql =
	        "SELECT * FROM user_tab_comments WHERE table_type='TABLE'";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        Map map = new HashMap<>();
	        String TABLE_NAME = rs.getString("TABLE_NAME");
	        String COMMENTS = rs.getString("COMMENTS");
	        map.put("TABLE_NAME", TABLE_NAME);
	        map.put("COMMENTS", COMMENTS == null ? "" : COMMENTS);

	        //获取列
	        List<Map> columnList = getColumnList(conn, TABLE_NAME);
	        map.put("COLUMNS", columnList);

	        //这里是过滤特殊的表，比如只生成SYS开头的表
	        if (TABLE_NAME.startsWith("SYS"))
	            tableList.add(map);
	        //System.out.println("TABLE_NAME ===>" + TABLE_NAME + "  COMMENTS==>" + COMMENTS);
	    }
	    rs.close();
	    ps.close();
	    return tableList;
	}
	
	// 获取数据表中所有列的列名，并添加到列表结构中。
	public static List getColumnList(Connection conn, String tableName)
	    throws SQLException {

	    List<Map> columnList = new ArrayList<Map>();

	    String sql =
	        "SELECT utc.table_name,utc.column_name,utc.data_type,utc.data_length,utc.data_default,utc.nullable,ucc.comments,p.PRIMARY_KEY " +
	        "FROM  user_tab_columns utc " +
	        "LEFT JOIN user_col_comments ucc " + //--查询注释
	        "ON utc.table_name = ucc.table_name " +
	        "AND  utc.column_name = ucc.column_name " +
	        "LEFT JOIN " + //--查询主键
	        "( SELECT col.table_name table_name, col.column_name column_name, CASE con.constraint_type WHEN 'P' THEN    'true' ELSE 'false' END PRIMARY_KEY " +
	        "FROM user_constraints con,user_cons_columns col " +
	        "WHERE con.constraint_name = col.constraint_name " +
	        "AND con.constraint_type = 'P') p " +
	        "ON utc.column_name = p.column_name " +
	        "AND p.table_name = utc.table_name " +
	        "WHERE utc.table_name = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, tableName);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        Map map = new HashMap<>();

	        String COLUMN_NAME = rs.getString("COLUMN_NAME");
	        String DATA_TYPE = rs.getString("DATA_TYPE");//VARCHAR2
	        String DATA_LENGTH = rs.getString("DATA_LENGTH");//200
	        String DATA_DEFAULT = rs.getString("DATA_DEFAULT");
	        String NULLABLE = rs.getString("NULLABLE");
	        String COMMENTS = rs.getString("COMMENTS");
	        String PRIMARY_KEY = rs.getString("PRIMARY_KEY");

	        map.put("COLUMN_NAME", COLUMN_NAME);
	        map.put("DATA_TYPE", DATA_TYPE);
	        map.put("DATA_LENGTH", DATA_LENGTH);
	        map.put("DATA_DEFAULT", DATA_DEFAULT == null ? "" : DATA_DEFAULT);
	        map.put("NULLABLE", "N".equals(NULLABLE) ? false : true);
	        map.put("COMMENTS", COMMENTS == null ? "" : COMMENTS);
	        map.put("PRIMARY_KEY", "true".equals(PRIMARY_KEY) ? true : false);
	        columnList.add(map);

	        //System.out.println("COLUMN_NAME ==>" + COLUMN_NAME + "  DATA_TYPE==>" + DATA_TYPE + "  DATA_LENGTH==>" + DATA_LENGTH + " NULLABLE==>" + NULLABLE + "  COMMENTS==>" + COMMENTS + " PRIMARY_KEY==>" + PRIMARY_KEY);
	    }
	    rs.close();
	    ps.close();
	    return columnList;
	}
	
	public static List<Map> getTableColumn_mysql(String schema, String tableName) throws SQLException
	{
		try {
			return getTableColumn_mysql(getConnection(), tableName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Map> getTableColumn_mysql(Connection conn, String tableName)
		    throws SQLException {

		    List<Map> columnList = new ArrayList<Map>();

		       
		    
		    String sql="SELECT *\r\n" + 
		    		"from COLUMNS where TABLE_SCHEMA='test' and table_name='"+tableName+"'";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    //ps.setString(1, tableName);
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		        Map<String, String> map = new HashMap<>();

		        String COLUMN_NAME = rs.getString("COLUMN_NAME");
		        String DATA_TYPE = rs.getString("DATA_TYPE");//VARCHAR2
		       /* String DATA_LENGTH = rs.getString("DATA_LENGTH");//200
		        String DATA_DEFAULT = rs.getString("DATA_DEFAULT");
		        String NULLABLE = rs.getString("NULLABLE");
		        String COMMENTS = rs.getString("COMMENTS");
		        String PRIMARY_KEY = rs.getString("PRIMARY_KEY");*/

		        if (DATA_TYPE.toUpperCase().contains("VARCHAR")) {
		        	DATA_TYPE="String";
				}

		        
		        map.put("COLUMN_NAME", COLUMN_NAME);
		        map.put("DATA_TYPE", DATA_TYPE);
		       /* map.put("DATA_LENGTH", DATA_LENGTH);
		        map.put("DATA_DEFAULT", DATA_DEFAULT == null ? "" : DATA_DEFAULT);
		        map.put("NULLABLE", "N".equals(NULLABLE) ? false : true);
		        map.put("COMMENTS", COMMENTS == null ? "" : COMMENTS);
		        map.put("PRIMARY_KEY", "true".equals(PRIMARY_KEY) ? true : false);*/
		        columnList.add(map);

		        //System.out.println("COLUMN_NAME ==>" + COLUMN_NAME + "  DATA_TYPE==>" + DATA_TYPE );
		    }
		    rs.close();
		    ps.close();
		    conn.close();
		    return columnList;
		}
	
}