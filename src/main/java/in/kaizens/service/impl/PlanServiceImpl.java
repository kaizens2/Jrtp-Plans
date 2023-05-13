package in.kaizens.service.impl;

import in.kaizens.entity.Plan;
import in.kaizens.entity.PlanCategory;
import in.kaizens.repository.PlanCategoryRepo;
import in.kaizens.repository.PlanRepo;
import in.kaizens.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {
    private final PlanRepo planRepo;
    private final PlanCategoryRepo planCategoryRepo;

    public PlanServiceImpl(PlanRepo planRepo, PlanCategoryRepo planCategoryRepo) {
        this.planRepo = planRepo;
        this.planCategoryRepo = planCategoryRepo;
    }

    @Override
    public Map<Integer, String> getPlanCategory() {
        List<PlanCategory> categoryList = planCategoryRepo.findAll();
        Map<Integer, String> categoryMap = new HashMap<>();
        categoryList.forEach(category ->
                categoryMap.put(category.getCategoryId(), category.getCategoryName())
        );
        return categoryMap;
    }

    @Override
    public boolean upsertPlan(Plan plan) {
        Plan save = planRepo.save(plan);
        return save.getPlanId() != null;
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepo.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> byId = planRepo.findById(planId);
        return byId.isPresent() ? byId.get() : null;
    }

    @Override
    public boolean deletePlanById(Integer planId) {
        boolean status = false;
        try {
            planRepo.deleteById(planId);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean softDelete(Integer planId, String status) {
        Optional<Plan> byId = planRepo.findById(planId);
        if (byId.isPresent()) {
            Plan plan = byId.get();
            plan.setActiveSw(status);
            planRepo.save(plan);
            return true;
        }
        return false;
    }
}
