package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class DeveloperData implements ApplicationRunner {
  MemberRepository memberRepository;
  CarRepository carRepository;


  public DeveloperData(MemberRepository memberRepository, CarRepository carRepository) {
    this.memberRepository = memberRepository;
    this.carRepository = carRepository;
  }




  private final String passwordUsedByAll = "test12";


  @Override
  public void run(ApplicationArguments args) throws Exception {
    Member m1 = new Member("member1", passwordUsedByAll, "memb1@a.dk", "Kurt", "Wonnegut", "Lyngbyvej 2", "Lyngby", "2800");
    Member m2 = new Member("member2", passwordUsedByAll, "aaa@dd.dk", "Hanne", "Wonnegut", "Lyngbyvej 2", "Lyngby", "2800");
    m1.setFavoriteCarColors(Arrays.asList("Green", "Yellow"));
    m1.setPhones(Map.of("Home", "2323", "Work", "123456"));
    m2.setFavoriteCarColors(Arrays.asList("Blue", "Red"));
    m2.setPhones(Map.of("Home", "4040404", "Work", "80808080"));


    memberRepository.save(m1);
    memberRepository.save(m2);
    Car c1 = new Car("Ford", "Fiesta", 2000, 80);
    Car c2 = new Car("Citroen", "c1", 1000, 30);
    carRepository.save(c1);
    carRepository.save(c2);

  }

}
