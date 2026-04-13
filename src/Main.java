import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Student Management System - Starting...");
        AppGUI window = new AppGUI();
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}