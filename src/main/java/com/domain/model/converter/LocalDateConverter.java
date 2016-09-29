package com.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by nishina on 2016/09/29.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return date == null ? null : Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return value == null ? null : value.toLocalDate();
    }
}
