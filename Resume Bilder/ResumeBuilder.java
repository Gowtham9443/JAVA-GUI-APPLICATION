import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResumeBuilder extends JFrame {
    // Personal Information Components
    private JTextField nameField, emailField, phoneField, addressField;
    
    // Education Components
    private JTextField schoolField, degreeField, graduationField;
    private JTextArea educationArea;
    
    // Experience Components
    private JTextField companyField, positionField, durationField;
    private JTextArea experienceArea;
    
    // Skills Components
    private JTextField skillField;
    private JTextArea skillsArea;
    
    public ResumeBuilder() {
        setTitle("Online Resume Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        
        // Create tabbed pane for different sections
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Add tabs
        tabbedPane.addTab("Personal Info", createPersonalInfoPanel());
        tabbedPane.addTab("Education", createEducationPanel());
        tabbedPane.addTab("Experience", createExperiencePanel());
        tabbedPane.addTab("Skills", createSkillsPanel());
        tabbedPane.addTab("Preview", createPreviewPanel());
        
        add(tabbedPane);
        setVisible(true);
    }
    
    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Name field
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);
        
        // Email field
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);
        
        // Phone field
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(20);
        panel.add(phoneField, gbc);
        
        // Address field
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        addressField = new JTextField(20);
        panel.add(addressField, gbc);
        
        return panel;
    }
    
    private JPanel createEducationPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(new TitledBorder("Add Education"));
        
        inputPanel.add(new JLabel("School/University:"));
        schoolField = new JTextField();
        inputPanel.add(schoolField);
        
        inputPanel.add(new JLabel("Degree:"));
        degreeField = new JTextField();
        inputPanel.add(degreeField);
        
        inputPanel.add(new JLabel("Graduation Year:"));
        graduationField = new JTextField();
        inputPanel.add(graduationField);
        
        JButton addButton = new JButton("Add Education");
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);
        
        // Education display area
        educationArea = new JTextArea(10, 30);
        educationArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(educationArea);
        scrollPane.setBorder(new TitledBorder("Education History"));
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String school = schoolField.getText().trim();
                String degree = degreeField.getText().trim();
                String graduation = graduationField.getText().trim();
                
                if (!school.isEmpty() && !degree.isEmpty() && !graduation.isEmpty()) {
                    educationArea.append("• " + degree + " from " + school + " (" + graduation + ")\n");
                    schoolField.setText("");
                    degreeField.setText("");
                    graduationField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill all education fields.");
                }
            }
        });
        
        return panel;
    }
    
    private JPanel createExperiencePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(new TitledBorder("Add Work Experience"));
        
        inputPanel.add(new JLabel("Company:"));
        companyField = new JTextField();
        inputPanel.add(companyField);
        
        inputPanel.add(new JLabel("Position:"));
        positionField = new JTextField();
        inputPanel.add(positionField);
        
        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);
        
        JButton addButton = new JButton("Add Experience");
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);
        
        // Experience display area
        experienceArea = new JTextArea(10, 30);
        experienceArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(experienceArea);
        scrollPane.setBorder(new TitledBorder("Work Experience"));
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String company = companyField.getText().trim();
                String position = positionField.getText().trim();
                String duration = durationField.getText().trim();
                
                if (!company.isEmpty() && !position.isEmpty() && !duration.isEmpty()) {
                    experienceArea.append("• " + position + " at " + company + " (" + duration + ")\n");
                    companyField.setText("");
                    positionField.setText("");
                    durationField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill all experience fields.");
                }
            }
        });
        
        return panel;
    }
    
    private JPanel createSkillsPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(new TitledBorder("Add Skills"));
        
        inputPanel.add(new JLabel("Skill:"), BorderLayout.WEST);
        skillField = new JTextField();
        inputPanel.add(skillField, BorderLayout.CENTER);
        
        JButton addButton = new JButton("Add Skill");
        inputPanel.add(addButton, BorderLayout.EAST);
        
        // Skills display area
        skillsArea = new JTextArea(10, 30);
        skillsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(skillsArea);
        scrollPane.setBorder(new TitledBorder("Skills"));
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String skill = skillField.getText().trim();
                
                if (!skill.isEmpty()) {
                    skillsArea.append("• " + skill + "\n");
                    skillField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please enter a skill.");
                }
            }
        });
        
        return panel;
    }
    
    private JPanel createPreviewPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JTextArea previewArea = new JTextArea();
        previewArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(previewArea);
        
        JButton generateButton = new JButton("Generate Resume");
        JButton saveButton = new JButton("Save to File");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(saveButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previewArea.setText(generateResumeText());
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("resume.txt"))) {
                    writer.write(generateResumeText());
                    JOptionPane.showMessageDialog(panel, "Resume saved to resume.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Error saving file: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        return panel;
    }
    
    private String generateResumeText() {
        StringBuilder resume = new StringBuilder();
        
        // Personal Information
        resume.append("========================================\n");
        resume.append("                 RESUME                 \n");
        resume.append("========================================\n\n");
        
        resume.append("PERSONAL INFORMATION\n");
        resume.append("Name: ").append(nameField.getText()).append("\n");
        resume.append("Email: ").append(emailField.getText()).append("\n");
        resume.append("Phone: ").append(phoneField.getText()).append("\n");
        resume.append("Address: ").append(addressField.getText()).append("\n\n");
        
        // Education
        resume.append("EDUCATION\n");
        if (educationArea.getText().isEmpty()) {
            resume.append("No education information provided.\n");
        } else {
            resume.append(educationArea.getText());
        }
        resume.append("\n");
        
        // Experience
        resume.append("WORK EXPERIENCE\n");
        if (experienceArea.getText().isEmpty()) {
            resume.append("No work experience provided.\n");
        } else {
            resume.append(experienceArea.getText());
        }
        resume.append("\n");
        
        // Skills
        resume.append("SKILLS\n");
        if (skillsArea.getText().isEmpty()) {
            resume.append("No skills provided.\n");
        } else {
            resume.append(skillsArea.getText());
        }
        
        return resume.toString();
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResumeBuilder();
            }
        });
    }
}