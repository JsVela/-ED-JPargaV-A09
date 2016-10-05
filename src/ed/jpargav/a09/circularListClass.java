/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpargav.a09;

/**
 *
 * @author JESUS PARGA VELA
 * @param <T>
 */
public class circularListClass<T> {

    //Atributos
    private nodeClass pivot;

    //Constructor nulo
    public circularListClass() {
        pivot = null;
    }

    //Insertar al Inicio
    public void insertInicio(T d) {
        //Creamos nuestro nodo a insertar
        nodeClass node = new nodeClass(d);
        if (!isEmpty()) {//Si no está vacía la lista
            //Insertamos el nodo al inicio y recorremos los nodos
            node.next = pivot;
            findLast().next = node;
            pivot = node;
        } else { //Si la lista está vacía
            pivot = node;
            node.next = pivot;
        }
    }

    //Insertar al final
    public void insertFinal(T d) {
        //Creamos nuestro nodo a insertar
        nodeClass node = new nodeClass(d);
        if (!isEmpty()) {//Si no está vacía la lista
            // recorremos los nodos y el último lo enlazamos con el nuevo
            findLast().next = node;
            // el nuevo lo enlazamos con el primero
            node.next = pivot;
        } else { //Si la lista está vacía
            pivot = node;
            node.next = pivot;
        }
    }

    // Borrar nodo inicial
    public T borrarInicio() {
        // se respalda dirección al primer nodo
        nodeClass node = pivot;
        if (!isEmpty()) {//Si no está vacía la lista
            // recorremos los nodos y el último lo enlazamos con el segundo
            findLast().next = pivot.next;
            pivot = pivot.next;
            return (T) node.getData();
        } else { //Si la lista está vacía
            return null;
        }
    }

    // Borrar nodo final
    public T borrarFinal() {
        nodeClass aux = pivot, ultimo;
        if (!isEmpty()) {//Si no está vacía la lista
            // recorremos los nodos hasta el penúltimo
            do {
                aux = aux.next;
            } while (aux.next.next != pivot);
            ultimo = aux.next;
            // el penúltimo se enlaza con el primero y se elimina el último
            aux.next = pivot;
            return (T) ultimo.getData();
        } else { //Si la lista está vacía
            return null;
        }
    }

    // BorrarNodo (int n)
    public T borrarNodo(T d) {
        // busca nodo a borrar
        nodeClass aux = findNode(d), b;
        if (aux != null && aux.next != null) {
            b = aux.next;  // b es nodo a borrar
            //borra el nodo b al romper el enlace
            aux.next = b.next;
            return (T) b.getData();
        } else {
            return null;
        }
    }

    // recorre lista hasta encontrar el nodo anterior
    private nodeClass findNode(T d) {
        nodeClass p = null, q = pivot;
        while (q != null && q.getData() != d) {
            p = q;
            q = q.next;
        }
        return p;
    }

    // recorre lista hasta llegar al final
    private nodeClass findLast() {
        nodeClass aux = pivot;
        do {
            aux = aux.next;
        } while (aux.next != pivot);
        return aux;
    }

    // checa si está vacía la lista
    private boolean isEmpty() {
        return pivot == null;
    }

    // muestra la lista
    public void showList() {
        nodeClass aux;
        aux = pivot;
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            do {
                System.out.println("[" + aux.getData() + "]->");
                aux = aux.next;
            } while (aux.next != pivot);
        }
    }

}
