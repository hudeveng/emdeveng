package com.pridet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pridet.dbo.MedicineStoreDO;
import com.pridet.geoLocation.GeoLocation;

@Repository("medicineStoreDao")
@Transactional
public class MedicineStoreDao extends BaseDao{
	
	public MedicineStoreDO saveStore(MedicineStoreDO msdo){
		getSession().save(msdo);
		System.out.println(msdo.getId());
		return msdo;
	}

	public List<MedicineStoreDO> findStoresByLatitudeAndLongitude(MedicineStoreDO msdo) {

		SessionFactoryImplementor impl = (SessionFactoryImplementor) getSession().getSessionFactory();
		ConnectionProvider cp = impl.getConnectionProvider();
		GeoLocation location = GeoLocation.fromDegrees(msdo.getLatitude(), msdo.getLongitude());
		GeoLocation[] boundingCoordinates = location.boundingCoordinates(5, 6371.01);
		boolean meridian180WithinDistance = boundingCoordinates[0].getLongitudeInRadians() > boundingCoordinates[1]
				.getLongitudeInRadians();

		java.sql.PreparedStatement statement;
		List<MedicineStoreDO> MedicineStores = new ArrayList<MedicineStoreDO>();

		try {
			Connection conn = cp.getConnection();
			statement = conn.prepareStatement(
					"SELECT * FROM Mastermedicinestore WHERE (latitude >= ? AND latitude <= ?) AND (longitude >= ? "
							+ (meridian180WithinDistance ? "OR" : "AND") + " longitude <= ?)");
			System.out.println("maxlatitude ::"+boundingCoordinates[0].getLatitudeInDegrees());
			System.out.println("maxlongitude ::"+ boundingCoordinates[0].getLongitudeInDegrees());
			System.out.println("minlatitude ::"+boundingCoordinates[1].getLatitudeInDegrees());
			System.out.println("minlongitude ::"+boundingCoordinates[1].getLongitudeInDegrees());
			statement.setDouble(1, boundingCoordinates[0].getLatitudeInDegrees());
			statement.setDouble(2, boundingCoordinates[1].getLatitudeInDegrees());
			statement.setDouble(3, boundingCoordinates[0].getLongitudeInDegrees());
			statement.setDouble(4, boundingCoordinates[1].getLongitudeInDegrees());
//			statement.setDouble(5, location.getLatitudeInDegrees());
//			statement.setDouble(6, location.getLatitudeInDegrees());
//			statement.setDouble(7, location.getLongitudeInDegrees());
//			statement.setDouble(8, 5 / 6371);
//			System.out.println("statement" + statement);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				MedicineStoreDO medicineStore = new MedicineStoreDO();
				medicineStore.setStorename(results.getString("storename"));
				medicineStore.setLatitude(results.getDouble("latitude"));
				medicineStore.setLongitude(results.getDouble("longitude"));
				System.out.println("latitude ::" + medicineStore.getLatitude());
				MedicineStores.add(medicineStore);
			}
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return MedicineStores;

	}

}
