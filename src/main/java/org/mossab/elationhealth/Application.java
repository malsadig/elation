package org.mossab.elationhealth;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mossab.elationhealth.enums.Commands;
import org.mossab.elationhealth.lab.LabResult;
import org.mossab.elationhealth.lab.SearchResult;
import org.mossab.elationhealth.util.GsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class Application {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static LabResultList labResultList = new LabResultList();

    public static void main(String[] args) throws FileNotFoundException {
        readInitialResults();

        beginReadingCommands();

        System.out.println("Exiting...goodbye!");
    }

    public static void beginReadingCommands() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Enter a command (\"help\" for instructions)");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("")) {
                continue;
            }
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            switch (Commands.parseCommand(command)) {
                case TEST_RUNNER:
                    displayTestRunnerResults();
                    break;
                case UPDATE:
                    readUpdatedResults();
                    break;
                case RESULT:
                    System.out.println(">> Enter a result id to look up");
                    Long resultId = scanner.nextLong();
                    SearchResult searchResult = labResultList.findRecents(resultId);
                    System.out.println(gson.toJson(searchResult));
                    break;
                case UNKNOWN:
                    printInstructions();
            }
            System.out.println(">> Enter a command (\"help\" for instructions)");
        }
    }

    private static void displayTestRunnerResults() throws FileNotFoundException {
        List<SearchResult> resultsBeforeUpdate = new ArrayList<>();
        resultsBeforeUpdate.add(labResultList.findRecents(126L));
        resultsBeforeUpdate.add(labResultList.findRecents(10540L));
        resultsBeforeUpdate.add(labResultList.findRecents(1245L));
        System.out.println("Results before update (rd1):");
        System.out.println(gson.toJson(resultsBeforeUpdate));

        readUpdatedResults();

        List<SearchResult> resultsAfterUpdate = new ArrayList<>();
        resultsAfterUpdate.add(labResultList.findRecents(1245L));
        resultsAfterUpdate.add(labResultList.findRecents(119L));
        System.out.println("Results after update (rd2):");
        System.out.println(gson.toJson(resultsAfterUpdate));

        labResultList.getResults().clear();
        readInitialResults();
    }

    public static void printInstructions() {
        System.out.println("testrunner = This command will pretty print the results as seen in the rd1 and rd2 files");
        System.out.println("result = This command will take input (lab result id) and return the three most "
                + "recent lab results.");
        System.out.println("update = This command will load the new lab results json file, to read the updates.");
        System.out.println("exit = This command will exit the program.");
    }

    public static void readUpdatedResults() throws FileNotFoundException {
        System.out.println("Ingesting updated lab results...");
        readFile("new_lab_results.json");
        System.out.println("Done ingesting updated lab results!");
    }

    public static void readInitialResults() throws FileNotFoundException {
        System.out.println("Just a moment...ingesting initial lab results...");
        labResultList.getResults().clear();
        readFile("initial_lab_results.json");
        System.out.println("Done ingesting initial lab results!");
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        GsonReader reader = new GsonReader(gson, fileName);
        List<LabResult> results = reader.readFile();
        labResultList.addResults(results);
    }
}
