package com.github.dkschlos.pipeline.filter;

import com.github.dkschlos.pipeline.domain.Record;

import java.util.List;

public interface FilterContext {
    List<Record> getRecords();

    void add(Record record);

    void remove(Record record);
}
