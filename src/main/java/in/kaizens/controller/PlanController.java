package in.kaizens.controller;

import in.kaizens.constants.AppConstants;
import in.kaizens.entity.Plan;
import in.kaizens.props.AppProperties;
import in.kaizens.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlanController {
    private final PlanService planService;
    private Map<String, String> message;

    public PlanController(PlanService planService, AppProperties appProperties) {

        this.planService = planService;
        this.message = appProperties.getMessage();
    }


    @GetMapping("/category")
    public ResponseEntity<Map<Integer, String>> planCategory() {
        return new ResponseEntity<>(planService.getPlanCategory(), HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        boolean isSaved = planService.upsertPlan(plan);
        String msg = AppConstants.EMP_STR;
        if (isSaved) {
            msg = message.get(AppConstants.PLAN_SAVE_SUCC);
        } else {
            msg = message.get(AppConstants.PLAN_SAVE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> plans() {
        return new ResponseEntity<>(planService.getAllPlan(), HttpStatus.OK);
    }

    @GetMapping("/Plan/{planId}")
    public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
        return new ResponseEntity<>(planService.getPlanById(planId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
        boolean isUpdated = planService.upsertPlan(plan);
        String msg = AppConstants.EMP_STR;
        if (isUpdated) {
            msg = message.get(AppConstants.PLAN_UPDATE_SUCC);
        } else {
            msg = message.get(AppConstants.PLAN_UPDATE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
        boolean isDeleted = planService.deletePlanById(planId);
        String msg = AppConstants.EMP_STR;
        if (isDeleted) {
            msg = message.get(AppConstants.PLAN_DELETE_SUCC);
        } else {
            msg = message.get(AppConstants.PLAN_DELETE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status) {
        boolean isStatusChanges = planService.softDelete(planId, status);
        String msg = AppConstants.EMP_STR;
        if (isStatusChanges) {
            msg = message.get(AppConstants.PLAN_STATUS_CHANGE);
        } else {
            msg = message.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
