package com.nfc.portal.module;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String getEn(String code) {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);

        return accessor.getMessage(code);
    }
    public String getAr(String code) {
        accessor = new MessageSourceAccessor(messageSource, new Locale("ar"));

        return accessor.getMessage(code);
    }
    

}
