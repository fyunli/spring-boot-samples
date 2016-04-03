package li.fyunli.springboot.controller;

import li.fyunli.springboot.entity.Todo;
import li.fyunli.springboot.repository.TodoRepository;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fyunli on 16/4/2.
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Resource
    private TodoRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> list() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable Long id) {
        Todo todo = this.repository.findOne(id);
        if (todo == null) {
            throw new ObjectNotFoundException(id, Todo.class.toString());
        }
        return todo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Todo create(@RequestBody Todo entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass());
        return this.repository.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Todo update(@PathVariable Long id, @RequestBody Todo entity) {
        logger.debug("update() of id#{} with body {}", id, entity);
        return this.repository.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.repository.delete(id);
    }

}
