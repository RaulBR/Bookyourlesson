package ro.bydl.domain;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Vehicle extends AbstractModel{
	@NotEmpty
	private String brand;
	@NotEmpty
	private String carType;
	@NotEmpty
	private String fuel;
	@NotEmpty
	private String chassis;
	private int engine;
	@NotEmpty
	private String licensePlate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vignettes;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date insurance;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ITP;
	
	private long teacherId;
	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

	private String year;

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String _type) {
		this.carType = _type;
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
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public Date getVignettes() {
		return vignettes;
	}
	public void setVignettes(Date vignettes) {
		this.vignettes = vignettes;
	}
	public Date getInsurance() {
		return insurance;
	}
	public void setInsurance(Date insurance) {
		this.insurance = insurance;
	}
	public Date getITP() {
		return ITP;
	}
	public void setITP(Date iTP) {
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
		return "Vehicle [brand=" + brand + ", _type=" + carType + ", fuel=" + fuel + ", chassis=" + chassis + ", engine=" + engine + ", licensePlate="
				+ licensePlate + ", vignettes=" + vignettes + ", insurance=" + insurance + ", ITP=" + ITP + "]";
	}
	
	
	
	

}
