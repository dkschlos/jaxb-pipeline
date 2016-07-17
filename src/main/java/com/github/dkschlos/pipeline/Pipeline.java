package com.github.dkschlos.pipeline;

import com.github.dkschlos.pipeline.filter.Filter;
import com.github.dkschlos.pipeline.filter.FilterContextLogDecorator;
import com.github.dkschlos.pipeline.filter.RemoveRecordsWithValueGreaterThanFilter;
import com.github.dkschlos.pipeline.filter.StandardFilterContext;
import com.github.dkschlos.pipeline.filter.source.LoadFakeRecordsFilter;
import com.github.dkschlos.pipeline.filter.source.LoadRecordsFromCsvFilter;
import com.github.dkschlos.pipeline.filter.target.WriteToConsole;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pipeline")
public class Pipeline {
    @XmlElements({
            @XmlElement(name = "loadFakeRecords", type = LoadFakeRecordsFilter.class),
            @XmlElement(name = "loadRecordsFromCsv", type = LoadRecordsFromCsvFilter.class),
            @XmlElement(name = "removeRecordsWithValueGreaterThan", type = RemoveRecordsWithValueGreaterThanFilter.class),
            @XmlElement(name = "writeToConsole", type = WriteToConsole.class),
    })
    private List<Filter> filters = new ArrayList<>();

    public void run(){
        StandardFilterContext context = new StandardFilterContext();
        for(Filter filter : filters){
            filter.filter(new FilterContextLogDecorator(filter.getClass(), context));
        }
    }
    public static Pipeline create(InputStream inputStream) {
        try {
            JAXBContext context = JAXBContext.newInstance(Pipeline.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Pipeline) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
