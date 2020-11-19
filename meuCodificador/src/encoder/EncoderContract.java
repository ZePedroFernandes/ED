package encoder;

import exceptions.InvalidKeyFormat;
import exceptions.InvalidMessageException;
import exceptions.InvalidElementException;

/**
 * Contract to implement an Encoder
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public interface EncoderContract {

    /**
     * Encodes a message using the key present in a queue.For each character of
     * the message it should be added a certain value, this value can be found
     * in the key.If the first value present in the key is 3, then 'n' becomes
     * 'k' 'n' + 3 = 'k'.Encoding "novanjghl mu urxlv" with the key 317425317 42
     * 53174 will return "knowledge is power". The withe spaces are preserved.
     *
     * @param message the message to be encoded.
     * @param key the key to be used.
     * @return The message but encoded with the specific key.
     * @throws InvalidMessageException if the message has a null or empty value.
     * @throws InvalidElementException if the key as any non integer element.
     * @throws InvalidKeyFormat if the key is null or empty.
     */
    public String encode(String message, String key) throws InvalidMessageException, InvalidElementException, InvalidKeyFormat, NumberFormatException;

}
