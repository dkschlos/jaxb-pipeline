package com.github.dkschlos.pipeline.filter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveRecordsWithValueGreaterThanFilter implements Filter {
    @XmlAttribute
    private int threshold = 0;


    @Override
    public void filter(FilterContext context) {
        context.getRecords().stream().filter(r -> r.getValue() > threshold).forEach(context::remove);
    }
}
