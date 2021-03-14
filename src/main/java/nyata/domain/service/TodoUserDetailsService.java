package nyata.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nyata.domain.model.User;
import nyata.domain.repositoriy.UserRepository;

/**
 * ユーザー認証のサービス
 * @author nyata
 */
@Service
public class TodoUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getOne(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found.");
        }
        return new TodoUserDetails(user);
    }
}