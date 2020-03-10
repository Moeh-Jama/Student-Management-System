package web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Util.Module;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {


//    @Query(value="Select * from module m LEFT JOIN enrolled_modules_students ems ON m.module_id=ems.ems_module_id WHERE ems.ems_student_id=?1", nativeQuery =true)
//    List<Module> getAllRegisteredModules(Long studentID);
//
    @Query(value="Select * from module m where m.end_date > CURDATE()", nativeQuery = true)
    List<Module> getAllAvailableModules(Long studentID);
}
