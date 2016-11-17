package ro.bydl.service.statistics.containers;

public abstract class StatisticContainer<T> {
	private T t;
	private long total;
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long studentId) {
		this.total = studentId;
	}
	
	
}
