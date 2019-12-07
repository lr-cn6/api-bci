package cl.globallogic.recruiting.apibci.service;

import cl.globallogic.recruiting.apibci.exception.ApiBciException;
import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.repository.UserRepository;
import cl.globallogic.recruiting.apibci.security.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static java.util.Collections.emptyList;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtToken jwtToken;

    @Override
    public User getUserRs(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User p) throws ApiBciException{
        User response;

        p.setId(UUID.randomUUID().toString());
        p.setActive(true);
        p.setToken(jwtToken.build(p));
        try {
            userRepository.save(p);
        }catch (Exception e){
            throw new ApiBciException(e);
        }

        response = userRepository.findById(p.getId()).get();
        response.setPassword(null);
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(email).get();
        if(Objects.isNull(u)){
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), emptyList());
    }
}
