/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciabdemp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class PersistenciaBDemp {

    public static void main(String[] args) {
        EntityManagerFactory emf=
                Persistence.createEntityManagerFactory("com.mycompany_PersistenciaBDemp_jar_1.0-SNAPSHOTPU");
        DeptJpaController dao =new DeptJpaController(emf);
        List<Dept> lista=dao.findDeptEntities();
        for(Dept departamento : lista){
        System.out.println("nombre departamento: "+departamento.getDname());}
        EntityManager em = emf.createEntityManager();
        Dept undept = new Dept();
        undept.setDeptno(60);
        undept.setDname("RRHH");
        undept.setLoc("Burgos");
        em.getTransaction().begin();
        em.persist(undept);
        em.getTransaction().commit();
    }
}
