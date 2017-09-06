package org.mossab.elationhealth.lab;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mossab on 9/6/17.
 *
 * Simple return POJO after getting the previous three search results.
 *
 * @author: mossab
 */
public class SearchResult {
    @SerializedName("result_id")
    private Long resultId;

    @SerializedName("last_three_values")
    private List<LabResult> lastThreeValues = new ArrayList<>();

    public SearchResult() {
    }

    public SearchResult(Long resultId) {
        this.resultId = resultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchResult that = (SearchResult) o;

        return resultId != null ? resultId.equals(that.resultId) : that.resultId == null;
    }

    @Override
    public int hashCode() {
        return resultId != null ? resultId.hashCode() : 0;
    }

    public Long getResultId() {
        return resultId;
    }

    public List<LabResult> getLastThreeValues() {
        return lastThreeValues;
    }

    public void setLastThreeValues(List<LabResult> lastThreeValues) {
        this.lastThreeValues = lastThreeValues;
    }
}
