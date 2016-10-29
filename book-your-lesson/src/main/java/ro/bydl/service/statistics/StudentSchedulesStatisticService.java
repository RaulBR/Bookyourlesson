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
import ro.bydl.dao.StudnetDAO;

import ro.bydl.domain.Schedule;
import ro.bydl.domain.Student;
import ro.bydl.service.statistics.containers.StudentStatisticalContainer;

@Service
public class StudentSchedulesStatisticService {
	@Autowired
	private ScheduleDAO dao;
	@Autowired
	private StudnetDAO studentDao;
	
	public Collection<StudentStatisticalContainer> howBusy() {
		List<StudentStatisticalContainer> sorted = getBruteList();

		Collections.sort(sorted);

		return sorted;
	}
	

	public Collection<StudentStatisticalContainer> howBusy(int week) {
		List<StudentStatisticalContainer> sorted = getBruteList(week);

		Collections.sort(sorted);

		return sorted;
	}
	
	private List<StudentStatisticalContainer> getBruteList() {
		List<StudentStatisticalContainer> sorted = new LinkedList<>();

		for (Map.Entry<Long, Integer> student : scheduleCount(dao.getAll()).entrySet()) {
			System.out.println(student.getKey());
			System.out.println(student.getValue());
			Student stud = studentDao.findById(student.getKey());
			System.out.println(stud.getName());
			StudentStatisticalContainer statistic = new StudentStatisticalContainer();

			statistic.setT(stud);
			statistic.setTotal(student.getValue());
			statistic.setDone(dao.coutStudentStatus("done", (student.getKey())));
			statistic.setAbsent(dao.coutStudentStatus("absent", (student.getKey())));
			statistic.setPending(dao.coutStudentStatus("pending", (student.getKey())));
			statistic.setBooked(dao.coutStudentStatus("booked", (student.getKey())));
			sorted.add(statistic);

		}
		return sorted;
	}
	
	private List<StudentStatisticalContainer> getBruteList(int week) {
		List<StudentStatisticalContainer> sorted = new LinkedList<>();

		for (Map.Entry<Long, Integer> student : scheduleCount(dao.searchByWeek(week)).entrySet()) {
			
			Student tec = studentDao.findById(student.getKey());
			StudentStatisticalContainer statistic = new StudentStatisticalContainer();

			statistic.setT(tec);
			statistic.setTotal(student.getValue());
			statistic.setDone(dao.coutStudentStatus("done", (student.getKey())));
			statistic.setAbsent(dao.coutStudentStatus("absent", (student.getKey())));
			statistic.setPending(dao.coutStudentStatus("pending", (student.getKey())));
			statistic.setBooked(dao.coutStudentStatus("booked", (student.getKey())));
			sorted.add(statistic);

		}
		return sorted;
	}

	private Map<Long, Integer> scheduleCount(Collection<Schedule> unsortedSchedules) {
		Map<Long, Integer> countedSchedules = new HashMap<>();
		for (Schedule schedule : unsortedSchedules) {

			long temp = schedule.getStudentId();
			Integer count = countedSchedules.get(temp);
			countedSchedules.put(temp, (count == null) ? 1 : count + 1);
		}
		return countedSchedules;
	}

	
	
}
