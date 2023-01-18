package ccmc.ac.jp.student.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserReq {
    private String username;
    private String name;
    private Integer age;
    private String grade;
    private String password;
}
