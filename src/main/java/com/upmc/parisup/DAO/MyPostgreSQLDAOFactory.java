package com.upmc.parisup.DAO;

import com.upmc.parisup.DAO.DAOImpl.RatingDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.SelectedSchoolDAOImpl;
import com.upmc.parisup.DAO.DAOImpl.UserDAOImpl;
import com.upmc.parisup.business.Rating;
import com.upmc.parisup.business.School;
import com.upmc.parisup.business.SelectedSchool;
import com.upmc.parisup.business.User;

/**
 * 
 * PostgreSQL DAO factory
 *
 */
public class MyPostgreSQLDAOFactory extends AbstractDAOFactory {

	public MyPostgreSQLDAOFactory() {
		super();
	}

	/**
	 * 
	 * Singleton holder
	 *
	 */
	private static class DAOHolder {
		private static final UserDAO USER_DAO = new UserDAOImpl(User.class);
		private static final SchoolDAO SCHOOL_DAO = new SchoolDAOImpl(School.class);
		private static final SelectedSchoolDAO SELECTED_SCHOOL_DAO = new SelectedSchoolDAOImpl(SelectedSchool.class);
		private static final RatingDAO RATING_DAO = new RatingDAOImpl(Rating.class);
	}

	@Override
	public DAO<?> getUserDAO() {
		return DAOHolder.USER_DAO;
	}

	@Override
	public DAO<?> getSchoolDAO() {
		return DAOHolder.SCHOOL_DAO;
	}

	@Override
	public DAO<?> getSelectedSchoolDAO() {
		return DAOHolder.SELECTED_SCHOOL_DAO;
	}

	@Override
	public DAO<?> getRatingDAO() {
		return DAOHolder.RATING_DAO;
	}
}