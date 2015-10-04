package org.oa.ajax_rest_demo.dao;

import org.oa.ajax_rest_demo.model.Accessory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class AccessoryDao implements BaseDao<Accessory> {
	private Statement statement;
	private Connection connection;
	private ResultSet generatedKeys;

	public AccessoryDao(Statement statement, Connection connection) {
		this.connection = connection;
		this.statement = statement;

	}

	@Override
	public List<Accessory> loadAll(long idAnimal) {
		List<Accessory> accessories = new ArrayList<>();
		String query = "SELECT * FROM accessories where id_animal = " + idAnimal + ";";
		try {

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				accessories.add(new Accessory(id, name, cost));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accessories;
	}

	@Override
	public Accessory findById(long id) {
		Accessory Accessory = null;
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM accessories WHERE id=" + id + ";");
			while (resultSet.next()) {
				int local_id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				Accessory = new Accessory(local_id, name, cost);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accessory;
	}

	@Override
	public Accessory create(Accessory Accessory) {

		long id;

		try {

			statement.executeUpdate(
					"INSERT INTO accessories " + " (name, cost, id_animal)" + " VALUES ('" + Accessory.getName() + "','"
							+ Accessory.getCost() + "','" + Accessory.getIdAnimal() + "')",
					Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getLong(1);
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		return findById(id);
	}

	@Override
	public Accessory update(Accessory Accessory) {

		try {
			statement.executeUpdate("UPDATE accessories SET name='" + Accessory.getName() + "',cost='"
					+ Accessory.getCost() + "' WHERE id=" + Accessory.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return findById(Accessory.getId());
	}

	@Override
	public boolean delete(Accessory Accessory) {
		try {
			System.out.println("item.getId() =" + Accessory.getId());
			statement.executeUpdate("DELETE FROM accessories WHERE id=" + Accessory.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Accessory> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
