package com.pinnoserv.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "file_metadata")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_url")
    private String fileUrl;
    @Column(name = "status")
    private int status;
    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "statement_report",
            referencedColumnName = "id"
    )
    private StatementReport statementReport;

}
