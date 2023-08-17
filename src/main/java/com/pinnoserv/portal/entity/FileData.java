package com.pinnoserv.portal.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "image_data")
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name")
    private String name;
    @Column(name = "file_type")
    private String type;
    @Column(name = "file_path")
    private String imagePath;
    @Column(name = "file_status")
    private int status;
}
