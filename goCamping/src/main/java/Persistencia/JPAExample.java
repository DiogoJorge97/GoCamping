/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andreia Patrocínio
 * @author Carolina Albuquerque
 * @author Diogo Jorge
 * @author Pedro Pires
 *
 */
public class JPAExample {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();


    public static void main(String[] args) {
        JPAExample example = new JPAExample();
        
        System.out.println("CAMPER");
        System.out.println("After Sucessfully insertion ");
        Camper camper1 = example.saveCamper("patrocinioandreia", "Andreia ", "patrocinioandreia@ua.pt", "password", 123456789, 54321, "Rua do Estaleiro");
        Camper camper2 = example.saveCamper("ptpires1", "Pedro ", "ptpires@ua.pt", "sabonete", 678901234, 98076, "Sabugal");
        example.listCamper();

        System.out.println("After Sucessfully modification ");
        example.updateCamper(camper1.getUsername(), "Andreia Patrocínio");
        example.updateCamper(camper2.getUsername(), "Pedro Pires");
        example.listCamper();

        System.out.println("After Sucessfully deletion ");
        example.deleteCamper(camper2.getUsername());
        example.listCamper();
        System.out.println("\n\n");
        
        
        System.out.println("MANAGER");
        System.out.println("After Sucessfully insertion ");
        Manager manager1 = example.saveManager("cmalbuquerque", "Carolina", "camalbuquerque@ua.pt", "password", 764386974, "Viseu");
        Manager manager2 = example.saveManager("diogojorge", "Diogo", "dj97@ua.pt", "password", 572853657, "Leiria");
        Manager manager3 = example.saveManager("joana", "Joana Maria", "joana@ua.pt", "password", 237583456, "Amadora");
        example.listManager();

        System.out.println("After Sucessfully modification ");
        example.updateManager(manager1.getUsername(), "Carolina Albuquerque");
        example.updateManager(manager2.getUsername(), "Diogo Jorge");
        example.listCamper();

        System.out.println("After Sucessfully deletion ");
        example.deleteManager(manager3.getUsername());
        example.listManager();
        System.out.println("\n\n");
        

        System.out.println("CAMPSITE");
        System.out.println("After Sucessfully insertion ");
        Campsite campsite1 = example.saveCampsite(123, "Costa Nova Campsite", "Praia da Costa Nova", "maps", 786637966, 30.0, 15.0, 5.0, "9347652781", "inserir descrição", manager1);
        Campsite campsite2 = example.saveCampsite(124, "Barra Campsite", "Praia da Barra", "maps", 456327645, 25.0, 10.0, 5.0, "9347652781", "inserir descrição", manager2);
        Campsite campsite3 = example.saveCampsite(125, "Sol Nascente", "Macedo de Cavaleiros", "maps", 234567894, 20.0, 10.0, 2.0, "9347652781", "inserir descrição", manager1);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateCampsite(campsite1.getId(), "Praia da Costa Nova, Aveiro");
        example.updateCampsite(campsite2.getId(), "Praia da Barra, Aveiro");
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteCampsite(campsite3.getId());
        example.listCampsite();
        
        
        System.out.println("ACCOMMODATION");
        System.out.println("After Sucessfully insertion ");
        Accommodation accommodation1 = example.saveAccommodation(71, "bungalow", campsite1);
        Accommodation accommodation5 = example.saveAccommodation(75, "bungalow", campsite1);
        Accommodation accommodation6 = example.saveAccommodation(76, "bungalow", campsite1);
        Accommodation accommodation2 = example.saveAccommodation(72, "tent", campsite1);
        Accommodation accommodation3 = example.saveAccommodation(73, "roulote", campsite1);
        Accommodation accommodation7 = example.saveAccommodation(77, "roulote", campsite1);
        Accommodation accommodation4 = example.saveAccommodation(74, "bungalow", campsite1);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateAccommodation(accommodation1.getId(), "tent");
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteAccommodation(accommodation4.getId());
        example.listCampsite();
        
        System.out.println("BUNGALOW");
        System.out.println("After Sucessfully insertion ");
        Bungalow bungalow1 = example.saveBungalow(76, 40.0, 35.0, 10.0, 3, 4);
        Bungalow bungalow2 = example.saveBungalow(75, 20.0, 25.0, 10.0, 2, 2);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateBungalow(bungalow1.getAccommodationID(), 40.5, 36.0);
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteBungalow(bungalow2.getAccommodationID());
        example.listCampsite();
        
        System.out.println("TENT PITCH");
        System.out.println("After Sucessfully insertion ");
        TentPitch tent1 = example.saveTentPitch(71, 18.0, 20.0, 10.0);
        TentPitch tent2 = example.saveTentPitch(72, 18.0, 20.0, 10.0);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateTentPitch(tent1.getAccommodationID(), 21.0, 21.0);
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteTentPitch(tent2.getAccommodationID());
        example.listCampsite();
        
        System.out.println("ROULOTE PITCH");
        System.out.println("After Sucessfully insertion ");
        RoulotePitch roulote1 = example.saveRoulotePitch(73, 15.0, 18.0, 10.0);
        RoulotePitch roulote2 = example.saveRoulotePitch(77, 15.0, 18.0, 10.0);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateRoulotePitch(roulote1.getAccommodationID(), 16.0, 18.0);
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteRoulotePitch(roulote2.getAccommodationID());
        example.listCampsite();
        
        System.out.println("RESERVATION");
        System.out.println("After Sucessfully insertion ");
        Date date = new Date(2018, 05, 22);
        Date date1 = new Date(2018, 05, 25);
        Date date2 = new Date(2018, 05, 27);
        Reservation reservation1 = example.saveReservation(1000, date, date1, camper1, accommodation6);
        Reservation reservation2 = example.saveReservation(1001, date, date1, camper1, accommodation3);
        example.listCampsite();

        System.out.println("After Sucessfully modification ");
        example.updateReservation(reservation1.getId(), date, date2);
        example.listCampsite();

        System.out.println("After Sucessfully deletion ");
        example.deleteReservation(reservation2.getId());
        example.listCampsite();
              
        
        System.out.println("CAMPSITE IMAGES");
        System.out.println("After Sucessfully insertion ");
        CampsiteImage image1 = example.saveCampsiteImage(campsite1, "foto1" );
        CampsiteImage image2 = example.saveCampsiteImage(campsite1, "foto2" );
        CampsiteImage image3 = example.saveCampsiteImage(campsite1, "foto3" );
        CampsiteImageKey imageKey = new CampsiteImageKey(campsite1.getId(), "foto3");

        example.listCampsiteImage();

        System.out.println("After Sucessfully deletion ");
        example.deleteCampsiteImage(imageKey);
        example.listCampsiteImage();
        
        System.out.println("FAVOURITE LIST");
        System.out.println("After Sucessfully insertion ");
        FavouriteList fav1 = example.saveFavouriteList(camper1, campsite1);
        FavouriteList fav2 = example.saveFavouriteList(camper1, campsite2);
        
        FavouriteListKey favKey = new FavouriteListKey(camper1.getUsername(), campsite2.getId());

        example.listCampsiteImage();

        System.out.println("After Sucessfully deletion ");
        example.deleteFavouriteList(favKey);
        example.listCampsiteImage();
        
        
        System.out.println("SERVICES ACTIVITIES");
        System.out.println("After Sucessfully insertion ");
        ServicesActivities serviceActivities1 = example.saveServicesActivities(44, "Restaurante");
        ServicesActivities serviceActivities2 = example.saveServicesActivities(45, "Piscina");
        ServicesActivities serviceActivities3 = example.saveServicesActivities(46, "Lavandaria");
        example.listServicesActivities();

        System.out.println("After Sucessfully modification ");
        example.updateServicesActivities(serviceActivities1.getServiceID(), "Restaurante com take away");
        example.listServicesActivities();

        System.out.println("After Sucessfully deletion ");
        example.deleteServicesActivities(serviceActivities3.getServiceID());
        example.listServicesActivities();
        
        System.out.println("CAMPSITE SERVICES");
        System.out.println("After Sucessfully insertion ");
        CampsiteServices service1 = example.saveCampsiteService(campsite1, serviceActivities1);
        CampsiteServices service2 = example.saveCampsiteService(campsite1, serviceActivities2);
        CampsiteServices service3 = example.saveCampsiteService(campsite2, serviceActivities2);
        CampsiteServices service4 = example.saveCampsiteService(campsite2, serviceActivities1);
        
        
        CampsiteServicesKey servicesKey = new CampsiteServicesKey(campsite2.getId(), serviceActivities1.getServiceID());

        example.listCampsiteImage();

        System.out.println("After Sucessfully deletion ");
        example.deleteCampsiteService(servicesKey);
        example.listCampsiteImage();
    }

    public Camper saveCamper(String username, String fullname, String email, String password, int NIF, int campsiteCard, String address) {
        Camper camper = new Camper();
        System.out.println("new camper");
        try {
            entityManager.getTransaction().begin();
            System.out.println("at the start of transaction");
            camper.setUsername(username);
            camper.setFullName(fullname);
            camper.setEmail(email);
            camper.setPassword(password);
            camper.setNIF(NIF);
            camper.setCampsiteCard(campsiteCard);
            camper.setAddress(address);
            entityManager.persist(camper);
            entityManager.getTransaction().commit();
            System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save didn't work on camper");
        }
        return camper;
    }

    public void listCamper() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Camper c");
            List<Camper> Campers = query.getResultList();
            for (Iterator<Camper> iterator = Campers.iterator(); iterator.hasNext();) {
                Camper camper = (Camper) iterator.next();
                System.out.println(camper.getUsername() + " \t" + camper.getFullName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("camper listing didn't work");
        }
    }

    public void updateCamper(String username, String fullname) {
        try {
            entityManager.getTransaction().begin();
            Camper camper = (Camper) entityManager.find(Camper.class, username);
            camper.setFullName(fullname);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update camper didn't work");
        }
    }

    public void deleteCamper(String username) {
        try {
            entityManager.getTransaction().begin();
            Camper camper = (Camper) entityManager.find(Camper.class, username);
            entityManager.remove(camper);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete camper didn't work");
        }
    }

    public Manager saveManager(String username, String fullname, String email, String password, int NIF, String address) {
        Manager manager = new Manager();
        System.out.println("new manager");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            manager.setUsername(username);
            manager.setFullName(fullname);
            manager.setEmail(email);
            manager.setPassword(password);
            manager.setNIF(NIF);
            manager.setAddress(address);
            entityManager.persist(manager);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save didn't work on manager");
        }
        return manager;
    }

    public void listManager() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Manager c");
            List<Manager> Managers = query.getResultList();
            for (Iterator<Manager> iterator = Managers.iterator(); iterator.hasNext();) {
                Manager manager = (Manager) iterator.next();
                System.out.println(manager.getUsername() + " \t" + manager.getFullName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("manager listing didn't work");
        }
    }

    public void updateManager(String username, String fullname) {
        try {
            entityManager.getTransaction().begin();
            Manager manager = (Manager) entityManager.find(Manager.class, username);
            manager.setFullName(fullname);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update manager didn't work");
        }
    }

    public void deleteManager(String username) {
        try {
            entityManager.getTransaction().begin();
            Manager manager = (Manager) entityManager.find(Manager.class, username);
            entityManager.remove(manager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete manager didn't work");
        }
    }

    public Campsite saveCampsite(int id, String title, String location, String mapsLocation, int companyNIF, double adultPrice, double childPrice, double babyPrice, String contact, String desc, Manager manager) {
        Campsite campsite = new Campsite();
        System.out.println("new campsite");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            campsite.setId(id);
            campsite.setTitle(title);
            campsite.setLocation(location);
            campsite.setMapsLocation(mapsLocation);
            campsite.setCompanyNIF(companyNIF);
            campsite.setAdultPrice(adultPrice);
            campsite.setChildPrice(childPrice);
            campsite.setBabyPrice(babyPrice);
            campsite.setContact(contact);
            campsite.setDescription(desc);
            campsite.setManager(manager);

            entityManager.persist(campsite);

            entityManager.getTransaction().commit();
            System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save didnt' work on campsite");
        }
        return campsite;
    }

    public void listCampsite() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Campsite c");
            List<Campsite> Campsites = query.getResultList();
            for (Iterator<Campsite> iterator = Campsites.iterator(); iterator.hasNext();) {
                Campsite campsite = (Campsite) iterator.next();
                System.out.println(campsite.getManager() + "\t" + campsite.getId() + " \t " + campsite.getTitle());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("campsite listing didn't work");
        }
    }

    public void updateCampsite(int id, String location) {
        try {
            entityManager.getTransaction().begin();
            Campsite campsite = (Campsite) entityManager.find(Campsite.class, id);
            campsite.setLocation(location);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update campsite didn't work");
        }
    }

    public void deleteCampsite(int id) {
        try {
            entityManager.getTransaction().begin();
            Campsite campsite = (Campsite) entityManager.find(Campsite.class, id);
            entityManager.remove(campsite);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete campsite didn't work");
        }
    }

    public CampsiteImage saveCampsiteImage(Campsite campsite, String imageName) {
        CampsiteImage images = new CampsiteImage();
        System.out.println("new Campsite image");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            images.setCampsite(campsite.getId());
            images.setImageName(imageName);
            entityManager.persist(images);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save didn't work on images");
        }
        return images;
    }

    public void listCampsiteImage() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from CampsiteImage c");
            List<CampsiteImage> campsiteImages = query.getResultList();
            System.out.println("query done images");
            for (Iterator<CampsiteImage> iterator = campsiteImages.iterator(); iterator.hasNext();) {
                CampsiteImage images = (CampsiteImage) iterator.next();
                System.out.println(images.getCampsite() + " \t" + images.getImageName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("campsite images listing didn't work");
        }
    }


    public void deleteCampsiteImage(CampsiteImageKey imageKey) {
        try {
            entityManager.getTransaction().begin();
            CampsiteImage campsiteImages = (CampsiteImage) entityManager.find(CampsiteImage.class, imageKey);
            entityManager.remove(campsiteImages);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete campsite images didn't work");
        }
    }
    
    public CampsiteServices saveCampsiteService(Campsite campsite, ServicesActivities service) {
        CampsiteServices services = new CampsiteServices();
        System.out.println("new Favourite List");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            services.setServiceID(service.getServiceID());
            services.setCampsiteID(campsite.getId());
            entityManager.persist(services);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on campsite services");
        }
        return services;
    }

    public void listCampsiteService() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from TentPitch c");
            List<CampsiteServices> campsiteServices = query.getResultList();
            for (Iterator<CampsiteServices> iterator = campsiteServices.iterator(); iterator.hasNext();) {
                CampsiteServices services = (CampsiteServices) iterator.next();
                System.out.println(services.getCampsiteID() + "\t" + services.getServiceID());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("campsite services list listing didn't work");
        }
    }

    
    public void deleteCampsiteService(CampsiteServicesKey serviceKey) {
        try {
            entityManager.getTransaction().begin();
            CampsiteServices service = (CampsiteServices) entityManager.find(CampsiteServices.class, serviceKey);
            entityManager.remove(service);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete campsite services didn't work");
        }
    }
    
    public ServicesActivities saveServicesActivities(int serviceID, String serviceDesc) {
        ServicesActivities services = new ServicesActivities();
        System.out.println("new Service or Activitie");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            services.setServiceID(serviceID);
            services.setServicesDesc(serviceDesc);
            entityManager.persist(services);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on servicesActivities");
        }
        return services;
    }

    public void listServicesActivities() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from ServicesActivities c");
            List<ServicesActivities> servicesActivities = query.getResultList();
            for (Iterator<ServicesActivities> iterator = servicesActivities.iterator(); iterator.hasNext();) {
                ServicesActivities services = (ServicesActivities) iterator.next();
                System.out.println(services.getServiceID() + "\t" + services.getServicesDesc());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("servicesActivities listing didn't work");
        }
    }

    public void updateServicesActivities(int serviceID, String serviceDesc) {
        try {
            entityManager.getTransaction().begin();
            ServicesActivities services = (ServicesActivities) entityManager.find(ServicesActivities.class, serviceID);
            services.setServicesDesc(serviceDesc);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update servicesActivities didn't work");
        }
    }

    public void deleteServicesActivities(int serviceID) {
        try {
            entityManager.getTransaction().begin();
            ServicesActivities services = (ServicesActivities) entityManager.find(ServicesActivities.class, serviceID);
            entityManager.remove(services);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete servicesActivities didn't work");
        }
    }

    public Reservation saveReservation(int id, Date startate, Date endDate, Camper camper, Accommodation accommodation) {
        Reservation reservation = new Reservation();
        System.out.println("new Reservation");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            reservation.setId(id);
            reservation.setStartDate(startate);
            reservation.setEndDate(endDate);
            reservation.setCamper(camper);
            reservation.setAccommodation(accommodation);
            entityManager.persist(reservation);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on reservation");
        }
        return reservation;
    }

    public void listReservation() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Reservation c");
            List<Reservation> reservations = query.getResultList();
            for (Iterator<Reservation> iterator = reservations.iterator(); iterator.hasNext();) {
                Reservation reservation = (Reservation) iterator.next();
                System.out.println(reservation.getId() + "\t" + reservation.getCamper() + "\t" + reservation.getAccommodation());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("reservation listing didn't work");
        }
    }

    public void updateReservation(int id, Date startDate, Date endDate) {
        try {
            entityManager.getTransaction().begin();
            Reservation reservation = (Reservation) entityManager.find(Reservation.class, id);
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update reservation didn't work");
        }
    }

    public void deleteReservation(int id) {
        try {
            entityManager.getTransaction().begin();
            Reservation reservation = (Reservation) entityManager.find(Reservation.class, id);
            entityManager.remove(reservation);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete reservation didn't work");
        }
    }

    public Accommodation saveAccommodation(int id, String type, Campsite campsite) {
        Accommodation accommodation = new Accommodation();
        System.out.println("new Accommodation");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            accommodation.setId(id);
            accommodation.setType(type);
            accommodation.setCampsite(campsite);
            entityManager.persist(accommodation);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on accommodation");
        }
        return accommodation;
    }

    public void listAccommodation() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Accommodation c");
            List<Accommodation> accommodations = query.getResultList();
            for (Iterator<Accommodation> iterator = accommodations.iterator(); iterator.hasNext();) {
                Accommodation accommodation = (Accommodation) iterator.next();
                System.out.println(accommodation.getId() + "\t" + accommodation.getCampsite());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("accommodation listing didn't work");
        }
    }

    public void updateAccommodation(int id, String type) {
        try {
            entityManager.getTransaction().begin();
            Accommodation accommodation = (Accommodation) entityManager.find(Accommodation.class, id);
            accommodation.setType(type);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update accommodation didn't work");
        }
    }

    public void deleteAccommodation(int id) {
        try {
            entityManager.getTransaction().begin();
            Accommodation accommodation = (Accommodation) entityManager.find(Accommodation.class, id);
            entityManager.remove(accommodation);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete accommodation didn't work");
        }
    }

    public Bungalow saveBungalow(int accommodationID, double area, double price, double campingCardDiscount, int bedrooms, int capacity) {
        Bungalow bungalow = new Bungalow();
        System.out.println("new Bungalow");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            bungalow.setAccommodationID(accommodationID);
            bungalow.setArea(area);
            bungalow.setPrice(price);
            bungalow.setCampingCardDiscount(campingCardDiscount);
            bungalow.setBedrooms(bedrooms);
            bungalow.setCapacity(capacity);
            entityManager.persist(bungalow);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on bungalow");
        }
        return bungalow;
    }

    public void listBungalow() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Bungalow c");
            List<Bungalow> bungalows = query.getResultList();
            for (Iterator<Bungalow> iterator = bungalows.iterator(); iterator.hasNext();) {
                Bungalow bungalow = (Bungalow) iterator.next();
                System.out.println(bungalow.getAccommodationID() + "\t" + bungalow.getPrice());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("bungalow listing didn't work");
        }
    }

    public void updateBungalow(int accommodationID, double area, double price) {
        try {
            entityManager.getTransaction().begin();
            Bungalow bungalow = (Bungalow) entityManager.find(Bungalow.class, accommodationID);
            bungalow.setArea(area);
            bungalow.setPrice(price);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update bungalow didn't work");
        }
    }

    public void deleteBungalow(int accommodationID) {
        try {
            entityManager.getTransaction().begin();
            Bungalow bungalow = (Bungalow) entityManager.find(Bungalow.class, accommodationID);
            entityManager.remove(bungalow);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete bungalow didn't work");
        }
    }

    public TentPitch saveTentPitch(int accommodationID, double area, double price, double campingCardDiscount) {
        TentPitch tent = new TentPitch();
        System.out.println("new Tent Pitch");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            tent.setAccommodationID(accommodationID);
            tent.setArea(area);
            tent.setPrice(price);
            tent.setCampingCardDiscount(campingCardDiscount);
            entityManager.persist(tent);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on tent pitch");
        }
        return tent;
    }

    public void listTentPitch() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from TentPitch c");
            List<TentPitch> tents = query.getResultList();
            for (Iterator<TentPitch> iterator = tents.iterator(); iterator.hasNext();) {
                TentPitch tent = (TentPitch) iterator.next();
                System.out.println(tent.getAccommodationID() + "\t" + tent.getPrice());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("tent pitch listing didn't work");
        }
    }

    public void updateTentPitch(int accommodationID, double area, double price) {
        try {
            entityManager.getTransaction().begin();
            TentPitch tent = (TentPitch) entityManager.find(TentPitch.class, accommodationID);
            tent.setArea(area);
            tent.setPrice(price);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update tent pitch didn't work");
        }
    }

    public void deleteTentPitch(int accommodationID) {
        try {
            entityManager.getTransaction().begin();
            TentPitch tent = (TentPitch) entityManager.find(TentPitch.class, accommodationID);
            entityManager.remove(tent);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete tent pitch didn't work");
        }
    }

    public RoulotePitch saveRoulotePitch(int accommodationID, double area, double price, double campingCardDiscount) {
        RoulotePitch roulote = new RoulotePitch();
        System.out.println("new Roulote Pitch");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            roulote.setAccommodationID(accommodationID);
            roulote.setArea(area);
            roulote.setPrice(price);
            roulote.setCampingCardDiscount(campingCardDiscount);
            entityManager.persist(roulote);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on tent pitch");
        }
        return roulote;
    }

    public void listRoulotePitch() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from TentPitch c");
            List<RoulotePitch> roulotes = query.getResultList();
            for (Iterator<RoulotePitch> iterator = roulotes.iterator(); iterator.hasNext();) {
                RoulotePitch roulote = (RoulotePitch) iterator.next();
                System.out.println(roulote.getAccommodationID() + "\t" + roulote.getPrice());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("roulote pitch listing didn't work");
        }
    }

    public void updateRoulotePitch(int accommodationID, double area, double price) {
        try {
            entityManager.getTransaction().begin();
            RoulotePitch roulote = (RoulotePitch) entityManager.find(RoulotePitch.class, accommodationID);
            roulote.setArea(area);
            roulote.setPrice(price);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("update roulote pitch didn't work");
        }
    }

    public void deleteRoulotePitch(int accommodationID) {
        try {
            entityManager.getTransaction().begin();
            RoulotePitch roulote = (RoulotePitch) entityManager.find(RoulotePitch.class, accommodationID);
            entityManager.remove(roulote);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete roulote pitch didn't work");
        }
    }
    
    public FavouriteList saveFavouriteList(Camper camper, Campsite campsite) {
        FavouriteList favouriteList = new FavouriteList();
        System.out.println("new Favourite List");
        try {
            entityManager.getTransaction().begin();
            //System.out.println("at the start of transaction");
            favouriteList.setCamperUsername(camper.getUsername());
            favouriteList.setCampsiteID(campsite.getId());
            entityManager.persist(favouriteList);
            entityManager.getTransaction().commit();
            //System.out.println("just after comit");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("save  didnt' work on tent pitch");
        }
        return favouriteList;
    }

    public void listFavouriteList() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from TentPitch c");
            List<FavouriteList> favouriteLists = query.getResultList();
            for (Iterator<FavouriteList> iterator = favouriteLists.iterator(); iterator.hasNext();) {
                FavouriteList favouriteList = (FavouriteList) iterator.next();
                System.out.println(favouriteList.getCamperUsername() + "\t" + favouriteList.getCampsiteID());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("favourite list listing didn't work");
        }
    }

    
    public void deleteFavouriteList(FavouriteListKey favouriteKey) {
        try {
            entityManager.getTransaction().begin();
            FavouriteList favouriteList = (FavouriteList) entityManager.find(FavouriteList.class, favouriteKey);
            entityManager.remove(favouriteList);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("delete favourite lit pitch didn't work");
        }
    }
    
}