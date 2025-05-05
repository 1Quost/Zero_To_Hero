package quizzapp.zero_to_hero;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Quiz Manager class to manage questions
class QuizManager {


    // Method to load the image from the path
    public ImageIcon loadImage(String imagePath) {
        try {
            // Try loading the image from the file path
            File imageFile = new File(imagePath);

            if (!imageFile.exists()) {
                System.out.println("Image not found: " + imagePath);
                return null;  // If the image does not exist, return null
            }

            BufferedImage image = ImageIO.read(imageFile);  // Load the image
            if (image == null) {
                System.out.println("Error reading image: " + imagePath);
                return null;  // If the image cannot be read, return null
            }

            return new ImageIcon(image);  // Return the ImageIcon for the GUI

        } catch (IOException e) {
            e.printStackTrace();  // Print any IOExceptions
            return null;  // Return null if there's an error
        }
    }


    private List<Question> allQuestions;
    private List<QuestionImage> allImageQuestions; // Add a list for image questions

    public QuizManager() {
        // Initialize and populate questions
        initializeQuestions();
        initializeImageQuestions();
    }

    private void initializeQuestions() {
        allQuestions = new ArrayList<>();





        /* ====================== */
        /*    OOP Questions       */
        /* ====================== */

        // OOP Questions - Easy
        allQuestions.add(new Question(
                "What does OOP stand for?",
                Arrays.asList( "Order of Operations","Object-Oriented Programming", "Only One Processor", "Open Output Port"),
                "Object-Oriented Programming",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which of the following is NOT a principle of OOP?",
                Arrays.asList("Encapsulation", "Polymorphism", "Compilation", "Inheritance"),
                "Compilation",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to create a class in Java?",
                Arrays.asList("object", "method", "interface","class"),
                "class",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is an object in Java?",
                Arrays.asList("Instance of a class", "A method", "A variable", "A loop"),
                "Instance of a class",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which concept allows using the same method name with different implementations?",
                Arrays.asList("Polymorphism", "Abstraction", "Encapsulation", "Inheritance"),
                "Polymorphism",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which access modifier makes members visible only within the same class?",
                 Arrays.asList( "protected", "public","private" ,"default"),
                "private",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What does the 'new' keyword do in Java?",
                Arrays.asList("Deletes an object", "Defines a method", "Initializes a variable","Creates an object"),
                "Creates an object",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which OOP concept is aimed at hiding internal details?",
                Arrays.asList("Encapsulation", "Inheritance", "Polymorphism", "Abstraction"),
                "Encapsulation",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which method is a constructor?",
                Arrays.asList("void type", "Same name as class","has return type", "called init()"),
                "Same name as class",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is inheritance?",
                Arrays.asList( "Overriding methods", "Creating objects", "Deriving a new class from an existing one","None of these"),
                "Deriving a new class from an existing one",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to inherit a class?",
                Arrays.asList( "inherits", "implements", "super","extends"),
                "extends",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which of the following is not a type of inheritance in Java?",
                Arrays.asList("Multiple", "Single", "Multilevel", "Hierarchical"),
                "Multiple",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which function is automatically called when an object is created?",
                Arrays.asList( "Destructor","Constructor", "Method", "Main"),
                "Constructor",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which of the following can have overloaded constructors?",
                Arrays.asList( "Interfaces", "Methods","Classes", "Objects"),
                "Classes",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which keyword prevents inheritance?",
                Arrays.asList( "static","final", "super", "abstract"),
                "final",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which keyword refers to the superclass?",
                Arrays.asList("super", "this", "base", "parent"),
                "super",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to define a method in an interface?",
                Arrays.asList( "interface", "void", "abstract","public"),
                "abstract",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the default access modifier for class members?",
                Arrays.asList("public", "private", "protected", "default"),
                "default",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which of the following is true for interfaces?",
                Arrays.asList( "Can be instantiated", "Can have private fields", "Cannot have constructors","None of these"),
                "Cannot have constructors",
                "OOP",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Can we overload main() method in Java?",
                Arrays.asList( "No", "Only with static keyword", "Yes","Only in abstract class"),
                "Yes",
                "OOP",
                "Easy"
        ));


        // OOP Questions - Medium
        allQuestions.add(new Question(
                "Which of the following allows method overriding?",
                Arrays.asList("Inheritance", "Abstraction", "Encapsulation", "Polymorphism"),
                "Inheritance",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is method overloading?",
                Arrays.asList("Same method name with different parameters", "Same method in different class", "Calling method inside another", "None of these"),
                "Same method name with different parameters",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which of these is a correct signature of a constructor?",
                Arrays.asList( "public void ClassName()", "void ClassName()","public ClassName()", "public class ClassName()"),
                "public ClassName()",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which access modifier allows access in the same package and subclasses?",
                Arrays.asList("protected", "private", "default", "public"),
                "protected",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is runtime polymorphism also called?",
                Arrays.asList( "Static binding","Dynamic binding", "Compile-time polymorphism", "Method overloading"),
                "Dynamic binding",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is the use of 'this' keyword?",
                Arrays.asList( "Call superclass constructor", "Invoke method","Refer to current object", "None of these"),
                "Refer to current object",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What happens if no constructor is defined in class?",
                Arrays.asList( "Error occurs", "Class cannot be created", "None of these" , "Default constructor is used"),
                "Default constructor is used",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Can a constructor be private?",
                Arrays.asList( "No", "Only in abstract class", "Only in interface" , "Yes"),
                "Yes",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which of the following is a correct example of method overriding?",
                Arrays.asList("Same method name and parameters in subclass", "Same method name with different parameters", "Method inside interface", "Constructor in subclass"),
                "Same method name and parameters in subclass",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is abstraction in OOP?",
                Arrays.asList( "Using same name methods","Hiding implementation details", "Combining classes", "Extending class functionality"),
                "Hiding implementation details",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which one is more abstract: Interface or Abstract Class?",
                Arrays.asList( "Abstract Class", "Both same", "Interface","Depends on context"),
                "Interface",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Can abstract classes have constructors?",
                Arrays.asList( "No", "Only if final", "Only if static" , "Yes"),
                "Yes",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which of the following is an example of polymorphism?",
                Arrays.asList("Method Overriding", "Constructor", "Access modifier", "Class creation"),
                "Method Overriding",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to prevent overriding a method?",
                Arrays.asList( "static", "super", "final","default"),
                "final",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to implement an interface?",
                Arrays.asList( "extends","implements", "interface", "abstract"),
                "implements",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which of the following supports multiple inheritance?",
                Arrays.asList("Interfaces", "Classes", "Abstract Classes", "Constructors"),
                "Interfaces",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What does JVM stand for?",
                Arrays.asList( "Java Variable Memory", "Java Visual Model", "None of these" , "Java Virtual Machine"),
                "Java Virtual Machine",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which concept allows treating objects as instances of their parent class?",
                Arrays.asList("Upcasting", "Downcasting", "Overloading", "Inheritance"),
                "Upcasting",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is the output if an abstract method is not overridden?",
                Arrays.asList( "Runtime error","Compile-time error", "Success", "None"),
                "Compile-time error",
                "OOP",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Can a class be both abstract and final?",
                Arrays.asList( "Yes", "Only in inner class","No", "Only with static"),
                "No",
                "OOP",
                "Medium"
        ));


        // OOP Questions - Hard
        allQuestions.add(new Question(
                "What is the Liskov Substitution Principle?",
                Arrays.asList( "Methods must be private","Subtypes must be substitutable for base types", "Classes should be abstract", "None of these"),
                "Subtypes must be substitutable for base types",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What does the Open/Closed Principle mean?",
                Arrays.asList("Software entities should be open for extension but closed for modification", "All classes must be public", "Classes should be open", "None"),
                "Software entities should be open for extension but closed for modification",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is multiple inheritance in Java?",
                Arrays.asList( "A class uses multiple interfaces", "An object having multiple parents","A class inherits from more than one class", "Not supported"),
                "A class uses multiple interfaces",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which OOP principle reduces software complexity by hiding details?",
                Arrays.asList( "Polymorphism", "Inheritance", "Overloading" , "Abstraction"),
                "Abstraction",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is dynamic method dispatch?",
                Arrays.asList( "Compile time overloading", "Constructor overloading","Run-time polymorphism mechanism", "Static dispatch"),
                "Run-time polymorphism mechanism",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Why is composition favored over inheritance?",
                Arrays.asList("Better flexibility and less coupling", "Easier to implement", "Less memory usage", "More access modifiers"),
                "Better flexibility and less coupling",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which design principle helps avoid tight coupling?",
                Arrays.asList( "Encapsulation", "Final keyword", "Method overloading" , "Dependency Inversion Principle"),
                "Dependency Inversion Principle",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which is not allowed in Java?",
                Arrays.asList("Multiple class inheritance", "Multiple interface implementation", "Abstract methods", "Overloading constructors"),
                "Multiple class inheritance",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What happens if a class does not implement all methods of an interface?",
                Arrays.asList( "It works fine","It must be declared abstract", "It becomes final", "Throws runtime error"),
                "It must be declared abstract",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which keyword is used to stop inheritance?",
                Arrays.asList( "static", "final","super", "abstract"),
                "final",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the purpose of interface segregation principle?",
                Arrays.asList("Clients should not be forced to implement unused interfaces", "One interface for all classes", "Avoid abstraction", "Avoid interface"),
                "Clients should not be forced to implement unused interfaces",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is constructor chaining?",
                Arrays.asList( "Overriding constructors", "Defining multiple constructors","Calling one constructor from another", "Static constructor"),
                "Calling one constructor from another",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the main difference between 'this' and 'super'?",
                Arrays.asList( "Both refer to parent","this refers to current class; super to parent class", "Both are same", "super is for abstract class only"),
                "this refers to current class; super to parent class",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Can you override static methods in Java?",
                Arrays.asList( "Yes","No", "Only in abstract class", "Only with private"),
                "No",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is object slicing?",
                Arrays.asList( "Loss of memory", "Large object copy","Loss of derived class info when assigned to base object", "Casting failure"),
                "Loss of derived class info when assigned to base object",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Can abstract classes have non-abstract methods?",
                Arrays.asList( "No", "Only in interfaces", "Only static methods" , "Yes"),
                "Yes",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is aggregation in OOP?",
                Arrays.asList("HAS-A relationship", "IS-A relationship", "Inheritance type", "None"),
                "HAS-A relationship",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is downcasting?",
                Arrays.asList( "Casting int to float", "Method overriding","Casting base to derived class", "Changing constructor"),
                "Casting base to derived class",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the main purpose of abstraction?",
                Arrays.asList("Hide complex implementation", "Overload methods", "Access modifiers", "None"),
                "Hide complex implementation",
                "OOP",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is coupling?",
                Arrays.asList("Size of class", "Number of objects","Degree of dependency between classes",  "Constructor length"),
                "Degree of dependency between classes",
                "OOP",
                "Hard"
        ));



        /* ====================== */
        /*    Tech Questions      */
        /* ====================== */


        // Technology Questions - Easy
        allQuestions.add(new Question(
                "What does CPU stand for?",
                Arrays.asList("Central Processing Unit", "Computer Processing Unit", "Central Process Utility", "Core Processing Unit"),
                "Central Processing Unit",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What does USB stand for?",
                Arrays.asList( "Unique System Backup", "Universal Serial Bus","Universal Software Base", "United Signal Board"),
                "Universal Serial Bus",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which company makes the iPhone?",
                Arrays.asList( "Samsung", "Google","Apple", "Microsoft"),
                "Apple",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the main function of RAM in a computer?",
                Arrays.asList("Store temporary data", "Store permanent data", "Process graphics", "Control power supply"),
                "Store temporary data",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which of these is a web browser?",
                Arrays.asList( "Linux","Chrome", "Photoshop", "Windows"),
                "Chrome",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What does 'www' stand for in a website browser?",
                Arrays.asList( "Web With Widgets", "Wireless Web World","World Wide Web", "World Web Widget"),
                "World Wide Web",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which company developed Windows?",
                Arrays.asList( "Apple", "IBM", "Google" , "Microsoft"),
                "Microsoft",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What kind of device is a printer?",
                Arrays.asList("Output", "Input", "Storage", "Control"),
                "Output",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is used to browse websites?",
                Arrays.asList( "Compiler","Web browser", "Terminal", "PowerPoint"),
                "Web browser",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What does Wi-Fi allow you to do?",
                Arrays.asList( "Print faster", "Cool your device","Connect to the Internet wirelessly", "Charge your phone"),
                "Connect to the Internet wirelessly",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which one is an operating system?",
                Arrays.asList( "Google", "YouTube", "Intel" , "Linux"),
                "Linux",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which of these is a programming language?",
                Arrays.asList("Python", "PowerPoint", "Photoshop", "Google Drive"),
                "Python",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What does AI stand for?",
                Arrays.asList( "Automated Internet","Artificial Intelligence", "Applied Interface", "Analytical Input"),
                "Artificial Intelligence",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the full form of HTML?",
                Arrays.asList( "HighText Machine Language", "Hyperlink Machine Language","HyperText Markup Language", "Home Tool Markup Language"),
                "HyperText Markup Language",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which device is used to input text?",
                Arrays.asList( "Monitor", "Printer", "Speaker" , "Keyboard"),
                "Keyboard",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is Google Chrome?",
                Arrays.asList("Web browser", "Operating System", "Text Editor", "Antivirus"),
                "Web browser",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which of these is a cloud storage service?",
                Arrays.asList( "VLC","Google Drive", "Adobe Reader", "GIMP"),
                "Google Drive",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which one is a mobile operating system?",
                Arrays.asList( "Ubuntu", "Windows XP","Android", "macOS"),
                "Android",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which company owns Android?",
                Arrays.asList( "Apple", "Microsoft", "Samsung" , "Google"),
                "Google",
                "Technology",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which device is used for video calling?",
                Arrays.asList("Webcam", "Printer", "Scanner", "Router"),
                "Webcam",
                "Technology",
                "Easy"
        ));


        // Technology Questions - Medium
        allQuestions.add(new Question(
                "What does GPU stand for?",
                Arrays.asList( "Global Processing Unit","Graphics Processing Unit", "Graphical Power Unit", "Graphic Programming Utility"),
                "Graphics Processing Unit",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the purpose of an IP address?",
                Arrays.asList( "Store personal data", "Run applications","Identify devices on a network", "Display web content"),
                "Identify devices on a network",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the main function of a firewall?",
                Arrays.asList( "Speed up RAM", "Monitor CPU temperature", "Install software" , "Block unauthorized access"),
                "Block unauthorized access",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What language is primarily used for Android development?",
                Arrays.asList("Java", "Swift", "Python", "Ruby"),
                "Java",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which technology enables cryptocurrency?",
                Arrays.asList( "Database", "Blockchain","Cloud", "Router"),
                "Blockchain",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What does IoT stand for?",
                Arrays.asList( "Information over Time", "Input of Technology","Internet of Things", "Internet on Television"),
                "Internet of Things",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the purpose of a DNS server?",
                Arrays.asList( "Scan viruses", "Load websites faster", "Encrypt data" , "Translate domain names to IP addresses"),
                "Translate domain names to IP addresses",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which tool is used for version control?",
                Arrays.asList("Git", "Excel", "WordPress", "Figma"),
                "Git",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which of the following is an IDE?",
                Arrays.asList( "Google","IntelliJ IDEA", "Photoshop", "Apache"),
                "IntelliJ IDEA",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What does SaaS stand for?",
                Arrays.asList( "System as a Service", "Security as a System","Software as a Service", "Speedy App and Software"),
                "Software as a Service",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is phishing?",
                Arrays.asList( "A firewall tool", "A method of programming", "A Wi-Fi protocol","A cyber attack to steal personal data"),
                "A cyber attack to steal personal data",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which of the following is a markup language?",
                Arrays.asList("HTML", "Python", "C++", "Java"),
                "HTML",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which protocol is used for secure web communication?",
                Arrays.asList( "HTTP","HTTPS", "FTP", "SMTP"),
                "HTTPS",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is a common port number for HTTP?",
                Arrays.asList( "443", "22","80", "25"),
                "80",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which component stores the BIOS?",
                Arrays.asList("RAM", "CPU", "GPU","ROM"),
                "ROM",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which JavaScript library is commonly used for UI?",
                Arrays.asList("React", "Node.js", "Flask", "Django"),
                "React",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What does API stand for?",
                Arrays.asList( "Advanced Programming Internet","Application Programming Interface", "Applied Programming Index", "Artificial Program Integration"),
                "Application Programming Interface",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is GitHub used for?",
                Arrays.asList( "Video editing","Hosting code repositories", "Photo management", "Data encryption"),
                "Hosting code repositories",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the full form of SQL?",
                Arrays.asList( "System Query Logic", "Simple Question Language","Structured Query Language", "Syntax Quality Language"),
                "Structured Query Language",
                "Technology",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is virtualization in computing?",
                Arrays.asList( "Speeding up RAM", "Connecting to the cloud", "Encrypting files","Creating virtual versions of hardware or OS"),
                "Creating virtual versions of hardware or OS",
                "Technology",
                "Medium"
        ));


        //Technology Questions -Hard

        allQuestions.add(new Question(
                "What does the ACID acronym stand for in databases?",
                Arrays.asList("Atomicity, Consistency, Isolation, Durability", "Access, Control, Integrity, Data", "Accuracy, Consistency, Identity, Distribution", "Application, Cache, Index, Data"),
                "Atomicity, Consistency, Isolation, Durability",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which port is used for SSH by default?",
                Arrays.asList( "80","22", "443", "8080"),
                "22",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the key difference between symmetric and asymmetric encryption?",
                Arrays.asList( "Asymmetric is faster", "Symmetric is obsolete", "Symmetric uses one key, asymmetric uses two keys","Symmetric uses public keys only"),
                "Symmetric uses one key, asymmetric uses two keys",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the function of a reverse proxy?",
                Arrays.asList( "It encrypts local storage", "It filters outgoing packets", "It scans for malware","It forwards requests to backend servers"),
                "It forwards requests to backend servers",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which RAID level provides redundancy and striping?",
                Arrays.asList("RAID 5", "RAID 0", "RAID 1", "RAID 10"),
                "RAID 5",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "In networking, what is the purpose of NAT?",
                Arrays.asList( "Detects phishing","Translates private IPs to public IPs", "Speeds up downloads", "Monitors bandwidth usage"),
                "Translates private IPs to public IPs",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which hashing algorithm is considered insecure?",
                Arrays.asList( "SHA-256", "SHA-3","MD5", "Bcrypt"),
                "MD5",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the primary purpose of a load balancer?",
                Arrays.asList( "Encrypt sensitive data", "Compile code", "Monitor CPU usage","Distribute incoming traffic across multiple servers"),
                "Distribute incoming traffic across multiple servers",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which tool is used to analyze network packets?",
                Arrays.asList("Wireshark", "Photoshop", "Docker", "Postman"),
                "Wireshark",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What does REST stand for in API design?",
                Arrays.asList( "Rapid Execution Secure Transfer","Representational State Transfer", "Remote Encoded Software Token", "Reduced Encryption for Secure Transmission"),
                "Representational State Transfer",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is a zero-day vulnerability?",
                Arrays.asList( "A virus that self-destructs in a day", "A backup file format", "A flaw unknown to the vendor","A system update error"),
                "A flaw unknown to the vendor",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which HTTP method is used to update a resource?",
                Arrays.asList( "GET", "POST", "DELETE","PUT"),
                "PUT",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is Docker primarily used for?",
                Arrays.asList("Containerization of applications", "Encrypting databases", "Designing GUIs", "Developing firmware"),
                "Containerization of applications",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which of the following is a NoSQL database?",
                Arrays.asList( "MySQL","MongoDB", "Oracle", "SQLite"),
                "MongoDB",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the main benefit of CDN in web services?",
                Arrays.asList( "Stronger encryption", "Lower CPU usage","Faster content delivery", "Offline mode support"),
                "Faster content delivery",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the primary role of OAuth 2.0?",
                Arrays.asList( "Authentication", "Data compression", "Error handling","Authorization"),
                "Authorization",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What does XSS stand for in cybersecurity?",
                Arrays.asList("Cross Site Scripting", "XML Server Security", "Xtreme Secure Socket", "Cross System Sync"),
                "Cross Site Scripting",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which protocol is used to retrieve emails from a server?",
                Arrays.asList( "SMTP","IMAP", "HTTP", "FTP"),
                "IMAP",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the purpose of a hypervisor?",
                Arrays.asList( "Encrypt traffic", "Speed up SSDs","Run virtual machines", "Generate random keys"),
                "Run virtual machines",
                "Technology",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What does DevOps combine?",
                Arrays.asList( "Design and Optimization", "Devices and OS", "Data and Outputs","Development and Operations"),
                "Development and Operations",
                "Technology",
                "Hard"
        ));






        /* ====================== */
        /*      Sports Quest      */
        /* ====================== */


        // Sport Questions - Easy
        allQuestions.add(new Question(
                "How many players are there in a soccer team on the field?",
                Arrays.asList("11", "10", "12", "9"),
                "11",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What sport is known as 'the king of sports'?",
                Arrays.asList( "Basketball", "Soccer","Tennis", "Cricket"),
                "Soccer",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "In which sport do players use rackets to hit a shuttlecock?",
                Arrays.asList( "Tennis", "Squash", "Badminton","Table Tennis"),
                "Badminton",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "How many rings are there on the Olympic flag?",
                Arrays.asList( "4", "6", "7","5"),
                "5",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country has won the most FIFA World Cups?",
                Arrays.asList("Brazil", "Germany", "Argentina", "France"),
                "Brazil",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "In basketball, how many points is a free throw worth?",
                Arrays.asList( "2","1", "3", "0"),
                "1",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the name of the tennis tournament played on grass courts in England?",
                Arrays.asList( "US Open", "Roland Garros","Wimbledon", "Australian Open"),
                "Wimbledon",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "In which sport can you get a 'hole in one'?",
                Arrays.asList( "Baseball", "Cricket", "Tennis","Golf"),
                "Golf",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which sport uses a puck?",
                Arrays.asList("Ice Hockey", "Lacrosse", "Rugby", "Basketball"),
                "Ice Hockey",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What color jersey is worn by the winner of the Tour de France?",
                Arrays.asList( "Red","Yellow", "Green", "Blue"),
                "Yellow",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country hosted the 2022 FIFA World Cup?",
                Arrays.asList( "Russia", "Brazil","Qatar", "Germany"),
                "Qatar",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which sport is associated with the Super Bowl?",
                Arrays.asList( "Basketball", "Baseball", "Hockey","American Football"),
                "American Football",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the highest score possible in a single frame of bowling?",
                Arrays.asList("30", "20", "15", "10"),
                "30",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the standard length of a marathon?",
                Arrays.asList( "40 km","42.195 km", "45 km", "50 km"),
                "42.195 km",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which sport includes the terms 'strike' and 'spare'?",
                Arrays.asList( "Cricket", "Baseball","Bowling", "Golf"),
                "Bowling",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the name of the famous basketball player known as 'King James'?",
                Arrays.asList( "Michael Jordan", "Kobe Bryant", "Kevin Durant","LeBron James"),
                "LeBron James",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which team sport is played with a bat and ball and originated in England?",
                Arrays.asList("Cricket", "Baseball", "Softball", "Rounders"),
                "Cricket",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the surface of a basketball court usually made from?",
                Arrays.asList( "Grass","Wood", "Sand", "Clay"),
                "Wood",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which Olympic event combines cross-country skiing and rifle shooting?",
                Arrays.asList( "Triathlon", "Pentathlon", "Biathlon","Duathlon"),
                "Biathlon",
                "Sport",
                "Easy"
        ));
        allQuestions.add(new Question(
                "In which sport would you perform a slam dunk?",
                Arrays.asList( "Volleyball", "Football", "Tennis","Basketball"),
                "Basketball",
                "Sport",
                "Easy"
        ));


        //Sport Questions - Medium
        allQuestions.add(new Question(
                "Which country won the first ever FIFA World Cup in 1930?",
                Arrays.asList("Uruguay", "Brazil", "Italy", "Germany"),
                "Uruguay",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "How many minutes is a rugby union match?",
                Arrays.asList( "90","80", "60", "70"),
                "80",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which NBA team has won the most championships?",
                Arrays.asList( "Los Angeles Lakers", "Chicago Bulls","Boston Celtics", "Golden State Warriors"),
                "Boston Celtics",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "In what year were women first allowed to compete in the Olympic Games?",
                Arrays.asList( "1920", "1896", "1932","1900"),
                "1900",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which famous boxer was known as 'The Greatest' and 'The People's Champion'?",
                Arrays.asList("Muhammad Ali", "Mike Tyson", "Joe Frazier", "Floyd Mayweather"),
                "Muhammad Ali",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which country invented the sport of table tennis?",
                Arrays.asList( "China","England", "Japan", "Germany"),
                "England",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What does FIFA stand for?",
                Arrays.asList( "Federal International Football Authority", "Fédération Internationale de Football Association","Football International Federation Association", "Federated Institution for Football Activities"),
                "Fédération Internationale de Football Association",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which male tennis player has the most Grand Slam titles (as of 2024)?",
                Arrays.asList( "Roger Federer", "Rafael Nadal", "Novak Djokovic","Pete Sampras"),
                "Novak Djokovic",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which athlete has won the most Olympic gold medals?",
                Arrays.asList( "Usain Bolt", "Simone Biles", "Larisa Latynina","Michael Phelps"),
                "Michael Phelps",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "How many players are on a baseball team (on the field) at one time?",
                Arrays.asList("9", "10", "11", "8"),
                "9",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which city has hosted the Summer Olympics three times?",
                Arrays.asList( "Athens","London", "Paris", "Los Angeles"),
                "London",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the term for a score of zero in tennis?",
                Arrays.asList( "Nil", "Zero","Love", "Blank"),
                "Love",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Who holds the record for the most home runs in MLB history?",
                Arrays.asList( "Babe Ruth", "Hank Aaron", "Alex Rodriguez","Barry Bonds"),
                "Barry Bonds",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the national sport of Japan?",
                Arrays.asList("Sumo Wrestling", "Karate", "Judo", "Baseball"),
                "Sumo Wrestling",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "How many holes are played in a standard round of golf?",
                Arrays.asList( "9","18", "12", "21"),
                "18",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Who won the men's FIFA World Cup in 2014?",
                Arrays.asList( "Brazil", "Argentina","Germany", "Spain"),
                "Germany",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the name of the stadium where FC Barcelona plays?",
                Arrays.asList( "Santiago Bernabéu", "San Siro", "Old Trafford","Camp Nou"),
                "Camp Nou",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "In cricket, how many runs is a boundary worth?",
                Arrays.asList("4", "2", "6", "1"),
                "4",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which athlete is nicknamed 'Lightning Bolt'?",
                Arrays.asList( "Tyson Gay","Usain Bolt", "Yohan Blake", "Asafa Powell"),
                "Usain Bolt",
                "Sport",
                "Medium"
        ));
        allQuestions.add(new Question(
                "In Formula 1, what color flag is waved to signal the end of a race?",
                Arrays.asList( "Red", "Green","Checkered", "Yellow"),
                "Checkered",
                "Sport",
                "Medium"
        ));


        //Sport Questions - Hard

        allQuestions.add(new Question(
                "Which country has won the most Olympic medals in total?",
                Arrays.asList("United States", "Russia", "Germany", "China"),
                "United States",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Who is the only athlete to play in both a Super Bowl and a World Series?",
                Arrays.asList( "Bo Jackson","Deion Sanders", "Michael Jordan", "Jim Thorpe"),
                "Deion Sanders",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the maximum break in snooker?",
                Arrays.asList( "155", "150","147", "140"),
                "147",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which country won the most gold medals at the 2020 Tokyo Olympics?",
                Arrays.asList("China", "Japan", "Russia","United States"),
                "United States",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the only team in the NFL to go a whole season undefeated, including the Super Bowl?",
                Arrays.asList("Miami Dolphins", "New England Patriots", "Dallas Cowboys", "San Francisco 49ers"),
                "Miami Dolphins",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which female tennis player has the most Grand Slam singles titles?",
                Arrays.asList( "Serena Williams","Margaret Court", "Steffi Graf", "Martina Navratilova"),
                "Margaret Court",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "In which sport would you perform a 'Salchow'?",
                Arrays.asList( "Diving", "Gymnastics", "Figure Skating","Ski Jumping"),
                "Figure Skating",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which nation won the 1998 FIFA World Cup?",
                Arrays.asList( "Brazil", "Germany", "Italy","France"),
                "France",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which horse won the Triple Crown in 2018?",
                Arrays.asList("Justify", "American Pharoah", "Secretariat", "Seabiscuit"),
                "Justify",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the term for three consecutive strikes in bowling?",
                Arrays.asList( "Hat Trick","Turkey", "Triple", "Flame"),
                "Turkey",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Who was the first gymnast to score a perfect 10 in the Olympics?",
                Arrays.asList( "Simone Biles", "Olga Korbut","Nadia Comăneci", "Shannon Miller"),
                "Nadia Comăneci",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which footballer holds the record for most career goals (official matches)?",
                Arrays.asList( "Pele", "Lionel Messi", "Josef Bican","Cristiano Ronaldo"),
                "Cristiano Ronaldo",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "In what year did Roger Bannister break the 4-minute mile?",
                Arrays.asList("1954", "1952", "1956", "1949"),
                "1954",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which country hosted the first modern Olympic Games?",
                Arrays.asList( "France","Greece", "United Kingdom", "Germany"),
                "Greece",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "How many players are on a water polo team (including goalie)?",
                Arrays.asList( "6", "8","7", "9"),
                "7",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which F1 driver won the most races in a single season?",
                Arrays.asList( "Michael Schumacher", "Sebastian Vettel", "Lewis Hamilton","Max Verstappen"),
                "Max Verstappen",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the oldest active trophy in North American sports?",
                Arrays.asList("Stanley Cup", "Commissioner's Trophy", "Lombardi Trophy", "Calder Cup"),
                "Stanley Cup",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which cyclist was stripped of seven Tour de France titles?",
                Arrays.asList( "Jan Ullrich","Lance Armstrong", "Alberto Contador", "Marco Pantani"),
                "Lance Armstrong",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "In which sport is the Davis Cup awarded?",
                Arrays.asList( "Badminton", "Table Tennis","Tennis", "Squash"),
                "Tennis",
                "Sport",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Who won the Ballon d'Or in 2023?",
                Arrays.asList( "Erling Haaland", "Kylian Mbappé", "Kevin De Bruyne","Lionel Messi"),
                "Lionel Messi",
                "Sport",
                "Hard"
        ));




        /* ====================== */
        /*     Science Quest      */
        /* ====================== */


        // Science Questions- Easy
        allQuestions.add(new Question(
                "What planet is known as the Red Planet?",
                Arrays.asList("Mars", "Venus", "Jupiter", "Saturn"),
                "Mars",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What gas do plants absorb from the atmosphere?",
                Arrays.asList( "Oxygen","Carbon Dioxide", "Nitrogen", "Hydrogen"),
                "Carbon Dioxide",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the chemical symbol for water?",
                Arrays.asList( "O2", "CO2", "H2O","NaCl"),
                "H2O",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which part of the body pumps blood?",
                Arrays.asList( "Liver", "Lungs", "Brain","Heart"),
                "Heart",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which planet is closest to the Sun?",
                Arrays.asList("Mercury", "Venus", "Earth", "Mars"),
                "Mercury",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the boiling point of water at sea level in Celsius?",
                Arrays.asList( "90°C","100°C", "80°C", "110°C"),
                "100°C",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which organ do humans use to breathe?",
                Arrays.asList( "Kidneys", "Liver","Lungs", "Heart"),
                "Lungs",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which force keeps us on the ground?",
                Arrays.asList( "Magnetism", "Friction", "Tension","Gravity"),
                "Gravity",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is H in the periodic table?",
                Arrays.asList("Hydrogen", "Helium", "Hassium", "Holmium"),
                "Hydrogen",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the center of an atom called?",
                Arrays.asList( "Electron","Nucleus", "Proton", "Neutron"),
                "Nucleus",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which natural satellite orbits the Earth?",
                Arrays.asList( "Mars", "Venus","The Moon", "Jupiter"),
                "The Moon",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What do bees produce?",
                Arrays.asList( "Milk", "Silk", "Pollen","Honey"),
                "Honey",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which sense is associated with the nose?",
                Arrays.asList("Smell", "Taste", "Hearing", "Sight"),
                "Smell",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which gas is essential for us to breathe?",
                Arrays.asList( "Carbon Dioxide", "Oxygen","Hydrogen", "Nitrogen"),
                "Oxygen",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What part of the plant conducts photosynthesis?",
                Arrays.asList( "Roots", "Stem","Leaves", "Flower"),
                "Leaves",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What type of energy does the Sun provide?",
                Arrays.asList( "Kinetic", "Chemical", "Electrical","Solar"),
                "Solar",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "How many legs does an insect have?",
                Arrays.asList("6", "8", "4", "10"),
                "6",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What shape is a DNA molecule?",
                Arrays.asList( "Spiral","Double Helix", "Circle", "Ladder"),
                "Double Helix",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for changing its color?",
                Arrays.asList( "Frog", "Lizard","Chameleon", "Snake"),
                "Chameleon",
                "Science",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which vitamin is made in the skin when exposed to sunlight?",
                Arrays.asList( "Vitamin C", "Vitamin A", "Vitamin B12","Vitamin D"),
                "Vitamin D",
                "Science",
                "Easy"
        ));


        // Science Questions - Medium

        allQuestions.add(new Question(
                "What part of the cell contains genetic material?",
                Arrays.asList("Nucleus", "Mitochondria", "Cytoplasm", "Ribosome"),
                "Nucleus",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which element has the atomic number 6?",
                Arrays.asList( "Oxygen", "Carbon","Nitrogen", "Helium"),
                "Carbon",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the main gas found in the air we breathe?",
                Arrays.asList( "Oxygen", "Carbon Dioxide","Nitrogen", "Hydrogen"),
                "Nitrogen",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which planet has the most moons?",
                Arrays.asList( "Jupiter", "Uranus", "Neptune","Saturn"),
                "Saturn",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "How many bones are in the adult human body?",
                Arrays.asList("206", "208", "210", "190"),
                "206",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What phenomenon explains the bending of light as it passes through water?",
                Arrays.asList( "Reflection", "Refraction","Diffraction", "Dispersion"),
                "Refraction",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which vitamin is primarily found in citrus fruits?",
                Arrays.asList( "Vitamin D", "Vitamin A","Vitamin C", "Vitamin K"),
                "Vitamin C",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What organelle is known as the powerhouse of the cell?",
                Arrays.asList( "Nucleus", "Golgi Body", "Chloroplast","Mitochondria"),
                "Mitochondria",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which blood type is considered the universal donor?",
                Arrays.asList("O Negative", "O Positive", "AB Positive", "A Negative"),
                "O Negative",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which planet rotates on its side?",
                Arrays.asList( "Neptune","Uranus", "Venus", "Mars"),
                "Uranus",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What does DNA stand for?",
                Arrays.asList( "Dioxyribose Nucleic Acid", "Dynamic Nucleotide Assembly","Deoxyribonucleic Acid", "Double Nucleic Acid"),
                "Deoxyribonucleic Acid",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which metal is liquid at room temperature?",
                Arrays.asList( "Lead", "Zinc", "Aluminum","Mercury"),
                "Mercury",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which part of the brain controls balance and coordination?",
                Arrays.asList("Cerebellum", "Cerebrum", "Brainstem", "Hypothalamus"),
                "Cerebellum",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the most abundant element in the universe?",
                Arrays.asList( "Oxygen","Hydrogen", "Helium", "Carbon"),
                "Hydrogen",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which scientist proposed the three laws of motion?",
                Arrays.asList( "Albert Einstein", "Galileo Galilei","Isaac Newton", "Niels Bohr"),
                "Isaac Newton",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which part of the electromagnetic spectrum is visible to humans?",
                Arrays.asList( "Ultraviolet", "Infrared", "X-rays","Visible Light"),
                "Visible Light",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the pH level of pure water?",
                Arrays.asList("7", "5", "9", "6.5"),
                "7",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which type of blood cell fights infections?",
                Arrays.asList( "Red Blood Cells","White Blood Cells", "Platelets", "Plasma"),
                "White Blood Cells",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the largest internal organ in the human body?",
                Arrays.asList( "Lungs", "Heart", "Liver","Kidneys"),
                "Liver",
                "Science",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the scientific term for the study of earthquakes?",
                Arrays.asList( "Geology", "Meteorology", "Volcanology","Seismology"),
                "Seismology",
                "Science",
                "Medium"
        ));


        // Science Questions - Hard

        allQuestions.add(new Question(
                "What law describes the relationship between the pressure and volume of a gas at constant temperature?",
                Arrays.asList("Boyle's Law", "Charles's Law", "Newton's Law", "Avogadro's Law"),
                "Boyle's Law",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What particle has a positive charge and resides in the nucleus?",
                Arrays.asList("Neutron","Proton",  "Electron", "Photon"),
                "Proton",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which element has the highest electrical conductivity?",
                Arrays.asList( "Copper", "Gold","Silver", "Aluminum"),
                "Silver",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the term for animals that are active during twilight hours?",
                Arrays.asList( "Diurnal", "Nocturnal", "Cathemeral","Crepuscular"),
                "Crepuscular",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which scientist developed the uncertainty principle?",
                Arrays.asList("Werner Heisenberg", "Max Planck", "Erwin Schrödinger", "Albert Einstein"),
                "Werner Heisenberg",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the SI unit of electric charge?",
                Arrays.asList( "Ampere","Coulomb", "Volt", "Farad"),
                "Coulomb",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which planet has a day longer than its year?",
                Arrays.asList( "Mercury", "Mars","Venus", "Neptune"),
                "Venus",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the approximate age of the Earth?",
                Arrays.asList( "3.2 billion years", "6.8 billion years", "2.9 billion years","4.5 billion years"),
                "4.5 billion years",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the rarest blood type in humans?",
                Arrays.asList("AB Negative", "O Negative", "A Negative", "B Positive"),
                "AB Negative",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the chemical formula for table salt?",
                Arrays.asList( "KCl","NaCl", "CaCl2", "NaCO3"),
                "NaCl",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What subatomic particle determines the atomic number of an element?",
                Arrays.asList( "Electron", "Neutron","Proton", "Nucleus"),
                "Proton",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What gas do plants primarily absorb for photosynthesis?",
                Arrays.asList( "Oxygen", "Nitrogen", "Hydrogen","Carbon Dioxide"),
                "Carbon Dioxide",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which force is responsible for keeping planets in orbit around the sun?",
                Arrays.asList("Gravity", "Magnetism", "Friction", "Centrifugal"),
                "Gravity",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which scientist is known for the laws of planetary motion?",
                Arrays.asList( "Isaac Newton", "Johannes Kepler","Galileo Galilei", "Copernicus"),
                "Johannes Kepler",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the name of the galaxy that contains Earth?",
                Arrays.asList( "Andromeda", "Messier 87","Milky Way", "Triangulum"),
                "Milky Way",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which organ produces insulin in the human body?",
                Arrays.asList( "Liver", "Kidney", "Gallbladder","Pancreas"),
                "Pancreas",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the name for the fear of germs?",
                Arrays.asList("Mysophobia", "Arachnophobia", "Acrophobia", "Thanatophobia"),
                "Mysophobia",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which layer of Earth's atmosphere contains the ozone layer?",
                Arrays.asList( "Troposphere","Stratosphere", "Mesosphere", "Thermosphere"),
                "Stratosphere",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which type of radiation has the shortest wavelength?",
                Arrays.asList( "X-rays", "Ultraviolet", "Gamma Rays","Infrared"),
                "Gamma Rays",
                "Science",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What’s the name of the effect where light bends around corners or edges?",
                Arrays.asList( "Refraction", "Reflection", "Interference","Diffraction"),
                "Diffraction",
                "Science",
                "Hard"
        ));




        /* ====================== */
        /*     Geo Questions      */
        /* ====================== */


        // Geography Questions - Easy
        allQuestions.add(new Question(
                "What is the capital city of France?",
                Arrays.asList("Paris", "Rome", "Berlin", "Madrid"),
                "Paris",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which continent is the Sahara Desert located on?",
                Arrays.asList( "Asia","Africa", "Australia", "South America"),
                "Africa",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the largest ocean on Earth?",
                Arrays.asList( "Atlantic Ocean", "Indian Ocean","Pacific Ocean", "Arctic Ocean"),
                "Pacific Ocean",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country is known as the Land of the Rising Sun?",
                Arrays.asList( "China", "Thailand", "South Korea","Japan"),
                "Japan",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the longest river in the world?",
                Arrays.asList("Nile River", "Amazon River", "Yangtze River", "Mississippi River"),
                "Nile River",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which U.S. state is known as the Sunshine State?",
                Arrays.asList( "California","Florida", "Texas", "Arizona"),
                "Florida",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the smallest continent by land area?",
                Arrays.asList( "Europe", "Antarctica", "Australia","South America"),
                "Australia",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country has the largest population?",
                Arrays.asList( "India", "United States", "Indonesia","China"),
                "China",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the capital city of the United Kingdom?",
                Arrays.asList("London", "Edinburgh", "Cardiff", "Belfast"),
                "London",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which ocean lies between Africa and Australia?",
                Arrays.asList( "Atlantic Ocean", "Indian Ocean","Pacific Ocean", "Arctic Ocean"),
                "Indian Ocean",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the tallest mountain in the world?",
                Arrays.asList( "K2", "Kangchenjunga","Mount Everest", "Lhotse"),
                "Mount Everest",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country is famous for the Eiffel Tower?",
                Arrays.asList( "Italy", "Spain", "Germany","France"),
                "France",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the capital city of Canada?",
                Arrays.asList("Ottawa", "Toronto", "Vancouver", "Montreal"),
                "Ottawa",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which continent is known as the 'Dark Continent'?",
                Arrays.asList( "Asia","Africa", "South America", "Australia"),
                "Africa",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the largest country by land area?",
                Arrays.asList( "Canada", "China","Russia", "United States"),
                "Russia",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which river flows through the city of London?",
                Arrays.asList( "Seine", "Danube", "Rhine","Thames"),
                "Thames",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the capital city of Australia?",
                Arrays.asList("Canberra", "Sydney", "Melbourne", "Brisbane"),
                "Canberra",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which desert is the largest in the world?",
                Arrays.asList( "Gobi","Sahara", "Kalahari", "Arctic"),
                "Sahara",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which U.S. state is the largest by land area?",
                Arrays.asList( "Texas", "California", "Alaska","Montana"),
                "Alaska",
                "Geography",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which country is home to the Great Wall?",
                Arrays.asList( "India", "Mongolia", "Japan","China"),
                "China",
                "Geography",
                "Easy"
        ));


        // Geography Questions - Medium
        allQuestions.add(new Question(
                "Which country has the most natural lakes?",
                Arrays.asList("Canada", "Russia", "United States", "Brazil"),
                "Canada",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the capital city of Turkey?",
                Arrays.asList( "Istanbul","Ankara", "Izmir", "Bursa"),
                "Ankara",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which African country has the most pyramids?",
                Arrays.asList( "Egypt", "Ethiopia","Sudan", "Libya"),
                "Sudan",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which river is the longest in Europe?",
                Arrays.asList( "Danube", "Rhine", "Seine","Volga"),
                "Volga",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which mountain range separates Europe from Asia?",
                Arrays.asList("Ural Mountains", "Alps", "Caucasus", "Carpathians"),
                "Ural Mountains",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the capital of New Zealand?",
                Arrays.asList( "Auckland","Wellington", "Christchurch", "Hamilton"),
                "Wellington",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the largest island in the world?",
                Arrays.asList( "Australia", "Borneo","Greenland", "Madagascar"),
                "Greenland",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which sea is the saltiest body of water on Earth?",
                Arrays.asList( "Red Sea", "Caspian Sea", "Mediterranean Sea","Dead Sea"),
                "Dead Sea",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which South American country is landlocked?",
                Arrays.asList("Paraguay", "Uruguay", "Ecuador", "Colombia"),
                "Paraguay",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which country has the most time zones?",
                Arrays.asList( "Russia","France", "USA", "China"),
                "France",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which desert is located in southern Africa?",
                Arrays.asList( "Sahara", "Gobi","Kalahari", "Patagonian"),
                "Kalahari",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the name of the large lake between the USA and Canada?",
                Arrays.asList( "Lake Victoria", "Lake Baikal", "Lake Michigan","Lake Superior"),
                "Lake Superior",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which Asian country has the most islands?",
                Arrays.asList("Indonesia", "Philippines", "Japan", "Malaysia"),
                "Indonesia",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which country shares the longest border with the U.S.?",
                Arrays.asList( "Mexico","Canada", "Russia", "Cuba"),
                "Canada",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which European country is known as the Land of a Thousand Lakes?",
                Arrays.asList( "Norway", "Sweden","Finland", "Switzerland"),
                "Finland",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which capital city lies on two continents?",
                Arrays.asList( "Cairo", "Moscow", "Athens","Istanbul"),
                "Istanbul",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which U.S. state has the most active volcanoes?",
                Arrays.asList( "Hawaii", "California", "Washington","Alaska"),
                "Alaska",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the smallest independent country in the world?",
                Arrays.asList("Vatican City", "Monaco", "San Marino", "Liechtenstein"),
                "Vatican City",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which continent has the most countries?",
                Arrays.asList( "Europe","Africa", "Asia", "South America"),
                "Africa",
                "Geography",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the capital of South Korea?",
                Arrays.asList( "Busan", "Incheon","Seoul", "Daegu"),
                "Seoul",
                "Geography",
                "Medium"
        ));


        // Geography Questions - Hard

        allQuestions.add(new Question(
                "Which country owns the most overseas territories?",
                Arrays.asList("France", "United Kingdom", "USA", "Spain"),
                "France",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the least densely populated country in the world?",
                Arrays.asList( "Namibia","Mongolia", "Australia", "Iceland"),
                "Mongolia",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which city is known as the 'City of a Hundred Spires'?",
                Arrays.asList( "Vienna", "Rome","Prague", "Paris"),
                "Prague",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which African country has Portuguese as its official language?",
                Arrays.asList( "Ghana", "Senegal", "Kenya","Mozambique"),
                "Mozambique",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which river flows through Baghdad?",
                Arrays.asList("Tigris", "Euphrates", "Jordan", "Nile"),
                "Tigris",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the largest volcano in the solar system?",
                Arrays.asList("Mauna Loa", "Etna","Olympus Mons",  "Kilimanjaro"),
                "Olympus Mons",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which country has the most UNESCO World Heritage Sites?",
                Arrays.asList( "China", "Italy","Germany", "India"),
                "Italy",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which capital city is the highest above sea level?",
                Arrays.asList( "Quito", "Kathmandu", "Thimphu","La Paz"),
                "La Paz",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the capital of Bhutan?",
                Arrays.asList("Thimphu", "Kathmandu", "Dhaka", "Colombo"),
                "Thimphu",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which ocean current is responsible for Europe’s mild climate?",
                Arrays.asList( "Humboldt Current","Gulf Stream", "Canary Current", "Kuroshio Current"),
                "Gulf Stream",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the name of the tectonic plate that carries India?",
                Arrays.asList("Eurasian Plate", "Pacific Plate","Indo-Australian Plate",  "African Plate"),
                "Indo-Australian Plate",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which country is home to the ancient city of Petra?",
                Arrays.asList( "Egypt", "Iran", "Saudi Arabia","Jordan"),
                "Jordan",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which desert is the driest non-polar desert on Earth?",
                Arrays.asList("Atacama", "Sahara", "Gobi", "Kalahari"),
                "Atacama",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which is the longest continental mountain range in the world?",
                Arrays.asList( "Rockies","Andes", "Himalayas", "Alps"),
                "Andes",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which strait separates Asia from North America?",
                Arrays.asList( "Strait of Gibraltar", "Bosporus","Bering Strait", "Dover Strait"),
                "Bering Strait",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which country lies on both the Equator and the Prime Meridian?",
                Arrays.asList( "Ghana", "Democratic Republic of the Congo", "Uganda","Gabon"),
                "Gabon",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which U.S. state is closest to Russia?",
                Arrays.asList("Alaska", "Hawaii", "Washington", "California"),
                "Alaska",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which city is located at the highest elevation in the world?",
                Arrays.asList( "El Alto","La Rinconada", "Lhasa", "Potosí"),
                "La Rinconada",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which European capital is divided by the River Danube?",
                Arrays.asList( "Vienna", "Bratislava","Budapest", "Belgrade"),
                "Budapest",
                "Geography",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which island nation is the only one located on all four hemispheres?",
                Arrays.asList( "Fiji", "Micronesia", "Seychelles","Kiribati"),
                "Kiribati",
                "Geography",
                "Hard"
        ));




        /* ====================== */
        /*     Arts Questions     */
        /* ====================== */


        // Art Questions -Easy
        allQuestions.add(new Question(
                "Who painted the Mona Lisa?",
                Arrays.asList("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"),
                "Leonardo da Vinci",
                "Art",
                "Easy"
        ));




        allQuestions.add(new Question(
                "What type of painting technique did Vincent van Gogh use?",
                Arrays.asList("Impressionism", "Cubism", "Pointillism", "Post-Impressionism"),
                "Post-Impressionism",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which famous painting is known for its 'starry night' sky?",
                Arrays.asList( "Starry Night","The Persistence of Memory", "The Scream", "Guernica"),
                "Starry Night",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which artist is known for his 'Campbell's Soup Cans' paintings?",
                Arrays.asList( "Roy Lichtenstein","Andy Warhol", "Jackson Pollock", "Salvador Dalí"),
                "Andy Warhol",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the primary subject of the painting 'The Persistence of Memory'?",
                Arrays.asList( "A skull", "A cityscape","Melting clocks", "A cow"),
                "Melting clocks",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What style of art did Pablo Picasso help pioneer?",
                Arrays.asList( "Abstract Expressionism", "Dadaism", "Cubism","Surrealism"),
                "Cubism",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which famous artist cut off his own ear?",
                Arrays.asList( "Pablo Picasso", "Salvador Dalí", "Claude Monet","Vincent van Gogh"),
                "Vincent van Gogh",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which artist is known for his abstract works with vibrant colors and geometric shapes?",
                Arrays.asList("Wassily Kandinsky", "Leonardo da Vinci", "Monet", "Van Gogh"),
                "Wassily Kandinsky",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the famous sculpture created by Michelangelo?",
                Arrays.asList("David", "The Thinker", "Venus de Milo", "The Kiss"),
                "David",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which artist is known for painting water lilies?",
                Arrays.asList("Pablo Picasso", "Claude Monet", "Vincent van Gogh", "Salvador Dalí"),
                "Claude Monet",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What famous structure did Gustave Eiffel design?",
                Arrays.asList( "Leaning Tower of Pisa", "Big Ben","Eiffel Tower", "Colosseum"),
                "Eiffel Tower",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Who painted 'The Girl with a Pearl Earring'?",
                Arrays.asList( "Rembrandt", "Johannes Vermeer","Leonardo da Vinci", "Michelangelo"),
                "Johannes Vermeer",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which artist is known for the painting 'The Persistence of Memory'?",
                Arrays.asList( "Pablo Picasso", "Claude Monet","Salvador Dalí", "Andy Warhol"),
                "Salvador Dalí",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which art movement was Salvador Dalí associated with?",
                Arrays.asList("Surrealism", "Cubism", "Impressionism", "Abstract Expressionism"),
                "Surrealism",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which of the following was a famous surrealist artist?",
                Arrays.asList("Claude Monet", "Vincent van Gogh", "Andy Warhol","Salvador Dalí"),
                "Salvador Dalí",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which museum is home to the painting 'The Mona Lisa'?",
                Arrays.asList("Louvre Museum", "The British Museum", "The Vatican Museums", "Uffizi Gallery"),
                "Louvre Museum",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which artist created the sculpture 'The Thinker'?",
                Arrays.asList( "Michelangelo","Auguste Rodin", "Donatello", "Pablo Picasso"),
                "Auguste Rodin",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which Italian artist is known for the Sistine Chapel ceiling?",
                Arrays.asList( "Leonardo da Vinci", "Raphael","Michelangelo", "Caravaggio"),
                "Michelangelo",
                "Art",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the name of the famous painting by Leonardo da Vinci that features a woman with a mysterious smile?",
                Arrays.asList("The Last Supper", "Mona Lisa", "The Creation of Adam", "Vitruvian Man"),
                "Mona Lisa",
                "Art",
                "Easy"
        ));


        // Art Questions -Medium

        allQuestions.add(new Question(
                "Which famous artist co-founded the Cubist movement with Pablo Picasso?",
                Arrays.asList("Henri Matisse","Georges Braque",  "Marcel Duchamp", "Juan Gris"),
                "Georges Braque",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What was the primary focus of the Dada movement?",
                Arrays.asList( "Realism", "Classical beauty", "Anti-art and absurdity","Cubism"),
                "Anti-art and absurdity",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which painting by Edvard Munch depicts a figure with a screaming expression?",
                Arrays.asList("The Scream", "Starry Night", "The Persistence of Memory", "Guernica"),
                "The Scream",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which artist is known for the 'Campbell's Soup Cans' and 'Marilyn Monroe' series?",
                Arrays.asList( "Jackson Pollock", "Roy Lichtenstein", "David Hockney","Andy Warhol"),
                "Andy Warhol",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which painter was also an inventor and scientist, besides being an artist?",
                Arrays.asList("Leonardo da Vinci", "Vincent van Gogh", "Michelangelo", "Rembrandt"),
                "Leonardo da Vinci",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Who painted 'The Birth of Venus'?",
                Arrays.asList( "Leonardo da Vinci","Sandro Botticelli", "Raphael", "Caravaggio"),
                "Sandro Botticelli",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which art movement is associated with artists like Claude Monet and Pierre-Auguste Renoir?",
                Arrays.asList( "Surrealism", "Cubism","Impressionism", "Expressionism"),
                "Impressionism",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which of these artists was NOT part of the Impressionist movement?",
                Arrays.asList("Georges Seurat", "Claude Monet", "Edgar Degas", "Salvador Dalí"),
                "Salvador Dalí",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the name of the famous geometric abstract artist known for his 'Composition' paintings?",
                Arrays.asList( "Kazimir Malevich","Piet Mondrian", "Jackson Pollock", "Wassily Kandinsky"),
                "Piet Mondrian",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which famous artist is known for his paintings of water lilies?",
                Arrays.asList("Claude Monet", "Paul Cézanne", "Edgar Degas", "Henri Matisse"),
                "Claude Monet",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Who is the artist behind the 'Guernica' painting, which portrays the horrors of war?",
                Arrays.asList( "Salvador Dalí", "Henri Matisse", "Jackson Pollock","Pablo Picasso"),
                "Pablo Picasso",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which famous surrealist artist is known for his melting clocks in 'The Persistence of Memory'?",
                Arrays.asList( "Marc Chagall", "Max Ernst","Salvador Dalí", "René Magritte"),
                "Salvador Dalí",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which famous artist is known for his 'Blue Period'?",
                Arrays.asList("Pablo Picasso", "Vincent van Gogh", "Henri Matisse", "Claude Monet"),
                "Pablo Picasso",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which American artist is known for his abstract expressionist works like 'No. 5, 1948'?",
                Arrays.asList( "Mark Rothko", "Willem de Kooning","Jackson Pollock", "Andy Warhol"),
                "Jackson Pollock",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which Italian artist is known for his frescoes on the ceiling of the Sistine Chapel?",
                Arrays.asList( "Raphael","Michelangelo", "Leonardo da Vinci", "Donatello"),
                "Michelangelo",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which 20th-century artist was known for his large, colorful drip paintings?",
                Arrays.asList( "Willem de Kooning", "Andy Warhol", "Roy Lichtenstein","Jackson Pollock"),
                "Jackson Pollock",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which German-born American artist is known for his Pop Art works and portraits of Marilyn Monroe?",
                Arrays.asList("Andy Warhol", "Roy Lichtenstein", "Keith Haring", "Robert Rauschenberg"),
                "Andy Warhol",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which American artist is famous for his 'American Gothic' painting?",
                Arrays.asList("Grant Wood", "Edward Hopper", "Jackson Pollock", "Norman Rockwell"),
                "Grant Wood",
                "Art",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which artist painted the 'Last Supper'?",
                Arrays.asList( "Michelangelo","Leonardo da Vinci", "Raphael", "Caravaggio"),
                "Leonardo da Vinci",
                "Art",
                "Medium"
        ));


        // Art Questions -Hard

        allQuestions.add(new Question(
                "Who painted 'Les Demoiselles d'Avignon', one of the earliest examples of Cubism?",
                Arrays.asList( "Georges Braque", "Henri Matisse", "Juan Gris","Pablo Picasso"),
                "Pablo Picasso",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which French artist is known for the technique of 'pointillism'?",
                Arrays.asList("Georges Seurat", "Claude Monet", "Henri Toulouse-Lautrec", "Vincent van Gogh"),
                "Georges Seurat",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which Italian painter and architect is credited with the creation of the 'Renaissance' style?",
                Arrays.asList( "Michelangelo","Leonardo da Vinci", "Raphael", "Donatello"),
                "Leonardo da Vinci",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which German artist painted 'The Garden of Earthly Delights'?",
                Arrays.asList( "Albrecht Dürer", "Gustav Klimt","Hieronymus Bosch", "Caspar David Friedrich"),
                "Hieronymus Bosch",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which artist painted 'The School of Athens', a fresco in the Vatican?",
                Arrays.asList( "Michelangelo", "Leonardo da Vinci", "Caravaggio","Raphael"),
                "Raphael",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which 20th-century artist is known for his work 'Nude Descending a Staircase No. 2'?",
                Arrays.asList("Marcel Duchamp", "Andy Warhol", "Jackson Pollock", "Salvador Dalí"),
                "Marcel Duchamp",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which artist painted the controversial 'The Death of Marat'?",
                Arrays.asList( "Paul Cézanne","Jacques-Louis David", "Édouard Manet", "Gustave Courbet"),
                "Jacques-Louis David",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which artist is known for creating the 'Guernica' painting, a reaction to the bombing of the Spanish town during the Spanish Civil War?",
                Arrays.asList("Salvador Dalí", "Pablo Picasso", "Henri Matisse", "Marc Chagall"),
                "Pablo Picasso",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Who painted the iconic 'The Night Watch'?",
                Arrays.asList("Rembrandt", "Johannes Vermeer", "Caravaggio", "Jan van Eyck"),
                "Rembrandt",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which American artist is known for his series of paintings of 'Jack-in-the-Pulpit' flowers?",
                Arrays.asList( "Edward Hopper", "John Singer Sargent","Georgia O'Keeffe", "Mark Rothko"),
                "Georgia O'Keeffe",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which French artist was a leader of the Fauvist movement and known for his bold, non-naturalistic use of color?",
                Arrays.asList("Henri Matisse", "Claude Monet", "Édouard Manet", "Paul Cézanne"),
                "Henri Matisse",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which English artist is associated with the Pre-Raphaelite Brotherhood?",
                Arrays.asList("J.M.W. Turner", "William Blake", "Francis Bacon","Dante Gabriel Rossetti" ),
                "Dante Gabriel Rossetti",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which artist is known for his 'Black Square' painting, a major contribution to the Russian avant-garde?",
                Arrays.asList("Kazimir Malevich", "Wassily Kandinsky", "Piet Mondrian", "Max Ernst"),
                "Kazimir Malevich",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which Italian Renaissance artist is known for his contributions to both painting and sculpture, creating works like 'David' and 'Pietà'?",
                Arrays.asList( "Leonardo da Vinci","Michelangelo", "Raphael", "Donatello"),
                "Michelangelo",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which Russian artist is known for his abstract works and as a founder of abstract art?",
                Arrays.asList( "Kazimir Malevich", "Piet Mondrian", "Wassily Kandinsky","Paul Klee"),
                "Wassily Kandinsky",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which German-born American artist was known for his use of 'drip painting'?",
                Arrays.asList("Jackson Pollock", "Mark Rothko", "Willem de Kooning", "Andy Warhol"),
                "Jackson Pollock",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which art movement, pioneered by artists like Andy Warhol and Roy Lichtenstein, used commercial techniques and mass media imagery?",
                Arrays.asList( "Dadaism", "Pop Art","Cubism", "Abstract Expressionism"),
                "Pop Art",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which artist was known for his depictions of war and violence, particularly in the painting 'Guernica'?",
                Arrays.asList( "Marc Chagall", "Salvador Dalí","Pablo Picasso", "Henri Matisse"),
                "Pablo Picasso",
                "Art",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which French artist is known for his surrealist works that often feature dreamlike imagery?",
                Arrays.asList("René Magritte", "Salvador Dalí", "Max Ernst", "Paul Klee"),
                "René Magritte",
                "Art",
                "Hard"
        ));








        /* ====================== */
        /*   Animal Questions     */
        /* ====================== */


        // Animal Questions -Easy

        allQuestions.add(new Question(
                "What is the fastest land animal?",
                Arrays.asList("Cheetah", "Lion", "Tiger", "Leopard"),
                "Cheetah",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its ability to change color to blend in with its surroundings?",
                Arrays.asList("Octopus","Chameleon",  "Squid", "Lizard"),
                "Chameleon",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the largest mammal on Earth?",
                Arrays.asList( "Elephant", "Giraffe","Blue Whale", "Shark"),
                "Blue Whale",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is the national symbol of the United States?",
                Arrays.asList( "Lion", "Elephant", "Buffalo","Bald Eagle"),
                "Bald Eagle",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the only mammal capable of flight?",
                Arrays.asList("Bat", "Bird", "Flying Squirrel", "Flying Fish"),
                "Bat",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known as the 'King of the Jungle'?",
                Arrays.asList("Lion", "Tiger", "Elephant", "Bear"),
                "Lion",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is the largest species of cat in the world?",
                Arrays.asList( "Lion","Siberian Tiger", "Jaguar", "Leopard"),
                "Siberian Tiger",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is famous for its slow movement and long naps, often seen hanging from trees?",
                Arrays.asList( "Koala", "Anteater","Sloth", "Tortoise"),
                "Sloth",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which type of animal is a Komodo dragon?",
                Arrays.asList( "Snake","Lizard", "Crocodile", "Turtle"),
                "Lizard",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which bird is known for its ability to mimic human speech?",
                Arrays.asList( "Eagle", "Sparrow", "Parrot","Penguin"),
                "Parrot",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the largest species of shark?",
                Arrays.asList("Whale Shark", "Great White Shark", "Hammerhead Shark", "Tiger Shark"),
                "Whale Shark",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its ability to carry heavy loads and is often used as a working animal?",
                Arrays.asList( "Horse","Elephant", "Camel", "Ox"),
                "Camel",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal has the longest lifespan?",
                Arrays.asList( "Whale", "Elephant", "Shark","Tortoise"),
                "Tortoise",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What type of animal is a jellyfish?",
                Arrays.asList("Invertebrate", "Fish", "Reptile", "Amphibian"),
                "Invertebrate",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for having a hump on its back and is often associated with desert environments?",
                Arrays.asList( "Donkey", "Horse","Camel", "Elephant"),
                "Camel",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "What is the primary diet of a panda?",
                Arrays.asList( "Fish","Bamboo", "Meat", "Fruits"),
                "Bamboo",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its unique black and white stripes?",
                Arrays.asList( "Tiger", "Penguin","Zebra", "Skunk"),
                "Zebra",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal has a long, sticky tongue and is known for catching insects?",
                Arrays.asList( "Lizard", "Anteater", "Chameleon","Frog"),
                "Frog",
                "Animal",
                "Easy"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its large, distinctive tusks?",
                Arrays.asList("Elephant", "Walrus", "Boar", "Rhino"),
                "Elephant",
                "Animal",
                "Easy"
        ));


        // Animal Questions -Medium

        allQuestions.add(new Question(
                "Which animal is known to have the longest migration of any mammal?",
                Arrays.asList("Gray Whale", "Elephant", "Bald Eagle", "Caribou"),
                "Gray Whale",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the primary method of communication for dolphins?",
                Arrays.asList( "Body language","Clicks and whistles", "Roaring", "Chirping"),
                "Clicks and whistles",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the largest species of primate?",
                Arrays.asList("Chimpanzee", "Gorilla", "Orangutan", "Baboon"),
                "Gorilla",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which bird has the largest wingspan of any living bird?",
                Arrays.asList("Eagle", "Penguin","Albatross",  "Vulture"),
                "Albatross",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is known for producing the sound called 'roar'?",
                Arrays.asList( "Tiger", "Bear", "Wolf","Lion"),
                "Lion",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its black-and-white fur and its distinctive 'tail'?",
                Arrays.asList("Panda", "Skunk", "Zebra", "Penguin"),
                "Panda",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which type of animal is a sea urchin?",
                Arrays.asList("Echinoderm", "Mammal", "Fish", "Crustacean"),
                "Echinoderm",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal has the largest brain relative to its body size?",
                Arrays.asList( "Elephant","Dolphin", "Human", "Whale"),
                "Dolphin",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which species of penguin is the largest?",
                Arrays.asList( "King Penguin", "Adélie Penguin", "Emperor Penguin","Chinstrap Penguin"),
                "Emperor Penguin",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its ability to regenerate limbs?",
                Arrays.asList("Axolotl", "Lizard", "Frog", "Turtle"),
                "Axolotl",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which species of bear is native to China and mainly feeds on bamboo?",
                Arrays.asList( "Grizzly Bear", "Polar Bear","Giant Panda", "Black Bear"),
                "Giant Panda",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is known for having a 'bat-like' wing structure, capable of gliding?",
                Arrays.asList( "Fruit Bat", "Flying Fish", "Dragonfly","Flying Squirrel"),
                "Flying Squirrel",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which mammal is known for giving birth to live young but lacks a placenta?",
                Arrays.asList("Marsupials", "Primates", "Rodents", "Reptiles"),
                "Marsupials",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal has the longest tongue in relation to its body size?",
                Arrays.asList("Ant-eater", "Chameleon", "Hummingbird", "Frog"),
                "Ant-eater",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which type of animal is a 'Blue Poison Dart Frog'?",
                Arrays.asList( "Reptile", "Fish","Amphibian", "Mammal"),
                "Amphibian",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is capable of flight but is not a bird?",
                Arrays.asList("Bat", "Flying Squirrel", "Dragonfly", "Flying Fish"),
                "Bat",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which type of animal is a sea cucumber?",
                Arrays.asList( "Fish", "Mammal", "Echinoderm","Invertebrate"),
                "Echinoderm",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "What is the fastest species of fish?",
                Arrays.asList("Sailfish", "Great White Shark", "Tuna", "Mahi Mahi"),
                "Sailfish",
                "Animal",
                "Medium"
        ));
        allQuestions.add(new Question(
                "Which animal is known for its 'tail slap' behavior in the water?",
                Arrays.asList( "Dolphin", "Seal", "Penguin","Whale"),
                "Whale",
                "Animal",
                "Medium"
        ));


        // Animal Questions -Hard

        allQuestions.add(new Question(
                "What animal has the largest eyes of any land mammal?",
                Arrays.asList("Elephant", "Giraffe", "Horse", "Albatross"),
                "Elephant",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal is capable of flight but is not a bird, often mistaken for one?",
                Arrays.asList( "Bat","Flying Squirrel", "Dragonfly", "Flying Fish"),
                "Bat",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the heaviest species of fish?",
                Arrays.asList("Whale Shark", "Great White Shark", "Manta Ray", "Stingray"),
                "Whale Shark",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which species of bird migrates the farthest, traveling up to 12,000 miles?",
                Arrays.asList("Arctic Tern", "Swallow", "Canada Goose", "Pelican"),
                "Arctic Tern",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal is known to have the strongest bite force relative to its size?",
                Arrays.asList( "Jaguar", "Crocodile","Pistol Shrimp", "Alligator"),
                "Pistol Shrimp",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal can survive for days without water, even in extremely hot environments?",
                Arrays.asList("Camel","Kangaroo Rat",  "Gila Monster", "Fennec Fox"),
                "Kangaroo Rat",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which mammal is known for being able to slow its heart rate and enter a state of hibernation for months?",
                Arrays.asList( "Bat", "Bear", "Ground Squirrel","Raccoon"),
                "Ground Squirrel",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal is the only one known to use tools to hunt for food?",
                Arrays.asList("Chimpanzee","Orangutan",  "Dolphin", "Elephant"),
                "Chimpanzee",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which species of shark is the only one known to enter freshwater environments?",
                Arrays.asList( "Great White Shark", "Hammerhead Shark", "Tiger Shark","Bull Shark"),
                "Bull Shark",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What is the primary food source for the carnivorous plant, the Venus Flytrap?",
                Arrays.asList("Insects", "Small Mammals", "Birds", "Reptiles"),
                "Insects",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal has a unique method of hunting by emitting high-pitched sounds that bounce off prey, a technique known as echolocation?",
                Arrays.asList("Bat", "Dolphin", "Whale", "All of the above"),
                "All of the above",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal is capable of asexual reproduction, producing offspring without a mate?",
                Arrays.asList( "Shark","Komodo Dragon", "Boa Constrictor", "Lionfish"),
                "Komodo Dragon",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal species has the longest gestation period?",
                Arrays.asList( "Whale", "Giraffe","Elephant", "Rhino"),
                "Elephant",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which bird is known for migrating the longest distance, often crossing oceans?",
                Arrays.asList("Bar-tailed Godwit", "Albatross", "Peregrine Falcon", "Red Knot"),
                "Bar-tailed Godwit",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal is known for being able to survive without oxygen for extended periods of time?",
                Arrays.asList( "Goldfish", "Shark","Tardigrade", "Snake"),
                "Tardigrade",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which mammal can sleep for up to three years at a time, entering a hibernation-like state?",
                Arrays.asList( "Tortoise", "Ground Squirrel", "Dormouse","Frog"),
                "Dormouse",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which animal has the most complex nervous system after humans?",
                Arrays.asList("Octopus", "Squid", "Dolphin", "Cuttlefish"),
                "Octopus",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "What animal is known for having a 'superpower' in terms of its ability to regenerate lost limbs?",
                Arrays.asList( "Starfish", "Axolotl","Lizard", "Salamander"),
                "Axolotl",
                "Animal",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which species of mammal has the highest number of teeth?",
                Arrays.asList( "Shark", "Rabbit","Anteater", "Opossum"),
                "Opossum",
                "Animal",
                "Hard"
        ));







         /* ====================== */
        /*      Hist Questions    */
        /* ====================== */


        // History Questions
        allQuestions.add(new Question(
                "Who was the first President of the United States?",
                Arrays.asList("George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"),
                "George Washington",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "In which year did the Titanic sink?",
                Arrays.asList( "1905","1912", "1920", "1898"),
                "1912",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What was the name of the first man to walk on the moon?",
                Arrays.asList( "Buzz Aldrin", "Neil Armstrong","Yuri Gagarin", "Alan Shepard"),
                "Neil Armstrong",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which country was the birthplace of the Olympic Games?",
                Arrays.asList( "Rome", "China", "France","Greece"),
                "Greece",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Who discovered America in 1492?",
                Arrays.asList("Christopher Columbus", "Ferdinand Magellan", "Marco Polo", "Leif Erikson"),
                "Christopher Columbus",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What was the name of the ship that brought the Pilgrims to America in 1620?",
                Arrays.asList("Mayflower", "Santa Maria", "Titanic", "Discovery"),
                "Mayflower",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "In which year did World War I begin?",
                Arrays.asList( "1912","1914", "1939", "1923"),
                "1914",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What was the name of the first human to fly in space?",
                Arrays.asList( "Neil Armstrong", "Buzz Aldrin","Yuri Gagarin", "Alan Shepard"),
                "Yuri Gagarin",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Who was the famous British Prime Minister during World War II?",
                Arrays.asList("Margaret Thatcher", "David Cameron", "Tony Blair","Winston Churchill" ),
                "Winston Churchill",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which ancient civilization built the pyramids?",
                Arrays.asList("Egyptians", "Romans", "Greeks", "Mayans"),
                "Egyptians",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What year did the Berlin Wall fall?",
                Arrays.asList("1991","1989",  "1979", "1963"),
                "1989",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Who was the first President of France?",
                Arrays.asList("Louis-Napoleon Bonaparte", "Charles de Gaulle", "Napoleon Bonaparte", "François Mitterrand"),
                "Louis-Napoleon Bonaparte",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What was the name of the first successful English settlement in America?",
                Arrays.asList( "Plymouth", "Jamestown","Roanoke", "Salem"),
                "Jamestown",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which of these wars was fought between the North and South in the United States?",
                Arrays.asList( "The Revolutionary War", "The Civil War","The War of 1812", "World War I"),
                "The Civil War",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "In what year did the United States gain independence?",
                Arrays.asList( "1789", "1800","1776", "1812"),
                "1776",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Who was the first female Prime Minister of the United Kingdom?",
                Arrays.asList("Margaret Thatcher", "Queen Victoria", "Theresa May", "Florence Nightingale"),
                "Margaret Thatcher",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which war ended with the signing of the Treaty of Versailles?",
                Arrays.asList( "World War II", "Napoleonic Wars", "Crimean War","World War I"),
                "World War I",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Who was the first emperor of China?",
                Arrays.asList("Qin Shi Huang", "Han Wudi", "Liu Bang", "Tang Taizong"),
                "Qin Shi Huang",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which ancient city was buried by the eruption of Mount Vesuvius in 79 AD?",
                Arrays.asList("Pompeii", "Athens", "Rome", "Carthage"),
                "Pompeii",
                "History",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which U.S. President abolished slavery?",
                Arrays.asList( "George Washington","Abraham Lincoln", "Thomas Jefferson", "Andrew Johnson"),
                "Abraham Lincoln",
                "History",
                "Easy"
        ));




        //History Questions -Medium
        allQuestions.add(new Question(
                "In which year did the Berlin Wall fall?",
                Arrays.asList( "1991", "1979", "1989","1963"),
                "1989",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the first emperor of China?",
                Arrays.asList( "Han Wudi", "Qin Shi Huang","Liu Bang", "Tang Taizong"),
                "Qin Shi Huang",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What ancient city was buried by the eruption of Mount Vesuvius in 79 AD?",
                Arrays.asList("Athens", "Rome","Pompeii",  "Carthage"),
                "Pompeii",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which event triggered the start of World War II?",
                Arrays.asList("Invasion of Poland", "Attack on Pearl Harbor", "Assassination of Archduke Ferdinand", "Invasion of France"),
                "Invasion of Poland",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the first woman to fly solo across the Atlantic?",
                Arrays.asList( "Harriet Quimby", "Jacqueline Cochran", "Bessie Coleman","Amelia Earhart"),
                "Amelia Earhart",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which country was the first to grant women the right to vote?",
                Arrays.asList("New Zealand", "United States", "France", "Sweden"),
                "New Zealand",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "In which year was the Magna Carta signed?",
                Arrays.asList( "1066","1215", "1492", "1588"),
                "1215",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the leader of the Soviet Union during World War II?",
                Arrays.asList( "Leon Trotsky", "Nikita Khrushchev", "Vladimir Lenin","Joseph Stalin"),
                "Joseph Stalin",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which U.S. president signed the Emancipation Proclamation?",
                Arrays.asList("Abraham Lincoln", "George Washington", "Thomas Jefferson", "Andrew Johnson"),
                "Abraham Lincoln",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What was the name of the ship that brought the first successful English settlers to America in 1607?",
                Arrays.asList( "Mayflower", "Discovery", "Golden Hind","Susan Constant"),
                "Susan Constant",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which battle was the turning point in the American Civil War?",
                Arrays.asList( "Battle of Antietam","Battle of Gettysburg", "Battle of Fort Sumter", "Battle of Shiloh"),
                "Battle of Gettysburg",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which famous ancient philosopher taught Alexander the Great?",
                Arrays.asList( "Plato", "Socrates","Aristotle", "Pythagoras"),
                "Aristotle",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the first President of the Republic of China?",
                Arrays.asList( "Chiang Kai-shek", "Mao Zedong", "Zhou Enlai","Sun Yat-sen"),
                "Sun Yat-sen",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What was the name of the ancient civilization that lived in Mesopotamia?",
                Arrays.asList("Sumerians", "Assyrians", "Babylonians", "Persians"),
                "Sumerians",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What empire was ruled by the Mongol leader Genghis Khan?",
                Arrays.asList( "The Ottoman Empire", "The Mongol Empire","The Byzantine Empire", "The Roman Empire"),
                "The Mongol Empire",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the famous French military leader that became Emperor?",
                Arrays.asList( "Louis XIV", "Charlemagne","Napoleon Bonaparte", "Philip II"),
                "Napoleon Bonaparte",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which country did the Aztecs reside in?",
                Arrays.asList( "Peru","Mexico", "Brazil", "Colombia"),
                "Mexico",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "In which year was the first modern Olympic Games held?",
                Arrays.asList("1896", "1924", "1900", "1912"),
                "1896",
                "History",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which war was fought between the United States and Mexico?",
                Arrays.asList("American Civil War", "Spanish-American War", "War of 1812","Mexican-American War" ),
                "Mexican-American War",
                "History",
                "Medium"
        ));




        //History Questions -Hard

        allQuestions.add(new Question(
                "Who was the king of Macedonia who conquered most of the known world?",
                Arrays.asList("Alexander the Great", "Philip II", "Antiochus", "Hannibal"),
                "Alexander the Great",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who invented the printing press in the 15th century?",
                Arrays.asList("Johannes Gutenberg", "Leonardo da Vinci", "Martin Luther", "Isaac Newton"),
                "Johannes Gutenberg",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What was the name of the first successful English settlement in America?",
                Arrays.asList( "Plymouth","Jamestown", "Roanoke", "Salem"),
                "Jamestown",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the first President of the United States?",
                Arrays.asList( "Thomas Jefferson", "Abraham Lincoln","George Washington", "John Adams"),
                "George Washington",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which battle marked the end of the Napoleonic Wars?",
                Arrays.asList( "Battle of Leipzig", "Battle of Waterloo","Battle of Austerlitz", "Battle of Trafalgar"),
                "Battle of Waterloo",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which event marked the end of World War II in Europe?",
                Arrays.asList( "Battle of Stalingrad", "The Battle of the Bulge", "V-E Day","D-Day"),
                "V-E Day",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What year did the French Revolution begin?",
                Arrays.asList( "1776", "1789","1800", "1799"),
                "1789",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which empire collapsed after the fall of Constantinople?",
                Arrays.asList( "Roman Empire", "Ottoman Empire","Byzantine Empire", "Mongol Empire"),
                "Byzantine Empire",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who discovered the law of gravity?",
                Arrays.asList("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nicolas Copernicus"),
                "Isaac Newton",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the last czar of Russia?",
                Arrays.asList( "Alexander III", "Ivan IV", "Nicholas II","Peter the Great"),
                "Nicholas II",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which war was fought between the United States and Mexico?",
                Arrays.asList("Mexican-American War", "American Civil War", "Spanish-American War", "War of 1812"),
                "Mexican-American War",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What was the name of the first man-made satellite launched by the Soviet Union?",
                Arrays.asList( "Vostok 1", "Luna 2", "Sputnik 1","Soyuz 11"),
                "Sputnik 1",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which country was the first to grant women the right to vote?",
                Arrays.asList( "United States", "Australia", "Finland","New Zealand"),
                "New Zealand",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
                Arrays.asList("Nikita Khrushchev", "Joseph Stalin", "Leonid Brezhnev", "Mikhail Gorbachev"),
                "Nikita Khrushchev",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What year did the Berlin Wall fall?",
                Arrays.asList( "1991","1989", "1987", "1990"),
                "1989",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which ancient civilization is known for creating the first known written language?",
                Arrays.asList( "Egyptians", "Indus Valley","Sumerians", "Minoans"),
                "Sumerians",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which country did the United States fight in the War of 1812?",
                Arrays.asList( "France", "Spain", "Mexico","Great Britain"),
                "Great Britain",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which war was fought between the North and South of the United States from 1861 to 1865?",
                Arrays.asList("American Civil War", "World War I", "Spanish-American War", "Mexican-American War"),
                "American Civil War",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What was the name of the ship that carried the Pilgrims to America in 1620?",
                Arrays.asList( "Santa Maria","Mayflower", "Pinta", "Endeavour"),
                "Mayflower",
                "History",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the longest-reigning British monarch before Queen Elizabeth II?",
                Arrays.asList( "King George III", "King Henry VIII", "Queen Elizabeth I","Queen Victoria"),
                "Queen Victoria",
                "History",
                "Hard"
        ));






        /* ====================== */
        /*    General Quest       */
        /* ====================== */


        // General Knowledge Questions
        allQuestions.add(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("Venus", "Mars", "Jupiter", "Mercury"),
                "Mars",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"),
                "Paris",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is H2O commonly known as?",
                Arrays.asList("Oxygen", "Salt", "Water", "Hydrogen"),
                "Water",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which animal is known as the 'King of the Jungle'?",
                Arrays.asList("Tiger", "Elephant", "Lion", "Bear"),
                "Lion",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "How many continents are there on Earth?",
                Arrays.asList("5", "6", "7", "8"),
                "7",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the largest ocean on Earth?",
                Arrays.asList("Indian", "Atlantic", "Arctic", "Pacific"),
                "Pacific",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which gas do plants absorb from the atmosphere?",
                Arrays.asList("Oxygen", "Carbon Dioxide", "Hydrogen", "Nitrogen"),
                "Carbon Dioxide",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which country is famous for the Great Wall?",
                Arrays.asList("India", "China", "Japan", "Korea"),
                "China",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which bird is known for imitating sounds?",
                Arrays.asList("Crow", "Parrot", "Eagle", "Sparrow"),
                "Parrot",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What color do you get by mixing red and white?",
                Arrays.asList("Pink", "Orange", "Purple", "Green"),
                "Pink",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which is the smallest prime number?",
                Arrays.asList("0", "1", "2", "3"),
                "2",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which month has 28 or 29 days?",
                Arrays.asList("February", "March", "April", "June"),
                "February",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "How many hours are there in a day?",
                Arrays.asList("24", "12", "36", "48"),
                "24",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the boiling point of water at sea level?",
                Arrays.asList("90°C", "80°C", "100°C", "70°C"),
                "100°C",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the tallest animal in the world?",
                Arrays.asList("Elephant", "Giraffe", "Horse", "Kangaroo"),
                "Giraffe",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which part of the plant conducts photosynthesis?",
                Arrays.asList("Root", "Stem", "Leaf", "Flower"),
                "Leaf",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What do bees make?",
                Arrays.asList("Milk", "Wax", "Honey", "Nectar"),
                "Honey",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "What is the main ingredient in bread?",
                Arrays.asList("Flour", "Rice", "Sugar", "Salt"),
                "Flour",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which shape has four equal sides?",
                Arrays.asList("Triangle", "Rectangle", "Square", "Circle"),
                "Square",
                "General",
                "Easy"
        ));

        allQuestions.add(new Question(
                "Which organ pumps blood through the body?",
                Arrays.asList("Lungs", "Heart", "Brain", "Liver"),
                "Heart",
                "General",
                "Easy"
        ));


        //General - Medium
        allQuestions.add(new Question(
                "Who painted the Mona Lisa?",
                Arrays.asList("Michelangelo", "Leonardo da Vinci", "Raphael", "Picasso"),
                "Leonardo da Vinci",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which country hosted the 2016 Summer Olympics?",
                Arrays.asList("China", "Brazil", "UK", "Russia"),
                "Brazil",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is the hardest natural substance on Earth?",
                Arrays.asList("Gold", "Iron", "Diamond", "Quartz"),
                "Diamond",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "How many teeth does a typical adult human have?",
                Arrays.asList("28", "30", "32", "36"),
                "32",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is the capital of Canada?",
                Arrays.asList("Toronto", "Vancouver", "Ottawa", "Montreal"),
                "Ottawa",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What is the currency of Japan?",
                Arrays.asList("Won", "Yuan", "Dollar", "Yen"),
                "Yen",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which planet has the most moons?",
                Arrays.asList("Jupiter", "Saturn", "Earth", "Neptune"),
                "Saturn",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "What language has the most native speakers worldwide?",
                Arrays.asList("English", "Mandarin", "Spanish", "Hindi"),
                "Mandarin",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "How many elements are on the periodic table?",
                Arrays.asList("108", "118", "128", "138"),
                "118",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which gas makes up most of Earth’s atmosphere?",
                Arrays.asList("Oxygen", "Hydrogen", "Nitrogen", "Carbon Dioxide"),
                "Nitrogen",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who discovered gravity?",
                Arrays.asList("Galileo", "Isaac Newton", "Einstein", "Tesla"),
                "Isaac Newton",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which city is known as the 'Big Apple'?",
                Arrays.asList("Los Angeles", "New York", "Chicago", "Boston"),
                "New York",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "In which year did World War II end?",
                Arrays.asList("1945", "1940", "1950", "1939"),
                "1945",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which blood type is known as the universal donor?",
                Arrays.asList("A", "B", "AB", "O negative"),
                "O negative",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which is the longest river in the world?",
                Arrays.asList("Amazon", "Nile", "Yangtze", "Mississippi"),
                "Nile",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who wrote 'Hamlet'?",
                Arrays.asList("Charles Dickens", "Jane Austen", "William Shakespeare", "Mark Twain"),
                "William Shakespeare",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which metal is liquid at room temperature?",
                Arrays.asList("Mercury", "Aluminum", "Lead", "Iron"),
                "Mercury",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "How many sides does a hexagon have?",
                Arrays.asList("5", "6", "7", "8"),
                "6",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Who was the first person on the moon?",
                Arrays.asList("Buzz Aldrin", "Yuri Gagarin", "Neil Armstrong", "John Glenn"),
                "Neil Armstrong",
                "General",
                "Medium"
        ));

        allQuestions.add(new Question(
                "Which vitamin is produced when skin is exposed to sunlight?",
                Arrays.asList("Vitamin A", "Vitamin C", "Vitamin D", "Vitamin B12"),
                "Vitamin D",
                "General",
                "Medium"
        ));



        //General -Hard
        allQuestions.add(new Question(
                "Which Nobel Prize category was introduced in 1969?",
                Arrays.asList("Peace", "Economics", "Literature", "Mathematics"),
                "Economics",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who developed the general theory of relativity?",
                Arrays.asList("Isaac Newton", "Stephen Hawking", "Albert Einstein", "Niels Bohr"),
                "Albert Einstein",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the smallest country in the world by area?",
                Arrays.asList("Monaco", "Nauru", "Vatican City", "San Marino"),
                "Vatican City",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which element has the atomic number 79?",
                Arrays.asList("Silver", "Platinum", "Gold", "Copper"),
                "Gold",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which is the only mammal capable of true flight?",
                Arrays.asList("Flying squirrel", "Bat", "Sugar glider", "Colugo"),
                "Bat",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which planet has the longest day (in Earth time)?",
                Arrays.asList("Venus", "Mars", "Jupiter", "Mercury"),
                "Venus",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the capital city of Kazakhstan?",
                Arrays.asList("Almaty", "Tashkent", "Astana", "Bishkek"),
                "Astana",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which war was fought between the North and South regions of the United States?",
                Arrays.asList("World War I", "The Civil War", "The Cold War", "The Revolutionary War"),
                "The Civil War",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "In computing, what does 'CPU' stand for?",
                Arrays.asList("Central Processing Unit", "Computer Power Unit", "Control Process Utility", "Central Print Unit"),
                "Central Processing Unit",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which desert is the largest in the world (non-polar)?",
                Arrays.asList("Gobi", "Kalahari", "Sahara", "Thar"),
                "Sahara",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the first female Prime Minister of the United Kingdom?",
                Arrays.asList("Theresa May", "Indira Gandhi", "Angela Merkel", "Margaret Thatcher"),
                "Margaret Thatcher",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which ancient civilization built Machu Picchu?",
                Arrays.asList("Maya", "Aztec", "Inca", "Olmec"),
                "Inca",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which is the longest bone in the human body?",
                Arrays.asList("Femur", "Humerus", "Tibia", "Spine"),
                "Femur",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which language is the most spoken in Africa?",
                Arrays.asList("Swahili", "Arabic", "French", "English"),
                "Swahili",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the Greek god of the sea?",
                Arrays.asList("Zeus", "Hades", "Poseidon", "Apollo"),
                "Poseidon",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the name of the galaxy that contains our Solar System?",
                Arrays.asList("Andromeda", "Whirlpool", "Milky Way", "Sombrero"),
                "Milky Way",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which instrument measures atmospheric pressure?",
                Arrays.asList("Thermometer", "Barometer", "Anemometer", "Hygrometer"),
                "Barometer",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which famous scientist was born on Pi Day (March 14)?",
                Arrays.asList("Galileo Galilei", "Marie Curie", "Isaac Newton", "Albert Einstein"),
                "Albert Einstein",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the capital of New Zealand?",
                Arrays.asList("Wellington", "Auckland", "Christchurch", "Hamilton"),
                "Wellington",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which continent is the least populated?",
                Arrays.asList("Europe", "Australia", "South America", "Antarctica"),
                "Antarctica",
                "General",
                "Hard"
        ));
        allQuestions.add(new Question(
                "Which planet has the longest day (in Earth time)?",
                Arrays.asList("Venus", "Mars", "Jupiter", "Mercury"),
                "Venus",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the capital city of Kazakhstan?",
                Arrays.asList("Almaty", "Tashkent", "Astana", "Bishkek"),
                "Astana",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which war was fought between the North and South regions of the United States?",
                Arrays.asList("World War I", "The Civil War", "The Cold War", "The Revolutionary War"),
                "The Civil War",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "In computing, what does 'CPU' stand for?",
                Arrays.asList("Central Processing Unit", "Computer Power Unit", "Control Process Utility", "Central Print Unit"),
                "Central Processing Unit",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which desert is the largest in the world (non-polar)?",
                Arrays.asList("Gobi", "Kalahari", "Sahara", "Thar"),
                "Sahara",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the first female Prime Minister of the United Kingdom?",
                Arrays.asList("Theresa May", "Indira Gandhi", "Angela Merkel", "Margaret Thatcher"),
                "Margaret Thatcher",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which ancient civilization built Machu Picchu?",
                Arrays.asList("Maya", "Aztec", "Inca", "Olmec"),
                "Inca",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which is the longest bone in the human body?",
                Arrays.asList("Femur", "Humerus", "Tibia", "Spine"),
                "Femur",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which language is the most spoken in Africa?",
                Arrays.asList("Swahili", "Arabic", "French", "English"),
                "Swahili",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Who was the Greek god of the sea?",
                Arrays.asList("Zeus", "Hades", "Poseidon", "Apollo"),
                "Poseidon",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the name of the galaxy that contains our Solar System?",
                Arrays.asList("Andromeda", "Whirlpool", "Milky Way", "Sombrero"),
                "Milky Way",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which instrument measures atmospheric pressure?",
                Arrays.asList("Thermometer", "Barometer", "Anemometer", "Hygrometer"),
                "Barometer",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which famous scientist was born on Pi Day (March 14)?",
                Arrays.asList("Galileo Galilei", "Marie Curie", "Isaac Newton", "Albert Einstein"),
                "Albert Einstein",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "What is the capital of New Zealand?",
                Arrays.asList("Wellington", "Auckland", "Christchurch", "Hamilton"),
                "Wellington",
                "General",
                "Hard"
        ));

        allQuestions.add(new Question(
                "Which continent is the least populated?",
                Arrays.asList("Europe", "Australia", "South America", "Antarctica"),
                "Antarctica",
                "General",
                "Hard"
        ));








    }
    // Add a method to initialize image questions
    private void initializeImageQuestions() {
        allImageQuestions = new ArrayList<>();


        /* ====================== */
        /*  Geography Questions   */
        /* ====================== */

        // Geography Flag Questions - Easy
        allImageQuestions.add(new QuestionImage(
                "Which country's flag is this?",
                Arrays.asList( "Italy", "Germany","France", "Spain"),
                "France",
                "Geography",
                "Easy",
                "/images/flags/france.png"
        ));

        allImageQuestions.add(new QuestionImage(
                "Which country's flag is this?",
                Arrays.asList("USA", "UK", "Australia", "New Zealand"),
                "USA",
                "Geography",
                "Easy",
                "/images/flags/usa.png"
        ));

        // Geography Flag Questions - Medium
        allImageQuestions.add(new QuestionImage(
                "Which country's flag is this?",
                Arrays.asList( "Argentina", "Colombia", "Chile","Brazil"),
                "Brazil",
                "Geography",
                "Medium",
                "/images/flags/brazil.png"
        ));

        allImageQuestions.add(new QuestionImage(
                "Which country's flag is this?",
                Arrays.asList("Sweden", "Norway", "Finland", "Denmark"),
                "Sweden",
                "Geography",
                "Medium",
                "/images/flags/sweden.png"
        ));

        // Geography Flag Questions - Hard
        allImageQuestions.add(new QuestionImage(
                "Which country's flag is this?",
                Arrays.asList( "Nepal", "Bhutan","Tibet", "Mongolia"),
                "Bhutan",
                "Geography",
                "Hard",
                "/images/flags/bhutan.png"
        ));

        /* ====================== */
        /*    Logo Questions      */
        /* ====================== */

        // Logo Questions - Easy
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList( "Microsoft", "Google","Apple", "Amazon"),
                "Apple",
                "Logo",
                "Easy",
                "/images/logos/apple.png"
        ));


        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList("Nike", "Adidas", "Puma", "Reebok"),
                "Nike",
                "Logo",
                "Easy",
                "/images/logos/nike.png"
        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",

                // Tesla Logo
                Arrays.asList( "BMW","Tesla", "Mercedes", "Audi"),
                "Tesla",
                "Logo",
                "Easy",
                "/images/logos/tesla.png"
        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList( "Burger King", "Wendy's", "KFC","McDonald's"),
                "McDonald's",
                "Logo",
                "Easy",
                "/images/logos/McDonald.png" // McDonald's Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList("Coca-Cola", "Pepsi", "Sprite", "Fanta"),
                "Coca-Cola",
                "Logo",
                "Easy",
                "/images/logos/cocacola.png"  // Coca-Cola Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                // Facebook Logo
                Arrays.asList( "Instagram","Facebook", "Twitter", "Snapchat"),
                "Facebook",
                "Logo",
                "Easy",
                "/images/logos/facebook.png"
        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList("Costa Coffee", "Dunkin'","Starbucks",  "Peet's Coffee"),
                "Starbucks",
                "Logo",
                "Easy",
                "/images/logos/starbucks.png"  // Starbucks Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList( "LG","Samsung", "Sony", "Panasonic"),
                "Samsung",
                "Logo",
                "Easy",
                "/images/logos/samsung.png"  // Samsung Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList( "Apple Music", "Pandora", "Spotify","Tidal"),
                "Spotify",
                "Logo",
                "Easy",
                "/images/logos/spotify.png"  // Spotify Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList( "Yahoo", "Bing","Google", "DuckDuckGo"),
                "Google",
                "Logo",
                "Easy",
                "/images/logos/google.png"  // Google Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?", Arrays.asList("Twitter", "Facebook", "Instagram", "Snapchat"),
                "Twitter",
                "Logo",
                "Easy",
                "/images/logos/twitter.png"  // Twitter Logo

        ));
        allImageQuestions.add(new QuestionImage(
                "Which company's logo is this?",
                Arrays.asList("Twitter", "Facebook", "Microsoft", "Snapchat"),
                "Microsoft",
                "Logo",
                "Easy",
                "/images/logos/microsoft.png"  // Microsoft Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Adidas", "Nike", "Puma", "Reebok"),
                "Adidas",
                "Logo",
                "Easy",
                "/images/logos/adidas.png"  // Adidas Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Coca-Cola", "Pepsi","Sprite", "7-Up"),
                "Pepsi",
                "Logo",
                "Easy",
                "/images/logos/pepsi.png" // Pepsi Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "McDonald's", "KFC","Wendy's", "Burger King"),
                "KFC",
                "Logo",
                "Easy",
                "/images/logos/kfc.png"  // KFC Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Audi", "Mercedes","BMW",  "Volkswagen"),
                "BMW",
                "Logo",
                "Easy",
                "/images/logos/bmw.png" // BMW Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Gucci", "Louis Vuitton","Chanel", "Prada"),
                "Chanel",
                "Logo",
                "Easy",
                "/images/logos/chanel.png"  // Chanel Logo


        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Toyota", "Nissan", "Mazda","Honda"),
                "Honda",
                "Logo",
                "Easy",
                "/images/logos/honda.png"  // Honda Logo

        ));


        // Logo Questions - Medium
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Nike", "Adidas","Puma", "Reebok"),
                "Adidas",
                "Logo",
                "Medium",
                "/images/logos/adidas.png"  // Adidas Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Google","Microsoft", "Apple", "IBM"),
                "Microsoft",
                "Logo",
                "Medium",
                "/images/logos/microsoft.png"  // Microsoft Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Twitter", "Facebook", "Instagram", "Snapchat"),
                "Twitter",
                "Logo",
                "Medium",
                "/images/logos/twitter.png"  // Twitter Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "eBay", "Alibaba","Amazon", "Walmart"),
                "Amazon",
                "Logo",
                "Medium",
                "/images/logos/amazon.png"  // Amazon Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Coca-Cola", "Sprite", "7-Up","Pepsi"),
                "Pepsi",
                "Logo",
                "Medium",
                "/images/logos/pepsi.png"  // Pepsi Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Gucci", "Louis Vuitton","Chanel", "Prada"),
                "Chanel",
                "Logo",
                "Medium",
                "/images/logos/chanel.png"  // Chanel Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Audi","BMW",  "Mercedes", "Lexus"),
                "BMW",
                "Logo",
                "Medium",
                "/images/logos/bmw.png"  // BMW Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Peugeot", "Renault", "Fiat", "Volkswagen"),
                "Peugeot",
                "Logo",
                "Medium",
                "/images/logos/peugeot.png"  // Peugeot Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("BMW", "Mercedes-Benz", "Audi", "Volkswagen"),
                "BMW",
                "Logo",
                "Medium",
                "/images/logos/bmw.png"  // BMW Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Toyota", "Nissan","Honda", "Mazda"),
                "Honda",
                "Logo",
                "Medium",
                "/images/logos/honda.png"  // Honda Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Tesla", "Ford", "Chevrolet", "Nissan"),
                "Tesla",
                "Logo",
                "Medium",
                "/images/logos/tesla.png"  // Tesla Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Audi", "Mercedes-Benz","BMW",  "Lexus"),
                "BMW",
                "Logo",
                "Medium",
                "/images/logos/bmw.png" // BMW Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Adidas","Nike", "Puma", "Reebok"),
                "Nike",
                "Logo",
                "Medium",
                "/images/logos/nike.png"  // Nike Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Burger King", "Wendy's", "KFC","McDonald's"),
                "McDonald's",
                "Logo",
                "Medium",
                "/images/logos/McDonald.png"  // McDonald's Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "LG","Samsung", "Sony", "Panasonic"),
                "Samsung",
                "Logo",
                "Medium",
                "/images/logos/samsung.png"  // Samsung Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Samsung", "Nokia","Huawei", "LG"),
                "Huawei",
                "Logo",
                "Medium",
                "/images/logos/huawei.png"  // Huawei Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Microsoft", "Google", "Amazon","Apple"),
                "Apple",
                "Logo",
                "Medium",
                "/images/logos/apple.png"  // Apple Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Chanel", "Gucci", "Louis Vuitton", "Prada"),
                "Chanel",
                "Logo",
                "Medium",
                "/images/logos/chanel.png"  // Chanel Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Pepsi", "Coca-Cola", "Sprite", "Fanta"),
                "Pepsi",
                "Logo",
                "Medium",
                "/images/logos/pepsi.png"  // Pepsi Logo

        ));


        // Logo Questions - Hard
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Ray-Ban", "Luxottica","Oakley", "Fendi"),
                "Luxottica",
                "Logo",
                "Hard",
                "/images/logos/luxottica.jpg"  // Luxottica Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Omega", "Patek Philippe", "Rolex","Tag Heuer"),
                "Rolex",
                "Logo",
                "Hard",
                "/images/logos/rolex.png"  // Rolex Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Audi", "Lexus", "BMW","Toyota"),
                "BMW",
                "Logo",
                "Hard",
                "/images/logos/bmw.png"  // BMW Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Gucci", "Chanel", "Louis Vuitton", "Prada"),
                "Gucci",
                "Logo",
                "Hard",
                "/images/logos/gucci.png"  // Gucci Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Tiffany", "Chopard", "Cartier","Bvlgari"),
                "Cartier",
                "Logo",
                "Hard",
                "/images/logos/cartier.png" // Cartier Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Nike", "Adidas", "Puma", "Reebok"),
                "Nike",
                "Logo",
                "Hard",
                "/images/logos/nike.png"  // Nike Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Land Rover", "Lexus","Jaguar", "Mercedes"),
                "Jaguar",
                "Logo",
                "Hard",
                "/images/logos/jaguar.png"  // Jaguar Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Armani", "Hugo Boss","Versace", "Prada"),
                "Hugo Boss",
                "Logo",
                "Hard",
                "/images/logos/hugo_boss.png"  // Hugo Boss Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("McDonald's", "Wendy's", "Burger King","KFC"),
                "KFC",
                "Logo",
                "Hard",
                "/images/logos/kfc.png"  // KFC Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Hermes", "Louis Vuitton", "Chanel", "Gucci"),
                "Hermes",
                "Logo",
                "Hard",
                "/images/logos/hermes.png"  // Hermes Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Nike","Vans", "Puma", "Adidas"),
                "Vans",
                "Logo",
                "Hard",
                "/images/logos/vans.png"  // Vans Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Wrangler", "Levi","Levi's", "Wranglers"),
                "Levi's",
                "Logo",
                "Hard",
                "/images/logos/levis.png"  // Levi's Logo

        ));
        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList( "Gucci", "Prada","Burberry", "Chanel"),
                "Burberry",
                "Logo",
                "Hard",
                "/images/logos/burberry.png"  // Burberry Logo

        ));

        allImageQuestions.add(new QuestionImage("Which company's logo is this?",
                Arrays.asList("Tesla", "Lamborghini","Ferrari",  "Audi"),
                "Lamborghini",
                "Logo",
                "Hard",
                "/images/logos/images/lamborgini.png"  // Burberry Logo

        ));

    }


    // Method to get text-based questions
    public List<Question> getQuestions(String category, String difficulty) {
        List<Question> filteredQuestions = allQuestions.stream()
                .filter(q -> q.getCategory().equals(category) && q.getDifficulty().equals(difficulty))
                .collect(Collectors.toList());

        // Shuffle questions for randomness
        Collections.shuffle(filteredQuestions);

        // Return up to 5 questions or all available if less than 5
        return filteredQuestions.stream()
                .limit(Math.min(5, filteredQuestions.size()))
                .collect(Collectors.toList());
    }


    // Add a method to get image-based questions
    public List<QuestionImage> getImageQuestions(String category, String difficulty) {
        List<QuestionImage> filteredQuestions = allImageQuestions.stream()
                .filter(q -> q.getCategory().equals(category) && q.getDifficulty().equals(difficulty))
                .collect(Collectors.toList());

        // Shuffle questions for randomness
        Collections.shuffle(filteredQuestions);

        // Return up to 5 questions or all available if less than 5
        return filteredQuestions.stream()
                .limit(Math.min(5, filteredQuestions.size()))
                .collect(Collectors.toList());
    }
}


