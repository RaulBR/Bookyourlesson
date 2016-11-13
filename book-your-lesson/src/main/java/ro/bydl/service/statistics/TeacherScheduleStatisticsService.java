package ro.bydl.service.statistics;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.dao.TeacherDAO;
import ro.bydl.domain.Schedule;
import ro.bydl.domain.Teacher;
import ro.bydl.service.statistics.containers.TeacherStatisticalContainer;

@Service
public class TeacherScheduleStatisticsService {
	@Autowired
	private ScheduleDAO dao;
	@Autowired
	private TeacherDAO teacherDao;

	
	
	public TeacherStatisticalContainer howBusy(long teahcerId){
		TeacherStatisticalContainer tsc=new TeacherStatisticalContainer();
		tsc.setT(teacherDao.findById(teahcerId));
		tsc.setTotal(dao.cuntByTeacherId(teahcerId));
		tsc.setDone(dao.coutTeacherStatus("done", teahcerId));
		tsc.setAbsent(dao.coutTeacherStatus("absent", teahcerId));
		tsc.setPending(dao.coutTeacherStatus("pending", teahcerId));
		tsc.setBooked(dao.coutTeacherStatus("booked", teahcerId));
		return tsc;
		
	}
	public Collection<TeacherStatisticalContainer> howBusy() {
		List<TeacherStatisticalContainer> sorted = getBruteList();

		Collections.sort(sorted);

		return sorted;
	}
	

	public Collection<TeacherStatisticalContainer> howBusy(int week) {
		List<TeacherStatisticalContainer> sorted = getBruteList(week);

		Collections.sort(sorted);

		return sorted;
	}
	
	private List<TeacherStatisticalContainer> getBruteList() {
		List<TeacherStatisticalContainer> sorted = new LinkedList<>();

		for (Map.Entry<Long, Integer> teachers : scheduleCount(dao.getAll()).entrySet()) {
			Teacher tec = teacherDao.findById(teachers.getKey());
			TeacherStatisticalContainer statistic = new TeacherStatisticalContainer();

			getStatisticContainer(teachers, tec, statistic);
			sorted.add(statistic);

		}
		return sorted;
	}


	private void getStatisticContainer(Map.Entry<Long, Integer> teacher, Teacher tec,
			TeacherStatisticalContainer statistic) {
		statistic.setT(tec);
		statistic.setTotal(teacher.getValue());
		statistic.setDone(dao.coutTeacherStatus("done", (teacher.getKey())));
		statistic.setAbsent(dao.coutTeacherStatus("absent", (teacher.getKey())));
		statistic.setPending(dao.coutTeacherStatus("pending", (teacher.getKey())));
		statistic.setBooked(dao.coutTeacherStatus("booked", (teacher.getKey())));
	}
	
	private List<TeacherStatisticalContainer> getBruteList(int week) {
		List<TeacherStatisticalContainer> sorted = new LinkedList<>();

		for (Map.Entry<Long, Integer> teacher : scheduleCount(dao.searchByWeek(week)).entrySet()) {
			Teacher tec = teacherDao.findById(teacher.getKey());
			TeacherStatisticalContainer statistic = new TeacherStatisticalContainer();

			getStatisticContainer(teacher, tec, statistic);
			sorted.add(statistic);

		}
		return sorted;
	}

	private Map<Long, Integer> scheduleCount(Collection<Schedule> unsortedSchedules) {
		Map<Long, Integer> countedSchedules = new HashMap<>();
		for (Schedule schedule : unsortedSchedules) {

			long temp = schedule.getTeacherId();
			Integer count = countedSchedules.get(temp);
			countedSchedules.put(temp, (count == null) ? 1 : count + 1);
		}
		return countedSchedules;
	}

}
