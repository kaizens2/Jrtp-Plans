package in.kaizens.controller;

import in.kaizens.entity.Plan;
import in.kaizens.service.PlanService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }


    @GetMapping("/category")
    @Operation(description = "get plan category")
    public ResponseEntity<Map<Integer, String>> planCategory() {
        return new ResponseEntity<>(planService.getPlanCategory(), HttpStatus.OK);
    }

    @PostMapping("/plan")
    @Operation(description = "save plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        boolean isSaved = planService.upsertPlan(plan);
        String msg;
        if (isSaved) {
            msg = "Plan Saved";
        } else {
            msg = "Plan Not Saved";
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    @Operation(description = "get all plans")
    public ResponseEntity<List<Plan>> plans() {
        return new ResponseEntity<>(planService.getAllPlan(), HttpStatus.OK);
    }

    @GetMapping("/Plan/{planId}")
    @Operation(description = "edit plan")
    public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
        return new ResponseEntity<>(planService.getPlanById(planId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    @Operation(description = "update plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
        boolean isUpdated = planService.upsertPlan(plan);
        String msg;
        if (isUpdated) {
            msg = "Plan Updated";
        } else {
            msg = "Plan Not Updated";
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/plan/{planId}")
    @Operation(description = "delete plan")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
        boolean isDeleted = planService.deletePlanById(planId);
        String msg;
        if (isDeleted) {
            msg = "Plan Deleted";
        } else {
            msg = "Plan Not Deleted";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    @Operation(description = "plan status change")
    public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status) {
        boolean isStatusChanges = planService.softDelete(planId, status);
        String msg;
        if (isStatusChanges) {
            msg = "Status Changed";
        } else {
            msg = "Status Not Changed";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
