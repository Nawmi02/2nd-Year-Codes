public class Job implements Runnable {
	
	 private boolean isEven;
	    private int min, max;

	    public Job(boolean isEven, int min, int max) 
	    {
	        this.isEven = isEven;
	        this.min = min;
	        this.max = max;
	    }

	    @Override
	    public void run() 
	    {
	        for (int i = min; i <= max; i++) 
	        {
	            if ((i % 2 == 0 && isEven==true) || (i % 2 != 0 && isEven==false)) 
	            {
	                System.out.println(Thread.currentThread().getName() + ": " + i);
	            }
	        }
	    }

}

