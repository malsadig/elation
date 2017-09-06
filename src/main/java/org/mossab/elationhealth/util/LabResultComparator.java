package org.mossab.elationhealth.util;

import org.mossab.elationhealth.lab.LabResult;

import java.util.Comparator;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class LabResultComparator implements Comparator<LabResult> {
    @Override
    public int compare(LabResult o1, LabResult o2) {
        if (o1.getPatientId() > o2.getPatientId()) {
            return 1;
        } else if (o1.getPatientId() < o2.getPatientId()) {
            return -1;
        } else {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return o2.getDate().compareTo(o1.getDate());
            }
        }
    }
}
