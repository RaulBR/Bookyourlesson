package ro.bydl.service.statistics.containers;

import ro.bydl.domain.Person;

public abstract class PersonStatisticContainer<T extends Person> extends StatisticContainer<Person> {
	public int getStatisticPercentage() {
		return 100;
	}
	private long done;
	private long pending;
	private long booked;
	private long notFree;
	private long absent;

	
	public long getDonePercentage() {
		
	return (this.getDone()*100/this.getTotal());
	}
	public long getPendingPercentage() {
		return ((getPending()*100/getTotal()));
	}
	public long getBookedPercentage() {
		return ((getBooked()*100/getTotal()));
	}
	public long getNotFreePercentage() {
		return ((getNotFree()*100/getTotal()));
	}
	public long getAbsentPercentage() {
		return ((getAbsent()*100/getTotal()));
	}
	public long getDone() {
		return done;
	}
	public void setDone(long done) {
		this.done = done;
	}
	public long getPending() {
		return pending;
	}
	public void setPending(long pending) {
		this.pending = pending;
	}
	public long getBooked() {
		return booked;
	}
	public void setBooked(long booked) {
		this.booked = booked;
	}
	public long getNotFree() {
		return notFree;
	}
	public void setNotFree(long notFree) {
		this.notFree = notFree;
	}
	public long getAbsent() {
		return absent;
	}
	public void setAbsent(long absent) {
		this.absent = absent;
	}
	
}
