/*
 *-----------------------------------------------------------------
 * This file is licensed under GPL 3.0:
 * http://www.gnu.org/licenses/gpl-3.0.html
 *-----------------------------------------------------------------
 * FILE: DBConnectionException.java
 *-----------------------------------------------------------------
 * PROGETTO: Atsilo
 *-----------------------------------------------------------------
 * OWNER
 * Antonio, 27/nov/2012
 * REVISION
 * <nome revisore>, <data revisione>
 *-----------------------------------------------------------------
 */

package atsilo.exception;


public class DBConnectionException extends Exception{

    public DBConnectionException(String s){
        super(s);
    }

    /**
     * @param message
     * @param cause
     */
    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
