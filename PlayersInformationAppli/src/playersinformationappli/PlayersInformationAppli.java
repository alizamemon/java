package playersinformationappli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

// Player class - serves as the base class
class Player {
    protected String name;
    protected int age;
    protected String nationality;
    protected int playerID;

    // Constructor
    public Player(String name, int age, String nationality, int playerID) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.playerID = playerID;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPlayerID() {
        return playerID;
    }
}

// Interface for Player Information
interface PlayerInformation {
    void displayPlayerInformation();

    void insertPlayerInformation(Player player);

    void deletePlayerInformation(int playerID);
}

// FootballPlayer class - extends Player and implements PlayerInformation
// FootballPlayer class - extends Player and implements PlayerInformation
class FootballPlayer extends Player implements PlayerInformation {
    public FootballPlayer(String name, int age, String nationality, int playerID) {
        super(name, age, nationality, playerID);
    }

    @Override
    public void displayPlayerInformation() {
        // Database connectivity code to retrieve and display player information
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:E:/derby/player;create=true");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM football_players WHERE playerID = " + getPlayerID());

            if (rs.next()) {
                String playerName = rs.getString("name");
                int playerAge = rs.getInt("age");
                String playerNationality = rs.getString("nationality");

                JOptionPane.showMessageDialog(null, "Player ID: " + getPlayerID() +
                        "\nName: " + playerName +
                        "\nAge: " + playerAge +
                        "\nNationality: " + playerNationality, "Player Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Player not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPlayerInformation(Player player) {
        // Database connectivity code to insert player information
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:E:/derby/player;create=true");
            PreparedStatement statement = conn.prepareStatement("INSERT INTO football_players (name, age, nationality, playerID) VALUES (?, ?, ?, ?)");
            statement.setString(1, player.getName());
            statement.setInt(2, player.getAge());
            statement.setString(3, player.getNationality());
            statement.setInt(4, player.getPlayerID());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Player information inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert player information!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayerInformation(int playerID) {
        // Database connectivity code to delete player information
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:E:/derby/player;create=true");
            PreparedStatement statement = conn.prepareStatement("DELETE FROM football_players WHERE playerID = ?");
            statement.setInt(1, playerID);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Player information deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete player information!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


// Main GUI Application class
public class PlayersInformationAppli extends JFrame {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel ageLabel;
    private JTextField ageTextField;
    private JLabel nationalityLabel;
    private JTextField nationalityTextField;
    private JLabel playerIDLabel;
    private JTextField playerIDTextField;
    private JButton displayButton;
    private JButton insertButton;
    private JButton deleteButton;

    public PlayersInformationAppli() {
        setTitle("Players Information App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addComponents();

        // Event listeners for buttons
      displayButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int playerID = Integer.parseInt(playerIDTextField.getText());
        FootballPlayer player = new FootballPlayer("", 0, "", playerID);
        player.displayPlayerInformation();
    }
});

       insertButton.addActionListener(new ActionListener() {
      @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        String nationality = nationalityTextField.getText();
        int playerID = Integer.parseInt(playerIDTextField.getText());
        Player player = new FootballPlayer(name, age, nationality, playerID);
        ((FootballPlayer) player).insertPlayerInformation(player); // Cast to FootballPlayer and call the method
    }
});


        deleteButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int playerID = Integer.parseInt(playerIDTextField.getText());
        FootballPlayer player = new FootballPlayer("", 0, "", playerID);
        player.deletePlayerInformation(playerID);
    }
});
    }

    private void initComponents() {
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        ageLabel = new JLabel("Age:");
        ageTextField = new JTextField();

        nationalityLabel = new JLabel("Nationality:");
        nationalityTextField = new JTextField();

        playerIDLabel = new JLabel("Player ID:");
        playerIDTextField = new JTextField();

        displayButton = new JButton("Display");
        insertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");
    }

    private void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ageTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(nationalityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nationalityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(playerIDLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(playerIDTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(displayButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(insertButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add(deleteButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlayersInformationAppli().setVisible(true);
            }
        });
    }
}
