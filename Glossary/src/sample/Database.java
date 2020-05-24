package sample;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    static final String DB_URL = "jdbc:sqlite:src/resources/glossary.db";
    static final String USER = "sa";
    static final String PASS = "";
    static final String TABLE = "glossary";
    static final String TERM = "term";
    static final String DESCRIPTION = "description";

    public static void addNewTerm(Term term) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO glossary (term, description) VALUES (?, ?)")) {
                preparedStatement.setObject(1, term.getTerm());
                preparedStatement.setObject(2, term.getDescription());
                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList getRandomTerm() {
        ArrayList<Term> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + TABLE + " ORDER BY RANDOM() LIMIT 10")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    list.add(new Term(resultSet.getString(TERM), resultSet.getString(DESCRIPTION)));
                }
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static void deleteTerm(Term term) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM " + TABLE + " WHERE (" + TERM + " = " + "\"" + term.getTerm() + "\")");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}