package stringcomparatorbysize;

import java.util.Comparator;

/**
 * A comparison function witch can be used to compare two Strings by them size.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class CompareStringsSize implements Comparator<String>{

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * 
     * @param string1 the first object to be compared.
     * @param string2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    @Override
    public int compare(String string1, String string2) {
        return string1.length() - string2.length();
    }

}
