package nypd_database.complaints.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import nypd_database.complaints.model.Complaint;
import nypd_database.complaints.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static java.lang.Math.abs;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping("/api")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @PostMapping("/complaints")
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        try {
            Random random = new Random(System.currentTimeMillis());
            Complaint _complaint = complaintRepository.save(
                    new Complaint(
                            abs(random.nextInt()),
                            complaint.getComplaintFromDate(),
                            complaint.getComplaintFromTime(),
                            complaint.getComplaintToDate(),
                            complaint.getComplaintToTime(),
                            complaint.getAddressPrecinctCode(),
                            complaint.getReportDate(),
                            complaint.getKeyCode(),
                            complaint.getOffenseDescription(),
                            complaint.getPdCode(),
                            complaint.getPdDescription(),
                            complaint.getCrimeAttemptedCompletedCode(),
                            complaint.getLawCategoryCode(),
                            complaint.getBoroughName(),
                            complaint.getLocationOfOccurrenceDescription(),
                            complaint.getPremisesTypeDescription(),
                            complaint.getJurisdictionDescription(),
                            complaint.getJurisdictionCode(),
                            complaint.getParksName(),
                            complaint.getHousingDevelopment(),
                            complaint.getDevelopmentLevelCode(),
                            complaint.getXCoordCode(),
                            complaint.getYCoordCode(),
                            complaint.getSuspectAgeGroup(),
                            complaint.getSuspectRace(),
                            complaint.getSuspectSex(),
                            complaint.getTransitDistrict(),
                            complaint.getLatitude(),
                            complaint.getLongitude(),
                            complaint.getLocation(),
                            complaint.getPatrolBorough(),
                            complaint.getStationName(),
                            complaint.getVictimAgeGroup(),
                            complaint.getVictimRace(),
                            complaint.getVictimSex()
                    )
            );
            return new ResponseEntity<>(_complaint, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        try {
            List<Complaint> complaints = new ArrayList<Complaint>();

            complaintRepository.findAll().forEach(complaints::add);
            
            if (complaints.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(complaints, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/complaints/{complaintNum}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable("complaintNum") Integer complaintNum) {
        Optional<Complaint> complaintData = complaintRepository.findById(complaintNum);

        if (complaintData.isPresent()) {
            return new ResponseEntity<>(complaintData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/complaints/{complaintNum}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable("complaintNum") Integer complaintNum, @RequestBody Complaint complaint) {
        Optional<Complaint> complaintData = complaintRepository.findById(complaintNum);

        if (complaintData.isPresent()) {
            Complaint _complaint = complaintData.get();
            _complaint.setCmplnt_num(complaint.getCmplnt_num());
            _complaint.setComplaintFromDate(complaint.getComplaintFromDate());
            _complaint.setComplaintFromTime(complaint.getComplaintFromTime());
            _complaint.setComplaintToDate(complaint.getComplaintToDate());
            _complaint.setComplaintToTime(complaint.getComplaintToTime());
            _complaint.setAddressPrecinctCode(complaint.getAddressPrecinctCode());
            _complaint.setReportDate(complaint.getReportDate());
            _complaint.setKeyCode(complaint.getKeyCode());
            _complaint.setOffenseDescription(complaint.getOffenseDescription());
            _complaint.setPdCode(complaint.getPdCode());
            _complaint.setPdDescription(complaint.getPdDescription());
            _complaint.setCrimeAttemptedCompletedCode(complaint.getCrimeAttemptedCompletedCode());
            _complaint.setLawCategoryCode(complaint.getLawCategoryCode());
            _complaint.setBoroughName(complaint.getBoroughName());
            _complaint.setLocationOfOccurrenceDescription(complaint.getLocationOfOccurrenceDescription());
            _complaint.setPremisesTypeDescription(complaint.getPremisesTypeDescription());
            _complaint.setJurisdictionDescription(complaint.getJurisdictionDescription());
            _complaint.setJurisdictionCode(complaint.getJurisdictionCode());
            _complaint.setParksName(complaint.getParksName());
            _complaint.setHousingDevelopment(complaint.getHousingDevelopment());
            _complaint.setDevelopmentLevelCode(complaint.getDevelopmentLevelCode());
            _complaint.setXCoordCode(complaint.getXCoordCode());
            _complaint.setYCoordCode(complaint.getYCoordCode());
            _complaint.setSuspectAgeGroup(complaint.getSuspectAgeGroup());
            _complaint.setSuspectRace(complaint.getSuspectRace());
            _complaint.setSuspectSex(complaint.getSuspectSex());
            _complaint.setTransitDistrict(complaint.getTransitDistrict());
            _complaint.setLatitude(complaint.getLatitude());
            _complaint.setLongitude(complaint.getLongitude());
            _complaint.setLocation(complaint.getLocation());
            _complaint.setPatrolBorough(complaint.getPatrolBorough());
            _complaint.setStationName(complaint.getStationName());
            _complaint.setVictimAgeGroup(complaint.getVictimAgeGroup());
            _complaint.setVictimRace(complaint.getVictimRace());
            _complaint.setVictimSex(complaint.getVictimSex());
            return new ResponseEntity<>(complaintRepository.save(_complaint), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/complaints/{complaintNum}")
    public ResponseEntity<HttpStatus> deleteComplaint(@PathVariable("complaintNum") Integer complaintNum) {
        try {
            complaintRepository.deleteById(complaintNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/complaints")
    public ResponseEntity<HttpStatus> deleteAllComplaints() {
        try {
            complaintRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
