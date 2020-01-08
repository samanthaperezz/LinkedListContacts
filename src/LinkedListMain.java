/**
 * @Author Samantha Perez
 * November 6, 2019
 * Description: This program reads in a list of contact information from a text file and stores it in a linked
 * list of contacts. The user is allowed to add, remove, modify or search for contacts.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class LinkedListMain {

    public static void main(String[] args) {


        LinkedList contactList = new LinkedList();
        /** reading contacts from file */
        try {
            Scanner read = new Scanner( new File("contacts.txt") );

            while (read.hasNext()) {
                String line = read.nextLine();
                String[] contactInfo = line.split(",");
                Contact contact = new Contact(contactInfo[0], contactInfo[1], contactInfo[2],
                        contactInfo[3], contactInfo[4], contactInfo[5]);
                contactList.add(contact);
            }
            read.close();

        } catch (FileNotFoundException fnf) {

            System.out.println("File was not found");
        }

        int choice = 0;

        while (choice != 6) {
            displayMenu();

            choice = getChoice();
            if ( choice == 1 ) {

                choiceOne( contactList );

            } else if (choice == 2) {

                choiceTwo( contactList );

            } else if ( choice == 3 ) {

                choiceThree( contactList );

            } else if ( choice == 4 ) {

                choiceFour( contactList );

            }else if( choice == 5 ){

                System.out.println( contactList );

            } else {
                    System.out.println("Bye!");
                    /** writting contacts back into file */
                    try{
                        FileWriter writer = new FileWriter("contacts.txt");
                        PrintWriter printWriter = new PrintWriter( writer );
                        printWriter.print(contactList.toFile());
                        printWriter.close();

                    }catch( IOException e ){
                        System.out.println("IO error");

                    }
                    break;

            }
        }
    }

    /**
     * This method displays the menu.
     */
    public static void displayMenu() {
        System.out.println("Menu Option");
        System.out.println("1. Add new contact\n2. Remove contact\n" +
                    "3. Search\n4. Update contact\n5. Display\n6. Quit");
    }

    /**
     * This method gets the users choice.
     * @return the users choice.
     */
    public static int getChoice() {
        System.out.println("Please enter choice: ");
        int choice = CheckInput.getIntRange(1, 7);

        return choice;
    }

    /**
     * This method gets the user input for firat name.
     * @return last name.
     */
    public static String lastNameInput() {
         System.out.println("Last name:");
         String last = CheckInput.getString();
         return last;
    }

    /**
     * This method gets the user input for firat name.
     * @return first name.
     */
    public static String firstNameInput() {
         System.out.println("First name:");
         String first = CheckInput.getString();;
         return first;

    }

    /**
     * This method performs everything for when adding a new contact to the link list.
     * @param contact Linked list contact.
     */
    public static void choiceOne( LinkedList contact ){
        String last = lastNameInput();
        String first = firstNameInput();
        System.out.println("Phone number:");
        String number = CheckInput.getString();
        System.out.println("Adress:");
        String address = CheckInput.getString();;
        System.out.println("City:");
        String city = CheckInput.getString();
        System.out.println("Zip code:");
        String zip = CheckInput.getString();
        Contact newContact = new Contact(last, first, number, address, city, zip);
        contact.add( newContact );

    }

    /**
     * This method performs everything for removing a contact.
     * @param contact Linked list contact.
     */
    public static void choiceTwo( LinkedList contact ){
        System.out.println("1. Remove by name\n2. Remove by index");
        int sub = CheckInput.getIntRange(1, 2);

        if ( sub == 1 ) {

            String last = lastNameInput();
            String first = firstNameInput();
            Boolean remove = contact.remove(first, last);

            if( remove == true ){

                System.out.println("Contact has been successfully been removed");
            } else{

                System.out.println("That contact does not exist!");
            }

        } else {

            System.out.println("What index would you like to remove?");
            System.out.println(contact);

            int index = CheckInput.getIntRange(0, contact.size());
            Contact removed = contact.remove(index-1);
            System.out.println(removed + " has been succefully been removed");


        }
    }

    /**
     * This method performs everything for updating a contact.
     * @param contact Linked list contact.
     */
    public static void choiceThree( LinkedList contact ){
        System.out.println("1. Search by last name\n2. search by zip code");
        int sub = CheckInput.getIntRange(1, 2);

        ArrayList<Contact> list = new ArrayList<Contact>();

        if( sub == 1 ) {

            String last = lastNameInput();
            list = contact.searchName(last);
            if ( list.isEmpty() ){

                System.out.println("Contact of last name " + last + " does not exist.");
            } else{

                for( int i = 0; i < list.size(); i++ ) {

                    System.out.println(list.get(i));
                }
            }
        } else {

            System.out.println("Zip code");
            String zip = CheckInput.getString();
            list = contact.searchZip( zip );

            if ( list.isEmpty() ){

                System.out.println("Contact of zip code " + zip + " does not exist.");
            } else{

                for( int i = 0; i < list.size(); i++ ) {
                    System.out.println(list.get(i));
                }
            }
        }
    }

    /**
     * This method performs everything when Updating a contact.
     * @param contact Linked list contact.
     */
    public static void choiceFour( LinkedList contact ){

        String last = lastNameInput();
        String first = firstNameInput();
        Contact existence = contact.searchName(last, first);

        if( existence != null ){

            System.out.println("What would you like to update?");
            System.out.println("1.Last name");
            System.out.println("2.First name");
            System.out.println("3.Phone num");
            System.out.println("4.Address");
            System.out.println("5.City");
            System.out.println("6.Zip");

            int change = CheckInput.getIntRange(1,6);

            if( change == 1 ){
                System.out.println("Updated last name:");
                String newLast = CheckInput.getString();
                existence.setLastName( newLast );
            } else if( change == 2 ){
                System.out.println("Updated first name:");
                String newFirst = CheckInput.getString();
                existence.setFirstName( newFirst );

            } else if( change == 3 ){
                System.out.println("Updated phone num:");
                String newNum = CheckInput.getString();
                existence.setPhoneNum( newNum );

            }else if( change == 4 ){
                System.out.println("Updated Address:");
                String newAddress = CheckInput.getString();
                existence.setAdress( newAddress );
            }else if( change == 5 ){
                System.out.println("Updated City:");
                String newCity = CheckInput.getString();
                existence.setCity( newCity );
            }else{
                System.out.println("Updated Zip:");
                String newZip = CheckInput.getString();
                existence.setZipCode( newZip );
            }

        } else {
            System.out.println("That contact does not exist.");
        }
    }
}
