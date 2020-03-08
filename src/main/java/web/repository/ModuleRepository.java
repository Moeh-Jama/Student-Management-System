package web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Util.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
