package com.github.dkschlos.pipeline.filter.target;

import com.github.dkschlos.pipeline.domain.Record;
import com.github.dkschlos.pipeline.filter.Filter;
import com.github.dkschlos.pipeline.filter.FilterContext;

public class WriteToConsole implements Filter {
    @Override
    public void filter(FilterContext context) {
        for(Record record : context.getRecords()){
            System.out.println(record);
        }
    }
}
