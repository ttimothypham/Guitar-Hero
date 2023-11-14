
public class GuitarString {
	
	public RingBuffer ringBuffer; 
	private int time; //variable to count total number of times tic() is called
	private int N; //variable for the capacity of the RingBuffer
	
	GuitarString(double frequency) 
	{
		double desiredCapacity = 44100 / frequency;
		N = (int) Math.ceil(desiredCapacity); //rounds the desired capacity up
		ringBuffer = new RingBuffer(N); //creates new RingBuffer
		for (int i = 0; i < N; i++)
		{
			ringBuffer.enqueue(0);
		}
	}
	
	GuitarString (double[] init)
	{
		ringBuffer = new RingBuffer(init.length);
		for (int i = 0; i < init.length; i++)
		{
			ringBuffer.enqueue(init[i]);
		}
	}
	
	public void pluck()
	{
		for (int i = 0; i < N; i++)
		{
			double random = (Math.random() - .5); //random num from -.5 to .5
			ringBuffer.dequeue(); 
			ringBuffer.enqueue(random); //enqueue the random num in the RingBuffer
		}
	}
	
	public void tic() 
	{
		double firstSample = ringBuffer.dequeue(); //dequeue the first sample of the buffer
		double scaledAverage = .994 * .5 * (firstSample + sample()); // the average of the first two samples scaled by the energy decay factor of 0.994
		ringBuffer.enqueue(scaledAverage); //enqueues the scaledAverage
		time++;
	}
	
	public double sample()
	{
		return ringBuffer.peek();
	}
	
	public int time()
	{
		return time;
	}

}
