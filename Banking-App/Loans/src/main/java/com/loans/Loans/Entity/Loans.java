package com.loans.Loans.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loans extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNo;

    @Column(name = "loan_number")
    private String loanNo;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "Total loan")
    private Integer totalLoan;

    @Column(name = "amoutnt paid")
    private Integer amountPaid;

    @Column(name = "out_standing_amount")
    private Integer outStandingAmount;

}
