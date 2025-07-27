package vn.edu.eiu.cse465.service;

import vn.edu.eiu.cse465.entity.Major;
import vn.edu.eiu.cse465.repo.MajorRepo;

import java.util.List;

public class MajorService {

    public void saveMajor(Major major) {
        MajorRepo.save(major);
    }

    public void updateMajor(Major major) {
        MajorRepo.update(major);
    }

    public void removeMajor(Major major) {
        MajorRepo.remove(major);
    }

    public Major findMajorById(String majorId) {
        return MajorRepo.findMajorById(majorId);
    }

    public List<Major> findAllMajors() {
        return MajorRepo.findAllMajor();
    }

    public List<Major> findMajorsByName(String name) {
        return MajorRepo.findMajorByName(name);
    }
}
