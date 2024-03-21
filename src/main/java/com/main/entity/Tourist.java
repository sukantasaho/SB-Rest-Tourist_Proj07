package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="REST_TOURIST_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist 
{     
	  @Id
	  @SequenceGenerator(name = "gen1", sequenceName = "TOURIST_SEQ1", initialValue = 100000, allocationSize = 1)
	  @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
      private Integer tid;
	  
	  @NonNull
      private String name;
	  @NonNull
      private String city;
	  @NonNull
      private String packageType;
	  @NonNull
      private Double budget;
}
