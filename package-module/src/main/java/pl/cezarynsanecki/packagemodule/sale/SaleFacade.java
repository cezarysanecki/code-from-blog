package pl.cezarynsanecki.packagemodule.sale;

import pl.cezarynsanecki.packagemodule.kernel.ProductId;
import pl.cezarynsanecki.packagemodule.sale.api.CannotSaleException;
import pl.cezarynsanecki.packagemodule.warehouse.WarehouseFacade;

public class SaleFacade {

  private final WarehouseFacade warehouseFacade;

  SaleFacade(final WarehouseFacade warehouseFacade) {
    this.warehouseFacade = warehouseFacade;
  }

  public void sale(ProductId productId) {
    boolean available = warehouseFacade.isAvailable(productId);
    if (!available) {
      throw new CannotSaleException(productId);
    }
    // some logic
  }

}
