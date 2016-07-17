package com.github.dkschlos.pipeline;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class PipelineExampleUsage {
    @Test
    public void exampleUsage() throws IOException {
        try(InputStream inputStream = getClass().getResourceAsStream("/pipeline.xml")){
            Pipeline pipeline = Pipeline.create(inputStream);
            pipeline.run();
        }
    }
}
