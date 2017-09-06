package org.mossab.elationhealth.lab;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by mossab on 9/6/17.
 *
 * Simple POJO to store the parsed lab results from file.
 *
 * @author: mossab
 */
public class LabResult {
    private Date date;
    private String name;
    private Long value;

    @SerializedName("patient_id")
    private Long patientId;

    @SerializedName("result_id")
    private Long resultId;

    public LabResult() {
    }

    public LabResult(Date date, Long resultId, String name, Long value, Long patientId) {
        this.date = date;
        this.resultId = resultId;
        this.name = name;
        this.value = value;
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabResult labResult = (LabResult) o;

        return resultId != null ? resultId.equals(labResult.resultId) : labResult.resultId == null;
    }

    @Override
    public int hashCode() {
        return resultId != null ? resultId.hashCode() : 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
