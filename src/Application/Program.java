package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Rental;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
		LocalDateTime checkin = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.print("Return (dd/MM/yyyy hh:ss): ");
		LocalDateTime checkout = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		System.out.print("Enter price per hour: ");
		Double perHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		Double perDay = sc.nextDouble();
		
		Rental rental = new Rental(checkin, checkout, perHour, perDay);
		
		System.out.println("INVOICE: ");
		System.out.println("Basic payment : " + rental.calculateValue());
		System.out.println("Tax: " + rental.getTax());
		System.out.println("Total payment: " + (rental.calculateValue() + rental.getTax()));
		
		
		//COMMIT AND PUSHING 17:16 PARA TESTAR
		
		
		//COMIT AND PUSHING 17:40 DO NOTEBOOK PARA TESTAR
	}

}
