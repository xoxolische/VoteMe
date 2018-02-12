package com.voteme.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.voteme.model.Comment;
import com.voteme.model.CommentMark;
import com.voteme.model.Mark;
import com.voteme.model.Opinion;
import com.voteme.model.OpinionMark;
import com.voteme.model.Role;
import com.voteme.model.User;
import com.voteme.model.Versus;
import com.voteme.model.VersusMark;

/**
 * 
 * @author Nikita Pavlov TODO add hibernate.cfg.xml to gitignore
 */
public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				// Create registry builder
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				// Create registry
				registry = registryBuilder.build();

				registry = registryBuilder.configure("hibernate.cfg.xml").build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
				sources.addAnnotatedClass(Mark.class).addAnnotatedClass(Opinion.class).addAnnotatedClass(User.class)
						.addAnnotatedClass(Versus.class).addAnnotatedClass(Role.class)
						.addAnnotatedClass(OpinionMark.class).addAnnotatedClass(VersusMark.class).addAnnotatedClass(CommentMark.class).addAnnotatedClass(Comment.class);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}