package org.mossab.elationhealth;

import org.mossab.elationhealth.lab.LabResult;
import org.mossab.elationhealth.lab.SearchResult;
import org.mossab.elationhealth.util.LabResultComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mossab on 9/6/17.
 * <p>
 * This is a class that is used to store all the lab results. It will then sort them
 * using the labresultcomparator, to get the results in order of date, name, and patient id
 * <p>
 * The find recents method is the crucial part of the code. it will return the previous three search results
 * for a given result id, by traversing the results list till it finds the labresult. it will then get the
 * three before it.
 *
 * @author: mossab
 */
public class LabResultList {
    private List<LabResult> results = new ArrayList<>();

    public void addResults(List<LabResult> results) {
        this.results.addAll(results);
        this.results.sort(new LabResultComparator());
    }

    public SearchResult findRecents(Long resultId) {
        int index = -1;

        for (int i = 0; i < this.results.size(); i++) {
            if (Objects.equals(this.results.get(i).getResultId(), resultId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        } else {
            SearchResult searchResult = new SearchResult(resultId);
            for (int i = index + 1; i < index + 4; i++) {
                if (i < this.results.size()) {
                    LabResult result = this.results.get(i);
                    searchResult.getLastThreeValues().add(result);
                }
            }
            return searchResult;
        }
    }

    public List<LabResult> getResults() {
        return results;
    }

    public void setResults(List<LabResult> results) {
        this.results = results;
    }
}
