
public class RingBuffer {
	
	private int first = 0;
	private int last = 0;
	private double[] values;

	public RingBuffer(int capacity)
	{
		values = new double[capacity];
	}
	
	public int size()
	{
		if(first < last)
		{
			return last - first; 
		}
		return values.length - first + last;
	}
	
	public boolean isEmpty()
	{
		return (size() == 0);
	}
	
	public boolean isFull()
	{
		return (size() == values.length);
	}
	
	public void enqueue(double x)
	{
		
	}
	
	public double dequeue()
	{
		double returning = values[first]; 
		values[first] = 0; 
		first ++; 
		if(first >= values.length)
		{
			first = 0; 
		}
		return returning; 
		
	}
	
	public double peek()
	{
		return values[first];
		
	}
	
	public String toString()
	{
		
		String returning = ""; 
		int start = first; 
		while(start != last)
		{
			returning += values[start]; 
			start = (start + 1) % values.length; 

		}
		return returning; 
	}
}
