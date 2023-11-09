
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
		if (!isFull()) //checks if the array is not full
		{
			values[last] = x; //enqueue x to last
			if (last + 1 == values.length) //checks if last needs to be wrapped
			{
				last = 0; //wraps last to index 0
			}
			else //no wrap is needed
			{
				last++; //increments last
			}
		}
		if (values.size() == 0) //checks if the array is empty
		{
			values[first] = x; //sets x in the first index
		}
		if (isFull())
		{
			throw new IllegalStateException("Buffer is full");
		}
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
