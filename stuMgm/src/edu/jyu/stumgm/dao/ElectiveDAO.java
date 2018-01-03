package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.User;

public class ElectiveDAO extends BaseDAO<Elective> implements IElectiveDAO{
	public ElectiveDAO(){
		super(Elective.class);
	}
	
	public void save(Elective s){
		
//		super.setSessionFactory(sessionFactory);
//		super.save(s);	
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
//		template.save(s);
	}

	public void delete(String id) {
		Elective elective = new Elective();
		elective.setId(id);
		template.delete(elective);		
	}

	@SuppressWarnings("unchecked")
	public List<Elective> findByKey(final String key) {
		return (List<Elective>)template.execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria cri = session.createCriteria(Elective.class);
				cri.add(Restrictions.or(Restrictions.like("stuNumber", key,
                                    MatchMode.ANYWHERE), 
						Restrictions.or(Restrictions.like("username", key,
                                    MatchMode.ANYWHERE),
						Restrictions.or(Restrictions.like("gender", key,
                                    MatchMode.ANYWHERE),
						Restrictions.or(Restrictions.like("city", key,
                                    MatchMode.ANYWHERE),
												Restrictions.or(Restrictions.like("identityID", key, MatchMode.ANYWHERE),
														Restrictions.or(Restrictions.like("phone", key, MatchMode.ANYWHERE),
																Restrictions.or(Restrictions.like("email", key, MatchMode.ANYWHERE), 
																		Restrictions.or(Restrictions.like("postID", key, MatchMode.ANYWHERE),
																				Restrictions.like("address", key, MatchMode.ANYWHERE))))))))));
				return cri.list();
			}
		});
	}

	public void deleteByids(final List<String> numbers) {
//		template.execute(new HibernateCallback(){
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException{
//				return session.createQuery("delete from Elective g where g.stuNumber in (:n)").setParameterList("n", numbers).executeUpdate();
//			}
//		});
		
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Elective e where e.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
	public List<Elective> findAll()
	{
//		return template.find("from Elective");
//		return super.findAll();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Elective.class);
//		criteria.add(Restrictions.eq("ElectiveName", name));
		
		List<Elective> list = (List<Elective>)criteria.list();
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public Elective get(Serializable id)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Elective.class);
		criteria.add(Restrictions.eq("id", id));
		List<Elective> res = (List<Elective>)criteria.list();
		if(res==null||res.isEmpty()) return null;
		return res.get(0);
	}
	
	public void update(Elective Elective)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(Elective);
		session.getTransaction().commit();
		session.close();
	}

	

	

	
}