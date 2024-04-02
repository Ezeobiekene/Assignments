import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class StudentSearchAppWithScroll {

    private JFrame frame;
    private JScrollPane scrollPane;
    private JTable studentTable;
    private JTextField searchField;
    private JButton searchButton;

    private String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily","Alice", "Bob", "Charlie", "David", "Emily"};

    public StudentSearchAppWithScroll() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Student Search with Scroll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the table with a 2D Object array for the data
        Object[][] data = new Object[studentNames.length][1];
        for (int i = 0; i < studentNames.length; i++) {
            data[i][0] = studentNames[i];
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, new String[]{"Student Name"});
        studentTable = new JTable(tableModel);

        // Add scrollbar to student table
        scrollPane = new JScrollPane(studentTable);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 350, 550);

        // Create search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add components to frame
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

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
        new StudentSearchAppWithScroll();
    }
}

