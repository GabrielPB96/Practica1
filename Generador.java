/**
 * @author (G.A.M.E.) 
 * @version (19.03.2021)
 * 16.03.2021
 * 17.03.2021
 * 19.03.2021
 */
import java.util.Random;
public class Generador{
    private int[] lista;
    private Random colector;
    private long inicio, fin;
    
    public Generador(int longitud){
        lista    = new int[longitud];
        colector = new Random();
        inicio = fin = 0;
    }
    
    public Generador(){
        lista    = null;
        colector = new Random();
        inicio = fin = 0;
    }
    
    public void genAleatoriosConRepeticion(int n){
        try{
            lista  = new int[n];
            inicio = System.nanoTime();
            for(int i = 0; i < lista.length; i++){
                lista[i] = colector.nextInt(1000)+1;
            }
            fin = System.nanoTime();
            System.out.println("Tomo generar " + n +" con repeticion: "+ (fin - inicio));
        }catch(NegativeArraySizeException e){
            System.out.println("Valores negativos no aceptados");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void genAleatoriosSinRepeticion(int n){
        int generado, i;
        boolean encontrado;
        try{
            lista = new int[n];
            i = 0;
            encontrado = true;
            inicio = System.nanoTime();
            do{
                generado = colector.nextInt(1000)+1;
                encontrado = buscar(generado);
                if(!encontrado){
                    lista[i] = generado;
                    i++;
                }
            }while(encontrado || i < lista.length);
            fin = System.nanoTime();
            System.out.println("Tomo generar " + n +" sin repeticion: "+ (fin - inicio));
        }catch(NegativeArraySizeException e){
            System.out.println("Valores negativos no aceptados");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
    private boolean buscar(int n){
        boolean encontrado;
        encontrado = false;
        for(int i=0; i<lista.length && !encontrado; i++){
            if(lista[i] != 0)
                encontrado = lista[i] == n ? true : false;
            else
                i = lista.length;
        }   
        return encontrado;
    }
    
    public int[] recuperar(int cantidad){
        int[] nueva_lista;
        nueva_lista = null;
        try{
            nueva_lista = new int[cantidad];
            for(int i=0; i<cantidad; i++){
                nueva_lista[i] = lista[i];
            }
        }catch(ArrayIndexOutOfBoundsException e){
            nueva_lista = null;
            System.out.println("FUERA DE RANGO!!!");
        }catch(NegativeArraySizeException e){
            System.out.println("Valores negativos no aceptados");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        return nueva_lista;
    }
    
    public void imprimir(){
        try{
            for(int x: lista){
                System.out.println(x +"  ");
            }
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public void main(){}
}
