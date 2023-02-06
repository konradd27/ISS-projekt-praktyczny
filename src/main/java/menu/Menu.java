package menu;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

import issnumberofppl.ISSNumberOfPeople;
import issnumberofppl.ISSNumberOfPeople_Hibernate;
import issnumberofppl.ISSNumberOfPeople_read;
import issnumberofppl.ISSPeople;
import issspeed.ISSSpeed;
import isspass.ISSPass;
import issspeed.ISSSpeedHibernate;
import issspeed.ISSSpeedHibernateSessionFactory;
import issspeed.ISSSpeed_read;
import org.hibernate.SessionFactory;

public class Menu {
    private SessionFactory sessionFactory;

    private boolean isRunning = true;
    private static final String OPTIONS = """
            What d u wana do?
            1 - obliczania prędkości ISS        
            2 - zwracanie listy nadchodzących przebiegów ISS dla określonej lokalizacji
            3 - zwracanie liczby osób przebywających w kosmosie w ramach ISS
            4 - GUI - pozycja ISS na mapie swiata
            5 - dodatkowa statystika
            6 - zakoncz program""";
    private static final String MENUERRORMESSAGE = "Please enter a number 1-6";
    private static final String MENUERRORMESSAGE2 = "Please enter a number 1-3";


    public void startMenu() {
        do {
            menuAction();
        } while (isRunning);
    }

    public void showMenuOptions() {
        System.out.println(OPTIONS);
    }

    private void menuAction() {
        showMenuOptions();
        try {
            int input = readInt();
            handleOption(input);
        } catch (Exception e) {
            System.out.println(MENUERRORMESSAGE);
        }

    }

    private void handleOption(int input) {

        executeOption(input);

    }

    private void executeOption(int input) {


        switch (input) {
            case 1:
                try {
                    ISSSpeed issSpeed = new ISSSpeed();
                    List<Object> stats = issSpeed.getSpeed();
                    Double speed = (double) stats.get(0);
                    Integer timeStamp = (Integer) stats.get(1);

                    ISSSpeedHibernate issSpeedHibernate = new ISSSpeedHibernate(speed, timeStamp);
                    ISSSpeedHibernateSessionFactory issSpeedHibernateSessionFactory = new ISSSpeedHibernateSessionFactory();
                    issSpeedHibernateSessionFactory.issSpeedSave(issSpeedHibernate, sessionFactory);
                    System.out.println("ISS current speed is " + stats.get(0) + " M/S");
                    System.out.println("Timestamp is " + stats.get(1) + " seconds");
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 2:
                ISSPass.issPass();
                break;
            case 3:
                try {
                    ISSNumberOfPeople issNumberOfPeople = new ISSNumberOfPeople();
                    int nrOfPpl = issNumberOfPeople.getNumberOfPeople();
                    System.out.println("Current nr of ppl @ ISS is " + nrOfPpl);
                    System.out.println("Full list of ppl @ ISS is:");

                    for(ISSPeople people : issNumberOfPeople.getListOfPeople()){
                        System.out.println(people.getName());
                    }

                    ISSNumberOfPeople_Hibernate issNumberOfPeople_hibernate = new ISSNumberOfPeople_Hibernate();
                    issNumberOfPeople_hibernate.saveISSPeople(issNumberOfPeople.getListOfPeople(), sessionFactory);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 4:
                System.out.println(input);
                break;
            case 5:
                System.out.println("""
                        Please select option:
                        1- Save Number of people SQL data to your computer
                        2- Save ISS speed SQL data to your computer
                        3- Save both Datas to your computer
                        
                        """);
                int x = readInt();
                switch (x){
                    case 1:
                    saveNumberOfPeople();
                    break;
                    case 2: saveISSSPeed();
                    break;
                    case 3:
                        saveNumberOfPeople();
                        saveISSSPeed();
                        break;
                    default:
                        System.out.println(MENUERRORMESSAGE2);
                        break;
                }








                break;
            case 6:
                System.out.println("Program Terminated");
                isRunning = false;
                break;
            default:
                System.out.println(MENUERRORMESSAGE);

        }

    }


    private void end() throws Exception {
        showMessage("Program Terminated");
        isRunning = false;


    }

    void showMessage(String message) {
    }

    ;

    int readInt() {

        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.next());
        return input;


    }

    void saveNumberOfPeople() {
        ISSNumberOfPeople_read issNumberOfPeople_read = new ISSNumberOfPeople_read();
        List<ISSPeople> issPeople = issNumberOfPeople_read.getISSPeopleFromSQL();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please specify file path for list of people data:");

        String filePath = scanner.next();

        Path path = Paths.get(filePath);
        try{
            Files.createFile(path);
            Files.write(path, issPeople.toString().getBytes(), StandardOpenOption.WRITE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void saveISSSPeed(){
        ISSSpeed_read issSpeed_read = new ISSSpeed_read();
        List<ISSSpeedHibernate> issSpeedHibernates = issSpeed_read.getISSSpeedFromSQL();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please specify file path for iss speed data:");

        String filePath = scanner.next();

        Path path = Paths.get(filePath);
        try{
            Files.createFile(path);
            Files.write(path, issSpeedHibernates.toString().getBytes(), StandardOpenOption.WRITE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}




