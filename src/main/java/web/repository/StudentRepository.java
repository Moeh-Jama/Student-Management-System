package web.repository;
import web.model.Util.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT COUNT(s)  FROM Student  AS s where s.gender = 'male'")
    public Long countMaleStaff();
}
