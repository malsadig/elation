package org.mossab.elationhealth.enums;

/**
 * Created by mossab on 9/6/17.
 *
 * The "command line" commands to keep the program going and get inputs.
 *
 * @author: mossab
 */
public enum Commands {
    UPDATE("update"),
    RESULT("result"),
    TEST_RUNNER("testrunner"),
    UNKNOWN("help");

    private final String commandString;

    Commands(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }

    public static Commands parseCommand(String cmdString) {
        for (Commands command : Commands.values()) {
            if (cmdString.equals(command.getCommandString())) {
                return command;
            }
        }
        return UNKNOWN;
    }
}
