package ccmc.ac.jp.student.service;

import ccmc.ac.jp.student.entity.User;
import ccmc.ac.jp.student.payload.request.CreateUserReq;
import ccmc.ac.jp.student.payload.request.UpdateUserReq;
import ccmc.ac.jp.student.reppository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User create(CreateUserReq req);

    User update(UpdateUserReq req);

    // ham delete, ham view
    Boolean delete(String userName);

    List<User> view(String userName);
}
