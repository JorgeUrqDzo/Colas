package Colas;

import javax.swing.*;
import java.util.Random;
import java.awt.*;

/**
 * Created by JorgeLuis on 30/09/2014.
 */
public class Banco extends Frame {

    public static void main(String[] args) {

       // Random r =new Random();

        //r.nextInt(5);

        System.out.println("\n\t\tSimulacion de la atencion de clientes en un Banco\n");

       Cola cola = new Cola(3);
        cola.Encolar(1);
        cola.Encolar(3);
        cola.Encolar(5);
        System.out.println(cola.isVacia());
        System.out.println(cola.isLlena());
        cola.Sacar();
        cola.Sacar();
        //cola.Sacar();
        System.out.println(cola.isVacia());
        System.out.println(cola.isLlena());
        cola.Encolar(05);
        cola.Encolar(05);

     // colaBanco();

    }

    public static void banco(){

        Random r =new Random();

        Cola cola = new Cola(r.nextInt(3)+1);

        //numero de clientes en la cola
        int contadorClientes = cola.getTamanio();
        System.out.println("\t\t\t<<Hay " + contadorClientes + " clientes en el banco>>\n");

        //Agregando datos a la cola
        for (int i = 0; i < contadorClientes; i++) {
            cola.Encolar(r.nextInt(20));
        }

        //Calculando tiempo de atencion para los clientes
        int prom = 0;
        for (int i = 0; i< contadorClientes; i++) {

            int tiempo = r.nextInt(20)+1;
            System.out.println("# El cliente numero " + (i+1) + " de la fila lo atendieron en >> " + tiempo + " << min");
            cola.Sacar();

            prom = (tiempo + prom);

            if(i +1 >= 2){
                double apx = prom/(i+1);
                System.out.println("\t -->> Tiempo promedio para atender al siguiente cliente es aproximada> " + apx + " min");

            }

        }
            System.out.println("\n\t\t<<Se han atendido " + contadorClientes + " clientes>>");
        if(cola.isVacia())
            System.out.println("\t\t<<La Fila del Banco esta vacia>>");
    }

    public static void colaBanco(){

        //creando objeto para numero aleatorios
        Random rdm = new Random();

        //objeto de la clase cola con parametro aleatorio
        int capacidad = 3;
        Cola cola = new Cola(capacidad);

        System.out.println("Abriendo el Banco");

        System.out.println("Banco con capacidad de " + capacidad + " personas en la cola");
        // Delcaracion e inicializacion de variables para el ciclo
        int contador = 0;
        int promTiemp = 0;
        int contadoraux = 0;

        //ciclo para llenar la cola del banco
        do{
            int clientes;

            if(!cola.isVacia()) {
                 clientes = (rdm.nextInt(5));
            }else{
                 clientes = (rdm.nextInt(5)+1);
            }
            System.out.println("Hay " + clientes + " esperando fuera del banco");

            if(clientes>0){

                for(int x = 0; x <clientes; x++) {

                    contador = contador + 1;
                    cola.Encolar("Persona " + x+1);
                    System.out.println("Han ingresado " + 1 + " clientes al banco.");

 /*                  *//*  if(cola.isLlena()){
                        System.out.println("El banco esta lleno!!!!");*//*

                    }//end else if*/

                }//end for

            }//end if

            int tiempo = rdm.nextInt(10)+1;

            if(++contadoraux < contador) {
                System.out.println("Tiempo de atencion de cliente " + (contadoraux) + " fue de " + tiempo + " minutos");
                promTiemp = (promTiemp + tiempo) / contadoraux;
                System.out.println("El tiempo estimado para atender al siguiente cliente es " + promTiemp + " minutos aproximadamente");
                cola.Sacar();
            }

        }while(!cola.isVacia());

    }//end colaBanco

}
