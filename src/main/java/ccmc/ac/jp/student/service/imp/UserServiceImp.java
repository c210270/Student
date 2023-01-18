package ccmc.ac.jp.student.service.imp;

import ccmc.ac.jp.student.entity.User;
import ccmc.ac.jp.student.payload.request.CreateUserReq;
import ccmc.ac.jp.student.payload.request.UpdateUserReq;
import ccmc.ac.jp.student.reppository.IUserRepo;
import ccmc.ac.jp.student.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public List<User> getAll() {
        return iUserRepo.findAll();
    }

    @Override
    public User create(CreateUserReq req) {
//       check username da ton tai hay chua, neu chua thi tao, neu co thi bao loi
        Optional<User> userOp = iUserRepo.findByUserName(req.getUsername());
        if(userOp.isPresent()) {
            return null;
        }
        User newUser = new User();
        newUser.setUserName(req.getUsername());
        newUser.setName(req.getName());
        newUser.setPassword(DigestUtils.md5Hex(req.getPassword()));
        newUser.setAge(req.getAge());
        newUser.setGrade(req.getGrade());
        return iUserRepo.save(newUser);
    }

    @Override
    public User update(UpdateUserReq req) {
        Optional<User> userOp = iUserRepo.findByUserName(req.getUserName());
        if (userOp.isPresent()){
            User user = userOp.get();
            user.setName(req.getName());
            user.setPassword(DigestUtils.md5Hex(req.getPassword()));
            user.setAge(req.getAge());
            user.setGrade(req.getGrade());
            return iUserRepo.save(user);
        }

        return null;
    }



    // ham delete, ham view
    @Override
    public Boolean delete(String userName) {
        Optional<User> user = iUserRepo.findByUserName(userName);
        if(user.isPresent()){
            iUserRepo.deleteUserByUserName(userName);
            return true;
        }
        return null;
    }

    @Override
    public List<User> view(String userName) {
        Optional<User> userDetail = iUserRepo.findByUserName(userName);
        if(userDetail.isPresent()){
           return iUserRepo.userDetail(userName);
        }
        return null;
    }

}
