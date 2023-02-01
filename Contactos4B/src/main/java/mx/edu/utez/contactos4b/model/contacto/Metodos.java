package mx.edu.utez.contactos4b.model.contacto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Stack;


public class Metodos  {
    public static void main(String args[]) {

        FileReader f = null;
        BufferedReader reader = null;
        String line = null;
        Stack stack = new Stack();

        if (args.length < 1) {
            System.err.println("Archivo pila");
        }

        try {
            f = new FileReader(args[0]);
            reader = new BufferedReader(f);
            while ((line = reader.readLine()) != null)
                stack.push(line);
        } catch (Exception e) {
            System.err.println("File not found " + args[0]);
            return;
        }

        while ((line = (String) stack.pop()) != null) {
            System.out.println(line);
        }
    }
}
