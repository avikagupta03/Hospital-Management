import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class hospitalmanagement
{
    public static void main(String[] args)
    {
        boolean bool =false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to hospital");
        System.out.println("Enter 1 to book an appointment");
        System.out.println("Enter 2 to view appointments");
        System.out.println("Enter 3 to Exit the System");
        while (!bool)
        {
            Integer code = sc.nextInt();
            sc.nextLine();
            switch (code)
            {
                case 1:
                    System.out.println("To continue booking kindly eneter the following details");
                    System.out.print("Your name\n");
                    String Name =sc.nextLine();
                    System.out.print("What is the issue\n");
                    String MedicalIssue=sc.nextLine();
                    System.out.print("Which doctor you wanna book Appointement of\n");
                    String Doctor=sc.nextLine();
                    String fileName = Name.replaceAll("\\s", "")+".txt";
                    String data = "data.txt";
                    try{
                        PrintWriter writer = new PrintWriter(new FileWriter(fileName,true));
                        PrintWriter writer2 = new PrintWriter(new FileWriter(data,true));
                        writer.println("Name: " + Name);
                        writer.println("Medical Issue: " + MedicalIssue);
                        writer.println("Doctor: " + Doctor);
                        writer2.println("Doctor: " + Doctor + ", Name: " + Name);
                        writer.close();
                        writer2.close();
                        System.out.println("Your Information have been registered with us.Thank you");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Not able to store the information");
                    }
                    break;
                case 2:
                    boolean foundMatch = false;
                    String DoctorName = sc.nextLine();

                    System.out.println("Patient currently enrolled with doctor " + DoctorName);
                    String file = "data.txt";
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String search;
                        while ((search = br.readLine()) != null) {
                            if (search.contains("Doctor: " + DoctorName)) {
                                String[] parts = search.split(", Name ");
                                for (int i = 1; i < parts.length; i++) {
                                    String patientName = parts[i].split(",")[0].trim();
                                    System.out.println("Patient Name: " + patientName);
                                    foundMatch = true; 
                                }
                            }
                        }
                        if (!foundMatch) { 
                            System.out.println("No Appointments Found for Doctor: " + DoctorName);
                        }
                        br.close();
                } catch (Exception e) {
                    System.out.println("File not found");
                }                    
                case 3:
                    System.out.println("Exiting Hospital Appointment System");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            bool = true;
        }
    }
}
