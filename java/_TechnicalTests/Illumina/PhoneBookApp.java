package _TechnicalTests.Illumina;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

/**
 * Phone Book Application.
 */
public class PhoneBookApp extends JFrame {

    // Components
    private ArrayList<Contact> contacts;
    private JTextField searchField;
    private JTable phoneBookTable;
    private JButton clearSearchButton, addButton, editButton, deleteButton;
    private JLabel infoLabel;
    private JSeparator separator;

    /**
     * Constructor for PhoneBookApp.
     */
    public PhoneBookApp() {
        initializeUI();
        setUpComponents();
        setUpListeners();
    }

    /**
     * Sets up main UI.
     */
    private void initializeUI() {
        setTitle("Phone Book App");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);
        setLocationRelativeTo(null); // Centers JPanel
        setVisible(true);
    }

    /**
     * Sets up components.
     */
    private void setUpComponents() {
        // Initializes contacts list
        contacts = new ArrayList<>();

        // Sets up Search field JPanel
        JPanel searchPanel = new JPanel(new BorderLayout());
        JPanel searchFieldPanel = new JPanel(new BorderLayout());
        JLabel searchLabel = new JLabel("Search:  ");
        searchField = new JTextField(12);
        searchField.setPreferredSize(new Dimension(searchField.getPreferredSize().width, 26));
        // Adds button to clear search field
        clearSearchButton = new JButton("Clear");
        searchFieldPanel.add(searchLabel, BorderLayout.WEST);
        searchFieldPanel.add(searchField, BorderLayout.CENTER);
        searchFieldPanel.add(clearSearchButton, BorderLayout.LINE_END);
        searchPanel.add(searchFieldPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Add space below panel

        // Sets up Phone Book JTable
        String[] columnNames = {"Name", "Phone Number", "Address"};
        DefaultTableModel phoneBookTableModel = new DefaultTableModel(new Object[][]{}, columnNames) {
            // Prevents in-place editing of cells
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        phoneBookTable = new JTable(phoneBookTableModel);
        // Enables Sorting of Table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(phoneBookTableModel);
        phoneBookTable.setRowSorter(sorter);

        // Sets up Edit, Delete, & Add Buttons JPanel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Add space below panel
        // Creates info label with italic text & thin font
        infoLabel = new JLabel("<html><i>Select a row to edit a contact  </i></html>");
        Font italicThinFont = new Font("SansSerif", Font.ITALIC, 12).deriveFont(Font.PLAIN, 12); 
        infoLabel.setFont(italicThinFont);
        // Creates separator & action buttons
        separator = new JSeparator(SwingConstants.VERTICAL); 
        separator.setForeground(Color.GRAY);
        separator.setPreferredSize(new Dimension(1, 24));
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        addButton = new JButton("Add Contact");
        // Hides info label, clear search, edit & delete buttons initially
        clearSearchButton.setVisible(false);
        infoLabel.setVisible(false); 
        editButton.setVisible(false);
        deleteButton.setVisible(false); 
        separator.setVisible(false);
        // Adds components to Buttons JPanel
        buttonsPanel.add(infoLabel);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(separator); 
        buttonsPanel.add(addButton);

        // Adds components to main panel
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(phoneBookTable), BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up event listeners.
     */
    private void setUpListeners() {
        // Listens for search field changes and applies continuous filtering
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { 
                searchContacts(); 
                clearSearchButton.setVisible(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) { 
                searchContacts(); 
                if (searchField.getText().isEmpty()) {
                    clearSearchButton.setVisible(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) { 
                // N.A 
            }
        });

        // Listens to clear search button and clears search field
        clearSearchButton.addActionListener(e -> searchField.setText(""));

        // Listens for table row selections and updates GUI
        phoneBookTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = phoneBookTable.getSelectedRow();
                if (selectedRow != -1) {
                    // If a row is selected, show the edit & delete buttons
                    editButton.setVisible(true);
                    deleteButton.setVisible(true);
                    separator.setVisible(true);
                    infoLabel.setVisible(false);
                } else {
                    // If no row is selected, hide the edit & delete buttons
                    editButton.setVisible(false);
                    deleteButton.setVisible(false);
                    separator.setVisible(false);
                    infoLabel.setVisible(true); // Show guiding info about editing contacts
                }
            }
        });

        // Listens to edit button and opens edit contact dialog
        editButton.addActionListener(e -> {
            int selectedRow = phoneBookTable.getSelectedRow();
            Contact selectedContact = null;
            // Checks if row is selected and in-bounds of contacts list
            if (selectedRow != -1  && selectedRow < contacts.size()) {
                selectedContact = contacts.get(selectedRow);
                openAddEditContactDialog(selectedContact);
            }
        });

        // Listens to delete button and opens delete confirmation dialog
        deleteButton.addActionListener(e -> openDeleteContactDialog());

        // Listens to add button and opens add contact dialog
        addButton.addActionListener(e -> openAddEditContactDialog(null));
    }

    /**
     * Searches contacts list based on search input.
     */
    private void searchContacts() {
        String searchInput = searchField.getText(); // Gets search field input
        DefaultTableModel model = (DefaultTableModel) phoneBookTable.getModel();
        model.setRowCount(0); // Clears table

        // Iterates through contacts & adds to table if contact contains the input
        for (Contact contact : contacts) {
            if (contact.contains(searchInput)) {
                model.addRow(new Object[]{contact.getName(), contact.getPhoneNumber(), contact.getAddress()});
            }
        }
    }

    /**
     * Opens dialog to delete a contact.
     */
    private void openDeleteContactDialog() {
        int selectedRow = phoneBookTable.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this contact?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Removes contact from ArrayList
                contacts.remove(selectedRow);
                // Refreshes table, accounting for current search input
                searchContacts();
            }
        }
    }

    /**
     * Opens dialog to add or edit a contact.
     *
     * @param contactToEdit Contact to edit
     */
    private void openAddEditContactDialog(Contact contactToEdit) {
        // JDialog
        JDialog addContactDialog = new JDialog(this, (contactToEdit == null ? "Add Contact" : "Edit Contact"), true);
        addContactDialog.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Labels & text fields for contact info
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel addressLabel = new JLabel("Address:");
        JTextField nameField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JTextField addressField = new JTextField(15);

        // If editing contact, populates fields with contact info
        if (contactToEdit != null) {
            nameField.setText(contactToEdit.getName());
            phoneField.setText(contactToEdit.getPhoneNumber());
            addressField.setText(contactToEdit.getAddress());
        }

        // Adds components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(addressField);

        // Buttons to add/update contact and cancel action
        JButton saveButton = new JButton((contactToEdit == null ? "Add" : "Save"));
        JButton cancelButton = new JButton("Cancel");

        // Attaches listener to save contact button
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();
            // Validates input fields
            if (inputIsValid(name, phone, address, addContactDialog)) {
                // If editing a contact, updates it in ArrayList
                if (contactToEdit != null) {
                    int selectedRow = phoneBookTable.getSelectedRow();
                    Contact oldContact = contacts.get(selectedRow);
                    oldContact.setName(name);
                    oldContact.setPhoneNumber(phone);
                    oldContact.setAddress(address);
                } else {
                    // Else, creates new contact & adds it to ArrayList
                    Contact newContact = new Contact(name, phone, address);
                    contacts.add(newContact);
                    infoLabel.setVisible(true);
                }
                // Refreshes table, accounting for current search input
                searchContacts(); 
                addContactDialog.dispose(); // Closes dialog
            }
        });

        // Attaches listener to cancel button
        cancelButton.addActionListener(e -> addContactDialog.dispose());
        
        // Adds buttons to button panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Set border for input panel

        // Adds text fields panel & buttons panel to dialog
        addContactDialog.add(panel, BorderLayout.CENTER);
        addContactDialog.add(buttonsPanel, BorderLayout.SOUTH);

        // Shows dialog
        addContactDialog.pack();
        addContactDialog.setLocationRelativeTo(this); // Center dialog
        addContactDialog.setVisible(true);
    }

    /**
     * Validates input fields for a new or existing contact.
     *
     * @param name          Name of contact.
     * @param phone         Phone number of contact.
     * @param address       Address of contact.
     * @param parentDialog Parent dialog for displaying error messages.
     * @return true if all input fields are valid, false otherwise.
     */
    private boolean inputIsValid(String name, String phone, String address, Dialog parentDialog) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
        // Validate name
        if (name.isEmpty()) {
            errorMessage.append("Name cannot be empty.\n");
            isValid = false;
        }
        // Validate phone number
        if (!phone.matches("\\d+")) {
            errorMessage.append("Phone number must be numeric.\n");
            isValid = false;
        }
        // Validate address
        if (address.length() < 4) {
            errorMessage.append("Address must be at least 4 characters.\n");
            isValid = false;
        }
        // Displays error message if input is invalid
        if (!isValid) {
            JOptionPane.showMessageDialog(parentDialog, errorMessage.toString(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    /**
     * Class for a Phone Book Contact.
     */
    private static class Contact {
        // Fields
        private String name, phoneNumber, address;

        // Constructor
        public Contact(String name, String phoneNumber, String address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        // Getters & setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        // Method to check if a contact contains the search input
        public boolean contains(String searchInput) {
            String cleaned = searchInput.toLowerCase();
            return name.toLowerCase().contains(cleaned) ||
                    phoneNumber.toLowerCase().contains(cleaned) ||
                    address.toLowerCase().contains(cleaned);
        }
    }

    /**
     * Main method to run PhoneBookApp.
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { new PhoneBookApp(); });
    }
}
