//package propensi.sixacti.model;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name = "fulfillment")
//public class FulfillmentModel implements Serializable{
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	
//	@NotNull
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @Column(name="tanggal", nullable = false)
//    private Date tanggal;
//	
//	
//
//}
