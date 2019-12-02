package timesheetProject;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;

import com.timesheet.beans.User;
import com.timesheet.data.UserDAO;

public class UserDAOTest {

	 public static UserDAO userdao = new UserDAO();
	
	@Test 
	public void testAuthintication() throws SQLException {
		User obj = null;
		obj = userdao.authenticateUser("user1", "password");
		assertEquals("john", obj.getF_name());
		System.out.println(obj);
	}
		
}
