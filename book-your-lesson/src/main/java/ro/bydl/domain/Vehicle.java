package ro.bydl.domain;

public abstract class Vehicle {
	private String brand;
	private String _type;
	private String fuel;
	private String chassis;
	private String engine;
	private String licensePlate;
	private boolean vignettes;
	private boolean insurance;
	private boolean ITP;
	

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public boolean isVignettes() {
		return vignettes;
	}
	public void setVignettes(boolean vignettes) {
		this.vignettes = vignettes;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public boolean isITP() {
		return ITP;
	}
	public void setITP(boolean iTP) {
		ITP = iTP;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassis == null) ? 0 : chassis.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (chassis == null) {
			if (other.chassis != null)
				return false;
		}
		else if (!chassis.equals(other.chassis))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		}
		else if (!licensePlate.equals(other.licensePlate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", _type=" + _type + ", fuel=" + fuel + ", chassis=" + chassis + ", engine=" + engine + ", licensePlate="
				+ licensePlate + ", vignettes=" + vignettes + ", insurance=" + insurance + ", ITP=" + ITP + "]";
	}
	
	
	
	

}
