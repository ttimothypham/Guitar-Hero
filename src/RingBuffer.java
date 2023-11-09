
public class RingBuffer {
	
	private int first = 0;
	private int last = 0;
	private int size = 0; 
	private double[] values;

	public RingBuffer(int capacity)
	{
		values = new double[capacity];
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
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
			size++; 
		}
		else
		{
			throw new IllegalStateException("Buffer is full");
		}
		
	}
	
	public double dequeue()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Buffer is empty");
		}
		double returning = values[first]; 
		values[first] = 0; 
		first ++; 
		if(first >= values.length)
		{
			first = 0; 
		}
		size --; 
		return returning; 
		
	}
	
	public double peek()
	{
		return values[first];
		
	}
	
	public String toString()
	{
		if(isEmpty())
		{
			System.out.println("here");
			return "[]";
		}
		String returning = ""+values[first]; 
		int start = first; 
		while(start != last -1)
		{
			 
			start = (start + 1) % values.length; 
			returning += ", " + values[start];

		}
		return "[" + returning + "]"; 
	}
}
