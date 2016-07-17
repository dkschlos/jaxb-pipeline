package com.github.dkschlos.pipeline.filter;

import com.github.dkschlos.pipeline.domain.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FilterContextLogDecorator implements FilterContext {
    private Logger logger;
    private FilterContext underlying;

    public FilterContextLogDecorator(Class<? extends Filter> filterType, FilterContext underlying) {
        this.logger = LoggerFactory.getLogger(filterType);
        this.underlying = underlying;
    }

    public List<Record> getRecords() {
        return underlying.getRecords();
    }

    public void remove(Record record) {
        logger.info("Record removed: '{}'.", record);
        underlying.remove(record);
    }

    public void add(Record record) {
        logger.info("Record added: '{}'.", record);
        underlying.add(record);
    }
}
