package _TechnicalTests.Illumina;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookSwingApp extends JFrame {

    private JTextField nameField, phoneNumberField, addressField, searchField;
    private JButton addButton, editButton, deleteButton, searchButton, clearSearchButton;
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private List<Contact> contacts;
    private int selectedRow = -1; // To track the selected row for editing

    public PhoneBookSwingApp() {
        setTitle("Phone Book");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize components
        nameField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        addressField = new JTextField(20);
        searchField = new JTextField(20);
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");
        clearSearchButton = new JButton("Clear");
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Address"}, 0);
        contactTable = new JTable(tableModel);
        contacts = new ArrayList<>();

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(clearSearchButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contactTable), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        // Add mainPanel to the frame
        add(mainPanel);

        // Event listeners
        addButton.addActionListener(e -> {
            if (selectedRow != -1) {
                contactTable.getSelectionModel().clearSelection();
                selectedRow = -1;
                clearFields();
                addButton.setText("Add");
            } else {
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String address = addressField.getText();
                Contact newContact = new Contact(name, phoneNumber, address);
                contacts.add(newContact);
                updateContactTable();
                clearFields();
            }
        });

    editButton.addActionListener(e -> {
        if (selectedRow != -1) {
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();
            Contact updatedContact = new Contact(name, phoneNumber, address);
            contacts.set(selectedRow, updatedContact); // Update the contact in the list
            updateContactTable();
            clearFields();
            addButton.setText("Add");
            selectedRow = -1;
        } else {
            selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                Contact selectedContact = contacts.get(selectedRow);
                nameField.setText(selectedContact.getName());
                phoneNumberField.setText(selectedContact.getPhoneNumber());
                addressField.setText(selectedContact.getAddress());
                addButton.setText("Update");
            }
        }
    });

        deleteButton.addActionListener(e -> {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                contacts.remove(selectedRow);
                updateContactTable();
                clearFields();
            }
        });

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().toLowerCase();
            List<Contact> searchResults = new ArrayList<>();
            for (Contact contact : contacts) {
                if (contact.getName().toLowerCase().contains(searchText) ||
                        contact.getPhoneNumber().contains(searchText) ||
                        contact.getAddress().toLowerCase().contains(searchText)) {
                    searchResults.add(contact);
                }
            }
            updateContactTable(searchResults);
        });

        clearSearchButton.addActionListener(e -> {
            searchField.setText("");
            updateContactTable(contacts);
        });

        // Add DocumentListener to text fields
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                addButton.setEnabled(!nameField.getText().isEmpty() &&
                        !phoneNumberField.getText().isEmpty() &&
                        !addressField.getText().isEmpty());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                addButton.setEnabled(!nameField.getText().isEmpty() &&
                        !phoneNumberField.getText().isEmpty() &&
                        !addressField.getText().isEmpty());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                addButton.setEnabled(!nameField.getText().isEmpty() &&
                        !phoneNumberField.getText().isEmpty() &&
                        !addressField.getText().isEmpty());
            }
        };

        nameField.getDocument().addDocumentListener(documentListener);
        phoneNumberField.getDocument().addDocumentListener(documentListener);
        addressField.getDocument().addDocumentListener(documentListener);
    }

    private void updateContactTable() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            Object[] rowData = {contact.getName(), contact.getPhoneNumber(), contact.getAddress()};
            tableModel.addRow(rowData);
        }
        // Notify the table that its data has changed
        tableModel.fireTableDataChanged();
    }

    private void updateContactTable(List<Contact> contactList) {
        tableModel.setRowCount(0);
        for (Contact contact : contactList) {
            Object[] rowData = {contact.getName(), contact.getPhoneNumber(), contact.getAddress()};
            tableModel.addRow(rowData);
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneNumberField.setText("");
        addressField.setText("");
    }

    private class Contact {

        private String name;
        private String phoneNumber;
        private String address;

        public Contact(String name, String phoneNumber, String address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhoneBookSwingApp().setVisible(true));
    }
}
