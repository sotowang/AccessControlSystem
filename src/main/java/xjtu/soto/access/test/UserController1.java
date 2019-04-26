package xjtu.soto.access.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class UserController1 {
    @Autowired
    private UserRepository1 userRepository1;

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;


    //http://localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com
    @GetMapping(path = "/add")

    public void addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository1.save(n);
    }

    //    http://localhost:8080/demo/all
    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository1.findAll();
    }

    @GetMapping(path = "/info")
    @ResponseBody
    public User findOne(@RequestParam Long id) {
        return userRepository1.findOne(id);
    }

    @GetMapping(path = "delete")
    public void delete(@RequestParam Long id) {
        userRepository1.delete(id);
    }


    /**
     * 验证排序和分页查询方法
     * @return
     */
    @GetMapping(path="/page")
    @ResponseBody
    public Page<User> getAllUserByPage() {
        return userPagingAndSortingRepository.findAll(
                new PageRequest(1, 20, new Sort(new Sort.Order(Sort.Direction.ASC, "name")))
        );
    }

    /**
     * 排序查询
     * @return
     */
    @GetMapping(path="/sort")
    @ResponseBody
    public Iterable<User> getAllUsersWithSort() {
        return userPagingAndSortingRepository.findAll(
                new Sort(new Sort.Order(Sort.Direction.ASC, "name"))
        );
    }



}
