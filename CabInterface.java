import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CabInterface extends JFrame implements ActionListener {
    private JTextArea outputArea;
    private JButton bookButton, historyButton;
    private Get_Car cabService;
    private ArrayList<Get_Car.Edge>[] graph;

    public CabInterface() {
        // Frame setup
        setTitle("Cab Booking System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output area for displaying booking details
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        bookButton = new JButton("Book Cab");
        historyButton = new JButton("Show Rider Journey Details");

        bookButton.addActionListener(this);
        historyButton.addActionListener(this);

        buttonPanel.add(bookButton);
        buttonPanel.add(historyButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize cab service and graph
        cabService = new Get_Car();
        graph = new ArrayList[13];
        Driver_Information.City_Map(graph);
        Car_Data.Car_Details();
        Driver_Information.Driver_DataBase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            // Book a cab and display booking details
            cabService.Book_Car("Siddharth Goutam Kumar", 20, 'M', "Online_Payment", "Upper Bazaar", "Doranda", "Premium Service");
            cabService.Booking_Details_Confirmation(graph);

            // Display booking details in the output area
            outputArea.setText("Booking Details:\n");
            outputArea.append("Name: Siddharth Goutam Kumar\n");
            outputArea.append("Age: 20\n");
            outputArea.append("Gender: M\n");
            outputArea.append("Payment Mode: Online_Payment\n");
            outputArea.append("Source Location: Upper Bazaar\n");
            outputArea.append("Destination Location: Doranda\n");
            outputArea.append("Cab Type: Premium Service\n");
            outputArea.append("Driver: Ram_Mohan\n");
            outputArea.append("Driver Contact: 123456789\n");
            outputArea.append("Origin: Vellore\n");
            outputArea.append("Distance: 31.0 km\n");
            outputArea.append("Cost: Rs. 1557.75\n\n");
            outputArea.append("Your cab will arrive shortly.\n");
        } else if (e.getSource() == historyButton) {
            // Display rider journey details
            cabService.Rider_History();
            outputArea.append("\nRider Journey Details:\n");
            outputArea.append("(Name: Siddharth Goutam Kumar, Source: Upper Bazaar, Destination: Doranda)\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CabInterface().setVisible(true);
        });
    }
}
class Get_Car {
    public static class Edge {
        int destination;
        double distance;

        public Edge(int destination, double distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    public void Book_Car(String name, int age, char gender, String paymentMode, String source, String destination, String cabType) {
        // Mocked method to represent booking functionality
        System.out.println("Booking cab for: " + name);
    }

    public void Booking_Details_Confirmation(ArrayList<Edge>[] graph) {
        // Mocked method to confirm booking and display details
        System.out.println("Booking confirmed.");
    }

    public void Rider_History() {
        // Mocked method to display rider journey history
        System.out.println("Displaying rider journey history.");
    }
}
 class Driver_Information {
    public static void Driver_DataBase() {
        // Mocked method to load driver data
        System.out.println("Loading driver database.");
    }

    public static void City_Map(ArrayList<Get_Car.Edge>[] graph) {
        // Mocked method to create city map
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Get_Car.Edge(1, 31.0)); // Example edge
        System.out.println("City map initialized.");
    }
}
