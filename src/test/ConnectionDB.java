package test;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionDB {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public ConnectionDB() throws SQLException {}


    public static int getIntInput(String... msg) {
        Scanner sc = new Scanner(System.in);
        String message = "entrez un nombre entier:";
        if (msg.length > 0)
            message = msg[0];
        System.out.println(message);
        int num = sc.nextInt();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner sc = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.println(message);
        String str = sc.nextLine();
        return str;

    }

    public static void main(String[] args) {













        /*try{
            cnx=connecterDB();
            st=cnx.createStatement();
            rst=st.executeQuery("SELECT * FROM students");
            while(rst.next()){

                       /*    System.out.print(rst.getString("nom")+"\t");
                           System.out.print(rst.getString("prenom")+"\t");
                           System.out.print(rst.getString("email")+"\t");
                           System.out.print(rst.getInt("apogee")+"\t");
                           System.out.print(rst.getFloat("notes")+"\t");
                           System.out.println();*/
           /* }

        }catch(Exception ex){
            ex.printStackTrace();
        }*/

        try {
            cnx = connecterDB();
            st = cnx.createStatement();
            rst = st.executeQuery("SELECT * FROM departements");
            while (rst.next()) {
                          /* System.out.print(rst.getInt("id_dept")+"\t");
                           System.out.print(rst.getString("intitule")+"\t");
                           System.out.print(rst.getString("id_responsable")+"\t");
                           System.out.println();*/
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            cnx = connecterDB();
            st = cnx.createStatement();
            rst = st.executeQuery("SELECT * FROM enseignat");
            while (rst.next()) {

                            /*System.out.print(rst.getString("nom") + "\t");
                            System.out.print(rst.getString("prenom") + "\t");
                         System.out.print(rst.getString("email") + "\t");
                            System.out.print(rst.getString("grade") + "\t");
                         System.out.println();*/
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static Connection  connecterDB(){
        try{
            /*  Class.forName("com.mysql.jdbc.Driver");*/
            String url="jdbc:mysql://localhost:3306/saidadziri";
            String user="root";
            String password="";
            Connection cnx=DriverManager.getConnection(url,user,password);
            System.out.println("Connexion bien établié");
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /////////////////////////////////////////////departement/////////////////////////////////////////////////////////////////////////////////////////
    public static void addDept(){
        int id=getIntInput("entrez l'id du departement:");
        String intitule =getStringInput("entrez l'intitule du departement :");
        int id_responsable=getIntInput("entrez l'id du responsable sur le departement:");

        try{
            String query="INSERT INTO departements VALUES("+id+",'"+intitule+"',"+id_responsable+")";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("departement well added");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
    public static void getDeptById() {
        int id=getIntInput("entrez l'id du departement que vous voulez afficher:");
        try{
            String query="SELECT * FROM departements WHERE id='"+id+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("departement well found");
            }else{
                System.out.println("departement not found");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateDpt(){
        int id=getIntInput("entrez l'id du departement:");
        String intitule =getStringInput("entrez l'intitule du departement :");
        int id_responsable=getIntInput("entrez l'id du responsable sur le departement:");

        try{
            String query="UPDATE departements SET intitule='"+intitule
                    +"', id='"+id_responsable
                    +"' WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified departement");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDptById(){
        int id=getIntInput("entrez l'id du departement que vous voulez supprimer:");
        try{
            String query="DELETE FROM departements WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted departement");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /////////////////////////////////////////////////////enseignant///////////////////////////////////////////////////////////////////////////////////////////
    public static void getEnseigById() {
        int id=getIntInput("entrez l'id du enseignant:");
        try{
            String query="SELECT * FROM enseignat WHERE id='"+id+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("enseignant  exist");
            }else{
                System.out.println("enseignant non exist");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updateEnseig(){
        int id=getIntInput("entrez l'id du enseignant:");
        String nom =getStringInput("entrez le nom  enseignant :");
        String prenom =getStringInput("entrez le prenom  enseignant:");
        String email =getStringInput("entrez l'email enseignant:");
        String grade =getStringInput("entrez la grade enseignant:");
        try{
            String query="UPDATE enseignat SET nom='"+nom
                    +"', prenom='"+prenom

                    +"', email='"+email
                    +"', grade='"+grade
                    +"' WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("changer enseignant");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addEnseig() {
        String nom =getStringInput("entrez le nom enseignant :");
        String prenom =getStringInput("entrez le prenom enseignant:");
        String email =getStringInput("entrez l'email enseignant:");
        String grade =getStringInput("entrez la grade enseignant:");
        try{
            String query="INSERT INTO enseignat (nom,prenom,email,grade) VALUES('"+nom+"','"
                    +prenom+"','"+email+"','"+grade+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("ajouter enseignant");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteEnseigById(){
        int id=getIntInput("entrez un id enseignat:");
        try{
            String query="DELETE FROM enseignat WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted enseignat");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
