package com.github.dkschlos.pipeline.filter.source;

import com.github.dkschlos.pipeline.filter.Filter;
import com.github.dkschlos.pipeline.filter.FilterContext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadFakeRecordsFilter implements Filter {
    @XmlElement(name = "record")
    private List<FakeRecord> records;

    @Override
    public void filter(FilterContext context) {
        if (records != null) {
            for (FakeRecord fakeRecord : records) {
                context.add(fakeRecord.toRecord());
            }
        }

    }
}
