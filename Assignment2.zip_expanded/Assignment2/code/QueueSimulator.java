import java.lang.*;

public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };
  private double currTime;
  private double arrivalRate;
  private double serviceTime;
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  private Event e;
  
  public double getRandTime(double arrivalRate){
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }
  
  public QueueSimulator(double aR, double servT, double simT){
	  arrivalRate = aR;
	  
	  serviceTime = servT;	  
	  totalSimTime = simT;
  }
  
  
  public double calcAverageWaitingTime(){	
	  
	    int totpac = eventQueue.size();
	    Data data;
	    double sum = 0;
	    
	    while(!eventQueue.isEmpty()){
	    	data= eventQueue.dequeue();
	    	sum += (data.getDepartureTime() - data.getArrivalTime());
	    }
	    
	    
	    return sum/totpac;
  }
  
  public double runSimulation(){
	  
	  timeForNextArrival = getRandTime(arrivalRate);	
	  
	  
	  currTime = 0;
	  
	  while(currTime < totalSimTime) {		  
		
		  if(buffer.isEmpty()) {
			  e = Event.ARRIVAL;
			  timeForNextDeparture = timeForNextArrival + serviceTime;
			  
		  }
		 
		  else if(timeForNextArrival < timeForNextDeparture) {
			  e = Event.ARRIVAL;
		  }
		 
		  else { 
			  e = Event.DEPARTURE;
		  }	  
		  
		
		  if(e==Event.ARRIVAL) {
			  Data temA = new Data();
			  currTime = timeForNextArrival;
		  		
		  		temA.setArrivalTime(currTime);
		  		buffer.enqueue(temA);
		  		timeForNextArrival += getRandTime(arrivalRate);
		  		
			  
		  }
		  
		  else if (e==Event.DEPARTURE) {
			  Data temB=new Data();
			  currTime = timeForNextDeparture;
		  		
		  		temB= buffer.dequeue();
		  		temB.setDepartureTime(currTime);
		  		eventQueue.enqueue(temB);
		  		timeForNextDeparture += serviceTime;		
		  		
		  }		  	
		 
	  }
	  
	  return calcAverageWaitingTime();
  }
}