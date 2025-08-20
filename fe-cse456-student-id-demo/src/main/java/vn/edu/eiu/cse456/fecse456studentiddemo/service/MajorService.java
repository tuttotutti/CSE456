package vn.edu.eiu.cse456.fecse456studentiddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Major;
import vn.edu.eiu.cse456.fecse456studentiddemo.repo.MajorRepo;

import java.util.List;

@Service //Can use @Component
public class MajorService {
    //DI: use dependency injection. There are 2 ways: field, constructor, setter
    @Autowired
    private MajorRepo majorRepo;

    //Method for saving major into database
    public void saveMajor(Major major){
        majorRepo.save(major);
    }

    public List<Major> getAllMajors(){
        return majorRepo.findAll();
    }
}
