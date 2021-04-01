package domain.services;

import java.util.Calendar;
import java.util.Date;

import domain.entities.Contract;
import domain.entities.Installment;

public class InstallmentService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public InstallmentService() {
	}

	
	public InstallmentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	
	public void generateInstallment(Contract contract, int months) {
		double totalValue = contract.getTotalValue();
		Date baseDate = contract.getDate();
		double baseAmount = totalValue / months;
		
		
		for (int i=1; i <= months; i++) {
			baseDate = addMonths(contract.getDate(), i);
			double interest = onlinePaymentService.interest(baseAmount, i);
			double baseFeeAmount = baseAmount + interest;
			double paymentFee = onlinePaymentService.paymentFee(baseFeeAmount);
			
			double amount = baseAmount + interest + paymentFee;
			
			
			contract.addInstallment(new Installment(baseDate, amount));
		}
	}
	
	private Date addMonths(Date baseDate, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(baseDate);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
