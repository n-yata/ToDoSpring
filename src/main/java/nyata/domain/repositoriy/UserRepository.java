package nyata.domain.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.domain.model.User;

public interface UserRepository extends JpaRepository<User, String>{
}