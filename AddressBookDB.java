import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookDB  {
	public static void insertContact() {
		System.out.println("Inserting a new contact to adressbook table");
		Connection conn = AddressBookMainday35.getsqlConnection();
		if (conn != null) {
			String insertEmp = "INSERT INTO addressbookday35 (firstName,lastName,address,city,state,zip,phoneno,email) values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(insertEmp);
				preparedStatement.setString(1, "ABE");
				preparedStatement.setString(2, "XYV");
				preparedStatement.setString(3, "A 111");
				preparedStatement.setString(4, "Nodia");
				preparedStatement.setString(5, "UP");
				preparedStatement.setInt(6, 211025);
				preparedStatement.setString(7, "8934888214");
				preparedStatement.setString(8, "xyv@gmail.com");
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Data is Updated");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlException) {
						System.out.println(sqlException.getMessage());

					}
				}
			}
		}

	}public static void updateContactNameOfAdressbook() {
		System.out.println("Updating address of ABD");
		Connection conn = AddressBookMainday35.getsqlConnection();
		if (conn != null) {
			String updateEmpPayroll = "UPDATE addressbookday35 SET lastName = ? WHERE address ='A 111'";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(updateEmpPayroll);
				preparedStatement.setString(1, "ZZZZ");
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Data is Updated");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlException) {
						System.out.println(sqlException.getMessage());

					}
				}
			}
		}

	}
	public static void readAdressbook() {
		System.out.println("Displaying all data of adressBook table");
		Connection conn = AddressBookMainday35.getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM addressbookday35";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					String firstName = resultSet.getString(1);
					String lastName = resultSet.getString(2);
					String adress = resultSet.getString(3);
					String city = resultSet.getString(4);
					String state = resultSet.getString(5);
					Integer zip = resultSet.getInt(6);
					String phoneNumber = resultSet.getString(7);
					String email = resultSet.getString(8);
					String row = String.format(
							"User record:\n FirstName: %s,\n LastName: %s, \n Address: %s,  \n City: %s,\n State: %s , \n Zip: %d, \n PhoneNumber: %s, \n email:%s,\n",
							firstName, lastName, adress, city, state, zip, phoneNumber, email);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}
	public static void showdatabyState() {
		System.out.println("Displaying information from paticular state");
		Connection conn = AddressBookMainday35.getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT firstName FROM addressbookday35 WHERE state = 'UP'";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {

					String name = resultSet.getString(1);

					String row = String.format("User record: \n Name: %s", name);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}
	private static void showPersonName() {
		System.out.println("Displaying Name");
		Connection conn = AddressBookMainday35.getsqlConnection();

		try {
			if (conn != null) {

				String readEmpPayroll = "SELECT * FROM addressbookday35 WHERE empname ='ZZZ'";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Integer salary = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String gender = resultSet.getString(5);
					String row = String.format(
							"User record: \n Id: %d, \n Name: %s,\n Salary: %d, \n Date: %s,  \n Gender: %s \n", id,
							name, salary, date, gender);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}
	

}
