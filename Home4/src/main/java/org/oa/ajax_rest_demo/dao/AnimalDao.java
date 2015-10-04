package org.oa.ajax_rest_demo.dao;

import org.oa.ajax_rest_demo.model.Animal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class AnimalDao implements BaseDao<Animal> {
	private Statement statement;
	private Connection connection;
	private ResultSet generatedKeys;

    public AnimalDao(Statement statement, Connection connection) {
		this.connection = connection;
		this.statement = statement;
		
	}

    @Override
    public List<Animal> loadAll() {
    	List<Animal> animals = new ArrayList<>();
		try {
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM animals;");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				animals.add(new Animal(id, name, cost));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return animals;
    }

    @Override
    public Animal findById(long id) {
		Animal animal = null;
		try {
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM animals WHERE id=" + id
							+ ";");
			while (resultSet.next()) {
				int local_id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				animal = new Animal(local_id,name, cost);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animal;
    }

	@Override
	public Animal create(Animal item) {

		long id;
		
		try {
			
			statement.executeUpdate("INSERT INTO animals " + " (name, cost)"
					+ " VALUES ('" + item.getName() + "','" + item.getCost()
					+ "')", Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			ResultSet generatedKeys = statement.getGeneratedKeys();
			 if (generatedKeys.next()) {
	                id = generatedKeys.getLong(1);
	            }
	            else {
	            	return null;
	            }
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

		return findById(id);
		
	}

	@Override
	public Animal update(Animal changed) {
		
		try {
			statement.executeUpdate("UPDATE animals SET name='"
					+ changed.getName() + "',cost='" + changed.getCost()
					+ "' WHERE id=" + changed.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return findById(changed.getId());
	}

	@Override
	public boolean delete(Animal item) {
		try {

			statement.executeUpdate("DELETE FROM animals WHERE id=" + item.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Animal> loadAll(long idAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

}
