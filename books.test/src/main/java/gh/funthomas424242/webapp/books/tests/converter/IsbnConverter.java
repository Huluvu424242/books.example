package gh.funthomas424242.webapp.books.tests.converter;

import gh.funthomas424242.webapp.books.domain.types.ISBN;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.AsParameterConverter;
import org.jbehave.core.steps.ParameterConverters;

@Converter
public class IsbnConverter {

    @AsParameterConverter
    public ISBN convertPercent(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        String[] tokens = value.split("-");
        if (tokens.length != 5) {
            throw new ParameterConverters.ParameterConvertionFailed("Expected 2 tokens (amount and currency) but got " + tokens.length + ", value: " + value + ".");
        }

        return new ISBN(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
    }
}
