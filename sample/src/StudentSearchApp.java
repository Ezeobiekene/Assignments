import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class StudentSearchApp {

    private JFrame frame;
    private JTable studentTable;
    private JTextField searchField;
    private JButton searchButton;

    private String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Emily"};

    public StudentSearchApp() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Student Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the table with a 2D Object array for the data
        Object[][] data = new Object[studentNames.length][1];
        for (int i = 0; i < studentNames.length; i++) {
            data[i][0] = studentNames[i];
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, new String[]{"Student Name"});
        studentTable = new JTable(tableModel);
        studentTable.setFillsViewportHeight(true);

        // Create search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add components to frame
        frame.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        frame.add(searchPanel, BorderLayout.NORTH);

        // Add action listener to search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                DefaultTableModel filteredTableModel = new DefaultTableModel(new String[]{"Student Name"}, 0);

                for (String studentName : studentNames) {
                    if (studentName.toLowerCase().contains(searchTerm)) {
                        filteredTableModel.addRow(new Object[]{studentName});
                    }
                }

                studentTable.setModel(filteredTableModel);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentSearchApp();
    }
}
