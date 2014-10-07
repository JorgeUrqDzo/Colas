package Colas;

import sun.rmi.transport.ObjectTable;

/**
 * Created by JorgeLuis on 12/09/2014.
 */
public class Cola {

    private int First;
    private int Last;
    private int Tamanio;
    private Object cola[];

    //constructor
    public Cola(int t) {

        this.First = -1;
        this.Last = -1;
        this.Tamanio = t;
        this.cola = new Object[Tamanio];
    }


    public boolean isVacia(){

        return Last == -1 && First == -1;
    }


    public boolean isLlena(){

        return Last == Tamanio-1;
    }


    public void Encolar(Object x){

        if(isLlena())
            System.out.println("La Cola esta llena elimine datos!");


        else if(isVacia()) {
            Last = Last + 1;
            First = First + 1;
            cola[Last] = x;
        }
        else{

            Last = Last + 1;
            cola[Last] = x;
        }
    }

    public Object Sacar(){

        if(isVacia()) {
            System.out.println("No hay elementos, inserte datos!");
            return "cola vacia";
        }
        else
        {
                Object aux;
            if(First==Last){
                aux = cola[First];
                First = -1;
                Last = -1;
                return aux;
            }else{
                aux = cola[First];
                First = First + 1;
                return aux;
            }
        }
    }

    public int getTamanio(){

        return cola.length;
    }

/*    private int VerPrimero(){

        if(isVacia()) {
            System.out.println("No hay ningun elemento en la cola!");
            return 0;
        }
        else
         return cola[First];
    }

    private int VerUltimo(){

        if(isVacia()) {
            System.out.println("No hay ningun elemento en la cola!");
            return 0;
        }
        else
        return cola[Last];
    }*/
}
