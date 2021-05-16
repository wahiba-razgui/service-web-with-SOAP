package de.tekup.white.test.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.models.whitetest.Address;
@Service
public class WhiteElegibilityService {

		//le service web soap avec une adresse de type string

	/*	public WhiteTestResponse getStudentStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
		//return null;
		Boolean testId=false;
		Boolean testCode=false;
		int id=0;
		int code=0;
		List<Student> students = new ArrayList<>() ;
		List<Exam> exams = new ArrayList<>() ;
		for (int i=1; i<11;i++) {
			Student s = new Student();
			s.setId(i);
			s.setName("Student"+i);
			Address ad = new Address();
			ad.setCity("beja"+i);
			ad.setPosteCode(9010);
			ad.setStreet("sidisaad");
			s.setAddress(ad);
			students.add(s);
		}
		for (int i=1; i<11;i++) {
			Exam e = new Exam();
			e.setCode("1z0-80"+i);
			e.setName("OCA");
			exams.add(e);
		}
		//tester si l'id de studient existe dans la liste ou non 
		for (int i=0;i<students.size();i++) {
			if(students.get(i).getId()==studentRequest.getStudentId()) {
				testId=true;
				id=i;
				break;
			}
		}
		//tester si le code de l'exam existe dans la liste ou non 
		for (int i=0;i<exams.size();i++) {
			if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
				testCode=true;
				code=i;
				break;
			}
		}

		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
		if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testId)) {
			mismatchs.add("student id is wrong");
		}
		if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("code exam should be not Empty");
		}
		if(!(testCode))
		{
			mismatchs.add("code exam is wrong ");
		}
		if(mismatchs.isEmpty()) {
			Student student = new Student();
			student.setId(studentRequest.getStudentId());
			student.setName(students.get(id).getName());
			student.setAddress((students.get(id).getAddress()));
			Exam exam = new Exam();
			exam.setCode(studentRequest.getExamCode());
			exam.setName(exams.get(code).getName());
			whiteTestResponse.setStudent(student);
			whiteTestResponse.setExam(exam);
			LocalDateTime localDate = LocalDateTime.now().plusDays(3);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
			whiteTestResponse.setDate(xmlGregorianCalendar);
			whiteTestResponse.setIsValid(true);
			
		}else {
			whiteTestResponse.setIsValid(false);
		}
		return whiteTestResponse;
	}
	}*/
	
	
	

	//service avec  une address de type complexe
		public WhiteTestResponse getStudentStatus2(StudentRequest studentRequest) throws DatatypeConfigurationException {
			Boolean testId=false;
			Boolean testCode=false;
			int id=0;
			int code=0;
			List<Student> students = new ArrayList<>() ;
			List<Exam> exams = new ArrayList<>() ;
			for (int i=1; i<11;i++) {
				Student s = new Student();
				s.setId(i);
				s.setName("Student"+i);
				Address a = new Address();
				a.setCity("city"+i);
				a.setPosteCode(1140+i);
				a.setStreet("street"+i);
				s.setAddress(a);
				students.add(s);
			}
			for (int i=1; i<11;i++) {
				Exam e = new Exam();
				e.setCode("1z0-80"+i);
				e.setName("OCA");
				exams.add(e);
			}
			//tester si l'id de studient existe dans la liste ou non 
			for (int i=0;i<students.size();i++) {
				if(students.get(i).getId()==studentRequest.getStudentId()) {
					testId=true;
					id=i;
					break;
				}
			}
			//tester si le code de l'exam existe dans la liste ou non 
			for (int i=0;i<exams.size();i++) {
				if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
					testCode=true;
					code=i;
					break;
				}
			}

			WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
			List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
			if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testId)) {
				mismatchs.add("wrong student id");
			}
			if(studentRequest.getExamCode().isEmpty()) {
				mismatchs.add("exam code must be not empty");
			}
			if(!(testCode))
			{
				mismatchs.add("wrong exam code");
			}
			if(mismatchs.isEmpty()) {
				Student student = new Student();
				student.setId(studentRequest.getStudentId());
				student.setName(students.get(id).getName());
				student.setAddress((students.get(id).getAddress()));
				Exam exam = new Exam();
				exam.setCode(studentRequest.getExamCode());
				exam.setName(exams.get(code).getName());
				whiteTestResponse.setStudent(student);
				whiteTestResponse.setExam(exam);
				LocalDateTime localDate = LocalDateTime.now().plusDays(3);
				XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
				whiteTestResponse.setDate(xmlGregorianCalendar);
				whiteTestResponse.setIsValid(true);
				
			}else {
				whiteTestResponse.setIsValid(false);
			}
			return whiteTestResponse;
		}

		public WhiteTestResponse getStudentStatus(StudentRequest studentRequest) {
			// TODO Auto-generated method stub
			return null;
		}
		}

	



