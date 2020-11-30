package nypd_database.complaints.model;


import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Table("complaints")
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {

    @Getter @Setter
    @Column("cmplnt_num")
    @PrimaryKey
    private @NonNull Integer cmplnt_num;
    @Getter @Setter
    @Column("cmplnt_fr_dt")
    private LocalDate complaintFromDate;
    @Getter @Setter
    @Column("cmplnt_fr_tm")
    private Long complaintFromTime;
    @Getter @Setter
    @Column("cmplnt_to_dt")
    private LocalDate complaintToDate;
    @Getter @Setter
    @Column("cmplnt_to_tm")
    private Long complaintToTime;
    @Getter @Setter
    @Column("addr_pct_cd")
    private Integer addressPrecinctCode;
    @Getter @Setter
    @Column("rpt_dt")
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate reportDate;
    @Getter @Setter
    @Column("ky_cd")
    private Integer keyCode;
    @Getter @Setter
    @Column("ofns_desc")
    private String offenseDescription;
    @Getter @Setter
    @Column("pd_cd")
    private Integer pdCode;
    @Getter @Setter
    @Column("pd_desc")
    private String pdDescription;
    @Getter @Setter
    @Column("crm_atpt_cptd_cd")
    private String crimeAttemptedCompletedCode;
    @Getter @Setter
    @Column("law_cat_cd")
    private String lawCategoryCode;
    @Getter @Setter
    @Column("boro_nm")
    @CassandraType(type = DataType.Name.TEXT)
    private String boroughName;
    @Getter @Setter
    @Column("loc_of_occur_desc")   
    private String locationOfOccurrenceDescription;
    @Getter @Setter
    @Column("prem_typ_desc")
    private String premisesTypeDescription;
    @Getter @Setter
    @Column("juris_desc")
    private String jurisdictionDescription;
    @Getter @Setter
    @Column("jurisdiction_code")
    private Integer jurisdictionCode;
    @Getter @Setter
    @Column("parks_nm")
    private String parksName;
    @Getter @Setter
    @Column("hadevelopt")
    private String housingDevelopment;
    @Getter @Setter
    @Column("housing_psa")
    private Integer developmentLevelCode;
    @Getter @Setter
    @Column("x_coord_cd")
    private Float xCoordCode;
    @Getter @Setter
    @Column("y_coord_cd")
    private Float yCoordCode;
    @Getter @Setter
    @Column("susp_age_group")
    private String suspectAgeGroup;
    @Getter @Setter
    @Column("susp_race")
    private String suspectRace;
    @Getter @Setter
    @Column("susp_sex")
    private String suspectSex;
    @Getter @Setter
    @Column("transit_district")
    private Integer transitDistrict;
    @Getter @Setter
    @Column("latitude")
    private Double latitude;
    @Getter @Setter
    @Column("longitude")
    private Double longitude;
    @Getter @Setter
    @Column("lat_lon")
    private String location;
    @Getter @Setter
    @Column("patrol_boro")
    private String patrolBorough;
    @Getter @Setter
    @Column("station_name")
    private String stationName;
    @Getter @Setter
    @Column("vic_age_group")
    private String victimAgeGroup;
    @Getter @Setter
    @Column("vic_race")
    private String victimRace;
    @Getter @Setter
    @Column("vic_sex")
    private String victimSex;

    @Override
    public String toString() {
        return "Complaint{" + "\n" +
                "complaintNumber=" + cmplnt_num + ",\n" +
                "complaintFromDate=" + complaintFromDate + ",\n" +
                "complaintFromTime=" + complaintFromTime + ",\n" +
                "complaintToDate=" + complaintToDate + ",\n" +
                "complaintToTime=" + complaintToTime + ",\n" +
                "addressPrecinctCode=" + addressPrecinctCode + ",\n" +
                "reportDate=" + reportDate + ",\n" +
                "keyCode=" + keyCode + ",\n" +
                "offenseDescription='" + offenseDescription + ",\n" +
                "pdCode=" + pdCode + ",\n" +
                "pdDescription='" + pdDescription + ",\n" +
                "crimeAttemptedCompletedCode='" + crimeAttemptedCompletedCode + ",\n" +
                "lawCategoryCode='" + lawCategoryCode + ",\n" +
                "boroughName='" + boroughName + ",\n" +
                "locationOfOccurrenceDescription='" + locationOfOccurrenceDescription + ",\n" +
                "premisesTypeDescription='" + premisesTypeDescription + ",\n" +
                ",jurisdictionDescription='" + jurisdictionDescription + ",\n" +
                "jurisdictionCode=" + jurisdictionCode + ",\n" +
                "parksName='" + parksName + ",\n" +
                "housingDevelopment='" + housingDevelopment + ",\n" +
                "developmentLevelCode=" + developmentLevelCode + ",\n" +
                "xCoordCode=" + xCoordCode + ",\n" +
                "yCoordCode=" + yCoordCode + ",\n" +
                "suspectAgeGroup='" + suspectAgeGroup + ",\n" +
                "suspectRace='" + suspectRace + ",\n" +
                "suspectSex='" + suspectSex + ",\n" +
                "transitDistrict=" + transitDistrict + ",\n" +
                "latitude=" + ",\n" +
                "longitude=" + longitude +
                "location='" + location + ",\n" +
                "patrolBorough='" + patrolBorough + ",\n" +
                "stationName='" + stationName + ",\n" +
                "victimAgeGroup='" + victimAgeGroup + ",\n" +
                "victimRace='" + victimRace + ",\n" +
                "victimSex='" + victimSex + ",\n" +
                '}';
    }
}