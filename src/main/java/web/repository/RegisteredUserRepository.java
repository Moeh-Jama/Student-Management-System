package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Util.RegisteredUser;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

    @Query(value="Select ru.isStaff from registered_user ru where ru.user_id = ?1", nativeQuery =true)
    Boolean isRegisteredUserStaffType(Integer id);
}
