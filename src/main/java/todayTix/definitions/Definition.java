package todayTix.definitions;


import todayTix.logs.Log;

import static todayTix.logs.Log.writeOperationExeption;

public abstract class Definition {

    protected void execute(String name, Runnable method) {
        Log.writeOperationStarted(name);
        try {
            method.run();
            Log.writeOperationCompleted();
        } catch (Exception e) {
            writeOperationExeption(e);
        }
    }
}
