package li.fyunli.springboot.repository;

import li.fyunli.springboot.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fyunli on 16/4/2.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
