import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentTime = dtf.format(LocalDateTime.now());

        JOptionPane.showMessageDialog(null,
                "Welcome to the Student Management System\n Session started: " + currentTime,
                "System Initialisation", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("Student Management System - Starting...");
        AppGUI window = new AppGUI();
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

