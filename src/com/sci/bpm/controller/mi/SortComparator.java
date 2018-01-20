package com.sci.bpm.controller.mi;

import com.sci.bpm.db.model.SciMatindMaster;

import java.util.Comparator;

public class SortComparator implements Comparator<SciMatindMaster> {
    @Override
    public int compare(SciMatindMaster m1, SciMatindMaster m2) {

      return m1.getInsertedDate().compareTo(m2.getInsertedDate());

    }
}
