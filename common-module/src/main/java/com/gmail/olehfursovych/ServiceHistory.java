package com.gmail.olehfursovych;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service_history")
public class ServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int historyId;

    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Person personnel;

    @Column(name = "service_date")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;

    @Column(name = "notes")
    private String notes;
}
