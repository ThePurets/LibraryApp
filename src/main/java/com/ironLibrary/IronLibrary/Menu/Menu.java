package com.ironLibrary.IronLibrary.Menu;
import com.ironLibrary.IronLibrary.Library.Library;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Library library = new Library();

    public static void menuStart() throws IOException {
        System.out.println("Welcome to the Iron Library App");
        menuSelectOption();
    }
    public static void menuSelectOption() throws IOException {
            System.out.println("Press 1 to go to the COMMANDS console, or press 2 to CLOSE THE APP");
            menuGetUserSelection();
    }
    public static void menuGetUserSelection() throws IOException {
        try{

            Scanner input = new Scanner(System.in);
            int opc2 = input.nextInt();

            if (opc2 <= 0 || opc2 >3){
                System.out.println("Please choose a number 1 or 2");
                menuSelectOption();
            }else{

                try {
                    if (opc2 == 1){
                        userSelectCommands();
                    }else if (opc2 == 2){
                        shutdownApp();
                    }

                }catch (InputMismatchException e){
                    System.out.println("Please enter a valid number!");
                    menuSelectOption();
                }
            }

        }catch (InputMismatchException exception){
            System.out.println("Please enter a valid number!");
            menuSelectOption();
        }
    }
    /*
    public static void userSelectItems() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to add TEACHERS, 2 to add COURSES or 3 to add STUDENTS, press 4 to EXIT");

        try{

            int opc = input.nextInt();

            if (opc <= 0 || opc > 5){
                System.out.println("Please choose a number between 1 to 4");
                userSelectItems();

            }else{
                try{

                    switch (opc) {
                        case 1 -> addTeacher();
                        case 2 -> addCourses();
                        case 3 -> addStudent();
                        case 4 -> menuSelectOption();
                    }

                }catch(InputMismatchException e){
                    System.out.println("Please enter a valid number!");
                    userSelectItems();
                }
            }
        }catch (InputMismatchException exception){
            System.out.println("Please enter a valid number!");
            menuSelectOption();
        }
    }

     */
    public static void userSelectCommands() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome to command console! ");
        System.out.println("Each command allows you to perform a task, select a command and follow the instructions... ");
        System.out.println("\n\n\n\n");

        int opcCommand = 0;
        do {
            System.out.println("Select a command: ");
            System.out.println("1. Add a book");
            System.out.println("2. Search book by title");
            System.out.println("3. Search book by category");
            System.out.println("4. Search book by Author");
            System.out.println("5. List all books along with author");
            System.out.println("6. Issue book to student");
            System.out.println("7. List books by usn");
            System.out.println("0. BACK");

            opcCommand = input.nextInt();

            if (opcCommand == 0) {

                System.out.println("Are you sure? Y / N");
                Scanner inputScanner2 = new Scanner(System.in);
                String opc0 = inputScanner2.next();

                if (opc0.equals("y") || opc0.equals("Y")) {
                    menuSelectOption();
                }else{
                    userSelectCommands();
                }

            }else if (opcCommand < 0 || opcCommand >=10){

                System.out.println("Please enter a valid number");

            }else{

                try{

                    switch (opcCommand){

                        case 1 -> library.addBookData();
                        case 2 -> library.searchBookByTitle();
                        case 3 -> library.searchBookByCategory();
                        case 4 -> library.seacrhBookByAuthor();
                        case 5 -> library.listAllbooksAlongWithAutor();
                        case 6 -> library.issueBookToStudent();
                        case 7 -> library.listBooksByUsn();
                        default -> throw new IllegalStateException("Please enter a valid number " + opcCommand);
                    }

                }catch(IllegalArgumentException e){System.out.println("Please enter a valid number");}
            }
        }while (opcCommand != 0);

    }

    public static void shutdownApp(){
        System.out.println("See you soon");
    }

}
