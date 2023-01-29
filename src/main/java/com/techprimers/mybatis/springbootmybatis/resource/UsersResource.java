package com.techprimers.mybatis.springbootmybatis.resource;

import com.techprimers.mybatis.springbootmybatis.mapper.UsersMapper;
import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/one")
    public List<Users> getOne() {
        Users users = new Users();
        users.setId(1);
        return usersMapper.findOne(users.getId());
    }

    @GetMapping("/insert")
    private List<Users> insert() {

        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(2333L);

        usersMapper.insert(users);

        return usersMapper.findAll();
    }

    @GetMapping("/update")
    private List<Users> updateUsers() {
        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(555L);
        usersMapper.update(users);

        return usersMapper.findAll();
    }

    @GetMapping("/delete")
    private List<Users> deleteUsers() {
        Users users = new Users();
        users.setName("Youtube");
        usersMapper.delete(users);

        return usersMapper.findAll();
    }
}
