 package thesis.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Main GUI class for Thesis Tracking System.
 * @author Marwa Mousa
 */
public class ThesisTrackingSystem extends JFrame {
   
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
    private JPanel loginPanel, studentPanel, supervisorPanel, coordinatorPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    
    public ThesisTrackingSystem() {
        setTitle("Thesis Tracking System - Libyan Academy (Marwa Mousa 02786)");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // يجعل النافذة في منتصف الشاشة
        
        initializeComponents();
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        
        // إنشاء لوحات التحكم
        loginPanel = createLoginPanel();
        studentPanel = createStudentPanel();
        supervisorPanel = createSupervisorPanel();
        coordinatorPanel = createCoordinatorPanel();
        
        // إضافة لوحة تسجيل الدخول فقط في البداية
        tabbedPane.addTab("Login", loginPanel);
        
        add(tabbedPane);
    }
    
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel titleLabel = new JLabel("Thesis Tracking System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);        
        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(userLabel, gbc);
        
        usernameField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(usernameField, gbc);
        
        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);
        
        passwordField = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passwordField, gbc);
        
        JLabel roleLabel = new JLabel("Role:");
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(roleLabel, gbc);
        
        String[] roles = {"Student", "Supervisor", "Program Coordinator", "Administrator"};
        roleComboBox = new JComboBox<>(roles);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(roleComboBox, gbc);
        
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        loginButton.addActionListener(e -> handleLogin());
        panel.add(loginButton, gbc);
        
        return panel;
    }
    
    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Student Dashboard - Update your thesis progress here!", SwingConstants.CENTER), BorderLayout.NORTH);

        JTextArea descArea = new JTextArea(5, 30);
        descArea.setLineWrap(true);
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JLabel("Progress Description:"));
        centerPanel.add(new JScrollPane(descArea));
        panel.add(centerPanel, BorderLayout.CENTER);

        JButton updateButton = new JButton("Update Progress");
        updateButton.addActionListener(e -> {
            if (!descArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Progress updated successfully!");
                descArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a description.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(updateButton, BorderLayout.SOUTH);

        return panel;
    }
    
    private JPanel createSupervisorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Supervisor Dashboard - Review student progress", SwingConstants.CENTER), BorderLayout.NORTH);
        
        String[] columns = {"Student Name", "Thesis Title", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        model.addRow(new Object[]{"Ahmed Mohamed", "AI in Healthcare", "On Track"});
        model.addRow(new Object[]{"Fatima Ali", "Machine Learning", "Delayed"});
        
        JTable studentTable = new JTable(model);
        panel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        
        JButton reviewButton = new JButton("Review Selected");
        reviewButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Feedback submitted!"));
        panel.add(reviewButton, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCoordinatorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Program Coordinator Dashboard", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JPanel statsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        statsPanel.add(new JLabel("Total Theses:")); statsPanel.add(new JLabel("45"));
        statsPanel.add(new JLabel("Completed:")); statsPanel.add(new JLabel("12"));
        statsPanel.add(new JLabel("In Progress:")); statsPanel.add(new JLabel("28"));
        statsPanel.add(new JLabel("Delayed:")); statsPanel.add(new JLabel("5"));
        
        panel.add(statsPanel, BorderLayout.CENTER);
        
        JButton reportButton = new JButton("Generate Report");
        reportButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Report generated!"));
        panel.add(reportButton, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void handleLogin() {
        try {
            String username = usernameField.getText();
            String role = (String) roleComboBox.getSelectedItem();
            
            // استخدام الاستثناء المخصص إذا كان الحقل فارغاً
            if (username.isEmpty()) {
                throw new ThesisException("Username cannot be empty! Please enter your name.");
            }
            
            // إخفاء لوحة تسجيل الدخول وإظهار لوحة التحكم المناسبة
            tabbedPane.remove(loginPanel);
            
            switch (role) {
                case "Student":
                    tabbedPane.addTab("Student Dashboard", studentPanel);
                    break;
                case "Supervisor":
                    tabbedPane.addTab("Supervisor Dashboard", supervisorPanel);
                    break;
                case "Program Coordinator":
                    tabbedPane.addTab("Coordinator Dashboard", coordinatorPanel);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Admin dashboard coming soon!");
                    tabbedPane.addTab("Login", loginPanel);
                    return;
            }
            
            tabbedPane.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + username);
            
        } catch (ThesisException e) {
            // التقاط الاستثناء المخصص وعرضه
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // التقاط أي أخطاء أخرى غير متوقعة
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // الدالة الرئيسية لتشغيل البرنامج
    public static void main(String[] args) {
        // تشغيل الواجهة في خيط آمن
        SwingUtilities.invokeLater(() -> {
            try {
                // مظهر جميل للنوافذ
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ThesisTrackingSystem system = new ThesisTrackingSystem();
            system.setVisible(true);
        });
    }
}