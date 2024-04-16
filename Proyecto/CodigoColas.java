import javax.swing.JOptionPane;

public class CodigoColas {
    public class Nodo{
        int informacion;
        Nodo next;
    }

    private Nodo inicioCola, finalCola;
    String Cola = "";

    public CodigoColas() {
        inicioCola = null;
        finalCola = null;
    }

    public boolean ColaVacia(){
        if(inicioCola == null){
            return true;
        }else{
            return false;
        }
    }

    public void Insertar(int informacion){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.informacion = informacion;
        nuevoNodo.next = null;

        if(ColaVacia()){
            inicioCola = nuevoNodo;
            finalCola = nuevoNodo;
        }else{
            finalCola.next = nuevoNodo;
            finalCola = nuevoNodo;
        }

    }

    public int Extraer(){
        if (!ColaVacia()) {
            int informacion = inicioCola.informacion;
            if(inicioCola == finalCola){
                inicioCola = null;
                finalCola = null;
            }else{
                inicioCola = inicioCola.next;
            }
            return informacion;
            
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void MostrarContenido(){
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while(recorrido != null){
            Cola += recorrido.informacion + " ";
            recorrido = recorrido.next;

        }

        String cadena [] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " +cadena[i];

        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";

    }

}
