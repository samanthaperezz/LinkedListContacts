
import java.util.ArrayList;

/** This class represents a a linked list */
public class LinkedList {
    /** represents the fist node */
    private Node first;
    /** represents the last node */
    private Node last;

    /**
     * class represents a node
     */
    public static class Node {
        /** represents the data inside contact */
        private Contact data;
        /** represents the next node */
        private Node    next;

        /**
         * Contructor - initializes data and next.
         * @param c the Contact.
         */
        public Node( Contact c ) {
            data = c;
            next = null;
        }

        /**
         * Contructor - initializes data and next.
         * @param c the contact.
         * @param n reference to next node.
         */
        public Node( Contact c, Node n ) {
            data = c;
            next = n;
        }

    }

    /**
     * Constructor - initialize first and last node.
     */
    public LinkedList() {
        first = null;
        last  = null;
    }

    /**
     * Method determines if linked list is empty.
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Method adds a new contact to the end of the list.
     * @param c the Contact.
     */
    public void add( Contact c ) {
        if ( first == null ) {

            first = new Node( c );
            last = first;

        } else {

            Node n = new Node( c );
            last.next = n;
            last = n;

        }
    }

    /**
     * This method sets a contact at a certain index and removes the
     * current one in that index.
     * @param i index.
     * @param c Contact.
     */
    public void set( int i, Contact c ) {
        if ( first == null || i < 0 ) {

            throw new IndexOutOfBoundsException();
        }

        Node n = first;
        for ( int j = 0; j < i; j++ ) {
            n = n.next;

            if( n == null ) {

                throw new IndexOutOfBoundsException();
            }
        }
        n.data = c;
    }

    /**
     * This method adds a contact to a certain index of the linked list.
     * @param i index.
     * @param c Contact.
     */
    public void add( int i, Contact c ) {
        if ( i < 0 ) {

            throw new IndexOutOfBoundsException();
        }
        if ( i == 0 ) {

            first = new Node( c, first );
            if ( last == null ) {

                last = first;
            }
        } 
        else {
            Node n = first;
            if ( n == null ) {

                throw new IndexOutOfBoundsException();
            }
            for( int j = 1; j < i; j++ ) {
                n = n.next;

                if( n == null ) {

                    throw new IndexOutOfBoundsException();
                }
            }
            n.next = new Node( c, n.next );
            if ( n.next.next == null ) {

                last = n.next;
            }
        }
    }

    /**
     * Gets a contact at a certain index.
     * @param i the index you want to get.
     * @return The contact at that index.
     */
    public Contact get( int i ) {
        if ( first == null || i < 0 ) {

            throw new IndexOutOfBoundsException();
        }
        Node n = first;

        for ( int j = 0; j < i; j++ ) {
            n = n.next;
            if ( n == null ) {

                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * This method get the size of the list.
     * @return linked list size.
     */
    public int size() {
        int count = 0;
        Node n = first;

        while ( n != null ) {

            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * This method removes a contact at a certain index.
     * @param i index.
     * @return the removed contact.
     */
    public Contact remove( int i ) {
        Contact rem;

        if ( first == null || i < 0 ) {

            throw new IndexOutOfBoundsException();
        }
        if ( i == 0 ) {

            rem = first.data;
            first = first.next;

            if ( first == null ) {

                last = null;
            }
        } 
        else {

            Node n = first;

            for ( int j = 1; j < i; j++ ) {

                n = n.next;

                if ( n == null ) {
                    throw new IndexOutOfBoundsException();
                }
            }
            if ( n.next == null ) {

                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if ( n.next == null ) {

                last = n;
            }
        }
        return rem;
    }

    /**
     * This method removes a contact by its first and last name.
     * @param lastName last name to be removed.
     * @param firstName first name to be removed.
     * @return true or false if the contact was removed.
     */
    public boolean remove( String lastName, String firstName ) {
        Contact c = new Contact(lastName,firstName);

        if( first != null ) {

            if( c.equals(first.data)) {

                first = first.next;

                if( first == null ) {

                    last = null;
                }
                return true;
            } else {

                Node n = first;
                while (n.next != null && !n.next.data.equals(c)) {

                    n = n.next;
                }
                    if( n.next != null) {

                        n.next = n.next.next;

                        if( n.next == null ) {

                            last = n;
                        }
                        return true;
                    }
            }
        }
        return false;
    }

    /**
     * This method iterates through the linked list looking for the first matching
     * full name.
     * @param lastName first name to be found.
     * @param firstName last name to be found.
     * @return first matching contact.
     */
    public Contact searchName( String lastName, String firstName ) {

        Contact c = new Contact( firstName,lastName );
        Node n = first;

        while ( n != null ) {

            if ( n.data.equals(c) ){

                return n.data;
            }
            n = n.next;
        }
        return null;
    }

    /**
     * This method searches for the matching last name.
     * @param lastName last name.
     * @return an array list of matching contacts.
     */
    public ArrayList<Contact> searchName( String lastName ) {
        ArrayList<Contact> contactList= new ArrayList<Contact>();
        Node n = first;

        while ( n != null ) {

            if ( lastName.equals(n.data.getLastName())) {

                contactList.add(n.data);
            }
            n = n.next;
        }
        return contactList;
    }

    /**
     * This method searches for the matching zip code.
     * @param Zip zip code to be found.
     * @return an array list of matching contacts.
     */
    public ArrayList<Contact> searchZip( String Zip ) {
        Node n = first;
        ArrayList<Contact> contactZip= new ArrayList<Contact>();

        while (n != null) {

            if (n.data.getZipCode().equals( Zip ) ) {

                contactZip.add( n.data );
            }
            n = n.next;
        }
        return contactZip;
    }

    /**
     * Method writes the contacts back into the file.
     */
    public String toFile(){
        String str = "";
        Node n = first;

        while( n != null ) {

            str = str + n.data + "\n";
            n = n.next;
        }
        return str;
    }

    /**
     * This method sorts the contacts alphabetically by last name.
     */
    public void sort(){
        boolean swapped = false;
        do {

            Node n = first;
            swapped = false;

            while ( n.next != null ) {

                if ( n.data.compareTo(n.next.data) > 0 ) {

                    Contact temp = n.data;
                    n.data = n.next.data;
                    n.next.data = temp;
                    swapped = true;
                }
                n = n.next;
            }
        } while(swapped);
    }

    /**
     * Get the contacts into the string.
     * @return a string of the contacts.
     */
    @Override
    public String toString() {
        sort();
        String str = "";
        int count = 1;
        Node n = first;

        while( n != null ) {

            str = str + " " + count + ".)"+ n.data + "\n";
            count+=1;
            n = n.next;
        }
        return str;
    }

}
