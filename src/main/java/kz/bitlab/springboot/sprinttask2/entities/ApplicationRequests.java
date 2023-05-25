package kz.bitlab.springboot.sprinttask2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="app_requests")
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="courseName")
    private String courseName;

    @Column(name="commentary")
    private String commentary;

    @Column(name="phone")
    private String phone;

    @Column(name="handled")
    private boolean handled;

}
