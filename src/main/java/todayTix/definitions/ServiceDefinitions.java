package todayTix.definitions;

import lombok.RequiredArgsConstructor;
import todayTix.adapters.AvailableTickets;


@RequiredArgsConstructor
public class ServiceDefinitions extends Definition {
    private final AvailableTickets availableTickets;

    public void requestAvailability(String quantity, String fromDate, String toDate, String headerValue) {
        execute("Consuming availability service", () -> {
            availableTickets.ticketsExist(quantity, fromDate, toDate, headerValue);
        });
    }

    public void statusCodeValidation(int statusExpected) {
        execute("Validating status code", () -> {
            availableTickets.codeValidation(statusExpected);
        });
    }

    public void minPriceValidation() {
        execute("Validation if the min price of all results for this product aren't null", availableTickets::minPriceValidations);
    }
}
