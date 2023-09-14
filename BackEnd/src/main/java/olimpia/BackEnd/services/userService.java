package olimpia.BackEnd.services;

import olimpia.BackEnd.models.userModel;
import olimpia.BackEnd.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userService {
    @Autowired
    userRepository myRepo;

    public userModel getByUserName(String userName) {
        List<userModel> users = myRepo.findByUserName(userName);
        if (!users.isEmpty()) {
            return users.get(0); // Devuelve el primer usuario encontrado
        } else {
            return null; // Devuelve null si no se encuentra ningún usuario
        }
    }
}
