package org.oa.ajax_rest_demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.oa.ajax_rest_demo.model.Accessory;
import org.oa.ajax_rest_demo.model.Animal;
import org.oa.ajax_rest_demo.model.Food;

public class DaoFacade {

	private Connection connection;
	private AnimalDao animalDao;
	private FoodDao foodDao;
	private AccessoryDao accessoryDao;

	private Statement statement;

	public DaoFacade() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/zoo_shop", "root", "usbw");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (connection == null) {
			System.exit(1);
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		animalDao = new AnimalDao(statement, connection);
		foodDao = new FoodDao(statement, connection);
		accessoryDao = new AccessoryDao(statement, connection);
	}

	public BaseDao<Animal> getAnimalDao() {
		return animalDao;
	}

	public BaseDao<Food> getFoodDao() {
		return foodDao;
	}

	public BaseDao<Accessory> getAccessoriesDao() {
		return accessoryDao;
	}

	public void closeSqlConnection() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
