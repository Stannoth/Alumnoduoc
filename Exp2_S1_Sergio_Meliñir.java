/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

public class VentaEntradas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String [] zonas = {"A", "B", "C"};
        int [] precios = {20000, 15000, 10000};
        boolean seguir = true;
        
        for (int i = 0; i < 100 && seguir; i++) {
            System.out.print("Bienvenido al Teatro Moro");
            System.out.print("Por favor, elige una opción");
            System.out.print("1. Comprar entrada");
            System.out.print("2. Salir");
            String opcion = scanner.nextLine();
            
            if(opcion.equals("1")){
                System.out.print("Zonas disponibles:");
                System.out.print("  A. Zona Premiun   ($20000)");
                System.out.print("  B. Zona Media     ($15000)");
                System.out.print("  C. Zona Económica ($10000)");
                System.out.print("Selecciona la zona donde deseas comprar tu entrada");
                String zona = scanner.nextLine().toUpperCase();
                
                int precioBase = 0;
                boolean zonaValida = false;
                for (int z = 0; z < zonas.length; z++){
                    if (zona.equals(zonas[z])){
                precioBase = precios[z];
                zonaValida = true;
                break;
                }
                }
                if (!zonaValida) {
                    System.out.print("Esta zona no es Válida");
                    System.out.print("Por favor, intente nuevamente");
                    continue;
                }
                
                //ingresar edad y evaluar si ingresa correctamente
                int edad;
                System.out.print("Ingresa tu edad");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    
                }catch (NumberFormatException e) {
                    System.out.print("Error de ingreso. Por favor, debes ingresar un número válido");
                    continue;
                }
                
                if (edad < 0){
                    System.out.print("Edad no válida");
                    continue;
                }
                
                //descuento estudiante y tercera edad
                double descuento = 0.0;
                if (edad < 26) {
                    descuento = 0.10;
                    System.out.print("Tienes un descuento del 10% por ser estudiante");
                } else if (edad > 59) {
                    descuento = 0.15;
                    System.out.print("Tienes un descuento del 15% por ser mayor de edad");
                }
                
                //Calcular precio final
                double precioFinal = precioBase;
                int contador = 0;
                while (contador < 1) {
                    precioFinal = precioBase * (1 - descuento);
                    contador++;
                }
                
                //Mostrar resumen de la compra
                System.out.print("    Resumen de tu compra");
                System.out.print("Zona seleccionada: " + zona);
                System.out.print("Precio base: $" + precioBase);
                System.out.print("Descuento que se aplica: " + (int)(descuento * 100) + "%");
                System.out.print("Total a pagar: $" + (int)precioFinal);
                
                System.out.print("Deseas comprar otra entrada? (s/n)");
                String continuar = scanner.nextLine().toLowerCase();
                if (!continuar.equals("s")) {
                    seguir = false;
                    System.out.print("Gracias por su compra. Disfrute la función");
                }
            }else if (opcion.equals("2")) {
                System.out.print("Graciaspor tu visita al Teatro Moro");
                break;
            }
            else {
                System.out.print("Opción inválida, intente nuevamente");
            }
                
            }
        }
    }