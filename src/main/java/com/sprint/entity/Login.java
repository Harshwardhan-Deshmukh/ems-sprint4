package com.sprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {
    @Id
    @SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_sequence"
    )
    private Long loginId;
    @Column(name = "username")
    private String loginUsername;
    @Column(name = "password")
    private String loginPassword;
    @Column(name = "loginstatus")
    private String loginStatus;

    @OneToOne(
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "empId"
    )
    private Employee employee;
}
