package ro.bydl.domain;

import org.hibernate.validator.constraints.NotBlank;

public class Schedule extends AbstractModel {

	private int startHour;
	private int endHour;
	@NotBlank
	private String date;
	private int week;
	private boolean isFree;
	private long studentId;
	private long teacherId;
	@NotBlank
	private String status;
	
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	@Override
	public String toString() {
		return "Schedule [startHour=" + startHour + ", endHour=" + endHour + ", date=" + date + ", week=" + week
				+ ", isFree=" + isFree + ", studentId=" + studentId + ", teacherId=" + teacherId + ", status=" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		long result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + endHour;
		result = prime * result + (isFree ? 1231 : 1237);
		result = prime * result + startHour;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + studentId;
		result = prime * result + teacherId;
		result = prime * result + week;
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (endHour != other.endHour)
			return false;
		if (isFree != other.isFree)
			return false;
		if (startHour != other.startHour)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentId != other.studentId)
			return false;
		if (teacherId != other.teacherId)
			return false;
		if (week != other.week)
			return false;
		return true;
	}


}
