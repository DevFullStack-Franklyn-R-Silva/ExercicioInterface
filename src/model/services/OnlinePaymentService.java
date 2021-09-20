package model.services;

public interface OnlinePaymentService {

	public double paymentFee(Double amount);

	public double interest(Double amount, Integer months);
}
