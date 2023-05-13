package in.kaizens.service;

import in.kaizens.entity.Plan;

import java.util.List;
import java.util.Map;

public interface PlanService {
    public Map<Integer,String> getPlanCategory();
    public boolean upsertPlan(Plan plan);
    public List<Plan> getAllPlan();
    public Plan getPlanById(Integer planId);
    public boolean deletePlanById(Integer planId);
    public boolean softDelete(Integer planId,String status);

}
