package pl.devcezz.mapstruct.decorator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SalaryService {

    private static final String SALARY_FORMAT = "%1$.2f€";
    private static final String SALARY_REGEX = "\\d+\\.\\d{2}";

    public String formatSalary(BigDecimal salary) {
        return String.format(Locale.US, SALARY_FORMAT, salary);
    }

    public BigDecimal extractSalary(String salary) {
        Pattern pattern = Pattern.compile(SALARY_REGEX);
        Matcher matcher = pattern.matcher(salary);
        BigDecimal result = matcher.find() ? new BigDecimal(matcher.group(0)) : BigDecimal.ZERO;
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
