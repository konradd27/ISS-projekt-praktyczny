import java.util.Scanner;

public class Menu {
    boolean x;

    static void showUserMenu(){
        System.out.println("What d u wana do?");
        System.out.println("""
        1 - obliczania prędkości ISS        
        2 - zwracanie listy nadchodzących przebiegów ISS dla określonej lokalizacji
        3 - zwracanie liczby osób przebywających w kosmosie w ramach ISS
        4 - GUI - pozycja ISS na mapie swiata
        5 - dodatkowa statystika
        6 - zakoncz program""");
        while(true){
            Scanner scanner = new Scanner(System.in);
            try{Integer userInput = Integer.parseInt(scanner.next());
                userSelectionProcess(userInput);
                break;
            }catch (Exception e){
                System.out.println("Please choose a valid option, don`t write letters");
            }
        }
    }
static void userSelectionProcess(int userInput){


    switch (userInput){
        case 1:
            System.out.println(userInput);
            break;
        case 2:
            ISSPass.issPass();
            break;
        case 3:
            System.out.println(userInput);
            break;
        case 4:
            System.out.println(userInput);
            break;
        case 5:
            System.out.println(userInput);
            break;
        case 6:
            System.out.println("program terminated");
            break;
        default:
            System.out.println("!!!Please choose a valid option 1-6!!!");
            showUserMenu();
    }
}
}
