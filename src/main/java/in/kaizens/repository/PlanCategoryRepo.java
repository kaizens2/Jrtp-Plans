package in.kaizens.repository;

import in.kaizens.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer> {
}
