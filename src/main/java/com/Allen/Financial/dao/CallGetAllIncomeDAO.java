package main.java.com.Allen.Financial.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import main.java.com.Allen.Financial.bean.Income;
//import oracle.jdbc.OracleTypes;

public class CallGetAllIncomeDAO {

	private static final int INCOME_NAME_INDEX = 1;
	private static final int RECIEVED_INDEX = 2;
	private static final int DUE_ON_INDEX = 3;
	private static final int RECIEVED_ON_INDEX = 4;
	private static final int RECURRING_INDEX = 5;
	private static final int AMOUNT_EXPECTED_INDEX = 6;
	private static final int AMOUNT_ACTUAL_INDEX = 7;
	private static final int USER_ID_INDEX = 8;
//	private static final int CURSOR_INDEX = 9;
	
	private static final String DATASOURCE = "jbdc/finances";
	
	public CallGetAllIncomeDAO() {}
	
	public List<Income> callGetAllIncome(Income income) throws ServletException {
//		public List<Income> callPostIncome(String income_name, Boolean recieved, Timestamp due_on,Timestamp recieved_on, 
//				Boolean recurring, Long amount_expected, Long amount_actual, Long user_Id) throws ServletException {
			
			final String methodName = "callGetAllIncome()";
			
//			final String query = "{call GETAllIncome(?,?,?,?,?,?,?,?,?)}";
			final String query = "{call GETAllIncome(?,?,?,?,?,?,?,?)}";
			
			Connection conn = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			
//			List<Income> incomeResultList = new ArrayList<Income>();
			
			try{
				conn = createConnection();
				
				cs = conn.prepareCall(query);
				cs.setString(INCOME_NAME_INDEX, income.getIncome_name());
				cs.setBoolean(RECIEVED_INDEX, income.getRecieved());
				cs.setTimestamp(DUE_ON_INDEX, income.getDue_on());
				cs.setTimestamp(RECIEVED_ON_INDEX, income.getRecieved_on());
				cs.setBoolean(RECURRING_INDEX, income.getRecurring());
				cs.setLong(AMOUNT_EXPECTED_INDEX, income.getAmount_expected());
				cs.setLong(AMOUNT_ACTUAL_INDEX, income.getAmount_actual());
				cs.setLong(USER_ID_INDEX, income.getUser_Id());
//				cs.registerOutParameter(CURSOR_INDEX, OracleTypes.CURSOR);
				
				cs.execute();
				
				rs = (ResultSet) cs.getObject(9);
				List<Income> incomeResultList = new ArrayList<Income>();
				
				while(rs.next()) {
				    long id = rs.getLong("id");
				    String income_name = rs.getString("income_name");
				    Boolean recieved = rs.getBoolean("recieved");
				    Timestamp due_on = rs.getTimestamp("due_on");
				    Timestamp recieved_on = rs.getTimestamp("recieved_on");
				    Boolean recurring = rs.getBoolean("recurring");
				    long amount_expected = rs.getLong("amount_expected");
				    long amount_actual = rs.getLong("amount_actual");
				    long user_Id = rs.getLong("userId");
				    
				    Income obj = new Income ();
				    obj.setId(id);
				    obj.setIncome_name(income_name);
				    obj.setRecieved(recieved);
				    obj.setDue_on(due_on);
				    obj.setRecieved_on(recieved_on);
				    obj.setRecurring(recurring);
				    obj.setAmount_expected(amount_expected);
				    obj.setAmount_actual(amount_actual);
				    obj.setUser_Id(user_Id);
				    
				    incomeResultList.add(obj);
				}
				return incomeResultList;
			}
			catch(NamingException | SQLException e) {
				throw new ServletException(e.getMessage());
				//throw new ServletException(e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			finally {
				cleanUpConnection(conn, cs, null);
			}
			
		}
		
		//Closing connection objects, ignoring null provided parameters
		private void cleanUpConnection(Connection conn, CallableStatement cs, ResultSet rs) {
			final String methodName = "cleanUpConnection()";
			try {
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e){
				
			}
			try {
				if(cs != null)
					cs.close();
			}
			catch(SQLException e) {
				
			}
			try {
				if(rs != null)
					rs.close();
			}
			catch(SQLException e) {
				
			}
		}
		
		//Opens connection to the jbdc defined by DATASOURCE
		private Connection createConnection() throws NamingException, SQLException {
			final Context ctx = new InitialContext();
			final DataSource ds = (DataSource) ctx.lookup(DATASOURCE);
			final Connection conn = ds.getConnection();
			
			return conn;
		}
}
