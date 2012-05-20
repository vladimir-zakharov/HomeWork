/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package associativeArray;

/**
 *
 * @author vladimir-zakharov
 */
public class NotFoundElementException extends Exception {

    public NotFoundElementException() {
        super();
    }
    
    public NotFoundElementException(String msg) {
        super(msg);
    }
}
