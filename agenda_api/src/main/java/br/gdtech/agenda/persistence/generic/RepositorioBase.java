package br.gdtech.agenda.persistence.generic;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Import(JinqJPAStreamProvider.class)
public abstract class RepositorioBase<T, U> {

	//@Autowired
	private JinqJPAStreamProvider jinqDataProvider;

	@PersistenceContext
	private EntityManager entityManager;

	public JPAJinqStream<T> stream(Class<T> t) {
		return streamOf(t);
	}

	protected <U> JPAJinqStream<U> streamOf(Class<U> clazz) {
		return jinqDataProvider.streamAll(entityManager, clazz);
	}

	public List<T> findAll() {
		return null;
	}

	public Iterable<T> findAllById(Iterable<Integer> iterable) {
		return null;
	}

	public long count() {
		return 0;
	}

	public void deleteById(Integer integer) {

	}

	public void delete(T t) {

	}

	public void deleteAll(Iterable<? extends T> iterable) {

	}

	public void deleteAll() {

	}

	public <S extends T> S save(S s) {
		return null;
	}

	public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}
}
