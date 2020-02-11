package br.gdtech.agenda.repository;

import org.jboss.logging.Logger;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositorioBase<T> implements JpaRepository<T, Integer>{

	@Autowired
	private JinqJPAStreamProvider jinqDataProvider;

	@PersistenceContext
	private EntityManager entityManager;

	protected static final Logger LOG = Logger.getLogger(RepositorioBase.class);

	protected abstract Class<T> entityType();

	public JPAJinqStream<T> stream() {
		return streamOf(entityType());
	}

	protected <U> JPAJinqStream<U> streamOf(Class<U> clazz) {
		return jinqDataProvider.streamAll(entityManager, clazz);
	}
}
