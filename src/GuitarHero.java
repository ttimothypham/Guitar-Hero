public class GuitarHero {
	
	public static GuitarString[] array;
	public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	
	public static void main(String[] args) //Not finished
	{
		array = new GuitarString[keyboard.length()];
		for (int i = 0; i < keyboard.length(); i++)
		{
			GuitarString string = new GuitarString(440 * Math.pow(1.05956, i - 25));
			array[i] = string;
		}
		final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
        
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Type the keyboard to play a note!");
        
        play(array);
		
	}
	
	private static void play(GuitarString[] array)
	{
		String[] notes = new String[]{"q", "w", "r"};
		int counter = 1; 
		StdDraw.text(.2 ,.2 , notes[0]);
		
		// the user types this character
		while (true)
		{
			
	       
			double sample = 0.0;
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped())
            {
            	String key = "" + StdDraw.nextKeyTyped();
            	if (keyboard.contains(key))
            	{
            		// pluck the corresponding string
            		array[keyboard.indexOf(key)].pluck();
            		System.out.println(key); 
            		System.out.println(notes[counter - 1]);
            		if(key.equals("" + notes[counter - 1]))
            		{    
                		StdDraw.clear();
	            		StdDraw.text(.2 ,.2 , notes[counter]);
	         	        if(counter + 1 < notes.length) {
	         	        	counter ++; 
	         	        }
            		}

            	}
                
            }
            // compute the superposition of the samples
            for (int i = 0; i < array.length; i++)
            {
            	sample = sample + array[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);
            
            
            // advance the simulation of each guitar string by one step
            for (int idx = 0; idx < array.length; idx++)
            {
            	array[idx].tic();
            }
            
            
        }
	}

}
