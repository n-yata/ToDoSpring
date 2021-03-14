package nyata.domain.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import nyata.domain.model.User;

/**
 * ユーザー情報のリポジトリ
 * @author nyata
 */
public interface UserRepository extends JpaRepository<User, String> {
}