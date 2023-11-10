package model.services;

public class PaypalService implements OnlinePaymentService {
    @Override
    public double paymentFee(double amount) {
        return amount * (2.0 / 100.0);
    }

    @Override
    public double interest(double amount, int months) {
        return amount * (1.0 / 100) * months;
    }
}
