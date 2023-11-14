
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
		// the user types this character
        char key = StdDraw.nextKeyTyped();
		while (true)
		{
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped())
            {
                // pluck the corresponding string
                array[keyboard.indexOf(key)].pluck();
                
            }
            // compute the superposition of the samples
            double sample = array[keyboard.indexOf(key)].sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            array[keyboard.indexOf(key)].tic();
        }
	}

}
