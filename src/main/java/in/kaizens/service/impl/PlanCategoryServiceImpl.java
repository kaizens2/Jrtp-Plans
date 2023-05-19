package in.kaizens.service.impl;

import in.kaizens.entity.PlanCategory;
import in.kaizens.repository.PlanCategoryRepo;
import in.kaizens.service.PlanCategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanCategoryServiceImpl implements PlanCategoryService {

    private PlanCategoryRepo planCategoryRepo;

    public PlanCategoryServiceImpl(PlanCategoryRepo planCategoryRepo) {
        this.planCategoryRepo = planCategoryRepo;
    }

    @Override
    public boolean upsert(PlanCategory planCategory) {
        PlanCategory save = planCategoryRepo.save(planCategory);
        return save.getCategoryId() != null;
    }

    @Override
    public boolean softDelete(Integer id, String status) {
        Optional<PlanCategory> category = planCategoryRepo.findById(id);
        if (category.isPresent()) {
            PlanCategory planCategory = category.get();
            planCategory.setActiveSw(status);
            planCategoryRepo.save(planCategory);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePlanCategoryById(Integer id) {
        boolean status = false;
        try {
            planCategoryRepo.deleteById(id);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public PlanCategory getPlanCategoryById(Integer id) {
        Optional<PlanCategory> byId = planCategoryRepo.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }
}
