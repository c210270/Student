package ccmc.ac.jp.student.controller;

import ccmc.ac.jp.student.entity.User;
import ccmc.ac.jp.student.payload.request.CreateUserReq;
import ccmc.ac.jp.student.payload.request.UpdateUserReq;
import ccmc.ac.jp.student.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/users")
    public List<User> getAll(){
        return userServiceImp.getAll();
    }

    @GetMapping("/userdetail")
    public List<User> userDetail(@RequestBody String userName){
        return userServiceImp.view(userName);

    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserReq> createUser(@RequestBody CreateUserReq req){
         userServiceImp.create(req);
        return ResponseEntity.ok(req);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserReq> updateUser(@RequestBody UpdateUserReq req){
        userServiceImp.update(req);
        return ResponseEntity.ok(req);
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody String userName){
        return userServiceImp.delete(userName);
    }
}
