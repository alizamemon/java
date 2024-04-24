package assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersInformationApplication {

    private static final String DB_URL = "jdbc:derby:E:/derby/player;create=true";
   

    private static Connection connection;
    private static JTextField textFieldName;
    private static JTextField textFieldCategory;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        JFrame frame = new JFrame("Players Information Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel labelName = new JLabel("Name");
        panel.add(labelName);

        textFieldName = new JTextField(20);
        panel.add(textFieldName);

        JLabel labelCategory = new JLabel("Category");
        panel.add(labelCategory);

        textFieldCategory = new JTextField(20);
        panel.add(textFieldCategory);

        JButton buttonInsert = new JButton("Insert");
        buttonInsert.addActionListener(e -> insertPlayer());
        panel.add(buttonInsert);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(e -> deletePlayer());
        panel.add(buttonDelete);

        JButton buttonList = new JButton("List");
        buttonList.addActionListener(e -> listPlayers());
        panel.add(buttonList);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private static void insertPlayer() {
        String name = textFieldName.getText();
        String category = textFieldCategory.getText();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO players (name, category) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, category);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Player inserted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to insert player", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void deletePlayer() {
        String name = textFieldName.getText();

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM players WHERE name = ?");
            statement.setString(1, name);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Player deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete player", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listPlayers() {
        List<String> players = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM players");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                players.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to list players", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, players, "Players", JOptionPane.INFORMATION_MESSAGE);
    }
}
