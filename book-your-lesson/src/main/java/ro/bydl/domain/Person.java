package ro.bydl.domain;

public class Person extends AbstractModel {
	
	private String name;
	private String sirName;
	private long cnp;
	private String category;
	
	
	
	public String  getCategory() {
		return category;
	}
	public void setCategory(String  category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSirName() {
		return sirName;
	}
	public void setSirName(String sirName) {
		this.sirName = sirName;
	}
	public long getCnp() {
		return cnp;
	}
	public void setCnp(long cnp) {
		this.cnp = cnp;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cnp ^ (cnp >>> 32));
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
		Person other = (Person) obj;
		if (cnp != other.cnp)
			return false;
		return true;
	}
	

}
