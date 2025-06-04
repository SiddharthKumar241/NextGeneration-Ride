import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CabBookingApp extends JFrame {

    private JTextField sourceField, destinationField, cabTypeField;
    private JButton bookButton, driverInfoButton;
    private JTextArea outputArea;

    public CabBookingApp() {
        setTitle("Cab Booking Application");
        setSize(520, 580);
        setMinimumSize(new Dimension(480, 540));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(152, 199, 156);
                Color color2 = new Color(64, 141, 87);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 15);
        Font outputFont = new Font("Consolas", Font.PLAIN, 14);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setFont(labelFont);
        sourceLabel.setForeground(Color.WHITE);
        inputPanel.add(sourceLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        sourceField = new JTextField(22);
        styleTextField(sourceField);
        sourceField.setFont(inputFont);
        inputPanel.add(sourceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(labelFont);
        destinationLabel.setForeground(Color.WHITE);
        inputPanel.add(destinationLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        destinationField = new JTextField(22);
        styleTextField(destinationField);
        destinationField.setFont(inputFont);
        inputPanel.add(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        JLabel cabTypeLabel = new JLabel("Cab Type (Sedan / SUV):");
        cabTypeLabel.setFont(labelFont);
        cabTypeLabel.setForeground(Color.WHITE);
        inputPanel.add(cabTypeLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        cabTypeField = new JTextField(22);
        styleTextField(cabTypeField);
        cabTypeField.setFont(inputFont);
        inputPanel.add(cabTypeField, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonsPanel.setOpaque(false);

        bookButton = new JButton("Book Cab");
        styleButton(bookButton, new Color(46, 204, 113), new Color(39, 174, 96));

        driverInfoButton = new JButton("Driver Info");
        styleButton(driverInfoButton, new Color(52, 152, 219), new Color(41, 128, 185));

        buttonsPanel.add(bookButton);
        buttonsPanel.add(driverInfoButton);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(10, 42);
        outputArea.setEditable(false);
        outputArea.setFont(outputFont);
        outputArea.setForeground(new Color(230, 230, 230));
        outputArea.setBackground(new Color(35, 39, 42));
        outputArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(25, 30, 34), 2, true),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        bookButton.addActionListener(e -> bookCab());
        driverInfoButton.addActionListener(e -> showDriverInfo());
    }

    private void styleTextField(JTextField textField) {
        textField.setBackground(new Color(245, 255, 245));
        textField.setForeground(new Color(20, 20, 20));
        textField.setBorder(new CompoundBorder(
                new LineBorder(new Color(34, 139, 34), 2, true),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        textField.setCaretColor(new Color(34, 139, 34));
    }

    private void styleButton(JButton button, Color baseColor, Color hoverColor) {
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 16f));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });
    }

    private void bookCab() {
        String source = sourceField.getText().trim();
        String destination = destinationField.getText().trim();
        String cabType = cabTypeField.getText().trim().toLowerCase();

        if (source.isEmpty() || destination.isEmpty() || cabType.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!cabType.equals("sedan") && !cabType.equals("suv")) {
            JOptionPane.showMessageDialog(this, "Cab type must be either 'Sedan' or 'SUV'.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        outputArea.append("Booking Details:\n");
        outputArea.append("From: " + source + "\n");
        outputArea.append("To: " + destination + "\n");
        outputArea.append("Cab Type: " + cabType.substring(0, 1).toUpperCase() + cabType.substring(1) + "\n");
        outputArea.append("Your cab has been successfully booked!\n");
        outputArea.append("-------------------------------------------------\n");

        sourceField.setText("");
        destinationField.setText("");
        cabTypeField.setText("");
    }

    private void showDriverInfo() {
        outputArea.append("Driver Details:\n");
        outputArea.append("Name: Rahul Sharma\n");
        outputArea.append("Contact: +91 9876543210\n");
        outputArea.append("Vehicle: Toyota Innova (SUV)\n");
        outputArea.append("License Plate: MH12 AB 1234\n");
        outputArea.append("-------------------------------------------------\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CabBookingApp app = new CabBookingApp();
            app.setVisible(true);
        });
    }
}
