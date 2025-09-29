/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploJTextField;

/**
 *
 * @author DAM2
 */
public class Utilidades {
    public static boolean eNumeroEnteiro(String cadea)
    {
        if(cadea==null||cadea.isEmpty())
        {
            return false;
        }
        int caracter=0;
        if(cadea.charAt(0)=='-')
        {
            if(cadea.length()>1)caracter++;
            else return false;
        }
        for(;caracter<cadea.length();caracter++)
        {
            if(!Character.isDigit(cadea.charAt(caracter)))
            {
                return false;
            }
        }
        return true;
    }
    
}
