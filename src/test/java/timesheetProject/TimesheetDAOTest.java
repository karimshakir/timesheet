package timesheetProject;

import org.junit.Test;

import com.timesheet.data.TimesheetDAO;

public class TimesheetDAOTest {

	private static TimesheetDAO dao = new TimesheetDAO();
	

	@Test
	public void testDelete() {
		dao.delete(3);
	}
}
