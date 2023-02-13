package dat3.car.service;

import dat3.car.dto.CarResponse;
import dat3.car.dto.MemberResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository){
    this.carRepository = carRepository;
  }

  public List<CarResponse> getMembers(boolean includeAll) {
    List<Car> cars = carRepository.findAll();

    List<CarResponse> carResponses = cars.stream().map((m)->new CarResponse(m,includeAll)).toList();
    return carResponses;
  }
}
