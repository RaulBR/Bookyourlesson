package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import ro.bydl.dao.VehicleDAO;

import ro.bydl.domain.Vehicle;

public class JdbcTemplateVehicleDao  implements VehicleDAO{
	
	@Autowired
	JdbcTemplate jdbcTeamplate;
	public Collection<Vehicle> getAll() {
		// TODO Auto-generated method stub
		return jdbcTeamplate.query("SELECT id, brand, model, fuel, chassis, engine, licensePlate, vignettes,"+ 
			       "insurance, \"ITP\" "+
			       "FROM public.vehicle;",
new  ScheduleMapper());
	}

	@Override
	public Vehicle findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Vehicle model) {
		
		return jdbcTeamplate.update("INSERT INTO public.vehicle( "+
	            "brand, model, fuel, chassis, engine, licensePlate, vignettes, "+
	            "insurance, ITP) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);", 
	            model.getBrand(),
	            model.get_type(),
	            model.getFuel(),
	            model.getChassis(),
	            model.getEngine(),
	            model.getLicensePlate(),
	            model.isVignettes(),
	            model.isInsurance(),
	            model.isITP()); 
	             
	    
	}

	@Override
	public int delete(Vehicle model) {
		// TODO Auto-generated method stub
		return 0;
	}
private static class ScheduleMapper implements RowMapper<Vehicle> {
		
		@Override
		public Vehicle mapRow(ResultSet rs, int arg1) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(rs.getInt("id"));
			vehicle.setBrand(rs.getString("brand"));
			vehicle.setFuel(rs.getString("week"));
			vehicle.setChassis(rs.getString("start_hour"));
			vehicle.setEngine(rs.getInt("end_hour"));
			vehicle.setLicensePlate(rs.getString("stundent_name"));
			vehicle.setVignettes(rs.getBoolean("teacher_name"));
			vehicle.setITP(rs.getBoolean("ITP"));	
			vehicle.setInsurance(rs.getBoolean("insurance"));
			return vehicle;
		}
}
@Override
public Collection<Vehicle> getByLicence() {
	// TODO Auto-generated method stub
	return null;
}
}
