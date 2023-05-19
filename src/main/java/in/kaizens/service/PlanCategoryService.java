package in.kaizens.service;

import in.kaizens.entity.PlanCategory;

public interface PlanCategoryService {
    public boolean upsert(PlanCategory planCategory);
    public boolean softDelete(Integer id,String Status);
    public boolean deletePlanCategoryById(Integer id);
    public PlanCategory getPlanCategoryById(Integer id);
}
