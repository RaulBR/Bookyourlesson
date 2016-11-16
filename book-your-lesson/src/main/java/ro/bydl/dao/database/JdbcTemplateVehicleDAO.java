package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.VehicleDAO;
import ro.bydl.domain.Vehicle;

@Component
public class JdbcTemplateVehicleDAO implements VehicleDAO {

	@Autowired
	JdbcTemplate jdbcTeamplate;

	public Collection<Vehicle> getAll() {
		
		return jdbcTeamplate.query("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes,"
				+ "insurance, itp, year,teacher_id   FROM public.vehicle;", new VehicleMapper());
	}

	@Override
	public Vehicle getByLicence(Vehicle vehicle) {
		
		return  jdbcTeamplate.queryForObject("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes,"
				+ "insurance, itp, year ,teacher_id  FROM public.vehicle WHERE  license_plate=? ", new Object[] {vehicle.getLicensePlate()},new VehicleMapper());
	}

	@Override

	public Vehicle findById(long id) {

		
		return  jdbcTeamplate.queryForObject("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes,"
				+ "insurance, itp, year ,teacher_id  FROM public.vehicle WHERE  id=? ", new Long[] {id},new VehicleMapper());
	}
	
	@Override
	public Collection<Vehicle> findByTeacherId(Long id) {
		
		return  jdbcTeamplate.query("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes, "+
      " insurance, itp, year, teacher_id "+
 "FROM public.vehicle WHERE  teacher_id=? ;", new Long[] {id},new VehicleMapper());
		
	}

	@Override

	public long insert(Vehicle model) {
		
		  
		  return jdbcTeamplate.update("INSERT INTO public.vehicle("
					+ " brand, model, fuel, chassis, engine, license_plate, vignettes, insurance, itp, year,teacher_id) " +

					"VALUES ( ?, ?, ?, ?, ?, ?, ?,?, ?,?,? ) ;", model.getBrand(), model.getCarType(), model.getFuel(),
					model.getChassis(), model.getEngine(), model.getLicensePlate(), model.getVignettes(),
					model.getInsurance(), model.getITP(),model.getYear(),model.getTeacherId());
		 }

	@Override
	public int delete(Vehicle model) {

		return jdbcTeamplate.update("DELETE FROM public.vehicle " + "WHERE id=?;", model.getId());
	}

	
	@Override
	public Vehicle findByChassis(String chassis) {
		// TODO Auto-generated method stub
		 return  jdbcTeamplate.queryForObject("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes, "+
			      " insurance, itp, year, teacher_id "+
			      "FROM public.vehicle WHERE  chassis=? ;", new String[] {chassis},new VehicleMapper());
	}
	@Override
	public Vehicle findbyLicencePlate(String licensePlate) {
		// TODO Auto-generated method stub
		return  jdbcTeamplate.queryForObject("SELECT id, brand, model, fuel, chassis, engine, license_plate, vignettes, "+
			      " insurance, itp, year, teacher_id "+
			      "FROM public.vehicle WHERE  license_plate=? ;", new String[] {licensePlate},new VehicleMapper());
	}

	private static class VehicleMapper implements RowMapper<Vehicle> {

		@Override
		public Vehicle mapRow(ResultSet rs, int arg1) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(rs.getInt("id"));
			vehicle.setBrand(rs.getString("brand"));
			vehicle.setCarType(rs.getString("model"));
			vehicle.setFuel(rs.getString("fuel"));
			vehicle.setChassis(rs.getString("chassis"));
			vehicle.setEngine(rs.getInt("engine"));
			vehicle.setLicensePlate(rs.getString("license_plate"));
			vehicle.setVignettes(rs.getDate("vignettes"));
			vehicle.setITP(rs.getDate("itp"));
			vehicle.setInsurance(rs.getDate("insurance"));
			vehicle.setYear(rs.getString("year"));
			vehicle.setTeacherId(rs.getLong("teacher_id"));
			return vehicle;
		}
	}

	@Override
	public void update(Vehicle model) {
		
		
	}

}

	


