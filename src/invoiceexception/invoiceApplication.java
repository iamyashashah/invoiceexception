package invoiceexception;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;


public class invoiceApplication {
	static Scanner sc = new Scanner(System.in);
	static double [] taxrate = new double[100];
	static double [] prices = new double[10];
	static double [] totalitem = new double[10];
	static double noOfitem;
	static double tax = 0.5;

	public static void main(String[] args) {
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);

		System.out.println("Welcom to invoice Application");
		for (int i=0;i<totalitem.length;i++)
		{
			totalitem[i]=0;
		}
		bill();
	}

	public static void bill ()
	{
		double taxrate = 0;
		double price = 0;
		int i = 0;
		int count = 0;
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);


		double subtotal = 0, taxamount = 0, grandtotal = 0;
		date();

		do 
		{
	try {
		System.out.println("enter the price of item :");
		price = sc.nextDouble();
		
	}catch (java.util.InputMismatchException e) {
		System.out.println("invalid number!");	
	}
	finally {
		prices [count] = price;
		if (price != 0.0)
		{
		count++;
		}
		else
			
		subtotal += prices[i];
	}
		
			
		
		}while (price != 0.0);

			
			try
			{
				System.out.println("enter the tax rate :");
				taxrate = sc.nextDouble();
				taxamount = ((subtotal * taxrate)/100);

				grandtotal = subtotal + taxamount;
				//catch the most specific exception first	
			}catch (java.util.InputMismatchException e)
			{
				System.out.println("invalid number!");
				System.out.println("tax %" + tax);
				taxrate = tax;
				taxamount = ((subtotal * taxrate)/100);

				grandtotal = subtotal + taxamount;
				//an IO exception is more general... maybe the drive is corrupt
			}


			finally {
				System.out.println("-----Receipt-----");
				for (i = 0; i < count; i++)
				{
					System.out.println(" " + nf.format(prices[i])); 
				}
				System.out.println("sub total = " + nf.format(subtotal));
				System.out.println("tax amount : " + nf.format(taxamount));
				System.out.println("grand total:  " + nf.format(grandtotal));
			}
			

			
	}
			

	public static void date () {
		// Instantiate a Date object
		Date date = new Date();

		// display time and date using toString()
		System.out.println(date.toString());
	}

}

