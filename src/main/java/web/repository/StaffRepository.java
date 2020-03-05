package web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Util.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
    @Query("SELECT COUNT(s)  FROM Staff  AS s where s.gender = 'male'")
    public Long countMaleStaff();
}
