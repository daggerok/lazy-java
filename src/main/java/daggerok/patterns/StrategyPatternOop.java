package daggerok.patterns;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.RoundingMode.HALF_EVEN;

public class StrategyPatternOop {

  interface Converter {
    public BigDecimal convert(final BigDecimal from);
  }

  public static abstract class AbstractConverter implements Converter {
    protected abstract BigDecimal conversionRate();
    @Override public BigDecimal convert(final BigDecimal value) {
      Objects.requireNonNull(value, "AbstractConverter.convert.null");
      final BigDecimal result = value.multiply(conversionRate());
      return toMoney(result);
    }
    private BigDecimal toMoney(final BigDecimal value) {
      Objects.requireNonNull(value, "AbstractConverter.toMoney.value.null");
      return value.setScale(2, HALF_EVEN);
    }
  }

  public static class UahToUsdConverter extends AbstractConverter {
    @Override
    protected BigDecimal conversionRate() {
      return BigDecimal.valueOf(1 / 28.01);
    }
  }

  public static class UsdToUahConverter extends AbstractConverter {
    @Override
    protected BigDecimal conversionRate() {
      return BigDecimal.valueOf(28.01);
    }
  }

  private StrategyPatternOop() { }
}
