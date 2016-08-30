package ro.bydl.domain;

public class Schedule {
private String startHour;
private String endHour;
private String day;
private String month;
private String year;
public String getStartHour() {
	return startHour;
}
public void setStartHour(String startHour) {
	this.startHour = startHour;
}
public String getEndHour() {
	return endHour;
}
public void setEndHour(String endHour) {
	this.endHour = endHour;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((day == null) ? 0 : day.hashCode());
	result = prime * result + ((endHour == null) ? 0 : endHour.hashCode());
	result = prime * result + ((month == null) ? 0 : month.hashCode());
	result = prime * result + ((startHour == null) ? 0 : startHour.hashCode());
	result = prime * result + ((year == null) ? 0 : year.hashCode());
	return result;
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
	if (day == null) {
		if (other.day != null)
			return false;
	} else if (!day.equals(other.day))
		return false;
	if (endHour == null) {
		if (other.endHour != null)
			return false;
	} else if (!endHour.equals(other.endHour))
		return false;
	if (month == null) {
		if (other.month != null)
			return false;
	} else if (!month.equals(other.month))
		return false;
	if (startHour == null) {
		if (other.startHour != null)
			return false;
	} else if (!startHour.equals(other.startHour))
		return false;
	if (year == null) {
		if (other.year != null)
			return false;
	} else if (!year.equals(other.year))
		return false;
	return true;
}


}
