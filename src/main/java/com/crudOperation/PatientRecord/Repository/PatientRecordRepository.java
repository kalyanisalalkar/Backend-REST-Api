package com.crudOperation.PatientRecord.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudOperation.PatientRecord.Model.PatientRecord;

@Repository
public interface PatientRecordRepository  extends JpaRepository<PatientRecord, Long>{

}
