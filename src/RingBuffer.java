
public class RingBuffer {
	
	private int first = 0;
	private int last;
	private int[] values;

	public RingBuffer(int capacity)
	{
		values = new int[capacity];
	}
	
	public int size()
	{
		
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
		
	}
	
	public double peek()
	{
		
	}
	
	public String toString()
	{
		
	}
}
