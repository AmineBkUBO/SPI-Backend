package spi.Util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spi.Entity.Enseignant;
import spi.Entity.Etudiant;
import spi.Entity.Formation;
import spi.Entity.Promotion;
import spi.Repository.EnseignantRepository;
import spi.Repository.EtudiantRepository;
import spi.Repository.FormationRepository;
import spi.Repository.PromotionRepository;

import java.time.LocalDate;

@Component
public class DataBaseSeeder implements CommandLineRunner {

    private final EnseignantRepository enseignantRepository;
    private final FormationRepository formationRepository;
    private final PromotionRepository promotionRepository;
    private final EtudiantRepository etudiantRepository;

    public DataBaseSeeder(EnseignantRepository enseignantRepository,
                          FormationRepository formationRepository,
                          PromotionRepository promotionRepository,
                          EtudiantRepository etudiantRepository) {
        this.enseignantRepository = enseignantRepository;
        this.formationRepository = formationRepository;
        this.promotionRepository = promotionRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedEnseignants();
        seedFormations();
        seedPromotions();
        seedEtudiants();
    }

    private void seedEnseignants() {
        // Enseignant 30
        if (!enseignantRepository.existsById(30)) {
            Enseignant e1 = new Enseignant();
            e1.setId(30);
            e1.setType("ENC");
            e1.setSexe("L");
            e1.setNom("Clochette");
            e1.setPrenom("Fée");
            e1.setAdresse("ciel étoilé");
            e1.setCp("29200");
            e1.setVille("neverland");
            e1.setPays("pays imaginaire");
            e1.setTelPort("00");
            e1.setEncPersoTel("00");
            e1.setEncUboTel("00");
            e1.setEncPersoEmail("00");
            e1.setEncUboEmail("00");
            enseignantRepository.save(e1);
        }

        // Enseignant 1
        if (!enseignantRepository.existsById(1)) {
            Enseignant e2 = new Enseignant();
            e2.setId(1);
            e2.setType("ENC");
            e2.setSexe("H");
            e2.setNom("Saliou");
            e2.setPrenom("Philippe");
            e2.setAdresse("6, rue de l'Argoat");
            e2.setCp("29860");
            e2.setVille("Le Drennec");
            e2.setPays("France");
            e2.setEncPersoTel("02.98.40.82.95");
            e2.setEncUboTel("02.98.01.69.74");
            e2.setEncUboEmail("Philippe.Saliou@univ-brest.fr");
            enseignantRepository.save(e2);
        }

        // Enseignant 2
        if (!enseignantRepository.existsById(2)) {
            Enseignant e3 = new Enseignant();
            e3.setId(2);
            e3.setType("ENC");
            e3.setSexe("H");
            e3.setNom("Ribaud");
            e3.setPrenom("Vincent");
            e3.setAdresse("20, avenur le Gorgeu");
            e3.setCp("29200");
            e3.setVille("Brest");
            e3.setPays("France");
            e3.setEncUboTel("02.98.01.69.71");
            e3.setEncUboEmail("Vincent.Ribaud@univ-brest.fr");
            enseignantRepository.save(e3);
        }

        // Enseignant 3
        if (!enseignantRepository.existsById(3)) {
            Enseignant e4 = new Enseignant();
            e4.setId(3);
            e4.setType("INT");
            e4.setSexe("F");
            e4.setNom("Le Guen");
            e4.setPrenom("Claudie");
            e4.setAdresse("15, boulevard mouchotte");
            e4.setCp("29200");
            e4.setVille("Brest");
            e4.setPays("France");
            e4.setTelPort("06.74.63.12.21");
            e4.setEncPersoTel("02.98.65.32.12");
            e4.setIntNoInsee("20136598BCF32");
            e4.setIntSocNom("Cap Gemini");
            e4.setIntSocAdresse("10 quai du commandant Malbert");
            e4.setIntSocCp("29200");
            e4.setIntSocVille("Brest");
            e4.setIntSocPays("France");
            e4.setIntFonction("Ingénieur Qualité");
            e4.setIntProfEmail("claudie.leguen@capgeminio.fr");
            e4.setIntProfTel("02.98.68.45.73");
            enseignantRepository.save(e4);
        }
    }

    private void seedFormations() {
        // Formation M2DOSI
        if (!formationRepository.existsById("M2DOSI")) {
            Formation f1 = new Formation();
            f1.setCodeFormation("M2DOSI");
            f1.setDiplome("M");
            f1.setN0Annee(true);
            f1.setNomFormation("Master Développement à l'Offshore des Systèmes d'Informat");
            f1.setDoubleDiplome(true);
            f1.setDebutHabilitation(LocalDate.of(2012, 9, 1));
            f1.setFinHabilitation(LocalDate.of(2016, 9, 1));
            formationRepository.save(f1);
        }

        // Formation M1TIIL
        if (!formationRepository.existsById("M1TIIL")) {
            Formation f2 = new Formation();
            f2.setCodeFormation("M1TIIL");
            f2.setDiplome("M");
            f2.setN0Annee(true);
            f2.setNomFormation("Master Technologie de l'Information et Ingénierie Logiciel");
            f2.setDoubleDiplome(false);
            f2.setDebutHabilitation(LocalDate.of(2012, 9, 1));
            f2.setFinHabilitation(LocalDate.of(2016, 9, 1));
            formationRepository.save(f2);
        }

        // Formation L3INFO
        if (!formationRepository.existsById("L3INFO")) {
            Formation f3 = new Formation();
            f3.setCodeFormation("L3INFO");
            f3.setDiplome("L");
            f3.setN0Annee(true);
            f3.setNomFormation("Licence d'Informatique");
            f3.setDoubleDiplome(false);
            f3.setDebutHabilitation(LocalDate.of(2012, 9, 1));
            f3.setFinHabilitation(LocalDate.of(2016, 9, 1));
            formationRepository.save(f3);
        }
    }

    private void seedPromotions() {
        Enseignant enseignant1 = enseignantRepository.findById(1).orElse(null);

        // Promotion 2006-2007
        if (!promotionRepository.existsById("2006-2007")) {
            Promotion p1 = new Promotion();
            p1.setAnneePro("2006-2007");
            p1.setNoEnseignant(enseignant1);
            p1.setSiglePro("RSOFT");
            p1.setNbEtuSouhaite((short) 12);
            p1.setEtatPreselection("ENC");
            p1.setDateRentree(LocalDate.of(2006, 9, 18));
            p1.setLieuRentree("LC117A");
            p1.setDateReponseLp(LocalDate.of(2006, 7, 14));
            promotionRepository.save(p1);
        }

        // Promotion 2004-2005
        if (!promotionRepository.existsById("2004-2005")) {
            Promotion p2 = new Promotion();
            p2.setAnneePro("2004-2005");
            p2.setNoEnseignant(enseignant1);
            p2.setSiglePro("CILI3");
            p2.setNbEtuSouhaite((short) 10);
            p2.setEtatPreselection("TER");
            p2.setDateRentree(LocalDate.of(2004, 9, 13));
            p2.setLieuRentree("LC117A");
            p2.setDateReponseLp(LocalDate.of(2004, 7, 23));
            p2.setDateReponseLalp(LocalDate.of(2004, 8, 13));
            p2.setProcessusStage("RECH");
            promotionRepository.save(p2);
        }

        // Promotion 2005-2006
        if (!promotionRepository.existsById("2005-2006")) {
            Promotion p3 = new Promotion();
            p3.setAnneePro("2005-2006");
            p3.setNoEnseignant(enseignant1);
            p3.setSiglePro("CILI4");
            p3.setNbEtuSouhaite((short) 12);
            p3.setEtatPreselection("TER");
            p3.setDateRentree(LocalDate.of(2005, 9, 19));
            p3.setLieuRentree("LC117A");
            p3.setDateReponseLp(LocalDate.of(2005, 7, 14));
            p3.setDateReponseLalp(LocalDate.of(2005, 8, 13));
            p3.setProcessusStage("EC");
            promotionRepository.save(p3);
        }
    }

    private void seedEtudiants() {
        Promotion promo20042005 = promotionRepository.findById("2004-2005").orElse(null);
        Promotion promo20052006 = promotionRepository.findById("2005-2006").orElse(null);

        // Etudiant 1
        if (!etudiantRepository.existsById("6589RS236F")) {
            Etudiant e1 = new Etudiant();
            e1.setNoEtudiantNat("6589RS236F");
            e1.setAnneePro(promo20042005);
            e1.setCodeCom("CILI3.2");
            e1.setNoEtudiantUbo("200056312");
            e1.setSexe("F");
            e1.setNom("Arnaldi");
            e1.setPrenom("Solenn");
            e1.setDateNaissance(LocalDate.of(1980, 3, 19));
            e1.setLieuNaissance("Guingamp");
            e1.setSituation("CEL");
            e1.setNationalite("Française");
            e1.setTelPort("06.88.55.78.97");
            e1.setEmail("solenn.arnaldi@wanadoo.fr");
            e1.setActuAdresse("17 rue Laënnec");
            e1.setActuCp("29200");
            e1.setActuVille("Brest");
            e1.setActuPays("France");
            e1.setPermAdresse("17 rue Laënnec");
            e1.setPermCp("29200");
            e1.setPermVille("Brest");
            e1.setPermPays("France");
            e1.setDernierDiplome("Master1 Informatique");
            e1.setUniversite("UBO Brest");
            e1.setSigleEtu("SOA");
            e1.setCompteCri("arnaldso");
            e1.setEstDiplome("O");
            etudiantRepository.save(e1);
        }

        // Etudiant 2
        if (!etudiantRepository.existsById("164598")) {
            Etudiant e2 = new Etudiant();
            e2.setNoEtudiantNat("164598");
            e2.setAnneePro(promo20042005);
            e2.setCodeCom("CILI3.1");
            e2.setNoEtudiantUbo("200056313");
            e2.setSexe("H");
            e2.setNom("Beriard");
            e2.setPrenom("François-Xavier");
            e2.setDateNaissance(LocalDate.of(1981, 7, 18));
            e2.setLieuNaissance("Charleville-mézières");
            e2.setSituation("CEL");
            e2.setNationalite("Française");
            e2.setTelPort("06.12.90.35.66");
            e2.setTelFixe("02.98.01.93.40");
            e2.setEmail("fx.beriard@apinc.org");
            e2.setActuAdresse("142 rue Robespierre");
            e2.setActuCp("29200");
            e2.setActuVille("Brest");
            e2.setActuPays("France");
            e2.setPermAdresse("142 rue Robespierre");
            e2.setPermCp("29200");
            e2.setPermVille("Brest");
            e2.setPermPays("France");
            e2.setDernierDiplome("Master1 Informatique");
            e2.setUniversite("UBO Brest");
            e2.setSigleEtu("FXB");
            e2.setCompteCri("beriarfr");
            e2.setEstDiplome("O");
            etudiantRepository.save(e2);
        }

        // Etudiant 3
        if (!etudiantRepository.existsById("0156523")) {
            Etudiant e3 = new Etudiant();
            e3.setNoEtudiantNat("0156523");
            e3.setAnneePro(promo20042005);
            e3.setCodeCom("CILI3.1");
            e3.setNoEtudiantUbo("200056314");
            e3.setSexe("H");
            e3.setNom("Carriere");
            e3.setPrenom("Guillaume");
            e3.setDateNaissance(LocalDate.of(1982, 6, 17));
            e3.setLieuNaissance("Brest");
            e3.setSituation("CEL");
            e3.setNationalite("Française");
            e3.setTelPort("06.76.94.89.85");
            e3.setTelFixe("02.98.92.77.34");
            e3.setEmail("gc@srbrest.com");
            e3.setActuAdresse("16 rue Albert de Mun");
            e3.setActuCp("29200");
            e3.setActuVille("Brest");
            e3.setActuPays("France");
            e3.setPermAdresse("6 rue Albert de Mun");
            e3.setPermCp("29200");
            e3.setPermVille("Brest");
            e3.setPermPays("France");
            e3.setDernierDiplome("Master1 Informatique");
            e3.setUniversite("UBO Brest");
            e3.setSigleEtu("GUC");
            e3.setCompteCri("carriegu");
            e3.setEstDiplome("O");
            etudiantRepository.save(e3);
        }

        // Etudiant 4
        if (!etudiantRepository.existsById("16894563")) {
            Etudiant e4 = new Etudiant();
            e4.setNoEtudiantNat("16894563");
            e4.setAnneePro(promo20042005);
            e4.setCodeCom("CILI3.1");
            e4.setNoEtudiantUbo("200056317");
            e4.setSexe("H");
            e4.setNom("Frin");
            e4.setPrenom("Ronan");
            e4.setDateNaissance(LocalDate.of(1981, 3, 6));
            e4.setLieuNaissance("Rennes");
            e4.setSituation("CEL");
            e4.setNationalite("Française");
            e4.setTelPort("06.63.92.05.30");
            e4.setTelFixe("02.99.64.04.78");
            e4.setEmail("frin_ronan@hotmail.com");
            e4.setActuAdresse("1 rue A. Dodds");
            e4.setActuCp("29200");
            e4.setActuVille("Brest");
            e4.setActuPays("France");
            e4.setPermAdresse("16 rue Duguesclin");
            e4.setPermCp("35590");
            e4.setPermVille("L'hermitage");
            e4.setPermPays("France");
            e4.setDernierDiplome("Master1 Informatique");
            e4.setUniversite("UBO Brest");
            e4.setSigleEtu("ROF");
            e4.setCompteCri("frinrona");
            e4.setEstDiplome("O");
            etudiantRepository.save(e4);
        }

        // Etudiant 5
        if (!etudiantRepository.existsById("20103526")) {
            Etudiant e5 = new Etudiant();
            e5.setNoEtudiantNat("20103526");
            e5.setAnneePro(promo20042005);
            e5.setCodeCom("CILI3.1");
            e5.setNoEtudiantUbo("200056318");
            e5.setSexe("F");
            e5.setNom("Kerjean");
            e5.setPrenom("Virginie");
            e5.setDateNaissance(LocalDate.of(1981, 3, 28));
            e5.setLieuNaissance("Brest");
            e5.setSituation("CEL");
            e5.setNationalite("Française");
            e5.setTelPort("06.62.35.78.79");
            e5.setEmail("virginie_kerjean@yahoo.fr");
            e5.setActuAdresse("199 rue du Commandant Drogou");
            e5.setActuCp("29200");
            e5.setActuVille("Brest");
            e5.setActuPays("France");
            e5.setPermAdresse("199 rue du Commandant Drogou");
            e5.setPermCp("29200");
            e5.setPermVille("Brest");
            e5.setPermPays("France");
            e5.setDernierDiplome("Master1 Informatique");
            e5.setUniversite("UBO Brest");
            e5.setSigleEtu("VIK");
            e5.setCompteCri("kerjeavi");
            e5.setEstDiplome("O");
            etudiantRepository.save(e5);
        }

        // Etudiant 6
        if (!etudiantRepository.existsById("18986523")) {
            Etudiant e6 = new Etudiant();
            e6.setNoEtudiantNat("18986523");
            e6.setAnneePro(promo20042005);
            e6.setCodeCom("CILI3.1");
            e6.setNoEtudiantUbo("200056320");
            e6.setSexe("F");
            e6.setNom("Le Vaillant");
            e6.setPrenom("Sandrine");
            e6.setDateNaissance(LocalDate.of(1981, 8, 3));
            e6.setLieuNaissance("Brest");
            e6.setSituation("CEL");
            e6.setNationalite("Française");
            e6.setTelPort("06.85.01.54.07");
            e6.setTelFixe("02.98.05.09.64");
            e6.setEmail("sandrine_le_vaillant@yahoo.fr");
            e6.setActuAdresse("1 rue Van-Gogh");
            e6.setActuCp("29280");
            e6.setActuVille("Plouzané");
            e6.setActuPays("France");
            e6.setPermAdresse("1 rue Van-Gogh");
            e6.setPermCp("29280");
            e6.setPermVille("Plouzané");
            e6.setPermPays("France");
            e6.setDernierDiplome("Master1 Informatique");
            e6.setUniversite("UBO Brest");
            e6.setSigleEtu("SLV");
            e6.setCompteCri("levailla");
            e6.setEstDiplome("O");
            etudiantRepository.save(e6);
        }

        // Etudiant 7
        if (!etudiantRepository.existsById("20103546")) {
            Etudiant e7 = new Etudiant();
            e7.setNoEtudiantNat("20103546");
            e7.setAnneePro(promo20042005);
            e7.setCodeCom("CILI3.2");
            e7.setNoEtudiantUbo("200056321");
            e7.setSexe("F");
            e7.setNom("Lemesle");
            e7.setPrenom("Patricia");
            e7.setDateNaissance(LocalDate.of(1981, 6, 3));
            e7.setLieuNaissance("Morlaix");
            e7.setSituation("CEL");
            e7.setNationalite("Française");
            e7.setTelPort("06.13.66.36.01");
            e7.setTelFixe("02.98.72.00.61");
            e7.setEmail("pat.lemesle@wanadoo.fr");
            e7.setActuAdresse("16 impasse de mouettes");
            e7.setActuCp("29600");
            e7.setActuVille("Morlaix");
            e7.setActuPays("France");
            e7.setPermAdresse("16 impasse de Mouettes");
            e7.setPermCp("29600");
            e7.setPermVille("Morlaix");
            e7.setPermPays("France");
            e7.setDernierDiplome("Master1 Informatique");
            e7.setUniversite("UBO Brest");
            e7.setSigleEtu("PAL");
            e7.setCompteCri("lemespa");
            e7.setEstDiplome("O");
            etudiantRepository.save(e7);
        }

        // Etudiant 8
        if (!etudiantRepository.existsById("20168938")) {
            Etudiant e8 = new Etudiant();
            e8.setNoEtudiantNat("20168938");
            e8.setAnneePro(promo20042005);
            e8.setCodeCom("CILI3.2");
            e8.setNoEtudiantUbo("200056322");
            e8.setSexe("H");
            e8.setNom("Lucas");
            e8.setPrenom("Stéphane");
            e8.setDateNaissance(LocalDate.of(1980, 3, 10));
            e8.setLieuNaissance("Lannion");
            e8.setSituation("CEL");
            e8.setNationalite("Française");
            e8.setTelPort("06.23.39.47.52");
            e8.setTelFixe("02.96.37.74.92");
            e8.setEmail("stephane-joel.lucas@laposte.net");
            e8.setActuAdresse("3 rue Lavoisier");
            e8.setActuCp("22300");
            e8.setActuVille("Lannion");
            e8.setActuPays("France");
            e8.setPermAdresse("3 rue Lavoisier");
            e8.setPermCp("22300");
            e8.setPermVille("Lannion");
            e8.setPermPays("France");
            e8.setDernierDiplome("Master1 Informatique");
            e8.setUniversite("UBO Brest");
            e8.setSigleEtu("SLU");
            e8.setCompteCri("lucasste");
            e8.setEstDiplome("O");
            etudiantRepository.save(e8);
        }

        // Etudiant 9
        if (!etudiantRepository.existsById("142398A23C2")) {
            Etudiant e9 = new Etudiant();
            e9.setNoEtudiantNat("142398A23C2");
            e9.setAnneePro(promo20042005);
            e9.setCodeCom("CILI3.2");
            e9.setNoEtudiantUbo("200056323");
            e9.setSexe("H");
            e9.setNom("Mavic");
            e9.setPrenom("Olivier");
            e9.setDateNaissance(LocalDate.of(1980, 3, 7));
            e9.setLieuNaissance("Quimper");
            e9.setSituation("CEL");
            e9.setNationalite("Française");
            e9.setTelPort("06.78.12.13.15");
            e9.setTelFixe("02.98.56.12.45");
            e9.setEmail("mavico@wanadoo.fr");
            e9.setActuAdresse("17 rue de Kerjogu");
            e9.setActuCp("29200");
            e9.setActuVille("Brest");
            e9.setActuPays("France");
            e9.setPermAdresse("17 rue de Kerjogu");
            e9.setPermCp("29200");
            e9.setPermVille("Brest");
            e9.setPermPays("France");
            e9.setDernierDiplome("Master1 Informatique");
            e9.setUniversite("UBO Brest");
            e9.setSigleEtu("OLM");
            e9.setCompteCri("mavicoli");
            e9.setEstDiplome("O");
            etudiantRepository.save(e9);
        }

        // Etudiant 10
        if (!etudiantRepository.existsById("361245")) {
            Etudiant e10 = new Etudiant();
            e10.setNoEtudiantNat("361245");
            e10.setAnneePro(promo20042005);
            e10.setCodeCom("CILI3.2");
            e10.setNoEtudiantUbo("200056312");
            e10.setSexe("H");
            e10.setNom("Troncal");
            e10.setPrenom("Yannick");
            e10.setDateNaissance(LocalDate.of(1979, 6, 4));
            e10.setLieuNaissance("Angouleme");
            e10.setSituation("CEL");
            e10.setNationalite("Française");
            e10.setTelPort("06.82.20.99.71");
            e10.setEmail("ytroncal@yahoo.fr");
            e10.setActuAdresse("17 rue Kerabecam");
            e10.setActuCp("29200");
            e10.setActuVille("Brest");
            e10.setActuPays("France");
            e10.setPermAdresse("17 rue Kerabecam");
            e10.setPermCp("29200");
            e10.setPermVille("Brest");
            e10.setPermPays("France");
            e10.setDernierDiplome("Master1 Informatique");
            e10.setUniversite("UBO Brest");
            e10.setSigleEtu("YAT");
            e10.setCompteCri("troncaya");
            e10.setEstDiplome("O");
            etudiantRepository.save(e10);
        }

        // Continue with 2005-2006 students...
        // Etudiant 11
        if (!etudiantRepository.existsById("1496024035g")) {
            Etudiant e11 = new Etudiant();
            e11.setNoEtudiantNat("1496024035g");
            e11.setAnneePro(promo20052006);
            e11.setCodeCom("CILI4.1");
            e11.setNoEtudiantUbo("20203300");
            e11.setSexe("F");
            e11.setNom("Raoul");
            e11.setPrenom("Aurélie");
            e11.setDateNaissance(LocalDate.of(1981, 4, 8));
            e11.setLieuNaissance("Guingamp");
            e11.setSituation("CEL");
            e11.setNationalite("Française");
            e11.setTelPort("06.64.91.49.04");
            e11.setEmail("aurao08@yahoo.fr");
            e11.setActuAdresse("App. 311, 6 rue des archives");
            e11.setActuCp("29200");
            e11.setActuVille("Brest");
            e11.setActuPays("France");
            e11.setPermAdresse("2 Kerbré");
            e11.setPermCp("22540");
            e11.setPermVille("Pédernec");
            e11.setPermPays("France");
            e11.setDernierDiplome("Master1 Informatique");
            e11.setUniversite("UBO Brest");
            e11.setSigleEtu("AUR");
            e11.setCompteCri("raoulaur");
            e11.setEstDiplome("O");
            etudiantRepository.save(e11);
        }

        // Etudiant 12
        if (!etudiantRepository.existsById("1499067588s")) {
            Etudiant e12 = new Etudiant();
            e12.setNoEtudiantNat("1499067588s");
            e12.setAnneePro(promo20052006);
            e12.setCodeCom("CILI4.1");
            e12.setNoEtudiantUbo("20203186");
            e12.setSexe("H");
            e12.setNom("Gaonach");
            e12.setPrenom("Julien");
            e12.setDateNaissance(LocalDate.of(1981, 9, 23));
            e12.setLieuNaissance("Landernau");
            e12.setSituation("CEL");
            e12.setNationalite("Française");
            e12.setTelPort("06.76.99.41.48");
            e12.setEmail("julien_gaonach@yahoo.fr");
            e12.setActuAdresse("19 kerbrad");
            e12.setActuCp("29470");
            e12.setActuVille("Plougastel-Daoulas");
            e12.setActuPays("France");
            e12.setPermAdresse("19 kerbrad");
            e12.setPermCp("29470");
            e12.setPermVille("Plougastel-Daoulas");
            e12.setPermPays("France");
            e12.setDernierDiplome("Master1 Informatique");
            e12.setUniversite("UBO Brest");
            e12.setSigleEtu("JUG");
            e12.setCompteCri("gaonacju");
            e12.setEstDiplome("O");
            etudiantRepository.save(e12);
        }

        // Etudiant 13
        if (!etudiantRepository.existsById("1492092540t")) {
            Etudiant e13 = new Etudiant();
            e13.setNoEtudiantNat("1492092540t");
            e13.setAnneePro(promo20052006);
            e13.setCodeCom("CILI4.1");
            e13.setNoEtudiantUbo("20105004");
            e13.setSexe("H");
            e13.setNom("Humbert");
            e13.setPrenom("Erwan");
            e13.setDateNaissance(LocalDate.of(1982, 2, 1));
            e13.setLieuNaissance("Paris 11ème");
            e13.setSituation("CEL");
            e13.setNationalite("Française");
            e13.setTelPort("06.81.37.85.18");
            e13.setEmail("erwan.humbert@gmail.com");
            e13.setActuAdresse("23 rue Saint Marc");
            e13.setActuCp("29200");
            e13.setActuVille("Brest");
            e13.setActuPays("France");
            e13.setPermAdresse("10 rue Henri Dunant");
            e13.setPermCp("29000");
            e13.setPermVille("Quimper");
            e13.setPermPays("France");
            e13.setDernierDiplome("Master1 Informatique");
            e13.setUniversite("UBO Brest");
            e13.setSigleEtu("ERH");
            e13.setCompteCri("humberer");
            e13.setEstDiplome("O");
            etudiantRepository.save(e13);
        }

        // Etudiant 14
        if (!etudiantRepository.existsById("07is8800515")) {
            Etudiant e14 = new Etudiant();
            e14.setNoEtudiantNat("07is8800515");
            e14.setAnneePro(promo20052006);
            e14.setCodeCom("CILI4.1");
            e14.setNoEtudiantUbo("20304099");
            e14.setSexe("H");
            e14.setNom("Barzic");
            e14.setPrenom("Ronan");
            e14.setDateNaissance(LocalDate.of(1982, 8, 28));
            e14.setLieuNaissance("Pont-L'Abbe");
            e14.setSituation("CEL");
            e14.setNationalite("Française");
            e14.setTelPort("06.71.18.27.02");
            e14.setEmail("rbarzic@hotmail.com");
            e14.setActuAdresse("35 rue Turenne");
            e14.setActuCp("29200");
            e14.setActuVille("Brest");
            e14.setActuPays("France");
            e14.setPermAdresse("5 rue de Coat bihan");
            e14.setPermCp("29900");
            e14.setPermVille("Concarneau");
            e14.setPermPays("France");
            e14.setDernierDiplome("Master1 Informatique");
            e14.setUniversite("UBO Brest");
            e14.setSigleEtu("ROB");
            e14.setCompteCri("barzicro");
            e14.setEstDiplome("O");
            etudiantRepository.save(e14);
        }

        // Etudiant 15
        if (!etudiantRepository.existsById("1493010305n")) {
            Etudiant e15 = new Etudiant();
            e15.setNoEtudiantNat("1493010305n");
            e15.setAnneePro(promo20052006);
            e15.setCodeCom("CILI4.1");
            e15.setNoEtudiantUbo("20304099");
            e15.setSexe("H");
            e15.setNom("Quéffélec");
            e15.setPrenom("Régis");
            e15.setDateNaissance(LocalDate.of(1982, 1, 28));
            e15.setLieuNaissance("Quimper");
            e15.setSituation("CEL");
            e15.setNationalite("Française");
            e15.setTelPort("06.71.85.85.19");
            e15.setEmail("queffelec.regis@wanadoo.fr");
            e15.setActuAdresse("31 rue Mirabeau");
            e15.setActuCp("29200");
            e15.setActuVille("Brest");
            e15.setActuPays("France");
            e15.setPermAdresse("route de kervinic");
            e15.setPermCp("29590");
            e15.setPermVille("Loperec");
            e15.setPermPays("France");
            e15.setDernierDiplome("Master1 Informatique");
            e15.setUniversite("UBO Brest");
            e15.setSigleEtu("REQ");
            e15.setCompteCri("queffere");
            e15.setEstDiplome("O");
            etudiantRepository.save(e15);
        }

        // Etudiant 16
        if (!etudiantRepository.existsById("1492057895k")) {
            Etudiant e16 = new Etudiant();
            e16.setNoEtudiantNat("1492057895k");
            e16.setAnneePro(promo20052006);
            e16.setCodeCom("CILI4.2");
            e16.setNoEtudiantUbo("20303736");
            e16.setSexe("H");
            e16.setNom("Le Nir");
            e16.setPrenom("David");
            e16.setDateNaissance(LocalDate.of(1981, 11, 21));
            e16.setLieuNaissance("Pont L'Abbé");
            e16.setSituation("CEL");
            e16.setNationalite("Française");
            e16.setTelPort("06.61.14.92.01");
            e16.setEmail("david.lenir@gmail.com");
            e16.setActuAdresse("Kerbenfous");
            e16.setActuCp("29120");
            e16.setActuVille("Tréméoc");
            e16.setActuPays("France");
            e16.setPermAdresse("Kerbenfous");
            e16.setPermCp("29120");
            e16.setPermVille("Tréméoc");
            e16.setPermPays("France");
            e16.setDernierDiplome("Master1 Informatique");
            e16.setUniversite("UBO Brest");
            e16.setSigleEtu("DAL");
            e16.setCompteCri("le_nirda");
            e16.setEstDiplome("O");
            etudiantRepository.save(e16);
        }

        // Etudiant 17
        if (!etudiantRepository.existsById("06816q06pf3")) {
            Etudiant e17 = new Etudiant();
            e17.setNoEtudiantNat("06816q06pf3");
            e17.setAnneePro(promo20052006);
            e17.setCodeCom("CILI4.2");
            e17.setNoEtudiantUbo("9308691R");
            e17.setSexe("H");
            e17.setNom("Decourchelle");
            e17.setPrenom("Antonin");
            e17.setDateNaissance(LocalDate.of(1974, 4, 13));
            e17.setLieuNaissance("Blois (41)");
            e17.setSituation("CEL");
            e17.setNationalite("Française");
            e17.setTelPort("06.63.90.96.36");
            e17.setEmail("antonin.decourchelle@gmail.com");
            e17.setActuAdresse("Keriars");
            e17.setActuCp("29280");
            e17.setActuVille("Plouzané");
            e17.setActuPays("France");
            e17.setPermAdresse("Keriars");
            e17.setPermCp("29280");
            e17.setPermVille("Plouzané");
            e17.setPermPays("France");
            e17.setDernierDiplome("Master1 Informatique");
            e17.setUniversite("UBO Brest");
            e17.setSigleEtu("AND");
            e17.setCompteCri("decouran");
            e17.setEstDiplome("O");
            etudiantRepository.save(e17);
        }

        // Etudiant 18
        if (!etudiantRepository.existsById("1499110659h")) {
            Etudiant e18 = new Etudiant();
            e18.setNoEtudiantNat("1499110659h");
            e18.setAnneePro(promo20052006);
            e18.setCodeCom("CILI4.2");
            e18.setNoEtudiantUbo("20504399");
            e18.setSexe("H");
            e18.setNom("Lorand");
            e18.setPrenom("Mickaël");
            e18.setDateNaissance(LocalDate.of(1982, 3, 26));
            e18.setLieuNaissance("Ploërmel (56)");
            e18.setSituation("CEL");
            e18.setNationalite("Française");
            e18.setTelPort("06.70.83.75.01");
            e18.setEmail("dralak@gmail.com");
            e18.setActuAdresse("2 et 4 rue des Archives");
            e18.setActuCp("29200");
            e18.setActuVille("Brest");
            e18.setActuPays("France");
            e18.setPermAdresse("16 rue de l'Ouest");
            e18.setPermCp("35600");
            e18.setPermVille("Redon");
            e18.setPermPays("France");
            e18.setDernierDiplome("Master1 Informatique");
            e18.setUniversite("Université de Rennes 1");
            e18.setSigleEtu("MIL");
            e18.setCompteCri("lorandmi");
            e18.setEstDiplome("O");
            etudiantRepository.save(e18);
        }

        // Etudiant 19
        if (!etudiantRepository.existsById("1893029650z")) {
            Etudiant e19 = new Etudiant();
            e19.setNoEtudiantNat("1893029650z");
            e19.setAnneePro(promo20052006);
            e19.setCodeCom("CILI4.2");
            e19.setNoEtudiantUbo("20203203");
            e19.setSexe("H");
            e19.setNom("Naretto");
            e19.setPrenom("Pierre-Emmanuel");
            e19.setDateNaissance(LocalDate.of(1980, 4, 26));
            e19.setLieuNaissance("Chateauroux (36)");
            e19.setSituation("CEL");
            e19.setNationalite("Française");
            e19.setTelPort("06.63.79.97.01");
            e19.setEmail("pierre_naretto@yahoo.fr");
            e19.setActuAdresse("48 Pen Ar Menez");
            e19.setActuCp("29200");
            e19.setActuVille("Brest");
            e19.setActuPays("France");
            e19.setPermAdresse("48 Pen Ar Menez");
            e19.setPermCp("29200");
            e19.setPermVille("Brest");
            e19.setPermPays("France");
            e19.setDernierDiplome("Master1 Informatique");
            e19.setUniversite("UBO Brest");
            e19.setSigleEtu("PIN");
            e19.setCompteCri("narettpi");
            e19.setEstDiplome("O");
            etudiantRepository.save(e19);
        }

        // Etudiant 20
        if (!etudiantRepository.existsById("1493003704n")) {
            Etudiant e20 = new Etudiant();
            e20.setNoEtudiantNat("1493003704n");
            e20.setAnneePro(promo20052006);
            e20.setCodeCom("CILI4.2");
            e20.setNoEtudiantUbo("20203100");
            e20.setSexe("H");
            e20.setNom("Allain");
            e20.setPrenom("Tangi");
            e20.setDateNaissance(LocalDate.of(1982, 10, 3));
            e20.setLieuNaissance("Douarnenez");
            e20.setSituation("CEL");
            e20.setNationalite("Française");
            e20.setTelPort("06.13.92.55.31");
            e20.setEmail("allain_tangi@yahoo.fr");
            e20.setActuAdresse("App. 222 - 6 rue des Archives");
            e20.setActuCp("29200");
            e20.setActuVille("Brest");
            e20.setActuPays("France");
            e20.setPermAdresse("11 rue des moineaux");
            e20.setPermCp("29100");
            e20.setPermVille("Douarnenez");
            e20.setPermPays("France");
            e20.setDernierDiplome("Master1 Informatique");
            e20.setUniversite("UBO Brest");
            e20.setSigleEtu("ALT");
            e20.setCompteCri("allainta");
            e20.setEstDiplome("O");
            etudiantRepository.save(e20);
        }
    }
}