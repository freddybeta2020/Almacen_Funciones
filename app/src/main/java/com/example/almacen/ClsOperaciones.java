package com.example.almacen;
/*2.	Leer la cantidad de unidades y el valor unitario de un producto y luego imprimir su valor bruto, el IVA,
el descuento y el valor neto (utilizar para cada uno un método) sabiendo que se cobra el IVA este es del 10 por
ciento sobre el valor bruto  y tiene un descuento dependiendo de la cantidad de unidades así: si es menor de 20 unidades
 se le da un descuento del 12% sobre el valor básico,  del 20% si la cantidad esta entre 20 y 50 unidades y del 25%
 si es mayor de 50 unidades. Utilizar clases y funciones para realizar la tarea.
 */
public class ClsOperaciones {

   public double iva;
    public double Calcular_iva(double valor_bruto){
          iva = 10;
         return (valor_bruto * iva)/100;
    }

    public double Calcular_valor_bruto(double valor_articulo, int cantidad){
        return valor_articulo * cantidad;
    }

    public double Calcular_descuento(double valor_bruto, int cantidad){
        double descuento =0;
        if (cantidad <=19 ){
            descuento = 12;
        }
        if (cantidad >=20 && cantidad <= 50){
            descuento = 20;
        }if(cantidad>=51) {
            descuento = 25;
        }
        return (valor_bruto*descuento)/100;
    }

    public double Calcular_neto(double valor_bruto, double descuento, double iva ){
        double neto_pagar;
        return neto_pagar = valor_bruto-descuento + iva;
    }

}
