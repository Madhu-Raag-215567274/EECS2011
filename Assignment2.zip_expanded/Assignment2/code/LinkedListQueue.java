

public class LinkedListQueue<E> implements Queue<E>{
	
	private SinglyLinkedList<E> node;

	 
	private int size;

  public LinkedListQueue(){
	node=new SinglyLinkedList<E>();
	this.size=0;
  }
  public int size(){
	return node.size();
  }
  public boolean isEmpty(){
	return node.isEmpty();
  }
  

public E first(){
	return node.last();
	
  }

 
public void enqueue(E node){
	
	  this.node.addFirst(node); 
	        
	   	   
  }
  

public E dequeue(){
	  	  
	return this.node.removeLast();
		
  }
}
