import java.util.*;

class Car_Data {
    static HashMap<String, String> st = new HashMap<>();
    public static void Car_Details() {
        st.put("Upper Bazaar", "JH010011");
        st.put("Firayalal Chowk", "JH010012");
        st.put("Sarjana", "JH010013");
        st.put("Wool House", "JH010014");
        st.put("HindPiri_Chowk", "JH010015");
        st.put("Over_Bridge", "JH0100ṇ16");
        st.put("Doranda", "JH010017");
        st.put("Hinoo", "JH010018");
        st.put("Birsa Munda Airport", "JH010019");
        st.put("Chutia", "JH010020");
        st.put("Dhurwa", "JH010021");
        st.put("Kutchery", "JH010022");
        st.put("Lalpur", "JH010023");
    }

    public static String Search_Car_Location(String location) {
        if (st.containsKey(location) == true)
            return st.get(location);
        return "None";
    }
}

class Get_Car extends Driver_Information {
    static Node head;
    static double distance = 0.0;
    static String name, location_source, Mode, location_dstination;
    static String Driver_Name, Number, Place;
    static char Gender;
    static int Age;
    static String Type_Of_Cab;
    static String Gaadi_number;
    static int Graph_Location_Code = 0;

    public static void Book_Car(String Name, int age, char Gender1, String Payment_Mode, String location_Begin,
            String Location_End, String Cab) {
        name = Name;
        Age = age;
        Gender = Gender1;
        Mode = Payment_Mode;
        Type_Of_Cab = Cab;
        location_source = location_Begin;
        location_dstination = Location_End;
        Gaadi_number = Search_Car_Location(location_source);
        HashMap<String, String> str = new HashMap<>();//Status For Booked In HashMap
        if (Search_Car_Location(location_source) != "None") {
            str.put(Search_Car_Location(location_source), "Booked");
            String[] Details = (Driver.get(Gaadi_number)).split(",");
            Driver_Name = Details[0];
            Number = Details[1];
            Place = Details[2];
        } else
            System.out.println("No Such Car Exist");
    }

    /*
     * public static void All_Paths(ArrayList<Edge>[] graph, String source, String
     * destination, String path) {
     * if (source == destination) {
     * System.out.println(path + "->");
     * return;
     * }
     * for (int i = 0; i < graph[Graph_Location_Code].size(); i++) {
     * Edge obj = graph[Graph_Location_Code].get(i);
     * All_Paths(graph, obj.destintion, destination, path + source);
     * }
     * }
     */

    public static void Get_Graph_Details(ArrayList<Edge>[] graph, HashMap<String, Integer> blank) {
        Graph_Location_Code = blank.get(location_source);
    }

    public static void Booking_Details_Confirmation(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph[Graph_Location_Code].size(); i++) {
            Edge obj = graph[Graph_Location_Code].get(i);
            if (location_dstination == obj.destintion) {
                distance = obj.distance;
            }
        }
        System.out.println("Name Of The Person " + name);
        System.out.println("Age " + Age);
        System.out.println("Gender Of The Person " + Gender);
        System.out.println("Payment Mode" + Mode);
        System.out.println("Source Location " + location_source);
        System.out.println("Destination Location " + location_dstination);
        System.out.println("Cab Alloted " + Gaadi_number);
        System.out.println("Type Of Car Service Selected " + Type_Of_Cab);
        System.out.println("Name Of The Driver " + Driver_Name);
        System.out.println("Mobile Number Of The Driver " + Number);
        System.out.println("Place Of Origin Of The Driver " + Place);
        if (distance != 0) {
            System.out.println(
                    "Your Distance Form " + location_source + " to " + location_dstination + " is " + distance);
            if (Type_Of_Cab == "Premium Service") {
                if (distance > 10)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Premium Car Is " + (distance * 50.25));
                else if (distance > 20.12)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Premium Car Is " + (distance * 61.25));
                else if (distance > 30)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Premium Car Is " + (distance * 67.25));
                else if (distance > 40)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Premium Car Is " + (distance * 72.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Premium Car Is " + (distance * 75.25));
            } else if (Type_Of_Cab == "Standard Taxi Servies") {
                if (distance > 10)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Standard Taxi Servies Is " + (distance * 40.25));
                else if (distance > 20.12)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Standard Taxi Servies Is " + (distance * 51.25));
                else if (distance > 30)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Standard Taxi Servies Is " + (distance * 57.25));
                else if (distance > 40)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Standard Taxi Servies Is " + (distance * 62.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Standard Taxi Servies Is " + (distance * 65.25));
            } else if (Type_Of_Cab == "Ride Sharing") {
                if (distance > 10)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Ride Sharing Is " + (distance * 40.25));
                else if (distance > 20.12)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Ride Sharing Is " + (distance * 46.25));
                else if (distance > 30)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Ride Sharing Is " + (distance * 50.25));
                else if (distance > 40)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Ride Sharing Is " + (distance * 58.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Ride Sharing Is " + (distance * 62.25));

            } else if (Type_Of_Cab == "Long-Distance Taxi Services") {
                if (distance > 100 && distance < 250)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Long-Distance Taxi Services Is " + (distance * 10.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Long-Distance Taxi Services Is " + (distance * 8.25));

            } else if (Type_Of_Cab == "Minivan or SUV Services") {
                if (distance > 10)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Minivan or SUV Services Is " + (distance * 51.25));
                else if (distance > 20.12)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Minivan or SUV Services Is " + (distance * 57.25));
                else if (distance > 30)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Minivan or SUV ServicesIs " + (distance * 65.25));
                else if (distance > 40)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Minivan or SUV Services Is " + (distance * 68.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Minivan or SUV Services Is " + (distance * 72.25));

            } else if (Type_Of_Cab == "Motorcycle Taxi Services") {
                if (distance > 10)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Motorcycle Taxi Services Is " + (distance * 21.25));
                else if (distance > 20.12)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Motorcycle Taxi Services Is " + (distance * 27.25));
                else if (distance > 30)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Motorcycle Taxi Services Is " + (distance * 35.25));
                else if (distance > 40)
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Motorcycle Taxi Services Is " + (distance * 38.25));
                else
                    System.out.println(" Your Cost Incurred While Going From " + location_source + " To "
                            + location_dstination + " With Motorcycle Taxi Services Is " + (distance * 42.25));

            }
            System.out.println("Please Wait Your Cab For Service " + Type_Of_Cab + " Will Arrive Shortly ");
        } else
            System.out.println("Oops Soory Your Car dosen't Go from " + location_source + " to " + location_dstination);
    }

    public static void Rider_History() {
        Node newnode = new Node(name, location_source, location_dstination);
        if (head == null)
            head = newnode;
        else {
            newnode.next = head;
            head = newnode;
        }
    }

    public static void Display_Rider_Details() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No Rider History");
            return;
        }
        while (temp != null) {
            if (temp.next == null) {
                System.out.println("(");
                System.out.println("Name Of The Rider is " + temp.Name + " ");
                System.out.println("Source Location Of The Rider Is " + temp.Src_Location + " ");
                System.out.println("Destination Location Of The Rider IS " + temp.Dest_Location + " ");
                System.out.println(")");
            } else {
                System.out.println("(");
                System.out.println("Name Of The Rider is " + temp.Name + " ");
                System.out.println("Source Location Of The Rider Is " + temp.Src_Location + " ");
                System.out.println("Destination Location Of The Rider IS " + temp.Dest_Location + " ");
                System.out.println(")");
                System.out.print("->");
            }
            temp = temp.next;
        }
    }
}

class Driver_Information extends Car_Data {
    static HashMap<String, String> Driver = new HashMap<>();

    public static void Driver_DataBase() {
        Driver.put("JH010011", "Ram_Mohan,123456789,Vellore");
        Driver.put("JH010012", "Shekhar_Krishanan,456789123,Vellore");
        Driver.put("JH010013", "Iyer_Venkeatesh,7418522369,Vellore");
        Driver.put("JH010014", "Somanathan_Reddy,963258741,Vellore");
        Driver.put("JH010015", "Viru_Vinesh,852479631,Vellore");
        Driver.put("JH010016", "Samuel_Paul,159753842,Vellore");
        Driver.put("JH010017", "Paul_David,489756123,Vellore");
        Driver.put("JH010018", "Mahesh_Sahu,698574123,Vellore");
        Driver.put("JH010019", "Talwinder,412578963,Vellore");
        Driver.put("JH010020", "Mohit,456321789,Jharkhand");
        Driver.put("JH010021", "Suresh,35748961,Chennai");
        Driver.put("JH010022", "Srinivas_Kappu,87431256,Andra_Pradesh");
        Driver.put("JH010023", "PonnuSwamy_P,254163987,Kochi");
    }

    static class Node {
        String Name;
        String Src_Location;
        String Dest_Location;
        Node next;

        Node(String naam, String srcc, String destu) {
            this.Name = naam;
            this.Src_Location = srcc;
            this.Dest_Location = destu;
            this.next = null;
        }
    }

    static class Edge {
        String source;
        String destintion;
        double distance;

        Edge(String Source, String Destintion, double Kilometres) {
            this.source = Source;
            this.destintion = Destintion;
            this.distance = Kilometres;
        }
    }

    public static void City_Map(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge("Upper Bazzar", "Firayalal Chowk", 22.5));
        graph[0].add(new Edge("Upper Bazzar", "Doranda", 31.0));
        graph[1].add(new Edge("Firayalal Chowk", "Wool House", 1.5));
        graph[1].add(new Edge("Firayalal Chowk", "Hinoo", 21.0));
        graph[3].add(new Edge("Sarjana", "Wool House", 11.2));
        graph[4].add(new Edge("Wool House", "Dhurwa", 50.6));
        graph[5].add(new Edge("HindPiri Chowk", "Over Bridge", 16.2));
        graph[5].add(new Edge("HindPiri Chowk", "Chutia", 2.5));
        graph[6].add(new Edge("Over Bridge", "Birsa Munda Airport", 27.0));
        graph[7].add(new Edge("Doranda", "Hinoo", 18.5));
        graph[8].add(new Edge("Hinoo", "Dhurwa", 49.5));
        graph[9].add(new Edge("Birsa Munda Airport", "Lalapur", 39.5));
        graph[10].add(new Edge("Chutia", "Dhurwa", 72.5));
        graph[11].add(new Edge("Dhurwa", "Wool House", 53.5));
        graph[12].add(new Edge("Kutchery", "Lalpur", 16.7));
        graph[2].add(new Edge("Lalpur", "Upper Bazaar", 39.67));
        HashMap<String, Integer> blank = new HashMap<>();
        blank.put("Upper Bazaar", 0);
        blank.put("Lalpur", 2);
        blank.put("Sarjana", 3);
        blank.put("Wool House", 4);
        blank.put("HindPiri Chowk", 5);
        blank.put("Firayalal Chowk", 1);
        blank.put("Over Bridge", 6);
        blank.put("Doranda", 7);
        blank.put("Hinoo", 8);
        blank.put("Birsa Munda Airport", 9);
        blank.put("Chutia", 10);
        blank.put("Dhurwa", 11);
        blank.put("Kutchery", 12);
    }
}

public class Cab extends Get_Car {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        head = null;
        ArrayList<Edge>[] graph = new ArrayList[13];
        City_Map(graph);
        Car_Data.Car_Details();
        Driver_Information.Driver_DataBase();
        Get_Car obj = new Get_Car();
        obj.Book_Car("Siddharth Goutam Kumar", 20, 'M', "Online_Payment", "Upper Bazaar", "Doranda", "Premium Service");
        // obj.All_Paths(graph, "Upper Bazaar", "Doranda", "");
        obj.Booking_Details_Confirmation(graph);
        String yes = "";
        System.out.println("Do You Want To Print Rider Journey Details Also ");
        yes = in.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            Rider_History();
            Display_Rider_Details();
        }
    }
}
