/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashapp;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author lorenzobengzon
 */
public class Model {
    String input;
    String method;
    
    
    String encrypt(String method,String input){
        this.input =input;
        this.method = method;
        String output = getHash(input.getBytes(), method);
        return output;
    }
    public static String getHash(byte[] inputBytes,String algorithm) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
             hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (Exception e) {
        }
        return hashValue;
    }
  
    public static void main(String[] args) {
        
        
    }
}