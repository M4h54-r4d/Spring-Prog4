package ir.freeland.springboot;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ir.freeland.springboot.persistence.model.Gender;
import ir.freeland.springboot.persistence.model.Items;
import ir.freeland.springboot.persistence.repo.StudentRepository;

@SpringBootTest
class SpringJPAApplicationTests {

	@Autowired
	StudentRepository repository;
	  
		@Test
		void contextLoads() {
		}
		
	    @Test
	    @Commit
	    void save_student() {
	    	Items s = new Items();
	    	s.setName("Alireza");
	    	s.setGender(  Gender.MALE);
	    	s.setBirthDate( new Date());
	    	Items newStudent = repository.save(s);
	    	
	    	System.out.println( newStudent.getId());
	    }

	 
}
