package in.kaizens.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "ACTIVE_SW")
    private String activeSw;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "CREATED_DATE", updatable = false)
    @UpdateTimestamp
    private Date createdDate;
    @Column(name = "UPDATED_DATE", insertable = false)
    @UpdateTimestamp
    private Date UpdatedDate;
}
