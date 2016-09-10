package ro.bydl.service;

public interface CalendarInterface {
	

		public void setWeek(int week);

		public void setPreviousWeek(int week) ;
		public void setThisWeek() ;

		public String getMonday() ;

		public String getTuesday() ;

		public String getWednesday() ;

		public String getThursday() ;

		public String getFriday() ;

		public String getSaturday();

		public String getSunday();
		

}
