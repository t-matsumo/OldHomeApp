package homeapp.repositry;

import org.springframework.data.repository.CrudRepository;

import homeapp.entity.Timer;

public interface TimerRepository extends CrudRepository<Timer, Long> {
}