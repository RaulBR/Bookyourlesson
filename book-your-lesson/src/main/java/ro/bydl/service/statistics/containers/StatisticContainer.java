package ro.bydl.service.statistics.containers;

public abstract class StatisticContainer<T> {
	private T t;
	private int total;
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
