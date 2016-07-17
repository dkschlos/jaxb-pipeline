package com.github.dkschlos.pipeline.filter.source;

import com.github.dkschlos.pipeline.domain.Record;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class FakeRecord {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public Record toRecord(){
        return new Record(name, value);
    }
}
