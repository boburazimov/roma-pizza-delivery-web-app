package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalog.Payment;
import uz.crm.system.entity.catalog.Restorant;
import uz.crm.system.entity.catalog.User;
import uz.crm.system.entity.template.AbEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDoc extends AbEntity {

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Date orderDate;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Restorant restorant;

    @OneToMany(mappedBy = "orderDoc")
    private List<OrderTableRow> orderTableRows;

    @OneToMany(mappedBy = "orderDoc")
    private List<Payment> payments;
}