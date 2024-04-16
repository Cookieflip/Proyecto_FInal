import javax.swing.JOptionPane;
public class CodigoListasEnlazadas {

    private Nodo head = null;
    public int length = 0;
    String lista = " ";

    public class Nodo{ //Clase interna llamada nodo
        public int data;
        public Nodo next; //Enlace al siguiente nodo
        //De la 
        //El constructor inicializa las variables de mi clase nodo
        Nodo(int valor){
            data = valor;
            next = null;
        }
    }

    public boolean IsEmptyList(){
        return head == null;
    }

    public int ObtenerNodo(int posicion){
        if(IsEmptyList()){
            return 0;
        }else{
            Nodo puntero = head;
            int contador = 0;
            while(contador<posicion&&puntero.next!=null){
                puntero = puntero.next;
                contador++;
            }
            if(contador!=posicion){
                return 0;
            
            }else{
                return puntero.data;
            }
        }
    }

    public int ContarNodos(){
        return length;
    }

    public void MostrarNodos(){
        Nodo current = head;
        //int contador = 0;
        while(current != null){
            lista += current.data + " ";
            current = current.next;
            //contador++;
        }
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }

    public void InsertarAlInicio(int valor){ 
        Nodo nodo = new Nodo(valor); //Insertar un nodo al inicio
        nodo.next = head; //Apuntar el puntero del nodo a la cabeza
        head = nodo; //
        length++;

    }

    public void InsertarAlFinal(int valor){
        Nodo nodo = new Nodo(valor);
        if(IsEmptyList()){
            head = nodo;
        }else{
            Nodo puntero = head;
            while(puntero.next != null){
                puntero= puntero.next;

            }
            puntero.next = nodo;
        }
        length++;
    }

    public void InsertarEnPosicion(int posicion, int valor){
        Nodo nodo = new Nodo(valor);
        if(IsEmptyList()){
            head = nodo;
        }else{
            Nodo puntero = head;
            int contador = 0;
            while(contador < (posicion-1) && puntero.next != null){
                puntero = puntero.next;
                contador++;
            }
            nodo.next = puntero.next;
            puntero.next = nodo;
        }
        length++;

    }

    public void EliminarAlInicio(){
        if(!IsEmptyList()){
            Nodo first = head;
            head = head.next;
            first.next = null;
            length--;
        }
    }

    public void EliminarAlFinal(){
        if(!IsEmptyList()){ //La lista no tiene que estar vacia
            if(head.next == null){ // Verificar que al menos hay un nodo
                head = null;
                length--;
            }else{
                Nodo puntero = head;
                while(puntero.next.next != null){
                    puntero = puntero.next;

                }
                puntero.next = null;
                length--;
            }
        }
    }

    public void EliminarNodo(int posicion){
        if (head!=null) {
            if (posicion==0) {
                Nodo first=head;
                head=head.next;
                first.next=null;
                length--;
            } else if (posicion<length) {
                Nodo puntero=head;
                int contador=0;
                while(contador<(posicion-1)){
                    puntero=puntero.next;
                    contador++;
                }
                Nodo temp=puntero.next;
                puntero.next=temp.next;
                temp.next=null;
                length++;
            }
        } 
    }
}
