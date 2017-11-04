package com.upmc.parisup.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import com.upmc.parisup.DAO.AbstractDAOFactory;
import com.upmc.parisup.DAO.Factory;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.api.schools.SchoolAPIService;
import com.upmc.parisup.business.School;
import com.upmc.parisup.business.User;

public class FillDB {

	public static void addUsers() throws NoSuchAlgorithmException, InvalidKeySpecException {
		User u1 = new User("chris", "dionisio", "ChriChri");
		User u2 = new User("belynda", "hamaz", "Beloche");
		User u3 = new User("marie", "laporte", "Wano");

		u1.setSalt(new AuthenticationService().generateSalt());
		u1.setPassword(new AuthenticationService().getEncryptedPassword("test", u1.getSalt()));

		u2.setSalt(new AuthenticationService().generateSalt());
		u2.setPassword(new AuthenticationService().getEncryptedPassword("test", u2.getSalt()));

		u3.setSalt(new AuthenticationService().generateSalt());
		u3.setPassword(new AuthenticationService().getEncryptedPassword("test", u3.getSalt()));

		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u1);
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u2);
		((UserDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getUserDAO()).add(u3);
	}

	public static void addSchools() {
		SchoolAPIService sas = SchoolAPIService.getInstance();
		List<School> schools = sas.retrieveAllSchools();
		for (School s : schools)
			((SchoolDAOImpl) AbstractDAOFactory.getFactory(Factory.MYSQL_DAO_FACTORY).getSchoolDAO()).add(s);
	}
}