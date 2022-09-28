package br.senai.sc.lanchonete.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexãoFactory {
    private final String URL = "jdbc:mysql://localhost:3306/lanchonete";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public Connection connectDB() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão");
        }
    }
}
