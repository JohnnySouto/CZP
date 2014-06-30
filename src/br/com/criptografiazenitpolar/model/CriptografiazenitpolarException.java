package br.com.criptografiazenitpolar.model;

/**
 *
 * @author Johnny Souto e-mail: falecomigo@johnnysouto.com.br
 */

public class CriptografiazenitpolarException extends Exception {
    
    public CriptografiazenitpolarException(String message, Exception e) {
        super(message, e);
    }
    
    public CriptografiazenitpolarException(String message) {
        super(message);
    }
    
}
