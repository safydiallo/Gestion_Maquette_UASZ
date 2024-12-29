package com.uasz.demo;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.demo.MSMaquette.Interface.EnseignementProxy;
import com.uasz.demo.MSMaquette.Interface.MaquetteProxy;
import com.uasz.demo.MS_Emploi.Interface.SeanceProxy;

import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Modele.Repartition.Enseignements;

import com.uasz.demo.Modele.Repartition.Repartitions;

import com.uasz.demo.Service.Repartition.EnseignantService;
import com.uasz.demo.Service.Repartition.EnseignementsService;
import com.uasz.demo.Service.Repartition.PerService;
import com.uasz.demo.Service.Repartition.RepartitionsService;
import com.uasz.demo.Service.Repartition.VacataireService;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceRepartitionApplication implements CommandLineRunner  { 
	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceRepartitionApplication.class, args);
	}

	@Autowired
	private EnseignantService enseignantService;
	@Autowired
	private EnseignementsService enseignementsService;
	@Autowired
	private RepartitionsService repartitionsService;
	@Autowired
	private PerService perService;

	@Autowired
	private VacataireService vacataireService;
	@Autowired
	private MaquetteProxy maquetteProxy;
	@Autowired
	private EnseignementProxy enseignementProxy;
	@Autowired
	private SeanceProxy seanceProxy;
	
	@Override
	public void run (String... args) throws Exception{
		Enseignant enseignant= enseignantService.ajouterEnseignant(new Enseignant(null,"Toure","El Bachir","Docteur",new Date(),null));
		
		//enseignantService.ajouterEnseignant(enseignant);
		//PER per=new PER();
		//PER per=new PER;
		//perService.ajouterPer(per);
		//vacataireService.ajouterVac(new Vacataire(null,"NDIAYE","Mamadou","Docteur",new Date(),"GL"));
		
		
		//System.out.println(enseignementProxy.lister_Enseignement_Repartition());
		List<Enseignements> enseignements=enseignementProxy.lister_Enseignement_Repartition();
		//Enseignements enseignements2=enseignementProxy.ajouter_enseignements_Repartitions(null);
		
		for(int i=0;i<enseignements.size();i++){
			enseignementsService.ajouterEnseignements(enseignements.get(i));
			repartitionsService.ajouterRepartition(new Repartitions(null,"aa",new Date(),enseignant,enseignements.get(i)));
		}
		

		
		
	}


	

}
