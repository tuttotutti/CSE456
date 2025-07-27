package vn.edu.eiu.cse465.service;

import vn.edu.eiu.cse465.entity.School;
import vn.edu.eiu.cse465.repo.SchoolRepo;

import java.util.List;

public class SchoolService {

    public void saveSchool(School school) {
        SchoolRepo.save(school);
    }

    public void updateSchool(School school) {
        SchoolRepo.update(school);
    }

    public void removeSchool(School school) {
        SchoolRepo.remove(school);
    }

    public School findSchoolById(String schoolId) {
        return SchoolRepo.findSchoolById(schoolId);
    }

    public List<School> findAllSchools() {
        return SchoolRepo.findAllSchool();
    }

    public List<School> findSchoolsByName(String name) {
        return SchoolRepo.findSchoolByName(name);
    }
}
