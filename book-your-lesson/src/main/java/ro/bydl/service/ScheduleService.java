package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import ro.bydl.domain.Schedule;

@Service
public class ScheduleService extends CalendarService {

private	boolean isFree = true;

	ArrayList<Schedule> s = new ArrayList<>();

	public boolean checkIfFree(Schedule toBeCHecked) {

		ArrayList<Schedule> sq = new ArrayList<>();
		// TODO change getSchedule() to get form db!

		sq = s;

		for (Schedule s : sq) {

			if (s.equals(toBeCHecked)) {

				isFree = false;

			}
		}

		return isFree;

	}

	public int validate(Schedule schedule) throws ValidationException {

		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();

		try {
			cal.setTime(df.parse(schedule.getDate()));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (cal.get(Calendar.YEAR) > Calendar.getInstance().get(Calendar.YEAR) + 1) {
			System.out.println("error");
		}

		return Calendar.getInstance().get(Calendar.YEAR);

	}

	private ArrayList<Schedule> getScheduels() {

		return s;
	}

	public void save(Schedule schedule) {
		s.add(schedule);

	}

	public boolean getIsFree() {
		return isFree;

	}

}
