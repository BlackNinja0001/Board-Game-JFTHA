/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jftha.spaces;

/**
 *
 * @author tue75856
 */
public class IllegalActivationTypeException extends IllegalArgumentException{
    public IllegalActivationTypeException(){};
    
    public IllegalActivationTypeException(String message){
        super("Illegal activation type error: " + message);
    }
}
