
package ejercicio2llamadas;

import java.util.Scanner;

public class costoLlamadas {     
    
    private String nombre = "", teleprueba;
    private final int [] consumo = new int [2];  
    private int telefono;
    private double costo;   
    
    public void ingresoInformacion () {
        boolean pruebaN = false;
        String cosumPrueba;
        
        Scanner entrada = new Scanner(System.in); 
        
        System.out.println("Programa para cálculo de costo de llamadas\n");
        
        System.out.println("Ingrese el nombre del cliente:");         
        nombre = entrada.nextLine();
        while (pruebaN == false){                                          
             for (int i=0; i<nombre.length() ;i++){                                                        
                 if (Character.isLetter(nombre.charAt(i))){                                                  
                     pruebaN = true;                                                  
                     break;                                              
                 }                                             
                 else {                                                                                              
                     pruebaN = false;                                                                  
                 }                                                                     
             }                                           
             if (pruebaN == false){                                           
                 System.out.println("Error, ingresó un valor numérico\nPor favor ingrese el nombre del cliente:");                        
                 nombre = entrada.nextLine();                                   
             } 
         }
        
        System.out.println("Ingrese el número de teléfono del cliente:");         
        teleprueba = entrada.nextLine();      
        
        while (pruebaN == true || teleprueba.startsWith("2") == false || teleprueba.startsWith("8") == false || teleprueba.length() > 8 || teleprueba.length() < 8){                                             
            for (int i=0; i<teleprueba.length() ;i++){                                              
                if (Character.isDigit(teleprueba.charAt(i))){                                                    
                    pruebaN = false;                                                                  
                }                                             
                else {                                                                                               
                    pruebaN = true;        
                     break;                                              
                }                                                                     
            }                                          
            if (pruebaN == true || (teleprueba.startsWith("2") == false && teleprueba.startsWith("8") == false) || (teleprueba.length() > 8 || teleprueba.length() < 8)){                                             
                System.out.println("Error, ingresó un valor incorrecto\nPor favor ingrese el número de teléfono nuevamente:");                             
                teleprueba = entrada.nextLine();                                           
            }                                                 
            if (pruebaN == false && (teleprueba.startsWith("2") || teleprueba.startsWith("8")) && teleprueba.length() == 8 ){                                          
               telefono = Integer.parseInt(teleprueba);
               break;
            }         
        }                        
        pruebaN = true;                     
        
        System.out.println("\nIngrese el consumo del cliente:");   
        
        for(int cont = 0; cont < consumo.length; cont++){
             switch (cont){
                 case 0:                      
                     System.out.println("Consumo de minutos:");                                       
                     cosumPrueba = entrada.nextLine();  
                     
                     while (pruebaN == true){                    
                         for (int i=0; i<cosumPrueba.length() ;i++){                                
                             if (Character.isDigit(cosumPrueba.charAt(i))){                   
                                 pruebaN = false;                   
                                                  
                             }                
                             else {                                                              
                                 pruebaN = true;     
                                 break;
                             }                                            
                         }                  
                         if (pruebaN==false){              
                             consumo[0] = Integer.parseInt(cosumPrueba);            
                         }        
                         else{                
                             System.out.println("Error, no ingresó un valor numérico\nPor favor ingrese el consumo de minutos:");                              
                             cosumPrueba = entrada.nextLine();                  
                         }                                 
                         
                     }   
                     pruebaN = true;
                     break;                     
                 case 1: 
                     System.out.println("Consumo de segundos:");
                     cosumPrueba = entrada.nextLine(); 
                     
                     while (pruebaN == true){                    
                         for (int i=0; i<cosumPrueba.length() ;i++){                                
                             if (Character.isDigit(cosumPrueba.charAt(i))){                   
                                 pruebaN = false;                                                              
                             }                
                             else {                                                              
                                 pruebaN = true;  
                                 break;     
                             }                                            
                         }                  
                         if (pruebaN==false){              
                             consumo[1] = Integer.parseInt(cosumPrueba);            
                         }        
                         else{                
                             System.out.println("Error, no ingresó un valor numérico\nPor favor ingrese el consumo de segundos:");                              
                             cosumPrueba = entrada.nextLine();                  
                         }                                    
                     }   
                     pruebaN = true;     
                     break;                                                                       
             }      
        }     
    }
    
    public double calculoConsumo () {
        
        if (teleprueba.startsWith("2")){
            costo = consumo[0]*35 + consumo[1]*35/60;
        }
        
        if (teleprueba.startsWith("8")){
            costo = consumo[0]*50 + consumo[1]*50/60;
        }
        
        return costo;
    }
    
    public void consumoFinal () {
        System.out.printf("El consumo de %s correspondiente al número %d es de ¢%.2f\n", nombre, telefono, calculoConsumo());    
    }
}
    

