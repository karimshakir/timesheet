package timesheetProject;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.timesheetProject.data.TimesheetDAO;

public class TimesheetDAOTest {

	private static TimesheetDAO dao = new TimesheetDAO();
	

	@Test
	public void testDelete() {
		dao.delete(3);
	}
}
