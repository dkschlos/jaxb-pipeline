package com.github.dkschlos.pipeline;

import org.slf4j.helpers.MessageFormatter;

public final class Form {
    private Form(){

    }

    public static String at(String template, Object... params){
        MessageFormatter messageFormatter = new MessageFormatter();
        return messageFormatter.arrayFormat(template, params).getMessage();
    }
}
