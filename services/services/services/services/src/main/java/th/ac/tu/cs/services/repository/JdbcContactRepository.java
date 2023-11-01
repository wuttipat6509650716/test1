package th.ac.tu.cs.services.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.tu.cs.services.model.contact;

import java.util.List;


@Repository
public class JdbcContactRepository implements ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(contact customer) {
        return jdbcTemplate.update("INSERT INTO hw1AddDrop (date, studentFirstName, studentLastName, studentId, studentYear, studyField, advisor, addressNumber, moo, tumbol, amphur, province, postalCode, mobilePhone, phone, cause, nadd, ndrop, subjectCodeAdd, subjectNameAdd, subjectSectionAdd, subjectDateAdd, subjectCreditAdd, subjectTeacherAdd, subjectTeacherCheckAdd, subjectCodeDrop, subjectNameDrop, subjectSectionDrop, subjectDateDrop, subjectCreditDrop, subjectTeacherDrop, subjectTeacherCheckDrop) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{customer.getDate(), customer.getStudentFirstName(), customer.getStudentLastName(), customer.getStudentId(), customer.getStudentYear(), customer.getStudyField(), customer.getAdvisor(),
                        customer.getAddressNumber(), customer.getMoo(), customer.getTumbol(), customer.getAmphur(), customer.getProvince(), customer.getPostalCode(), customer.getMobilePhone(), customer.getPhone(),
                        customer.getCause(), customer.getNadd(), customer.getNdrop(), customer.getSubjectCodeAdd(), customer.getSubjectNameAdd(), customer.getSubjectSectionAdd(), customer.getSubjectDateAdd(), customer.getSubjectCreditAdd(),
                        customer.getSubjectTeacherAdd(), customer.getSubjectTeacherCheckAdd(),customer.getSubjectCodeDrop(), customer.getSubjectNameDrop(), customer.getSubjectSectionDrop(), customer.getSubjectDateDrop(), customer.getSubjectCreditDrop(),
                        customer.getSubjectTeacherDrop(), customer.getSubjectTeacherCheckDrop()});
    }

    public contact findById(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM hw1AddDrop WHERE studentId=?",
                    BeanPropertyRowMapper.newInstance(contact.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<contact> findAll() {
        return jdbcTemplate.query("SELECT * from hw1AddDrop", BeanPropertyRowMapper.newInstance(contact.class));
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("DELETE FROM hw1AddDrop WHERE studentId=?", id);
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE from hw1AddDrop");
    }

    public int update(contact customer) {
        return jdbcTemplate.update("UPDATE hw1AddDrop SET studentFirstName=?, studentLastName=?, studyField=? WHERE id=?",
                new Object[] { customer.getStudentFirstName(), customer.getStudentLastName(), customer.getStudyField() });
    }

}
