package com.crudOperation.PatientRecord;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crudOperation.PatientRecord.Controller.PatientController;
import com.crudOperation.PatientRecord.Model.PatientRecord;
import com.crudOperation.PatientRecord.Repository.PatientRecordRepository;
import com.crudOperation.PatientRecord.Service.PatientRecordServiceImpl;


@SpringBootTest
@RunWith(SpringRunner.class)
class PatientRecordApplicationTests {
	
	@Autowired
	private PatientRecordServiceImpl serviceImpl;

	@MockBean
	private PatientRecordRepository patientRecordRepository;
	
	
	
	
	/*@Test
	public void getPatientTest() {
		when(patientRecordRepository.findAll())
		.thenReturn((List<PatientRecord>) Stream.of(new PatientRecord(102l, "kalyani",30,"pune", null, null),
				new PatientRecord(null, "shiv",30,"mumbai", null, null)).collect(Collectors.toList()));
		assertEquals(2, serviceImpl.getAllPAtientRecord().size());
	}
	
	@Test
	public void savePatient() {
		PatientRecord patient = new PatientRecord(102l,"pavan",33,"pune",null,null);
		when(patientRecordRepository.save(patient)).thenReturn(patient);
		assertEquals(patient, paServiceImpl.savePatient(patient));
	}*/
	
	
	@Test
	@DisplayName("It should save the Patient to the database")
	public void save() {
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setPatientId(1l);
		patientRecord.setPatientName("nitish");
		patientRecord.setAge(32);
		patientRecord.setAddress("pune");
		
		when(patientRecordRepository.save(any(PatientRecord.class))).thenReturn(patientRecord);
		
		PatientRecord newPatient = serviceImpl.savePatient(patientRecord);
		
		assertNotNull(newPatient);
		assertThat(newPatient.getPatientName()).isEqualTo("nitish");
	}
	
	@Test
	@DisplayName("It should return the Patient list with size of 2")
	public void getAllPatientRecord() {
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setPatientId(1l);
		patientRecord.setPatientName("nitish");
		patientRecord.setAge(32);
		patientRecord.setAddress("pune");
		
		PatientRecord patientRecord1 = new PatientRecord();
		patientRecord1.setPatientId(2l);
		patientRecord1.setPatientName("shiv");
		patientRecord1.setAge(3);
		patientRecord1.setAddress("pune");
		
		List<PatientRecord> list = new ArrayList<>();
		list.add(patientRecord);
		list.add(patientRecord1);
		
		when(patientRecordRepository.findAll()).thenReturn(list);
		
		List<PatientRecord> patient = serviceImpl.getAllPAtientRecord();
		
		assertEquals(2, patient.size());
		assertNotNull(patient);
	}
	
	
	@Test
	@DisplayName("It should return the Patient by its id")
	public void getpatientById() {
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setPatientId(1l);
		patientRecord.setPatientName("nitish");
		patientRecord.setAge(32);
		patientRecord.setAddress("pune");
		when(patientRecordRepository.findById(anyLong())).thenReturn(Optional.of(patientRecord));
		PatientRecord existingPatient = serviceImpl.getPatientById(patientRecord.getPatientId());
		assertNotNull(existingPatient);
		assertThat(existingPatient.getPatientId()).isNotEqualTo(null);
		
	}
	
	@Test
	@DisplayName("It should update the Patient genera with FANTACY")
	public void updatePatient() {
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setPatientId(1l);
		patientRecord.setPatientName("nitish");
		patientRecord.setAge(32);
		patientRecord.setAddress("pune");
		
		when(patientRecordRepository.findById(anyLong())).thenReturn(Optional.of(patientRecord));
		
		when(patientRecordRepository.save(any(PatientRecord.class))).thenReturn(patientRecord);
		patientRecord.setPatientName("Fantacy");
		PatientRecord exisitingPatient = serviceImpl.updatePatientRecord(patientRecord, patientRecord.getPatientId());
		
		assertNotNull(exisitingPatient);
		assertEquals("Fantacy", patientRecord.getPatientName());
	}
	
	@Test
	
	@DisplayName("It should delete the existing Patient BY ID")
	public void deletePatient() {
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setPatientId(1l);
		patientRecord.setPatientName("nitish");
		patientRecord.setAge(32);
		patientRecord.setAddress("pune");
		Long patientId = 1L;
		when(patientRecordRepository.findById(anyLong())).thenReturn(Optional.of(patientRecord));
		doNothing().when(patientRecordRepository).delete(any(PatientRecord.class));
		
		serviceImpl.deletePatient(patientId);
		
		verify(patientRecordRepository, times(1)).delete(patientRecord);
	}
	
	

	

	
}
