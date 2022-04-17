package todayTix.adapters;

public class AvailableTickets extends AutomatedBaseService {

    public void ticketsExist() {
        get("/1/from/20220418/to/20220425?param=5feb92a5-86a7-4f86-aaa0-9b90d63cbfee");
    }
}
