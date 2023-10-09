package pl.cezarynsanecki.packagemodule.sale.api;

import pl.cezarynsanecki.packagemodule.kernel.ProductId;

public class CannotSaleException extends RuntimeException {
  public CannotSaleException(final ProductId productId) {
  }
}
