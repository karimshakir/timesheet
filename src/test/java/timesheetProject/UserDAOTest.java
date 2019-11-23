package timesheetProject;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;

import com.timesheetProject.beans.User;
import com.timesheetProject.data.UserDAO;

public class UserDAOTest {

	 public static UserDAO userdao = new UserDAO();
	
	@Test 
	public void testSave() throws SQLException {
		// 0 is overwritten by the generated key
		User newUser = new User(5, "testUser", "user4@gmail.com", true);
		User obj = null;
		obj = userdao.save(newUser);
		assertEquals("testUser", obj.getName());
		System.out.println(obj);
	}
	
	@Test
	public void testfindById() {
		User expected = new User(5, "testUser", "user4@gmail.com", true);
		User actual = userdao.findByUserId(5);
		System.out.println(actual);
		assertTrue(expected.equals(actual));
		assertEquals(expected, actual);
	}
		
}
