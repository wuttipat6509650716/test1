package th.ac.tu.cs.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.contact;
import th.ac.tu.cs.services.repository.ContactRepository;
import th.ac.tu.cs.services.repository.JdbcContactRepository;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
/*@RequestMapping("/api")*/
@RestController
public class AddDropController {

    @Autowired
    JdbcContactRepository jd ;

    @GetMapping("/addDrop")
    public String input(@RequestParam(value = "day") String day,
                         @RequestParam(value = "myName") String name,
                         @RequestParam(value = "lastName") String lastname,
                         @RequestParam(value = "ID") String ID,
                         @RequestParam(value = "school_year") String school_year,
                         @RequestParam(value = "branch") String branch,
                         @RequestParam(value = "ajarn") String ajarn,
                         @RequestParam(value = "house") String house,
                         @RequestParam(value = "village") String village,
                         @RequestParam(value = "district") String district,
                         @RequestParam(value = "prefecture") String prefecture,
                         @RequestParam(value = "county") String county,
                         @RequestParam(value = "postcode") String postcode,
                         @RequestParam(value = "mobilePhone") String mobile,
                         @RequestParam(value = "mobileHome") String mobileHome,
                         @RequestParam(value = "cause") String cause,

                         @RequestParam(value = "add1") String nadd,
                         @RequestParam(value = "drop1") String ndrop,
                         @RequestParam(value = "code") String codeAdd,
                         @RequestParam(value = "subject") String subjectAdd,
                         @RequestParam(value = "section") String sectionAdd,
                         @RequestParam(value = "time") String timeAdd,
                         @RequestParam(value = "credit") String creditAdd,
                         @RequestParam(value = "teacher") String teacherAdd,
                         @RequestParam(value = "checkbox",defaultValue = "NULL") String checkboxAdd,
                         @RequestParam(value = "code1") String codeDrop,
                         @RequestParam(value = "subject1") String subjectDrop,
                         @RequestParam(value = "section1") String sectionDrop,
                         @RequestParam(value = "time1") String timeDrop,
                         @RequestParam(value = "credit1") String creditDrop,
                         @RequestParam(value = "teacher1") String teacherDrop,
                         @RequestParam(value = "checkbox1",defaultValue = "NULL") String checkboxDrop)  {
        contact p1 = new contact(day, name, lastname, ID, school_year, branch, ajarn, house, village, district, prefecture, county, postcode, mobile, mobileHome, cause, nadd, ndrop, codeAdd,
                                subjectAdd, sectionAdd, timeAdd, creditAdd, teacherAdd, checkboxAdd, codeDrop, subjectDrop, sectionDrop, timeDrop, creditDrop, teacherDrop, checkboxDrop);
        jd.save(p1);
        return "ส่งเข้า SQL เรียบร้อย";
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<contact> getTutorialById(@PathVariable("id") String id) {
        contact tutorial = jd.findById(id);
        if (tutorial != null) {
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<contact>> findAll(){
        List<contact> list = jd.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") String id) {
        try {
            int result = jd.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find AddDrop with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("AddDrop was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("AddDrop delete Contact.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllTutorials() {
        try {
            int numRows = jd.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + " AddDrop(s) successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete AddDrop.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable("id") String id, @RequestBody contact contact) {
        contact _pUpdate = jd.findById(id);
        if (_pUpdate != null) {
            _pUpdate.setStudentFirstName(contact.getStudentFirstName());
            _pUpdate.setStudentLastName(contact.getStudentLastName());
            _pUpdate.setStudyField(contact.getStudyField());

            jd.update(_pUpdate);
            return new ResponseEntity<>("Contact was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Contact with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

}
