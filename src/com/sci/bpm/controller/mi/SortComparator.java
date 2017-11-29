package com.sci.bpm.controller.mi;

import com.sci.bpm.db.model.SciMatindMaster;

import java.util.Comparator;

public class SortComparator implements Comparator<SciMatindMaster> {
    @Override
    public int compare(SciMatindMaster m1, SciMatindMaster m2) {

        if (m1.getInsertedDate() != null && m2.getInsertedDate() != null) {
            if (m1.getInsertedDate().after(m2.getInsertedDate())) {
                return -1;
            } else {
                return 1;
            }

        } else {
            return 0;
        }

    }
}
