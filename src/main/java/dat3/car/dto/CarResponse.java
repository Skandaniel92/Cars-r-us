package dat3.car.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
  Long id; //TODO i tvivl om denne skal med her?
  String brand;
  String model;
  double pricePrDay;

  int bestDiscount; //TODO i tvivl om denne skal med her?

  public CarResponse(Car car, boolean includeAll){
    this.id = car.getId();
    this.brand = car.getBrand();
    this.model = car.getModel();
    this.pricePrDay = car.getPricePrDay();
    if (includeAll){
      this.bestDiscount = car.getBestDiscount();
    }
  }

}
