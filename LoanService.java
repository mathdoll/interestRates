package pkg;

import org.apache.commons.lang3.StringUtils;

public class LoanService {

    private UserService userService = new UserService();
    private CreditScoreServiceEquifax equifax = new CreditScoreServiceEquifax();
    private CreditScoreServiceExperian experian = new CreditScoreServiceExperian();
    private MissedPaymentService missedPaymentService = new MissedPaymentService();

    /**
     * Only allows in month 6, 12, 24, 36, 48, 60
     * @param username
     * @param durationInMonth
     * @return
     */
    public int getInterestRate(String username, int durationInMonth) {

        if (durationInMonth != 6 &&
            durationInMonth != 12 &&
            durationInMonth != 24 &&
            durationInMonth != 36 &&
            durationInMonth != 48 &&
            durationInMonth != 60  ){
            throw new RuntimeException("Bad Request.....");
        }

        int intRate;

        // first find the user's SSN
        String ssn = userService.getSSN(username);

        if (StringUtils.isBlank(ssn)) {
            throw new RuntimeException("Could not find user.");
        }

        //ssn is called fico too
        int ficoEquifax = equifax.getFico(ssn);
        int ficoExperian = experian.getFico(ssn);
        int missedPayment6Months = missedPaymentService.missedPayment(6);
        int missedPayment12Months = missedPaymentService.missedPayment(12);
        int missedPayment24Months = missedPaymentService.missedPayment(24);


        // lets deal with Credit Score
        if (ficoEquifax > 800 && ficoExperian > 800) {
            intRate = 10;
        } else if (ficoEquifax > 750 && ficoExperian > 750) {
            intRate = 11;
        } else if (ficoEquifax > 650 && ficoExperian > 650) {
            intRate = 12;
        } else if (ficoEquifax > 600 && ficoExperian > 600) {
            intRate = 13;
        } else {
            intRate = 36;
        }

        // lets deal with Missed Payment
        if (missedPayment24Months > 2) {
            intRate++;
        } else {
            intRate--;
        }
        if (missedPayment12Months > 1) {
            intRate++;
        } else {
            intRate--;
        }
        if (missedPayment6Months > 0) {
            intRate++;
        } else {
            intRate--;
        }

        //lets assume that is for a six month intrest

        // finally lets see the duration
        if (durationInMonth == 12){
            intRate--;
        } else if (durationInMonth == 24){
            intRate = intRate -2;
        }else if (durationInMonth == 36){
            intRate = intRate -3;
        }else if (durationInMonth == 48){
            intRate = intRate -4;
        }else if (durationInMonth == 60){
            intRate = intRate -5;
        }

        return intRate;

    }

}
