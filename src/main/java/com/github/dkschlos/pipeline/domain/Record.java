package com.github.dkschlos.pipeline.domain;

import com.github.dkschlos.supercsv.io.declarative.CsvField;
import com.github.dkschlos.supercsv.io.declarative.annotation.ConvertNullTo;
import com.github.dkschlos.supercsv.io.declarative.annotation.ParseInt;
import com.github.dkschlos.supercsv.io.declarative.constraint.annotation.NotNull;

/**
 * Some arbitrary record-type to filter.
 */
public class Record {
    @NotNull
    @CsvField(order = 0)
    private String name;

    @ConvertNullTo(value = "0", order = 0)
    @ParseInt(order = 1)
    @CsvField(order = 1)
    private int value;

    public Record(){
        // for SuperCSV
    }

    public Record(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + ", " + value;
    }
}
