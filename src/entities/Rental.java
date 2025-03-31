package entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rental {
	LocalDateTime checkin;
	LocalDateTime checkout;
	Double perHour;
	Double perDay;
	
	public Rental() {
		
	}

	public Rental(LocalDateTime checkin, LocalDateTime checkout, Double perHour, Double perDay) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.perHour = perHour;
		this.perDay = perDay;
	}

	public LocalDateTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public LocalDateTime getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}

	public Double getPerHour() {
		return perHour;
	}

	public void setPerHour(Double perHour) {
		this.perHour = perHour;
	}

	public Double getPerDay() {
		return perDay;
	}

	public void setPerDay(Double perDay) {
		this.perDay = perDay;
	}
	
	public Double calculateValue() {
		Double hoursDifference = Double.valueOf(Duration.between(checkin, checkout).toHours());
		Double total = 0.0;
		if (hoursDifference < 12) {
			double totalHour = perHour * (hoursDifference + 1);
			total = totalHour;
		}
		else if(hoursDifference < 24) {
			double totalHour = perDay * 1.0;
			total = totalHour;
		}
		Double dayDifference = Double.valueOf(Duration.between(checkin, checkout).toDays());
		if (dayDifference >= 1) {
			total = (dayDifference + 1) * perDay;
		}
		return total;
		
	}
	public Double getTax() {
		double tax = 0.0;
		if (calculateValue() < 100) {
			tax = (calculateValue() * 20 / 100);
		}
		else {
			tax = (calculateValue() * 15 / 100);
		}
		return tax;
	}
}