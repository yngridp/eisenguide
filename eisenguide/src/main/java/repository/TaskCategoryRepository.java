package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.TaskCategory;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long>{

		List<TaskCategory> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String Descricao);
}
