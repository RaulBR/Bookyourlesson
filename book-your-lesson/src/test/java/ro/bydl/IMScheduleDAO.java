package ro.bydl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ro.bydl.domain.Schedule;

@SuppressWarnings("rawtypes")
public class IMScheduleDAO implements ScheduleDAO {
	private Map<Long, Schedule> schedules = new HashMap<Long, Schedule>();
	@Override
	public Collection<Schedule> getAll() {
		
		return null;
	}

	@Override
	public Schedule findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule update(Schedule model) {
		
		schedules.put(model.getId(),model);

		return model;
	}


	public boolean delete(Schedule model) {
		
		 boolean result = schedules.containsKey(model.getId());

		if (result)
			schedules.remove(model.getId());
		return result;
	}

		
	

	@Override
	public int edit(Schedule model) {
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
	public Object update(Object model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int edit(Object model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
