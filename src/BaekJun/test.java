package BaekJun;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import jdk.internal.org.objectweb.asm.Handle;

import java.io.*;
import java.util.*;

public class test {

    public static void main(String[] args) {
    }
}


class Animal {
    int id;
    Animal(int id){
        this.id = id;
    }
}

class Cat extends  Animal{
    int type;
    Cat(int type){
        super(1);
        
    }
}
