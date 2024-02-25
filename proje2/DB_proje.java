package com.mycompany.proje2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_proje {

    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/proje?user=root&password=Fatma5858";
    private static Connection conn;

    public static Danisman LoginDanisman(String mail, String sifre) {
        Danisman danisman = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_danisman WHERE mail='" + mail + "' AND sifre='" + sifre + "';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                danisman = new Danisman();
                danisman.id = rs.getInt("id");
                danisman.mail = rs.getString("mail");
                danisman.sifre = rs.getString("sifre");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return danisman;
    }//mail ve sifreyi doğrulayarak danışman girişini sağlar.

    public static Akademisyen LoginAkademisyen(String mail, String sifre) {
        Akademisyen akademisyen = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_akademisyen WHERE mail='" + mail + "' AND sifre='" + sifre + "';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                akademisyen = new Akademisyen();
                akademisyen.id = rs.getInt("id");
                akademisyen.mail = rs.getString("mail");
                akademisyen.sifre = rs.getString("sifre");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return akademisyen;
    }//mail ve sifreyi doğrulayarak akademisyen girişini sağlar.

    public static Ogrenci LoginÖğrenci(String mail, String sifre) {
        Ogrenci ogrenci = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_ogrenci WHERE mail='" + mail + "' AND sifre='" + sifre + "';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                ogrenci = new Ogrenci();
                ogrenci.id = rs.getInt("id");
                ogrenci.name_surname = rs.getString("name_surname");
                ogrenci.mail = rs.getString("mail");
                ogrenci.sifre = rs.getString("sifre");
                ogrenci.sinif = rs.getInt("sinif");
                ogrenci.devamsizlik = rs.getInt("devamsizlik");
                ogrenci.prep = rs.getBoolean("prep");
                ogrenci.kayit_yili = rs.getString("kayit_yili");
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ogrenci;
    }//mail ve sifreyi doğrulayarak öğrenci girişini sağlar.

    public static ArrayList<Ogrenci> SearchByNameOrDevamsizlik(String search) {
        ArrayList<Ogrenci> plist = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM proje.tbl_ogrenci WHERE name_surname LIKE '%" + search + "%' OR devamsizlik LIKE '%" + search + "%'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.id = rs.getInt("id");
                ogrenci.name_surname = rs.getString("name_surname");
                ogrenci.mail = rs.getString("mail");
                ogrenci.sifre = rs.getString("sifre");
                ogrenci.sinif = rs.getInt("sinif");
                ogrenci.devamsizlik = rs.getInt("devamsizlik");
                ogrenci.prep = rs.getBoolean("prep");
                ogrenci.kayit_yili = rs.getString("kayit_yili");
                plist.add(ogrenci);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plist;
    }// öğrencinin devamsızlık ya da adına göre arama yapar.

    public static ArrayList<Ders_ogrenci_list> SearchByNameStudent(String search) {
        ArrayList<Ders_ogrenci_list> plist = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM proje.tbl_ogrenci_ders WHERE ders_alan_ismi LIKE '%" + search + "%'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ders_ogrenci_list ogrenci = new Ders_ogrenci_list();
                ogrenci.id = rs.getInt("id");
                ogrenci.ders_adi = rs.getString("ders_adi");
                ogrenci.ders_alan_ismi = rs.getString("ders_alan_ismi");

                plist.add(ogrenci);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plist;
    }

    public static Ogrenci SearchStudentById(int id) {
        Ogrenci ogrenci = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM proje.tbl_ogrenci WHERE id=" + id + ";";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                ogrenci = new Ogrenci();
                ogrenci.id = rs.getInt("id");
                ogrenci.name_surname = rs.getString("name_surname");
                ogrenci.mail = rs.getString("mail");
                ogrenci.sifre = rs.getString("sifre");
                ogrenci.sinif = rs.getInt("sinif");
                ogrenci.devamsizlik = rs.getInt("devamsizlik");
                ogrenci.prep = rs.getBoolean("prep");
                ogrenci.kayit_yili = rs.getString("kayit_yili");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Danisman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ogrenci;
    }//id değerine göre öğrenci bilgilerini döndürür.

    public static Ders SearchCourseById2(int id) {
        Ders ders = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM proje.tbl_ders_icerik WHERE id=" + id + ";";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                ders = new Ders();
                ders.id = rs.getInt("id");
                ders.ders_adi = rs.getString("ders_adi");
                ders.ders_konu = rs.getString("ders_konu");
                ders.ders_hafta = rs.getInt("ders_hafta");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Danisman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ders;
    }//id değerine göre Ders içerik bilgilerini döndürür.

    public static ArrayList<Ders> GetCourses() {
        ArrayList<Ders> ders = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_ders_icerik ;";
            ResultSet rs = stmt.executeQuery(query);
            ders = new ArrayList<>();
            while (rs.next()) {
                Ders course = new Ders();
                course.id = rs.getInt("id");
                course.ders_adi = rs.getString("ders_adi");
                course.ders_konu = rs.getString("ders_konu");
                course.ders_hafta = rs.getInt("ders_hafta");
                ders.add(course);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ders;
    }//Ders bilgilerini getirir.

    public static ArrayList<Ders_ogrenci_list> GetCoursesAndStudent() {
        ArrayList<Ders_ogrenci_list> ders_ogrenci = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_ogrenci_ders ;";
            ResultSet rs = stmt.executeQuery(query);
            ders_ogrenci = new ArrayList<>();
            while (rs.next()) {
                Ders_ogrenci_list course = new Ders_ogrenci_list();
                course.id = rs.getInt("id");
                course.ders_adi = rs.getString("ders_adi");
                course.ders_alan_ismi = rs.getString("ders_alan_ismi");

                ders_ogrenci.add(course);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ders_ogrenci;
    }//Ders_icerik_listteki bilgileri getirir.

    public static ArrayList<Ders> GetCourseIcerik() {
        ArrayList<Ders> ders = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_ders_icerik ;";
            ResultSet rs = stmt.executeQuery(query);
            ders = new ArrayList<>();
            while (rs.next()) {
                Ders course = new Ders();
                course.id = rs.getInt("id");
                course.ders_adi = rs.getString("ders_adi");
                course.ders_konu = rs.getString("ders_konu");
                course.ders_hafta = rs.getInt("ders_hafta");
                ders.add(course);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ders;
    }//Ders_icerik bilgilerini getirir.

    public static ArrayList<Ogrenci> GetStudent() {
        ArrayList<Ogrenci> ogrenciList = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT*FROM proje.tbl_ogrenci ;";
            ResultSet rs = stmt.executeQuery(query);
            ogrenciList = new ArrayList<>();
            while (rs.next()) {
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.id = rs.getInt("id");
                ogrenci.name_surname = rs.getString("name_surname");
                ogrenciList.add(ogrenci);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ogrenciList;
    }//öğrenci bilgilerini getirir.

    public static boolean AddStudent(Ogrenci np1) {
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO proje.tbl_ogrenci "
                    + "(id, name_surname, mail, sifre, sinif, devamsizlik, prep, kayit_yili) "
                    + "VALUES ('" + np1.id + "', '" + np1.name_surname + "','" + np1.mail
                    + "','" + np1.sifre + "','" + np1.sinif + "', '" + np1.devamsizlik + "'," + np1.prep + ",'" + np1.kayit_yili + "');";

            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }//tbl_ogrenciler tablosuna öğrenci ekler.

    public static boolean AddCourseToStudentById(String ders_adi, String ders_alan_ismi) {
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO proje.tbl_ogrenci_ders "
                    + "(ders_adi,ders_alan_ismi) "
                    + "VALUES ('" + ders_adi + "', '" + ders_alan_ismi + "');";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }//proje.tbl_ogrenci_ders tablosuna yeni bir öğrenci ders kaydı eklemek için kullanılabilir.

    public static boolean DeleteCourseToStudentById(String ders_adi, String ders_alan_ismi) {
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM proje.tbl_ogrenci_ders WHERE ders_adi='" + ders_adi + "'AND ders_alan_ismi='" + ders_alan_ismi + "';";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }//proje.tbl_ogrenci_ders tablosuna yeni bir öğrenci ders kaydı silmek için kullanılabilir.

    public static boolean UpdateSifreDanisman(String sifre, String mail) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proje?user=root&password=Fatma5858");
            Statement stmt = conn.createStatement();
            String query = "UPDATE proje.tbl_danisman SET sifre='" + sifre + "' WHERE mail='" + mail + "';";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Frm_SifreGuncelleme.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//danışmanın şifresini günceller.

    public static boolean UpdateSifreOgrenci(String sifre, String mail) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proje?user=root&password=Fatma5858");
            Statement stmt = conn.createStatement();
            String query = "UPDATE proje.tbl_ogrenci SET sifre='" + sifre + "' WHERE mail='" + mail + "';";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//öğrencinin şifresini günceller.

    public static boolean UpdateDevamsizlik(String absence, String name_surname) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proje?user=root&password=Fatma5858");
            Statement stmt = conn.createStatement();
            String query = "UPDATE proje.tbl_ogrenci SET devamsizlik='" + absence + "' WHERE name_surname='" + name_surname + "';";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Danisman.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//öğrencinin devamsızlığını tablodan günceller.

    public static boolean UpdateCourseIcerik(Ders np1) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proje?user=root&password=Fatma5858");
            Statement stmt = conn.createStatement();
            String query = "UPDATE proje.tbl_ders_icerik SET "
                    + "ders_adi='" + np1.ders_adi + "', "
                    + "ders_konu='" + np1.ders_konu + "', "
                    + "ders_hafta='" + np1.ders_hafta + "' "
                    + "WHERE id=" + np1.id;

            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Frm_akademisyen.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//tbl_ders_icerik tablosuna ders viçeriğini günceller.

    public static boolean DeleteCourseIcerik(int id) {
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM proje.tbl_ders_icerik WHERE id=" + id + ";";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Danisman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }//tbl_ders_icerik tablosuna ders ve içeriğini siler.

    public static boolean AddCourseIcerik(Ders np1) {
        try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO proje.tbl_ders_icerik (id, ders_adi, ders_konu, ders_hafta) "
                    + "VALUES ('" + np1.id + "', '" + np1.ders_adi + "', '" + np1.ders_konu
                    + "', '" + np1.ders_hafta + "')";
            stmt.executeUpdate(query);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }//tbl_ders_icerik tablosuna ders ve içeriğini ekler.
}
