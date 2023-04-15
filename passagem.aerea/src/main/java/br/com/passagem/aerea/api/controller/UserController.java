package br.com.passagem.aerea.api.controller;

import br.com.passagem.aerea.internal.entity.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public interface UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> retrieveAllUsers();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id);

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id);
}
