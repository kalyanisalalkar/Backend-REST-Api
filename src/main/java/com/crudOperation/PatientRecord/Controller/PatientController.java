package com.crudOperation.PatientRecord.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.PatientRecord.Exception.ErrorMessage;
import com.crudOperation.PatientRecord.Model.PatientRecord;
import com.crudOperation.PatientRecord.Service.PatientRecordService;

@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientRecordService patientRecordService;

	// save operation
	@PostMapping("/patients")
	public ResponseEntity<PatientRecord> savePatient(@RequestBody PatientRecord patientRecord) {
		PatientRecord savePatientRecord = this.patientRecordService.savePatient(patientRecord);
		return new ResponseEntity<>(savePatientRecord, HttpStatus.CREATED);
	}

	// Update operation
	@PutMapping("/patients/{patientId}")
	public ResponseEntity<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord,
			@PathVariable("patientId") Long pid) {
		PatientRecord updatePatientRecord = this.patientRecordService.updatePatientRecord(patientRecord, pid);
		return ResponseEntity.ok(updatePatientRecord);

	}

	@GetMapping("/patients")
	public ResponseEntity<List<PatientRecord>> getAllPatientRecord() {
		return ResponseEntity.ok(this.patientRecordService.getAllPAtientRecord());

	}

	@GetMapping("/patients/{patientId}")
	public ResponseEntity<PatientRecord> getSinglePatient(@PathVariable Long patientId) {

		return ResponseEntity.ok(this.patientRecordService.getPatientById(patientId));

	}

	@DeleteMapping("/patients/{patientId}")
	public ResponseEntity<com.crudOperation.PatientRecord.payload.ApiResponse> deletePatient(
			@PathVariable("patientId") Long pid) {
		this.patientRecordService.deletePatient(pid);
		return new ResponseEntity<com.crudOperation.PatientRecord.payload.ApiResponse>(
				new com.crudOperation.PatientRecord.payload.ApiResponse("User Deleted Successfully", true),
				HttpStatus.OK);
	}

}
