package com.bksoft.absence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbsenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsenceApplication.class, args);
	}

	//TODO
	// intégrer la gestion des demandes d'absences par les étudiants
	// courbe d'évolution des absences au cours des semaines/mois, par classe

}
