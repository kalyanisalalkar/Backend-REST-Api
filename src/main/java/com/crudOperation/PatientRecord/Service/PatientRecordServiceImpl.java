package com.crudOperation.PatientRecord.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.PatientRecord.Exception.ResourceNotFoundException;
import com.crudOperation.PatientRecord.Model.PatientRecord;
import com.crudOperation.PatientRecord.Repository.PatientRecordRepository;

@Service
public class PatientRecordServiceImpl implements PatientRecordService {
	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
    //Save Operation
	
	@Override
	public PatientRecord savePatient(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}
	
	//Update Patient Record
	
	@Override
	public PatientRecord updatePatientRecord(PatientRecord patientRecord, Long patientId) {
		PatientRecord patientrecord = this.patientRecordRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("patientrecord ID " + patientId + "  not found !!"));

		patientrecord.setPatientName(patientRecord.getPatientName());
		patientrecord.setAge(patientRecord.getAge());
		patientrecord.setAddress(patientRecord.getAddress());
		PatientRecord updatePatient = this.patientRecordRepository.save(patientrecord);
		return updatePatient;

	}
	
	
    //get Patient By Id
	
	@Override
	public PatientRecord getPatientById(Long patientId) {
		PatientRecord patientRecord = this.patientRecordRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("patientrecord ID " + patientId + "  not found !!"));
		return patientRecord;
	}
	
     //get All PAtient Record
	
	@Override
	public List<PatientRecord> getAllPAtientRecord() {
		List<PatientRecord> patient = this.patientRecordRepository.findAll();

		return patient;
	}
	//Delete Patient By ID

	@Override
	public void deletePatient(Long patientId) {

		PatientRecord patient = this.patientRecordRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("patientrecord ID " + patientId + "  not found !!"));
		this.patientRecordRepository.delete(patient);

	}

}
