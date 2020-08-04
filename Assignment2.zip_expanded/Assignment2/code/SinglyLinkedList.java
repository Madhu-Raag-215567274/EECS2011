public class SinglyLinkedList<E>{

  private static class Node<E>{
	  private E emt; 
	  private Node<E> node;	 
	  
    public Node(E e, Node<E> n){
    emt=e;
    node = n;
    
    }
    
    
    public E getElement(){
    	return emt;
    }
    public Node<E> getNext(){
    	return node;
    }
    public void setNext(Node<E> n){
    	node=n;
    }
  }
  private Node<E> head = null;
  private Node<E> tail = null;   
  private int size = 0; 
  
  public SinglyLinkedList(){
	  
  }
  
  public int size(){
	  return size;
  }
  
  public boolean isEmpty(){
	  return this.size==0;
  }
  
  public E first(){
	  if (this.size==0) { 
		  return null;
	  }
	    return head.getElement();
  }
  
  public E last(){
	  if (this.size==0) {
		  return null;
	  }
	    return tail.getElement();
  }
  
  public void addFirst(E element){
	  head = new Node<>(element, head);
	  
	    if (size == 0) {
	      tail = head;  
	    }
	    size++;
  }
  
  public void addLast(E element){
	  Node<E> temp = new Node<>(element, null);   
	    if (this.size ==0) {
	      head = temp;
	    }
	    else {
	      tail.setNext(temp);   
	    }
	    tail = temp;                           
	    size++;
  }
  
  public E removeFirst(){
	  if (size == 0) {
	      tail = null;  
	    }
	  if (isEmpty()) {
		  return null;              
	  }
	    E temp = head.getElement();
	    head = head.getNext();                   
	    size--;
	    
	    return temp;
  }
/*  public E removeLast(){
	  
	  if (head == null) 
          return null; 

      if (head.node == null) { 
          return null; 
      } 
   
      Node<E> second = head; 
      while (second.node.node != null) {
          second= second.node; 
      }
  
      tail= second.node;
      E an=tail.getElement();
      tail=second;
      second.node = null; 
    
      return an;
  }*/


}