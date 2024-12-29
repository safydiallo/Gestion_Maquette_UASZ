package com.uasz.demo;

import com.uasz.demo.MSMaquette.Interface.UEProxy;
import com.uasz.demo.MSRepartition.Interface.EnseignantProxy;
import com.uasz.demo.MSRepartition.Interface.RepartitionsProxy;
import com.uasz.demo.MSRepartition.Modele.Repartitions;
import com.uasz.demo.Modele.Emploi.Batiment;
import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.BatimentService;
import com.uasz.demo.Service.Emploi.DeroulementService;
import com.uasz.demo.Service.Emploi.EmploiService;
import com.uasz.demo.Service.Emploi.RepartitionService;
import com.uasz.demo.Service.Emploi.SalleService;
import com.uasz.demo.Service.Emploi.SeanceService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceEmploiApplication implements CommandLineRunner {

	@Autowired
	private BatimentService batimentService;

	@Autowired
	private DeroulementService deroulementService;

	@Autowired
	private EmploiService emploiService;

	@Autowired
	private RepartitionService repartitionService;

	@Autowired
	private SalleService salleService;

	@Autowired
	private  SeanceService seanceService;
	@Autowired
	private RepartitionsProxy repartitionsProxy;


	public DaosMicroserviceEmploiApplication(UEProxy ueProxy){
		this.ueProxy= ueProxy;
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceEmploiApplication.class, args);
	}
	private final UEProxy ueProxy;
	
;
	@Override
	public  void run(String... args) throws Exception{
		System.out.println(ueProxy.lister_ue());
		
		batimentService.ajouterBatiment(new Batiment(null,"A","gdf45","Centre","",new Date(),null));
		Deroulement deroulement1 = deroulementService.ajouterDeroulement(new Deroulement(null,"",new Date(),null));
		Emploi emploi1= emploiService.ajouterEmploi(new Emploi(null,4,16,19,new Date(),null));
		
		salleService.ajouterSalle(new Salle(null,"info1","dff45",35,"",new Date(),null,null));
		
		

		System.out.println(repartitionsProxy.lister_Repartition_Repartition());
		List<Repartition> repartitions=repartitionsProxy.lister_Repartition_Repartition();
		for(int i=0;i<repartitions.size();i++){
			repartitionService.ajouterRepartition(repartitions.get(i));	
		}

		
	}
		
	}

