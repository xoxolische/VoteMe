package com.voteme.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.voteme.model.Mark;
import com.voteme.model.Opinion;
import com.voteme.model.User;
import com.voteme.model.Versus;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				// Create registry builder
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Map<String, String> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/vote_me");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.POOL_SIZE, "1");//
				settings.put(Environment.AUTOCOMMIT, "true");
				//settings.put(Environment.USE_SECOND_LEVEL_CACHE, "false");
				// .setProperty("hibernate.cache.provider_class",
				// "org.hibernate.cache.NoCacheProvider")
				// .setProperty("hibernate.cache.use_query_cache", "false")
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");//
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				// settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");

				// Apply settings
				registryBuilder.applySettings(settings);

				// Create registry
				registry = registryBuilder.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Mark.class)
						.addAnnotatedClass(Opinion.class).addAnnotatedClass(User.class).addAnnotatedClass(Versus.class);

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