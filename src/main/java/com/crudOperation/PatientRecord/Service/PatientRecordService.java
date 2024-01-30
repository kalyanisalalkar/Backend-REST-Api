package com.crudOperation.PatientRecord.Service;

import java.util.List;

import com.crudOperation.PatientRecord.Model.PatientRecord;

public interface PatientRecordService {

	PatientRecord savePatient(PatientRecord patientRecord);

	PatientRecord updatePatientRecord(PatientRecord patientRecord, Long patientId);

	PatientRecord getPatientById(Long patientId);

	List<PatientRecord> getAllPAtientRecord();

	void deletePatient(Long pid);

}
