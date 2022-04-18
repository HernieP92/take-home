package todayTix.adapters;

public class AvailableTickets extends AutomatedBaseService {

    public void ticketsExist(String quantity, String fromDate, String toDate, String headerValue) {
        get("/".concat(quantity).concat("/from/").concat(fromDate).concat("/to/").concat(toDate)
                .concat("?param=5feb92a5-86a7-4f86-aaa0-9b90d63cbfee"), headerValue);
    }

    public void codeValidation(int statusExpected) {
        statusCodeValidation(statusExpected);
    }

    public void minPriceValidations() {
        minPriceValidation();
    }

    public void errorMessageHandling(String expectederrormessage) {
        errorMessage(expectederrormessage);
    }

}
