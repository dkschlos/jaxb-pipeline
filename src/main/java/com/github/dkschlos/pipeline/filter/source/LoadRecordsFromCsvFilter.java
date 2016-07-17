package com.github.dkschlos.pipeline.filter.source;

import com.github.dkschlos.pipeline.Form;
import com.github.dkschlos.pipeline.domain.Record;
import com.github.dkschlos.pipeline.filter.Filter;
import com.github.dkschlos.pipeline.filter.FilterContext;
import com.github.dkschlos.supercsv.io.declarative.CsvDeclarativeBeanReader;
import org.supercsv.prefs.CsvPreference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadRecordsFromCsvFilter implements Filter {
    @XmlAttribute
    private String fileName;

    @XmlAttribute
    private char delimiter = ';';

    @XmlAttribute
    private String endOfLineSymbols = "\r\n";

    @XmlAttribute
    private char quoteSymbol = '\'';

    @Override
    public void filter(FilterContext context) {
        File file = new File(fileName);
        if(!file.exists()){
            throw new IllegalStateException(Form.at("Source file '{}' does not exist", fileName));
        }

        CsvPreference preference = new CsvPreference.Builder(quoteSymbol, delimiter, endOfLineSymbols).build();

        try(CsvDeclarativeBeanReader reader = new CsvDeclarativeBeanReader(new FileReader(fileName), preference)){
            Record record = null;
            while((record = reader.read(Record.class)) != null){
                context.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
