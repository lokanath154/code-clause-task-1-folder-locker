import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FOlderLocker {
    private JFrame frame;
    private JButton lockButton;
    private JButton unlockButton;
    private JTextField folderPathField;
    private JPasswordField passwordField;

    public FOlderLocker() {
        frame = new JFrame("Folder Locker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        folderPathField = new JTextField();
        panel.add(new JLabel("Folder Path:"));
        panel.add(folderPathField);

        passwordField = new JPasswordField();
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        lockButton = new JButton("Lock Folder");
        lockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lockFolder();
            }
        });
        panel.add(lockButton);

        unlockButton = new JButton("Unlock Folder");
        unlockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unlockFolder();
            }
        });
        panel.add(unlockButton);

        frame.getContentPane().add(panel);
    }

    public void lockFolder() {
        String folderPath = folderPathField.getText();
        String password = new String(passwordField.getPassword());

        try {
            File sourceFolder = new File(folderPath);
            if (sourceFolder.exists() && sourceFolder.isDirectory()) {
                encryptFolder(sourceFolder.getAbsolutePath(), password);
                JOptionPane.showMessageDialog(frame, "Folder Locked!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Folder Path");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    public void unlockFolder() {
        String folderPath = folderPathField.getText();
        String password = new String(passwordField.getPassword());

        try {
            File sourceFolder = new File(folderPath);
            if (sourceFolder.exists() && sourceFolder.isDirectory()) {
                decryptFolder(sourceFolder.getAbsolutePath(), password);
                JOptionPane.showMessageDialog(frame, "Folder Unlocked!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Folder Path");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private static void encryptFolder(String sourceFolder, String password) throws Exception {
        // ... (Same as previous code)
    }

    private static void decryptFolder(String sourceFolder, String password) throws Exception {
        // ... (Same as previous code)
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        FOlderLocker locker = new FOlderLocker();
        locker.display();
    }
}
