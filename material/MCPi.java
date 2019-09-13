public class MCPi {
	public static void main(String[] args)
	{
		long numHits = 0;
		long numTotal = 0;

		while(true)
		{
			double x = 2*Math.random()-1;
			double y = 2*Math.random()-1;

			double d = Math.sqrt(x*x + y*y);

			boolean inside = d <= 1;

			if(inside){
				++numHits;
			}
			numTotal++;

			//10 000 000
			if(numTotal % 10000000 == 0)
			{
				double pi = (4.0*numHits)/numTotal;
				System.out.println(pi);
			}

			// System.out.println(x + " " + y + " " + d + " inside " + inside);
		}

	}
}