package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Util.EnrolledModuleStudent;

import java.util.List;

@Repository
public interface EnrolledModuleStudentRepository  extends JpaRepository<EnrolledModuleStudent, Integer> {

    @Query(value="Select * from enrolled_module_students ems where ems.module_id = ?1", nativeQuery = true)
    List<EnrolledModuleStudent> getAllGradesOfModule(Integer module_id);

}
