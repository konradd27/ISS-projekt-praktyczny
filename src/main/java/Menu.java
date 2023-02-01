import java.util.Scanner;

public class Menu {
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
                try{
                    ISSSpeed issSpeed = new ISSSpeed();
                    double speed = issSpeed.getSpeed();
                    System.out.println("ISS current speed is " + speed + " M/S");
                    break;
                } catch (Exception e){e.printStackTrace();}

            case 2:
                ISSPass.issPass();
                break;
            case 3:
                System.out.println(input);
                break;
            case 4:
                System.out.println(input);
                break;
            case 5:
                System.out.println(input);
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

}




