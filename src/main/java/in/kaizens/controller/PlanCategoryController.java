package in.kaizens.controller;

import in.kaizens.constants.AppConstants;
import in.kaizens.entity.PlanCategory;
import in.kaizens.service.PlanCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class PlanCategoryController {

    private PlanCategoryService planCategoryService;

    public PlanCategoryController(PlanCategoryService planCategoryService) {
        this.planCategoryService = planCategoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePlanCategory(@RequestBody PlanCategory planCategory) {
        String msg = AppConstants.EMP_STR;
        boolean isSaved = planCategoryService.upsert(planCategory);
        msg = isSaved ? AppConstants.PLAN_CATEGORY_SAVE_SUCC : AppConstants.PLAN_CATEGORY_SAVE_FAIL;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePlanCategory(@RequestBody PlanCategory planCategory) {
        String msg = AppConstants.EMP_STR;
        boolean isSaved = planCategoryService.upsert(planCategory);
        msg = isSaved ? AppConstants.PLAN_CATEGORY_UPDATE_SUCC : AppConstants.PLAN_CATEGORY_UPDATE_FAIL;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/planCategory/{categoryId}")
    public ResponseEntity<String> deletePlanCategory(@PathVariable Integer categoryId) {
        String msg = AppConstants.EMP_STR;
        boolean isSaved = planCategoryService.deletePlanCategoryById(categoryId);
        msg = isSaved ? AppConstants.PLAN_CATEGORY_DELETE_SUCC : AppConstants.PLAN_CATEGORY_DELETE_FAIL;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{categoryId}/{status}")
    public ResponseEntity<String> changeStatus(@PathVariable Integer categoryId,@PathVariable String status) {
        String msg = AppConstants.EMP_STR;
        boolean isSaved = planCategoryService.softDelete(categoryId,status);
        msg = isSaved ? AppConstants.PLAN_CATEGORY_STATUS_CHANGE : AppConstants.PLAN_CATEGORY_STATUS_CHANGE_FAIL;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
