package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Vehicle;

public interface VehicleDAO extends BaseDao<Vehicle> {

	public Collection<Vehicle> getByLicence();
}
