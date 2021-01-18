package nypd_database.complaints.repository;

import nypd_database.complaints.model.Complaint;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ComplaintRepository extends CassandraRepository<Complaint, Integer> {
}