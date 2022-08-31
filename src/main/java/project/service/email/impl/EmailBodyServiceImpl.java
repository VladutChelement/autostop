package project.service.email.impl;

import org.springframework.stereotype.Service;
import project.entity.MyUser;
import project.service.email.EmailBodyService;

@Service
public class EmailBodyServiceImpl implements EmailBodyService {

    @Override
    public String emailBody(MyUser myUser) {
        return "Hello," +
                "In order to activate your account please access the following link:\n" +
                "http://localhost:8080/activation/" + myUser.getRandomToken();
    }
}
