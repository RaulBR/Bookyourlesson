package ro.bydl.service;

import java.util.ArrayList;

import ro.bydl.domain.Schedule;

public class ScheduleService {

	boolean isFree = true;
	ArrayList<Schedule> s = new ArrayList<>();

	public boolean checkIfFree(Schedule toBeCHecked) {

		ArrayList<Schedule> sq = new ArrayList<>();
		// TODO change getSchedule() to get form db!

		sq = getScheduels();

		for (Schedule s : sq) {

			if (s.equals(toBeCHecked)) {
				isFree = false;

			}
		}

		return isFree;

	}

	void setScheduels(ArrayList<Schedule> s) {

		this.s = s;
	}

	private ArrayList<Schedule> getScheduels() {

		return s;
	}

}
