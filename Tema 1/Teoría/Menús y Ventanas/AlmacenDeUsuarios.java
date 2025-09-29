/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploJDialog;

import java.util.Vector;

/**
 *
 * @author DAM22/23
 */
public class AlmacenDeUsuarios {
    private static Vector usuarios=new Vector();
    
    public static boolean isBaleiroAlmacenDeDatos()
    {
        if(usuarios.size()==0) return true;
        else return false;
    }
    
    public static void anhadirUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
    
    public static Vector recuperarUsuarios()
    {
        return usuarios;
    }
    
}
