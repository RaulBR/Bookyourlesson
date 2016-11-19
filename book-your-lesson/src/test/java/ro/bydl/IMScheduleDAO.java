package ro.bydl;

import java.util.Collection;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.domain.Schedule;


public class IMScheduleDAO implements ScheduleDAO {

	@Override
	public Collection<Schedule> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Schedule model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Schedule model) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void update(Schedule model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Schedule> searchByWeek(long studentId) {
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
	public Collection<Schedule> selectDistinctTeacherId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long coutStudentStatus(String status, long studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long coutTeacherStatus(int week, String status, long techerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long coutTeacherStatus(String status, long techerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long coutTeacherStatus(String status, long techerId, long studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long coutStudentStatus(int week, String status, long studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cuntByTeacherId(long teahcerId) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
	
	