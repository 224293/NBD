package nypd_database.complaints.repository;

import java.util.List;
import com.datastax.driver.core.LocalDate;
import nypd_database.complaints.model.Complaint;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ComplaintRepository extends CassandraRepository<Complaint, Integer> {
    
//    @AllowFiltering
//    List<Complaint> findByReportDate(LocalDate reportDate);
//
//    @AllowFiltering
//    List<Complaint> findByBoroughName(String boroughName);
}