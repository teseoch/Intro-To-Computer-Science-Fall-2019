class GOL {
	public static void print(boolean[][] grid)
	{
		final char ALIVE = '\u2B1B';
		final String DEAD = "  ";

		//assume gird is squared!
		int n = grid.length;

		for (int i = 0; i < n ; ++i ) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j])
					System.out.print(ALIVE);
				else
					System.out.print(DEAD);
			}
			System.out.println();
		}
	}

	public static boolean get_alive(boolean[][] grid, int i, int j)
	{
		int n = grid.length;
		//i > -n
		int tmpi = (i+n)%n;
		int tmpj = (j+n)%n;

		return grid[tmpi][tmpj];
	}

	public static int count_alive_n(boolean[][] grid, int i, int j)
	{
		int count = 0;

		for(int x = i - 1; x <= i + 1; ++x)
		{
			for(int y = j - 1; y <= j + 1; ++y)
			{
				if(x == i && y == j)
					continue;

				if(get_alive(grid, x, y))
					++count;
			}
		}

		return count;
	}

	public static void init_rand(boolean[][] grid, double alive_perc)
	{
		int n = grid.length;

		for (int i = 0; i < n ; ++i ) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = Math.random() < alive_perc;
			}
		}
	}

	public static void update(boolean[][] grid)
	{
		int n = grid.length;
		boolean[][] newGrid = new boolean[n][n];

		for (int i = 0; i < n ; ++i ) {
			for (int j = 0; j < n; j++) {
				int nAlive = count_alive_n(grid, i, j);

				if(grid[i][j])
				{
					if(nAlive < 2)
						newGrid[i][j] = false;
					if(nAlive == 2 || nAlive == 3)
						newGrid[i][j] = true;
					else //nAlive > 3
						newGrid[i][j] = false;
				}
				else
				{
					if(nAlive == 3)
						newGrid[i][j] = true;
					else
						newGrid[i][j] = false;
				}
			}
		}

		for (int i = 0; i < n ; ++i ) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = newGrid[i][j];
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		//true is alive
		int n = 100;

		boolean[][] grid = new boolean[n][n];
		init_rand(grid, 0.2);

		// grid[0][0] = true;
		// grid[1][0] = true;
		// grid[0][1] = true;
		// grid[1][1] = true;

		while(true)
		{
			print(grid);
			update(grid);
			Thread.sleep(200);

			System.out.print("\033[H\033[2J");
  			System.out.flush();
		}

	}
}