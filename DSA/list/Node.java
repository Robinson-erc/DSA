package list;


/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
  class Node<E>
   {
       E value;
       Node<E> next,prev;
       
       Node(E v, Node<E> n, Node<E>p)
       {
        value=v;
        next=n;
        prev= p;
       }
   }

