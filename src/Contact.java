
/** This class represents a single contact */
public class Contact {

    /** represents the contacts last name */
    private String lastName;
    /** represents the contacts first name */
    private String firstName;
    /** represents the contacts phone num */
    private String phoneNum;
    /** represents the contacts adress */
    private String address;
    /** represents the contacts city */
    private String city;
    /** represents the contacts zip code */
    private String zipCode;

    /**
     * Constructor - initializes first and last name.
     * @param firstN first name.
     * @param lastN last name.
     */
    public Contact( String firstN, String lastN ){
        lastName = lastN;
        firstName = firstN;
    }

    /**
     * Constructor - initializes all of contact.
     * @param firstN first name.
     * @param lastN last name.
     * @param num phone number.
     * @param addy address
     * @param c city.
     * @param zip zip code.
     */
    public Contact( String lastN, String firstN, String num, String addy, String c, String zip ){
        lastName = lastN;
        firstName = firstN;
        phoneNum = num;
        address = addy;
        city = c;
        zipCode = zip;
    }

    /**
     * Retrieves the value of the last name.
     * @return value of last name.
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Retrieves the value of the first name.
     * @return value of first name.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Retrieves the value of the phone number.
     * @return value of phone number.
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * Retrieves the value of the address.
     * @return value of address.
     */
    public String getAdress(){
        return address;
    }

    /**
     * Retrieves the value of the city.
     * @return value of city.
     */
    public String getCity(){
        return city;
    }

    /**
     * Retrieves the value of the zip code.
     * @return value of zip code.
     */
    public String getZipCode(){
        return zipCode;
    }

    /**
     * Sets the first name.
     * @param first first name.
     */
    public void setFirstName( String first ){
        firstName = first;
    }

    /**
     * Sets the last name.
     * @param last last name.
     */
    public void setLastName( String last ){
        lastName = last;
    }

    /**
     * Stes the phones number.
     * @param number phone number.
     */
    public void setPhoneNum( String number ){
        phoneNum = number;
    }

    /**
     * Sets the address.
     * @param addy adress.
     */
    public void setAdress( String addy ){
        address = addy;
    }

    /**
     * Sets the city.
     * @param c city.
     */
    public void setCity( String c ){
        city = c;
    }

    /**
     * Sets the zip code.
     * @param zip zip code.
     */
    public void setZipCode( String zip ){
        zipCode = zip;
    }


    /**
     * The string represents the contact.
     * @return string representation of the contact.
     */
    public String toString(){
        return lastName + ',' + firstName + ',' + phoneNum + ',' + address + ',' + city + ',' + zipCode;
    }

    /**
     * Compares first names and last names to see if they're equal.
     * @param o explicit names to be compared.
     * @return true if they are equal, false if otherwise.
     */
    public boolean equals( Object o )
    {
        if( o instanceof Contact ){

            Contact c = (Contact) o;
            return this.lastName.equals(c.lastName) && this.firstName.equals(c.firstName);
        }
        return false;
    }
    /**
     * This method compares names.
     * @param c Contact.
     * @return
     */
    public int compareTo( Contact c ){
        int compare = this.lastName.compareTo(c.lastName);

        if( compare == 0 ){

            return this.firstName.compareTo(c.firstName);
        }
        return compare;
    }
}
