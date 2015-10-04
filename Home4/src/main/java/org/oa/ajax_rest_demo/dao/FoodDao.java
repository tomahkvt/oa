package org.oa.ajax_rest_demo.dao;

import org.oa.ajax_rest_demo.model.Food;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class FoodDao implements BaseDao<Food> {
	private Statement statement;
	private Connection connection;
	private ResultSet generatedKeys;

    public FoodDao(Statement statement, Connection connection) {
		this.connection = connection;
		this.statement = statement;
		
	}

    @Override
    public List<Food> loadAll(long idAnimal) {
    	List<Food> foods = new ArrayList<>();
    	String query = "SELECT * FROM food where id_animal = " + idAnimal + ";";
		try {
			 
			ResultSet resultSet = statement
					.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				foods.add(new Food(id, name, cost));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foods;
    }

	@Override
	public Food findById(long id) {
		Food food = null;
		try {
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM food WHERE id=" + id
							+ ";");
			while (resultSet.next()) {
				int local_id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double cost = resultSet.getInt("cost");
				food = new Food(local_id,name, cost);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public Food create(Food food) {
		
		long id;
		
		try {
			
			statement.executeUpdate("INSERT INTO food " + " (name, cost, id_animal)"
					+ " VALUES ('" + food.getName() + "','" + food.getCost() + "','" + food.getIdAnimal()
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
		System.out.println("test2");
		return findById(id);
	}

	@Override
	public Food update(Food food) {
		
		try {
			statement.executeUpdate("UPDATE food SET name='"
					+ food.getName() + "',cost='" + food.getCost()
					+ "' WHERE id=" + food.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return findById(food.getId());
	}

	@Override
	public boolean delete(Food food) {
		try {
			System.out.println("item.getId() =" + food.getId());
			statement.executeUpdate("DELETE FROM food WHERE id=" + food.getId() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Food> loadAll() {
		
		return null;
	}


}
