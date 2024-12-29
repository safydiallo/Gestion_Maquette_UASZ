package com.uasz.demo;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.ClasseService;
import com.uasz.demo.Service.Maquette.CycleService;
import com.uasz.demo.Service.Maquette.EcService;
import com.uasz.demo.Service.Maquette.EnseignementService;
import com.uasz.demo.Service.Maquette.FiliereService;
import com.uasz.demo.Service.Maquette.FormationService;
import com.uasz.demo.Service.Maquette.GroupeService;
import com.uasz.demo.Service.Maquette.MaquetteService;
import com.uasz.demo.Service.Maquette.ModuleService;
import com.uasz.demo.Service.Maquette.NiveauService;
import com.uasz.demo.Service.Maquette.SemestreService;
import com.uasz.demo.Service.Maquette.UeService;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceMaquetteApplication implements CommandLineRunner {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(DaosMicroserviceMaquetteApplication.class, args);
		
	}
	@Autowired
	private UeService ueService;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private CycleService cycleService;

	@Autowired
	private EnseignementService enseignementService;

	@Autowired
	private FiliereService filiereService;

	@Autowired
	private FormationService formationService;
	@Autowired
	private GroupeService groupeService;

	@Autowired
	private MaquetteService maquetteService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private SemestreService semestreService;
	@Autowired
	private NiveauService niveauService;
	@Autowired
	private EcService ecService;

	

	
	
	@Override
	public void run (String... args) throws Exception{
		UE ue1= ueService.ajouterUE(new UE(null,"Genie-Logiciel1","inf351",8,4,"",new Date(),null,null,null));
		
		ueService.ajouterUE(new UE(null,"Genie-Logiciel2","inf351",8,4,"",new Date(),null,null,null));
		ueService.ajouterUE(new UE(null,"Reseaux et Telecoms","inf351",8,4,"",new Date(),null,null,null));
		ueService.ajouterUE(new UE(null,"Securite","inf351",8,4,"",new Date(),null,null,null));
		ueService.ajouterUE(new UE(null,"Droit des TICS","inf351",8,4,"",new Date(),null,null,null));
		EC ec1= ecService.ajouterEc(new EC(null,"Reseau_Telecom","INF362",1,2,3,4,5,"oui",new Date(),null,null));
		classeService.ajouterClasse(new Classe(null,"L3-2i",40,2,"",new Date(),null,null,null,null));
		cycleService.ajouterCycle(new Cycle(null,"Licence","",new Date(),null));
		Cycle cycle1 = cycleService.ajouterCycle(new Cycle(null,"Licence","",new Date(),null));
		Niveau niveau1 = niveauService.ajouterNiveau(new Niveau(null,"1er Annee","en cours",new Date(),cycle1,null));
		Niveau niveau2 = niveauService.ajouterNiveau(new Niveau(null,"2eme Annee","en cours",new Date(),cycle1,null));
		Niveau niveau3 = niveauService.ajouterNiveau(new Niveau(null,"1er Annee","en cours",new Date(),cycle1,null));
		
		Semestre semestre1=semestreService.ajouterSemestre(new Semestre(null,"semestre2","",new Date(),null,null));
		filiereService.ajouterFiliere(new Filiere(null,"Ingenierie Informatique","",new Date(),null));
		Classe semestre_5_L3_L2I= classeService.ajouterClasse(new Classe(null,"Licence 3 L2i Semestre 5",30,2,null,new Date(),null,semestre1,null,null));
		Formation formation1= formationService.ajouterFormation(new Formation(null,"L2i","", new Date(),null,niveau1,null,null));
		Formation formation2= formationService.ajouterFormation(new Formation(null,"Agroforesterie","", new Date(),null,niveau1,null,null));
		Formation formation3= formationService.ajouterFormation(new Formation(null,"MPI","", new Date(),null,niveau1,null,null));
		Formation formation4= formationService.ajouterFormation(new Formation(null,"Droit","", new Date(),null,niveau1,null,null));
		Groupe groupe1=groupeService.ajouterGroupe(new Groupe(null,"Groupe1",1,19,"",new Date(),null,null));

		maquetteService.ajouterMaquette(new Maquette(null,"La meilleure des classes",new Date(),formation1,null));

		
		
		Module module1= moduleService.ajouterModule(new Module(null,"BD","CM",2,3,"","",new Date(),ue1,ec1,null,null,null));
		Module module2= moduleService.ajouterModule(new Module(null,"GEO","CM",2,3,"","",new Date(),ue1,ec1,null,null,null));
		Module module3= moduleService.ajouterModule(new Module(null,"PHILO","CM",2,3,"","",new Date(),ue1,ec1,null,null,null));
		
		enseignementService.ajouterEnseignement(new Enseignement(null,"Mathematique","atteint","cours terminer",new Date(),semestre_5_L3_L2I,groupe1,module1));

	}
	}
