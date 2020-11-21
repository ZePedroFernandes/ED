/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colections;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Contact implements Comparable{

    private String firstName, lastName, phone;

    /**
     * * Sets up this contact with the specified information.
     *
     * @param first a string representation of a first name
     * @param last a string representation of a last name
     * @param telephone a string representation of a phone number
     */
    public Contact(String first, String last, String telephone) {
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    /**
     * Returns a description of this contact as a string.
     * @return a string representation of this contact
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName + "\t" + phone;
    }

    /**
     * Uses both last and first names to determine lexical ordering.
     * @param other the contact to be compared to this contact
     * @return the integer result of the comparison
     */
    public int compareTo(Object other) {
        int result;
        if (lastName.equals(((Contact) other).lastName)) {
            result = firstName.compareTo(((Contact) other).firstName);
        } else {
            result = lastName.compareTo(((Contact) other).lastName);
        }
        return result;
    }
}

