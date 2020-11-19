package zmain;

import F4EX5.Strings_to_Queue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] strings = new String[10];
        strings[0] = "1";
        strings[1] = "2";
        strings[2] = "3";
        strings[3] = "0";
        
        System.out.println(Strings_to_Queue.StringsToQueue(strings).toString());
    }
    
}
