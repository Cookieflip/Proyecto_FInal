import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        int opcion = 0, nodo = 0, nodoInformacion = 0, valor = 0, valor2 = 0, posicion = 0;
        
        CodigoPilas pila = new CodigoPilas();
        CodigoColas cola = new CodigoColas();
        CodigoListasEnlazadas lista = new CodigoListasEnlazadas();
        CodigoArboles arbolito = new CodigoArboles();

        //Menu Principal.
        do {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "                               Menu Principal\n"
                        + "Elija el tipo de estructura de datos que quiere aplicar:\n"
                        + "1. Listas Enlazadas.\n"
                        + "2. Colas.\n"
                        + "3. Pilas.\n"
                        + "4. Arboles.\n"
                        + "5. Salir."));
                
                switch (opcion) {

                    //Menu para Listas Enlazadas.
                    case 1:
                        do{
                            try{
                                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "   Menu de opciones (Listas Enlazadas)\n\n"
                                + "1. Insertar Nodo al inicio\n"
                                + "2. Insertar Nodo en posicion.\n"
                                + "3. Insertar Nodo al final.\n"
                                + "4. ¿Cuantos Nodos existen?\n"
                                + "5. Mostrar Nodos\n"
                                + "6. Eliminar Nodo al inicio\n"
                                + "7. Eliminar Nodo al final\n"
                                + "8. Eliminar Nodo en posicion\n"
                                + "9. Regresar al menu prncipal.\n"));
                                switch(opcion){
                                    case 1:
                                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del Nodo."));
                                    lista.InsertarAlInicio(valor);
                                    break;

                                    case 2:
                                    if (!lista.IsEmptyList()) {
                                        posicion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la posición del Nodo."));
                                        valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del Nodo."));
                                        lista.InsertarEnPosicion(posicion, valor);
                                        JOptionPane.showMessageDialog(null, "Se ha insertado un Nodo en la posición: " + posicion);
                                        if (posicion > lista.ContarNodos()) {
                                            JOptionPane.showMessageDialog(null, "La posicion no existe, intenta de nuevo.");
                                            lista.EliminarAlFinal();
                                        } 
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se puede, ya que la lista esta vacía.");
                                    }
                                    
                                    break;

                                    case 3:
                                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del Nodo."));
                                    lista.InsertarAlFinal(valor);
                                    break;

                                    case 4:
                                    JOptionPane.showMessageDialog(null, lista.ContarNodos());
                                    break;

                                    case 5:
                                    if (!lista.IsEmptyList()) {
                                        lista.MostrarNodos();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La lista está vacía.");
                                    }
                                    break;

                                    case 6:
                                    if (!lista.IsEmptyList()) {
                                        lista.EliminarAlInicio();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se pueden eliminar Nodos ya que la lista está vacía.");
                                    }
                                    break;
                                    case 7:
                                    if (!lista.IsEmptyList()) {
                                        lista.EliminarAlFinal();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se pueden eliminar Nodos ya que la lista está vacía.");
                                    }
                                    break;
                                    case 8:
                                    if (!lista.IsEmptyList()) {
                                        posicion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la posición del Nodo."));
                                        lista.EliminarNodo(posicion);
                                        if (posicion > lista.ContarNodos()) {
                                            JOptionPane.showMessageDialog(null, "La posicion no existe, intenta de nuevo.");
                                        } else{
                                        JOptionPane.showMessageDialog(null, "Se ha eliminado un Nodo en la posición: " + posicion);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se puede, ya que la lista esta vacía.");
                                    }
                                    break;

                                    case 9:
                                    opcion = 9;
                                    break;

                                    default:
                                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intenta de nuevo");
                                    break;

                                }
                            } catch (NumberFormatException e) {

                            }
                        }while (opcion != 9);
                    break;

                    //Menu para las Colas.    
                    case 2:
                        do{
                            try{
                                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "         Menú de Opciones (Colas)\n\n"
                                + "1. Insertar un Nodo.\n"
                                + "2. Eliminar un Nodo.\n"
                                + "3. Mostrar contenido de la Cola.\n"
                                + "4. Regresar al menu principal.\n"));
                                switch(opcion){
                                    case 1:
                                    nodoInformacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del Nodo."));
                                    cola.Insertar(nodoInformacion);
                                    break;

                                    case 2:
                                    if (!cola.ColaVacia()) {
                                        JOptionPane.showMessageDialog(null, "Se extrajo un Nodo con el valor: "+cola.Extraer());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La Cola esta vacia.");
                                    }

                                    break;

                                    case 3:
                                    if(!cola.ColaVacia()){
                                        cola.MostrarContenido();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "La Cola esta vacia.");
                                    }    
                                    break;

                                    case 4:
                                    opcion = 4;
                                    break;

                                    default:
                                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intenta de nuevo.");
                                    break;
                                }

                            } catch (NumberFormatException e) {

                            }
                        }while (opcion != 4);
                    break;   
                    
                    //Menu para las Pilas.
                    case 3:
                        do{
                            try{
                                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "                    Menú de Opciones (Pilas)\n\n"
                                + "1. Insertar un nodo\n"
                                + "2. Eliminar un nodo\n"
                                + "3. ¿La Pila esta vacia?\n"
                                + "4. ¿Cual es el último valor ingresado en la Pila?\n"
                                + "5. ¿Cuantos nodos tiene la pila?\n"
                                + "6. Vaciar Pila\n"
                                + "7. Mostrar contenido de la Pila\n"
                                + "8. Regresar al menu principal.\n\n"));
                                switch(opcion){
                                    case 1:
                                    nodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa e valor a guardar del nodo"));
                                    pila.InsertarNodo(nodo);
                                    break;
                                    
                                    case 2:
                                    if(!pila.PilaVacia()){
                                        JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor: "+pila.EliminarNodo());

                                    }else{
                                        JOptionPane.showMessageDialog(null, "La pila está vacia.");
                                    }
                                    break;

                                    case 3:
                                    if(pila.PilaVacia()){
                                        JOptionPane.showMessageDialog(null, "La pila esta vacia");
                                    }else{
                                        JOptionPane.showMessageDialog(null, "La pila no esta vacia");
                                    }
                                    break;

                                    case 4:
                                    if(!pila.PilaVacia()){
                                        JOptionPane.showMessageDialog(null, "El ultimo valor ingresado de la pila es: "+pila.MostrarUltimoValorIngresado());
                                    }else{
                                        JOptionPane.showMessageDialog(null, "La pila esta vacia");
                                    }
                                    break;

                                    case 5:
                                    JOptionPane.showMessageDialog(null, "La pila contiene: "+pila.TamanoPila()+ " nodos");
                                    break;

                                    case 6:
                                    if(!pila.PilaVacia()){
                                        pila.VaciarPila();
                                        JOptionPane.showMessageDialog(null, "Se ha vaciado la pila");

                                    }else{
                                        JOptionPane.showMessageDialog(null, "La pila esta vacia");
                                    }
                                    break;

                                    case 7:
                                    if (!pila.PilaVacia()){
                                        pila.MostrarValores();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "La pila esta vacia.");
                                    }
                                    break;

                                    case 8:
                                    opcion = 8;
                                    break;

                                    default:
                                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intenta de nuevo.");
                                    break;

                                }
                            } catch (NumberFormatException e) {

                            }
                        }while (opcion != 8);
                    break;
                       
                    //Menu para arboles.
                    case 4:
                    do {
                        try {
                            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                            "Menu de opciones (Arboles)\n\n"
                            + "1. Insertar Hoja\n"
                            + "2. Imprimir InOrden.\n"
                            + "3. Imprimir PreOrden.\n"
                            + "4. Imprimir PostOrden.\n"
                            + "5. Eliminar Nodo o Hoja.\n"
                            + "6. Buscar Hoja.\n"
                            + "7. Contar Nodos.\n"
                            + "8. Contar Hojas.\n"
                            + "9. Altura del Arbol.\n"
                            + "10. Regresar al menu principal.\n"));
                            switch(opcion){
                                case 1:
                                valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor de la hoja"));
                                arbolito.Insertar(valor);
                                
                                break;

                                case 2:
                                if (!arbolito.ArbolVacio()) {
                                    arbolito.InOrder(arbolito.raiz);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El arbol está esta vacio.");
                                }
                                break;

                                case 3:
                                if (!arbolito.ArbolVacio()) {   
                                arbolito.PreOrder(arbolito.raiz);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El arbol está esta vacio.");
                                }
                                break;

                                case 4:
                                if (!arbolito.ArbolVacio()) { 
                                arbolito.PostOrder(arbolito.raiz);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El arbol está esta vacio.");
                                    }
                                break;

                                case 5:
                                    if (!arbolito.ArbolVacio()) {
                                        valor2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor que quieres eliminar"));
                                        if (valor2 == valor) {
                                            arbolito.Eliminar(valor); 
                                            JOptionPane.showMessageDialog(null, "El Nodo/Hoja que eliminaste es: " + valor2);   
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El valor que ingresaste no esta en el arbol.");
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "El arbol está vacio.");
                                     }
                                    
                                break;

                                case 6:
                                int valor3 = 0;
                                if (!arbolito.ArbolVacio()) {
                                    valor3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del Nodo/Hoja que quieres buscar."));
                                    if (valor3 == valor) {
                                        arbolito.Buscar(valor);  
                                        JOptionPane.showMessageDialog(null, "El valor que buscas es: " + valor3);                                  
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El valor que ingresaste no esta dentro del arbol.");
                                    }
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "El arbol esta vacio.");
                                }
                                break;

                                case 7:
                                if (!arbolito.ArbolVacio()) {
                                    JOptionPane.showMessageDialog(null, "El numero de Nodos es de: " + arbolito.ContarNodos());
                                } else {
                                    JOptionPane.showMessageDialog(null, "El arbol esta vacio.");
                                }
                                break;

                                case 8:
                                if (arbolito.ArbolVacio()) {
                                    JOptionPane.showMessageDialog(null, "El arbol esta vacio.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El numero de Hojas es de: " + arbolito.ContarHojas());
                                    
                                }
                                break;

                                case 9:
                                if (!arbolito.ArbolVacio()) {
                                    JOptionPane.showMessageDialog(null, "La altura del arbol es de: " + arbolito.AlturaArbol());
                                } else {
                                    JOptionPane.showMessageDialog(null, "El arbol esta vacio.");
                                }
                                break;

                                case 10:
                                opcion = 10;
                                break;
                                default:
                                JOptionPane.showMessageDialog(null, "Opción incorrecta, intenta de nuevo.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            
                        }
                    } while (opcion != 10);
                    break;

                    //Opcion salir.
                    case 5:
                    JOptionPane.showMessageDialog(null, "Hasta luego.");
                    break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, intenta de nuevo.");
                    break;
                }
                

            } catch (NumberFormatException e) {

            }
        } while (opcion != 5);
    }
}
