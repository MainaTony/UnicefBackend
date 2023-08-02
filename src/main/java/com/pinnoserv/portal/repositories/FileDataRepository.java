package com.pinnoserv.portal.repositories;

import com.pinnoserv.portal.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
