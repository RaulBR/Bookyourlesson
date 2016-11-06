package ro.bydl;

import java.util.Collection;

import ro.bydl.domain.Schedule;


public class IMScheduleDAO implements ScheduleDAO {
	//private Map<Long, Schedule> schedules = new HashMap<Long, Schedule>();
	@Override
	public Collection<Schedule> getAll() {
		
		return null;
	}

	


	
	

	@Override
	public long update(Schedule model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Schedule> searchByWeek(int week) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Schedule> searchSchedules(int startHour, int endHour, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Schedule> searchByStudentId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Schedule> searchByTeacherId(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Collection<Schedule> searchByStudentId(long id, long teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Schedule model) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Schedule findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long coutStudentStatus(String string, Long long1) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public long coutTeacherStatus(String string, Long long1) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Collection<Schedule> selectDistinctTeacherId() {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public long insert(Schedule model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
