import javax.swing.JOptionPane; 
public class CodigoArboles {
    String arbolote = "";
    private class Nodo{
        int valor;
        Nodo izquierdo;
        Nodo derecho;
       
    
        public Nodo(int valor){
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
            
        }
    }

    Nodo raiz;
    int arbolito = 0;
    public CodigoArboles(){
        this.raiz = null;
    }

    public void Insertar(int valor){
        raiz = InsertNodo (raiz, valor);

    }

    private Nodo InsertNodo(Nodo currentRoot, int valor){
        if(currentRoot == null)
        return new Nodo(valor);
        if (valor < currentRoot.valor) {
            currentRoot.izquierdo = InsertNodo(currentRoot.izquierdo, valor);
        } else if(valor > currentRoot.valor){
            currentRoot.derecho = InsertNodo(currentRoot.derecho, valor);
        }
        return currentRoot;

    }

    public void InOrder(Nodo nodo){
        if (nodo != null) {
            InOrder(nodo.izquierdo);
            JOptionPane.showMessageDialog(null, nodo.valor + "");
            InOrder(nodo.derecho);
        }
    } 
    

    public void PreOrder(Nodo nodo){
        if (nodo != null) {
            JOptionPane.showMessageDialog(null, nodo.valor + "");
            PreOrder(nodo.izquierdo);
            PreOrder(nodo.derecho);

        }
    }

    public void PostOrder(Nodo nodo){
        if (nodo != null) {
            PostOrder(nodo.izquierdo);
            PostOrder(nodo.derecho);
            JOptionPane.showMessageDialog(null, nodo.valor + "");
        }
    }

    public void Eliminar(int valor){
        raiz = EliminarNodo(raiz, valor);
    }

    private Nodo EliminarNodo(Nodo currentRoot, int valor){
        if(currentRoot == null)
        return currentRoot;

        if(valor < currentRoot.valor){
            currentRoot.izquierdo = EliminarNodo(currentRoot.izquierdo, valor);

        }else if(valor > currentRoot.valor){
            currentRoot.derecho = EliminarNodo(currentRoot.derecho, valor);
        }else{
            if(currentRoot.izquierdo == null){
                return currentRoot.derecho;
            }else if(currentRoot.derecho == null){
                return currentRoot.izquierdo;
            }

            Nodo sucesor = EncontrarSucesor(currentRoot.derecho);
            currentRoot.valor = sucesor.valor;
            currentRoot.derecho = EliminarNodo(currentRoot.derecho, sucesor.valor);
        }
        return currentRoot;
    }

    private Nodo EncontrarSucesor(Nodo nodo){
        Nodo actual = nodo;
        while(actual.izquierdo != null){
            actual = actual.izquierdo;
        }
        return actual;
    }

    public Nodo Buscar(int valor){
        return BuscarNodo(raiz, valor);
    }

    private Nodo BuscarNodo(Nodo currentRoot, int valor){
        if (currentRoot == null || currentRoot.valor == valor) {
            return currentRoot;
        } if (valor < currentRoot.valor) {
            return BuscarNodo(currentRoot.izquierdo, valor);
        }else{
            return BuscarNodo(currentRoot.derecho, valor);
        }
    }

    public int ContarNodos(){
        return ContarNodosR(raiz);
    }

    private int ContarNodosR(Nodo nodo){
        if (nodo == null) {
            return 0;
        }
        return 1 + ContarNodosR(nodo.izquierdo) + ContarNodosR(nodo.derecho);
    }

    public int AlturaArbol(){
        return AlturaArbolR(raiz);
    }

    private int AlturaArbolR(Nodo nodo){
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(AlturaArbolR(nodo.izquierdo), AlturaArbolR(nodo.derecho));
    }

    public int ContarHojas(){
        return ContarHojasR(raiz);
    }

    private int ContarHojasR(Nodo nodo){
        if (nodo == null) {
            return 0;
        } if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return ContarHojasR(nodo.izquierdo) + ContarHojasR(nodo.derecho);
    }

    public boolean ArbolVacio(){
        return raiz == null;
    }
}
