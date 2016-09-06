package ro.bydl.person;



public class Teacher extends Person {
	private Category category;
	private Vehicle vehicle;
	private boolean atestat;
	protected String userName;
	protected String password;

	

	public Category getCategory() {
		return category;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public boolean isAtestat() {
		return atestat;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setAtestat(boolean atestat) {
		this.atestat = atestat;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher teacher = (Teacher) obj;
		if (category == null) {
			if (teacher.getCategory() != null)
				return false;
		} else if (vehicle == null) {
			if (teacher.getVehicle() != null)
				return false;
		} else if (atestat == false) {
			if (teacher.isAtestat() == false)
				return false;
		}
		return true;
	}

}
