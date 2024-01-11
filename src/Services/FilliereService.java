package Services;

import models.Enseignants;
import models.*;
import test.Database;

import java.util.ArrayList;

import static test.Database.enseignants;
import static test.Database.modules;

public class FilliereService {


    public static Filieres addFill(int fid, String fdesc){
        return  new Filieres();
    }

    public static Filieres updateFill(int fid, String fdesc, Enseignants enseignant){
        Filieres updatedFilliere = new Filieres();
        return updatedFilliere;
    }
    public static ArrayList<Filieres> deleteFillById(int fid) {
        return  Database.filieres;
    }

    public static Filieres getFilById(int fid){
        for (Filieres filliere : Database.filieres) {
            if (filliere.getFid() == fid) {
                return  filliere;
            }
        }
        return  new Filieres();
    }

    public static ArrayList<Filieres> getAllEtud(){
        return  Database.filieres;
    }
//    public static boolean isEnseignant(Enseignants enseignant) {
//        if (modules.size() >= 12 &&    EnseignantService.isEnseignant()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}