/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pootaller2;

/**
 *
 * @author PRIME
 */
public class Main {
    
    public static void main(String[] args) {
		crear();
		read();
		update();
		delete();
	}
	
	public static void crear() {
		DaoUser daoUser = new DaoUser();
		User user = new User(1, "Juan", "0943109147", "juan_19@hotmail.com", "juan1999","juan0943109147");		
		daoUser.setup();
		daoUser.crear(user);
		//user = new User(2, "Pedro", "097846123","pedro_20@hotmail.com", "pedro1998", "pedro01041998");
		daoUser.crear(user);		
	}
        
        public static void read() {
		DaoUser daoUser = new DaoUser();
		daoUser.setup();
		User user= daoUser.read(1);
		user.imprimir();
	}

	public static void update() {

		DaoUser daoUser = new DaoUser();
		daoUser.setup();
		User user= daoUser.read(1);
		user.setPhone("097894512");
		daoUser.update(user);
	}
	
	public static void delete() {
		DaoUser daoUser = new DaoUser();
		daoUser.setup();
		daoUser.delete(1);
		daoUser.delete(2);
	}
    
}
