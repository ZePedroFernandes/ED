package encoder;

import exceptions.InvalidKeyFormat;
import exceptions.InvalidMessageException;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import queues.LinkedQueue;

/**
 * Represents an Encoder that is able to code and decode a String.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Encoder implements EncoderContract {

    private LinkedQueue<Integer> keyQueue;

    /**
     * Construct's an instance of {@link Encoder}.
     */
    public Encoder() {
    }

    /**
     * Removes the withe spaces in the end and begging of the key.
     *
     * @param key the key to be corrected
     * @return the key with no spaces at the beginnig or the end of it.
     */
    private String RemoveKeySpaces(String key) {
        while (key.startsWith(" ")) {
            key = key.substring(1, key.length());
        }
        while (key.endsWith(" ")) {
            key = key.substring(0, key.length() - 1);
        }

        return key;
    }

    /**
     * Transfers to the queue every Integer element in the key.The key must be
     * formed with no null or irregular values.
     *
     * @param key key to be transfered to the queue.
     * @throws InvalidElementException if any key element is invalid (such as
     * null).
     * @throws InvalidKeyFormat if the key is not well formated.
     */
    private void keyToQueue(String key) throws InvalidElementException, NumberFormatException, InvalidKeyFormat {
        if (key == null) {
            throw new InvalidKeyFormat("Invalid key (null key)");
        }
        if (key.equals("")) {
            throw new InvalidKeyFormat("Invalid key (empty key)");
        }

        this.keyQueue = new LinkedQueue<>();

        String currentNumber = "";
        for (int i = 0; i < key.length(); i++) {
            currentNumber = "";
            while (i != key.length() && key.charAt(i) != ' ') {
                currentNumber += key.charAt(i);
                i++;
            }

            keyQueue.enqueue(Integer.parseInt(currentNumber)); // Lança uma exceção.
        }
    }

    /**
     * A string representation of the queue.
     *
     * @return string representation of the queue.
     */
    public String keyToString() {
        return this.keyQueue.toString();
    }

    /**
     * Removes value to a char, if the char is 'a' and the value is 2, the
     * return will be 'x'.
     *
     * @param letter the letter to remove the value.
     * @param value the value to remove to the letter.
     * @return the value obtained by subtracting to letter the value parameter.
     * @throws UnsupportedCharException if the char is not a letter A-Z or a-z.
     */
    private char encodeChar(char letter, int value) {
        int capitalized = 0;
        if (letter >= 97 && letter <= 122) {
            capitalized = 32;
        }
        if (letter >= 65 + capitalized && letter <= 90 + capitalized) {
            int valueOfChar = letter;
            valueOfChar -= value;

            while (valueOfChar < (65 + capitalized)) { //To prevent keys with big numbers
                valueOfChar += 26;
            }

            while(valueOfChar > (90 + capitalized)){ //To prevent keys with big numbers
                valueOfChar -= 26;
            }
            
            return (char) valueOfChar;
        } else {
            return letter;
        }
    }

    /**
     * Encodes a message using the key present in a queue.For each character of
     * the message it should be added a certain value, this value can be found
     * in the key.If the first value present in the key is 3, then 'n' becomes
     * 'k' 'n' + 3 = 'k'. Encoding "novanjghl mu urxlv" with the key 317425 will
     * return "knowledge is power". The withe spaces are preserved.
     *
     * @param message the message to be encoded.
     * @return The message but encoded with the specific key.
     * @throws InvalidMessageException if the message has a null or empty value.
     * @throws InvalidElementException if the key as any non integer element.
     * @throws InvalidKeyFormat if the key is null or empty.
     */
    @Override
    public String encode(String message, String key) throws InvalidMessageException, InvalidElementException, InvalidKeyFormat, NumberFormatException {
        key = this.RemoveKeySpaces(key);
        this.keyToQueue(key);
        String codedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            if (this.keyQueue.isEmpty()) {
                this.keyToQueue(key);
            }
            char currentChar = message.charAt(i);
            if (currentChar == ' ') {
                codedMessage += ' ';
            } else {
                try {
                    codedMessage += this.encodeChar(currentChar, this.keyQueue.dequeue());
                } catch (EmptyException e) {
                }
            }
        }

        return codedMessage;
    }

    /**
     * Has a similar behavior to the encode method.
     * Reverts the key and encodes the message so the message is decoded.
     * 
     * @param message The message to be decoded.
     * @param key The decod key.
     * @return A decoded version of the message given as parameter
     * @throws InvalidMessageException if the message has a null or empty value.
     * @throws InvalidElementException if the key as any non integer element.
     * @throws InvalidKeyFormat if the key is null or empty.
     */
    public String decode(String message, String key) throws InvalidMessageException, InvalidElementException, InvalidKeyFormat {
        key = this.RemoveKeySpaces(key);
        String decodeKey = "";
        String current = "";

        for (int position = 0; position < key.length(); position++) {
            current = "";
            while (position < key.length() && key.charAt(position) != ' ') {
                current += key.charAt(position);
                position++;
            }
            
            if (current.charAt(0) == '-') {
                if(current.length() == 1){
                    throw new InvalidKeyFormat("\"-\" is not a valid number");
                }
                decodeKey += current.substring(1);
            } else {
                decodeKey += '-' + current;
            }
            
            decodeKey += ' ';
        }
        
        return this.encode(message, decodeKey);
    }
}
