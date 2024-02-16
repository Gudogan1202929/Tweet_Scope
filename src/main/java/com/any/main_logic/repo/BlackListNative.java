package com.any.main_logic.repo;

import com.any.model.JWT_BL.dto.getTopicSummary_dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlackListNative {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false;trustServerCertificate=false;databaseName=Tweet_Scoop";
    private static final String JDBC_USER = "SA";
    private static final String JDBC_PASSWORD = "123456789Mm";

    public boolean findByToken(String token) {
        String sql = "SELECT * FROM black_tokens WHERE CAST(black_token AS NVARCHAR(MAX)) = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameter for the PreparedStatement
            preparedStatement.setString(1, token);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if at least one record is found
                if (resultSet.next()) {
                    return true; // Token found
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Token not found
    }



}
