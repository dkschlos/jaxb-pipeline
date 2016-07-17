package com.github.dkschlos.pipeline.filter;


import com.github.dkschlos.pipeline.domain.Record;

import java.util.ArrayList;
import java.util.List;

public class StandardFilterContext implements FilterContext {
    private List<Record> records = new ArrayList<>();

    @Override
    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    @Override
    public void add(Record record){
        records.add(record);
    }
    @Override
    public void remove(Record record){
        records.remove(record);
    }
}
