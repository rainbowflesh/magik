package is.nijikawa.fozubaoyo.mapper;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * jpa基本实现
 */
@NoRepositoryBean
public interface BaseRepo<T, ID> extends Repository<T, ID> {
    Optional<T> findById(T id);

    <S extends T> S save(S entity);
}