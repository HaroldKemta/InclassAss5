// made by harold kemta

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DogManagerGUI {
    private DogManager manager;
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<DogBreed> breedComboBox;
    private JSpinner ageSpinner, weightSpinner;
    private JTextArea displayArea;

    // Constructor
    public DogManagerGUI() {
        manager = new DogManager();
        frame = new JFrame("Dog Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new FlowLayout());

        // Input Fields
        nameField = new JTextField(10);
        breedComboBox = new JComboBox<>(DogBreed.values());
        ageSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        weightSpinner = new JSpinner(new SpinnerNumberModel(1.0, 0.1, 100.0, 0.1));

        // Buttons
        JButton addButton = new JButton("Add Dog");
        JButton removeButton = new JButton("Remove Dog");
        JButton searchButton = new JButton("Search Dog");
        JButton sortButton = new JButton("Sort Dogs by Age");

        // Display Area
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add Action Listeners
        addButton.addActionListener(new AddDogAction());
        removeButton.addActionListener(new RemoveDogAction());
        searchButton.addActionListener(new SearchDogAction());
        sortButton.addActionListener(new SortDogsAction());

        // Layout Components
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Breed:"));
        frame.add(breedComboBox);
        frame.add(new JLabel("Age:"));
        frame.add(ageSpinner);
        frame.add(new JLabel("Weight:"));
        frame.add(weightSpinner);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(searchButton);
        frame.add(sortButton);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    // Update Display
    private void updateDisplay() {
        displayArea.setText("");
        for (Dog d : manager.getAllDogs()) {
            displayArea.append(d.toString() + "\n");
        }
    }

    // Add Dog Action
    private class AddDogAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            DogBreed breed = (DogBreed) breedComboBox.getSelectedItem();
            int age = (int) ageSpinner.getValue();
            double weight = (double) weightSpinner.getValue();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Dog newDog = new Dog(name, breed, age, weight);
            if (manager.addDog(newDog)) {
                JOptionPane.showMessageDialog(frame, "Dog added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                updateDisplay();
            } else {
                JOptionPane.showMessageDialog(frame, "Dog with this name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Other Actions (Remove, Search, Sort) are similar

    public static void main(String[] args) {
        new DogManagerGUI();
    }
}
