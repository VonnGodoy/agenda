package br.gdtech.agenda.persistence.generic;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RepositorioBase<T, U> {

	//@Autowired
	private JinqJPAStreamProvider jinqDataProvider;

	@PersistenceContext
	private EntityManager entityManager;

//	protected abstract Class<T> entityType();

	public JPAJinqStream<T> stream(Class<T> t) {
		return streamOf(t);
	}

	protected <U> JPAJinqStream<U> streamOf(Class<U> clazz) {
		return jinqDataProvider.streamAll(entityManager, clazz);
	}
}
